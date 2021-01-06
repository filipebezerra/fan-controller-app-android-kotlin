package dev.filipebezerra.android.example.fancontroller.dial

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class DialView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(
    context,
    attrs,
    defStyleAttr
) {
    // Radius of the circle
    private var radius = 0.0f
    // The active speed selection
    private var fanSpeed = FanSpeed.OFF
    // position which will be used to draw label and circle position
    private val pointPosition = PointF(0.0f, 0.0f)
    //
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.DEFAULT_BOLD
    }
    companion object {
        private const val RADIUS_OFFSET_LABEL = 30
        private const val RADIUS_OFFSET_INDICATOR = -35
    }

    // TODO extract fixed value 2.0 to a constant
    // TODO extract fixed value 0.8 to a constant
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        radius = (min(width, height) / 2.0 * 0.8).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let { dialCanvas ->
            // Set dial background color to green if selection not off
            paint.color = if (fanSpeed == FanSpeed.OFF) Color.GRAY else Color.GREEN

            // Draw the dial
            dialCanvas.drawCircle(
                (width / 2.0f),
                (height / 2.0f),
                radius,
                paint
            )

            // Draw the indicator circle
            val markerRadius = radius + RADIUS_OFFSET_INDICATOR
            pointPosition.computeXYForSpeed(fanSpeed, markerRadius)
            paint.color = Color.BLACK
            dialCanvas.drawCircle(
                pointPosition.x,
                pointPosition.y,
                (radius / 12),
                paint
            )

            // Draw the text labels.
            val labelRadius = radius + RADIUS_OFFSET_LABEL
            for (l in FanSpeed.values()) {
                pointPosition.computeXYForSpeed(l, labelRadius)
                dialCanvas.drawText(
                    context.getString(l.label),
                    pointPosition.x,
                    pointPosition.y,
                    paint
                )
            }
        }
    }

    private fun PointF.computeXYForSpeed(position: FanSpeed, radius: Float) {
        // Angle are in radius
        val startAngle = Math.PI * (9 / 8.0)
        val angle = startAngle + position.ordinal * (Math.PI / 4)
        x = (radius * cos(angle)).toFloat() + width / 2
        y = (radius * sin(angle)).toFloat() + height / 2
    }
}