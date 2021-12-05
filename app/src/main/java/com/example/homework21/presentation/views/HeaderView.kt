package com.example.homework21.presentation.views

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.homework21.R

class HeaderView(context: Context, attrs: AttributeSet) :
    View(context, attrs) {

    companion object {
        private const val DEFAULT_COORDINATE = 0f
        private const val DEFAULT_SQUARE_UPPER_LEFT_COORDINATE = 10f
        private const val DEFAULT_SQUARE_LOWER_RIGHT_COORDINATE = 250f
        private const val DEFAULT_TITLE_TEXT_SIZE = 24f
        private const val DEFAULT_SUBTITLE_TEXT_SIZE = 16f
        private const val DEFAULT_CIRCLE_START_ANGLE = 0f
        private const val DEFAULT_STROKE_WIDTH = 5f
    }

    private var titleText: String = ""
    private var titleTextColor: Int = 0
    private var titleTextSize: Float = 24f

    private var subTitleText: String = ""
    private var subTitleTextColor: Int = 0
    private var subTitleTextSize: Float = 16f

    private var squareColor: Int = 0
    private var circleColor: Int = 0

    private var titleCoordinates: Pair<Float, Float> =
        DEFAULT_COORDINATE to DEFAULT_COORDINATE
    private var subTitleCoordinates: Pair<Float, Float> =
        DEFAULT_COORDINATE to DEFAULT_COORDINATE
    private var squareUpperLeftPoint: Pair<Float, Float> =
        DEFAULT_SQUARE_UPPER_LEFT_COORDINATE to DEFAULT_SQUARE_UPPER_LEFT_COORDINATE
    private var squareLowerRightPoint: Pair<Float, Float> =
        DEFAULT_SQUARE_LOWER_RIGHT_COORDINATE to DEFAULT_SQUARE_LOWER_RIGHT_COORDINATE

    private var circleSweepAngle = 0f
    private var circleDrawDuration: Int = 0
    private var valueAnimator = ValueAnimator.ofFloat(0f, 360f)

    init {

        context.theme.obtainStyledAttributes(attrs, R.styleable.HeaderView, 0, 0)
            .apply {
                titleText = getString(R.styleable.HeaderView_titleText).orEmpty()
                titleTextColor = getColor(R.styleable.HeaderView_titleTextColor, 0)
                titleTextSize =
                    getDimension(R.styleable.HeaderView_titleTextSize, DEFAULT_TITLE_TEXT_SIZE)
                subTitleText = getString(R.styleable.HeaderView_subTitleText).orEmpty()
                subTitleTextColor = getColor(R.styleable.HeaderView_subTitleTextColor, 0)
                subTitleTextSize = getDimension(
                    R.styleable.HeaderView_subTitleTextSize,
                    DEFAULT_SUBTITLE_TEXT_SIZE
                )
                squareColor = getColor(R.styleable.HeaderView_squareColor, 0)
                circleColor = getColor(R.styleable.HeaderView_circleColor, 0)
                circleDrawDuration = getInteger(R.styleable.HeaderView_circleDrawDuration, 0)
            }
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
    private val squarePaint = Paint().apply {
        color = squareColor
    }
    private val circlePaint = Paint().apply {
        color = circleColor
        style = Paint.Style.STROKE
        strokeWidth = DEFAULT_STROKE_WIDTH
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        resolveSubTitleTextSize()
        titleCoordinates = calculateTitleCoordinates()
        subTitleCoordinates = calculateSubTitleCoordinates()
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
        canvas?.drawRect(
            squareUpperLeftPoint.first,
            squareUpperLeftPoint.second,
            squareLowerRightPoint.first,
            squareLowerRightPoint.second,
            squarePaint
        )

        setOnClickListener {

        }
        canvas?.drawArc(
            squareUpperLeftPoint.first,
            squareUpperLeftPoint.second,
            squareLowerRightPoint.first,
            squareLowerRightPoint.second,
            DEFAULT_CIRCLE_START_ANGLE,
            circleSweepAngle,
            false,
            circlePaint
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

    fun onStartAnimation() {
        valueAnimator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            circleSweepAngle = value
            invalidate()
        }

        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.duration = circleDrawDuration.toLong()
        valueAnimator.start()
    }
}