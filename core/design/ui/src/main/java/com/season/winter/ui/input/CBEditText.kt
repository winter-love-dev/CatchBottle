package com.season.winter.ui.input

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.View.OnTouchListener
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.season.winter.common.extention.context.getDimension
import com.season.winter.common.extention.view.getAttr
import com.season.winter.common.extention.view.onTextChangedListener
import com.season.winter.designsystem.input.CBInput
import com.season.winter.designsystem.typography.base.FontFamily
import com.season.winter.ui.textView.CBTextView
import com.season.winter.core_design_resource.R as ResourceModuleR
import com.season.winter.designsystem.R as DesignSystemR


@SuppressLint("ClickableViewAccessibility")
class CBEditText @JvmOverloads constructor(
    private val context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
): AppCompatEditText(context, attrs, defStyleAttr),
    OnTouchListener,
    OnFocusChangeListener
{

    private var deleteIcon: Drawable? = null
    private var onFocusChangeListener: OnFocusChangeListener? = null
    private var onTouchListener: OnTouchListener? = null

    private var useDeleteButton = true
    private var viewType = CBInput.first
    private var cbInput = CBInput.First

    private var onCBTextChangedListener: ((text: String) -> Unit)? = null

    init {

        context.obtainStyledAttributes(
            attrs,
            DesignSystemR.styleable.CBEditText
        ).let { typed ->
            useDeleteButton = typed.getAttr(
                DesignSystemR.styleable.CBEditText_cb_input_use_delete_button,
                true
            )
            viewType = typed.getAttr(
                DesignSystemR.styleable.CBEditText_cb_edit_text_type,
                0
            )
            typed.recycle()
        }

        // setStyle
        setDefaultStyle()
        setViewType()

        // add function
        setDeleteIcon()

        // input listener
        textChangedListener()
    }

    private fun textChangedListener() {
        setClearIconVisible(false)
        onTextChangedListener {
            onCBTextChangedListener?.invoke(it)
            if (isFocused)
                setClearIconVisible(it.isNotEmpty())
        }
    }

    private fun setViewType() {
        setBackgroundResource(
            CBInput.getType(viewType, false)
        )
    }

    private fun setViewFocusedType() {
        setBackgroundResource(
            CBInput.getType(viewType, true)
        )
    }

    private fun setDeleteIcon() {
        deleteIcon = ContextCompat.getDrawable(
            context,
            ResourceModuleR.drawable.delete
        )?.apply {
            DrawableCompat.setTintList(this, hintTextColors)
            setBounds(
                0,
                0,
                intrinsicWidth - 12,
                intrinsicHeight - 12
            )
        }
        if (deleteIcon == null) return
        if (useDeleteButton.not()) return

        useDeleteButton = true
        super.setOnTouchListener(this)
        super.setOnFocusChangeListener(this)
    }

    private fun getPadding(res: Int): Int {
        return context.getDimension(res).toInt()
    }

    private fun setDefaultStyle() {
        cbInput = CBInput.getCBInputInfo(viewType).apply {
            setPadding(
                getPadding(paddingLeftRes),
                getPadding(paddingTopRes),
                getPadding(paddingRightRes),
                getPadding(paddingBottomRes)
            )
        }
        setTextColor(
            CBTextView.getDefaultTextColor(context)
        )
        typeface = ResourcesCompat.getFont(
            context,
            FontFamily.RegularResource
        )
        setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            context.getDimension(DesignSystemR.dimen.font_input_place_holder)
        )
    }

    override fun setOnFocusChangeListener(onFocusChangeListener: OnFocusChangeListener) {
        this.onFocusChangeListener = onFocusChangeListener
    }

    override fun setOnTouchListener(onTouchListener: OnTouchListener) {
        this.onTouchListener = onTouchListener
    }

    override fun onFocusChange(view: View, hasFocus: Boolean) {
        if (hasFocus)
            setViewFocusedType()
        else
            setViewType()
        setClearIconVisible(hasFocus && (text ?: "").isNotEmpty())
        (onFocusChangeListener ?: return).onFocusChange(view, hasFocus)
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        val x = motionEvent.x.toInt()
        val isVisible = deleteIcon?.isVisible == true
        val needPadding = x > width - paddingRight - (deleteIcon?.intrinsicWidth ?: 0)
        if (isVisible && needPadding) {
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                error = null
                text = null
            }
            return true
        }
        return (onTouchListener ?: return false).onTouch(view, motionEvent)
    }

    private fun setClearIconVisible(visible: Boolean) {
        if (useDeleteButton.not()) return
        deleteIcon?.setVisible(visible, false)
        setCompoundDrawables(null, null, if (visible) deleteIcon else null, null)
    }
}