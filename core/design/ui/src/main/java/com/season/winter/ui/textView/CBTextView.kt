package com.season.winter.ui.textView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.season.winter.designsystem.R

class CBTextView: AppCompatTextView {

    private var text: String = ""
    private var textColor: Int? = null

    private lateinit var context: Context

    constructor(context: Context): super(context) {
        initAttributes(context)
    }
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        initAttributes(context, attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        initAttributes(context, attrs)
    }

    fun initAttributes(context: Context, attrs: AttributeSet? = null) {
        this.context = context
        if (attrs == null) return
        val typed = context.obtainStyledAttributes(
            attrs,
            R.styleable.CBTextView
        )
        text = typed.getText(R.styleable.CBTextView_cb_text).toString()
        textColor = typed.getColor(
            R.styleable.CBTextView_cb_textSize,
            context.getColor(R.color.gray_5)
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = textColor ?: context.getColor(R.color.gray_5)

        canvas?.drawText(text, 0f, 0f, paint)
    }
}