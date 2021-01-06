package dev.filipebezerra.android.example.fancontroller.dial

import android.content.Context
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

class DialView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(
    context,
    attrs,
    defStyleAttr
) {
    // Radius of the circl
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
}