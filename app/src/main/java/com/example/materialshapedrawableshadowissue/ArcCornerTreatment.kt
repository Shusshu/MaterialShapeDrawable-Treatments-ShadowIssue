package com.example.materialshapedrawableshadowissue

import com.google.android.material.shape.CornerTreatment
import com.google.android.material.shape.ShapePath

class ArcCornerTreatment(val width: Float, val height: Float, private val isRightSide: Boolean = false) : CornerTreatment() {

    override fun getCornerPath(angle: Float, interpolation: Float, shapePath: ShapePath) {
        if (!isRightSide) {

            val (xa, ya) = 0f to height * interpolation
            val (xb, yb) = width * 1/5f to height * 1/3f * interpolation
            val (xc, yc) = width to 0f

            shapePath.reset(xa, ya)
            shapePath.addArc(xa, yb, xb * 2f, ya * 2f, 180f, 90f)
            shapePath.addArc(xb, yc, xc * 2f, yb * 2f, 180f, 90f)

        } else {

            val (xa, ya) = 0f to width * interpolation
            val (xb, yb) = height * 1/3f to width * 1/5f * interpolation
            val (xc, yc) = height to 0f

            shapePath.reset(xa, ya)
            shapePath.addArc(xa, yb, xb * 2f, ya * 2f, 180f, 90f)

            shapePath.addArc(xb, yc, xc * 2f, yb * 2f, 180f, 90f)
        }
    }
}
