package com.example.materialshapedrawableshadowissue

import android.content.res.Resources
import android.graphics.Paint
import android.graphics.Point
import android.os.Bundle
import android.util.TypedValue
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBottomAppBarBackground()
    }

    private fun setBottomAppBarBackground() {
        val width = window.getScreenWidth()
        val fabWidth = resources.dp2Px(56f)
        val fabMargin = resources.dp2Px(8f)
        val roundCornerRadius = resources.dp2Px(48f)
        val cradleVerticalOffset = resources.dp2Px(0f)
        val cornerWidth = (width - fabMargin * 2 - fabWidth - roundCornerRadius / 2f - fabMargin * 4) / 2f
        val cornerHeight = resources.dp2Px(16f)

        val shapePathModel = ShapeAppearanceModel().apply {
            topLeftCorner = QuadCornerTreatment(cornerWidth, cornerHeight)
            topRightCorner = QuadCornerTreatment(cornerWidth, cornerHeight, true)
            val topTreatment = BottomAppBarTopEdgeTreatment(fabMargin, roundCornerRadius, cradleVerticalOffset)
            topTreatment.fabDiameter = fabWidth
            topEdge = topTreatment
        }

        val backgroundDrawable = MaterialShapeDrawable(shapePathModel).apply {
            setTint(ContextCompat.getColor(baseContext, R.color.colorAccent))
            paintStyle = Paint.Style.FILL
            shadowCompatibilityMode = MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS
            elevation = resources.dp2Px(6f) // FIXME THIS IS NOT WORKING AS EXPECTED

        }

        bottom_bar.background = backgroundDrawable
    }

    private fun Resources.dp2Px(value: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, displayMetrics)
    }

    private fun Window.getScreenWidth(): Float {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x.toFloat()
    }

}
