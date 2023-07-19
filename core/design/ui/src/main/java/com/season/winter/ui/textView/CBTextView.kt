package com.season.winter.ui.textView

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import com.season.winter.common.extention.context.getDimension
import com.season.winter.common.extention.context.getInteger
import com.season.winter.designsystem.R
import com.season.winter.designsystem.typography.CBTypography
import com.season.winter.designsystem.typography.CBTypography.Companion.textViewType
import com.season.winter.designsystem.typography.base.Weight
import com.season.winter.ui.extensions.getAttr

class CBTextView @JvmOverloads constructor(
    private val context: Context,
    private val attrs: AttributeSet?,
): AppCompatTextView(context, attrs) {

    private var text: String = ""
    private var weight: Int = getWeight(context)
    private var textSize: Float = getDefaultTextSize(context)
    private var textColor: Int = getDefaultTextColor(context)
    private var fontFamily: Typeface = getFontFamily(context, CBTypography.BodyM)

    init {
        initAttributes()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        val paint = Paint().apply {
//            textSize = this@CBTextView.textSize ?: CBTypography.getDefaultSize(context)
//            color = textColor ?: context.getColor(R.color.gray_5)
//            typeface = Typeface.create(fontFamily, weight)
//        }
//        canvas?.drawText(text, 0f, 0f, paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }

    @SuppressLint("Recycle", "ResourceType")
    private fun initAttributes() {
        if (attrs == null) return
        val typed = context.obtainStyledAttributes(
            attrs,
            R.styleable.CBTextView
        )

        // text
        text = typed.getAttr(R.styleable.CBTextView_cb_text, "")

        // font
        val cbTypography = typed.textViewType
        textSize = context.getDimension(cbTypography.size)
        weight = context.getInteger(cbTypography.weight)
        fontFamily = CBTypography.getFontRes(context, cbTypography) ?: Typeface.DEFAULT

        // color
        textColor = typed.getAttr(
            R.styleable.CBTextView_cb_text_color,
            context.getColor(R.color.gray_5)
        )

        // setStyle
        setTypeface(fontFamily, weight)
        setTextColor(textColor)
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize) // setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
        setText(text)
    }


    companion object {

        fun getWeight(context: Context): Int {
            return context.getInteger(Weight.W500.value)
        }

        fun getDefaultTextSize(context: Context): Float {
            return CBTypography.getDefaultSize(context)
        }

        fun getFontFamily(context: Context, cbTypography: CBTypography?): Typeface {
            return if (cbTypography != null)
                CBTypography.getFontRes(context, cbTypography)
            else
                CBTypography.getFontRes(context, CBTypography.BodyM)
        }

        fun getDefaultTextColor(context: Context): Int {
            return context.getColor(R.color.gray_5)
        }
    }
}