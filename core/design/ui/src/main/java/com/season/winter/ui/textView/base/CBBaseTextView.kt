package com.season.winter.ui.textView.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.season.winter.designsystem.R
import com.season.winter.designsystem.typography.CBTypography

enum class CBTextViewType {
    Head,
    Body,
    Caption,
    ;

    fun getFont(selectedSize: Int): CBTypography {
        return when(this) {
            Head -> CBTypography.getHeadInfo(selectedSize)
            Body -> CBTypography.getBodyInfo(selectedSize)
            Caption -> CBTypography.getCaptionInfo(selectedSize)
        }
    }
}

abstract class CBBaseTextView @JvmOverloads constructor(
    private val context: Context,
    private val attrs: AttributeSet?,
//    defStyleAttr: Int
): AppCompatTextView(context, attrs/*, defStyleAttr*/) {

    private var text: String = ""
    private var weight: Int = Typeface.NORMAL
    private var textSize: Float? = null
    private var textColor: Int? = null
    private var fontFamily: Typeface = Typeface.DEFAULT

    abstract val styleableRes: IntArray

    abstract val textViewType: Int
    abstract val textAttr: Int
    abstract val selectedSizeAttr: Int
    abstract val colorAttr: Int

    private val TypedArray.viewType get(): CBTextViewType {
        return when (getInt(textViewType, 0)) {
            0 -> CBTextViewType.Head
            1 -> CBTextViewType.Body
            2 -> CBTextViewType.Caption
            else -> CBTextViewType.Body
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        initAttributes()
        Paint().run {
            textSize = this@CBBaseTextView.textSize ?: CBTypography.getDefaultHeadSize(context)
            color = textColor ?: context.getColor(R.color.gray_5)
            typeface = Typeface.create(fontFamily, weight)
            canvas.drawText(text, 0f, 0f, this)
        }
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

    @SuppressLint("Recycle")
    private fun initAttributes() {
        if (attrs == null) return
        val typed = context.obtainStyledAttributes(
            attrs,
            styleableRes
        )

        // text
        text = typed.getText(textAttr)?.toString() ?: ""

        // fontInfo
        val selectedSize = typed.getInt(selectedSizeAttr, 0)
        val fontInfo = typed.viewType.getFont(selectedSize)

        // textSize
        this.textSize = context.resources.getDimension(fontInfo.size)

        // weight
        weight = fontInfo.weight

        // fontFamily
        fontFamily = CBTypography.getFontRes(context, fontInfo) ?: Typeface.DEFAULT

        // color
        textColor = typed.getColor(
            colorAttr,
            context.getColor(R.color.gray_5)
        )
    }
}