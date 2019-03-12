package com.example.materialshapedrawableshadowissue

import com.google.android.material.shape.CornerTreatment
import com.google.android.material.shape.ShapePath

class QuadCornerTreatment(val width: Float, val height: Float, private val isRightSide: Boolean = false) : CornerTreatment() {

    override fun getCornerPath(angle: Float, interpolation: Float, shapePath: ShapePath) {
        if (!isRightSide) {
            shapePath.lineTo(0.0f, height * interpolation)
            shapePath.quadToPoint(width * 1 / 20f, height * 1/3f * interpolation, width, 0f)
        } else {
            shapePath.lineTo(0.0f, width * interpolation)
            shapePath.quadToPoint(height * 1 / 20f, width * 1/3f * interpolation, height, 0f)
        }
    }
}
