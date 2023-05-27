package com.example.core.presentation.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import com.example.core.R
import com.example.core.extension.setImageWithRoundCorners

class RoundCornerImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : CardView(context, attrs, defStyleAttr) {

    private val imageView = AppCompatImageView(context)
    private var imageHint: Drawable? = null
    private var scaleType = ImageView.ScaleType.CENTER_CROP

    var image: Any? = null
        set(value) {
            field = value
            setImageWithRoundCorners(value ?: imageHint)
        }

    init {
        addView(imageView)

        prepareAttributes(
            context.obtainStyledAttributes(
                attrs,
                R.styleable.RoundCornerImageView,
                0,
                0
            )
        )

        imageView.scaleType = scaleType
        setImageWithRoundCorners(image ?: imageHint)
    }

    private fun setImageWithRoundCorners(image: Any?) {
        imageView.setImageWithRoundCorners(image, imageHint, radius.toInt())

    }

    private fun prepareAttributes(attributes: TypedArray) {
        image = attributes.getDrawable(R.styleable.RoundCornerImageView_src)
        imageHint = attributes.getDrawable(R.styleable.RoundCornerImageView_srcHint)

        when (attributes.getInt(R.styleable.RoundCornerImageView_scaleType, 5)) {
            0 -> scaleType = ImageView.ScaleType.MATRIX
            1 -> scaleType = ImageView.ScaleType.FIT_XY
            2 -> scaleType = ImageView.ScaleType.FIT_START
            3 -> scaleType = ImageView.ScaleType.FIT_CENTER
            4 -> scaleType = ImageView.ScaleType.FIT_END
            5 -> scaleType = ImageView.ScaleType.CENTER
            6 -> scaleType = ImageView.ScaleType.CENTER_CROP
            7 -> scaleType = ImageView.ScaleType.CENTER_INSIDE
        }
    }
}