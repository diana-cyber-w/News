package com.example.homework21.presentation.customViews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.homework21.R

class HeaderView(context: Context, attrs: AttributeSet) :
    View(context, attrs) {

    private var titleText: String = ""
    private var titleTextColor: Int = 0
    private var titleTextSize: Float = 24f

    private var subTitleText: String = ""
    private var subTitleTextColor: Int = 0
    private var subTitleTextSize: Float = 16f

    private var titleCoordinates: Pair<Float, Float> = 100f to 100f
    private var subTitleCoordinates: Pair<Float, Float> = 100f to 100f

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.HeaderView, 0, 0)
            .apply {
                titleText = getString(R.styleable.HeaderView_titleText)!!
                titleTextColor = getColor(R.styleable.HeaderView_titleTextColor, 0)
                titleTextSize = getDimension(R.styleable.HeaderView_titleTextSize, 24f)
                subTitleText = getString(R.styleable.HeaderView_subTitleText)!!
                subTitleTextColor = getColor(R.styleable.HeaderView_subTitleTextColor, 0)
                subTitleTextSize = getDimension(R.styleable.HeaderView_subTitleTextSize, 16f)
            }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        resolveSubTitleTextSize()
        titleCoordinates = calculateTitleCoordinates()
        subTitleCoordinates = calculateSubTitleCoordinates()
    }

    private val titlePaint = Paint().apply {
        color = titleTextColor
        textSize = titleTextSize
        textAlign = Paint.Align.CENTER
    }
    private val subTitlePaint = Paint().apply {
        color = subTitleTextColor
        textSize = subTitleTextSize
        textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(
            titleText,
            titleCoordinates.first,
            titleCoordinates.second,
            titlePaint
        )
        canvas?.drawText(
            subTitleText,
            subTitleCoordinates.first,
            subTitleCoordinates.second,
            subTitlePaint
        )
    }

    private fun resolveSubTitleTextSize() {
        if (subTitlePaint.textSize >= titlePaint.textSize) {
            subTitlePaint.textSize = titlePaint.textSize / 2
        }
    }

    private fun calculateTitleCoordinates(): Pair<Float, Float> {
        return x + width / 2f - (titlePaint.descent() + titlePaint.ascent()) / 2f to y + height / 2f
    }

    private fun calculateSubTitleCoordinates(): Pair<Float, Float> {
        return x + width / 2f - (subTitlePaint.descent() + subTitlePaint.ascent()) / 2f to y + height / 2f + titlePaint.textSize
    }
}