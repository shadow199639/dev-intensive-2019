package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import ru.skillbranch.devintensive.R

private const val DEFAULT_ASPECT_RATIO = 1.78f

class AspectRatioImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyle) {

    private var aspectRatio = DEFAULT_ASPECT_RATIO

    init {
        attrs?.let { attributeSet ->
            val a = context.obtainStyledAttributes(attributeSet, R.styleable.AspectRatioImageView)
            aspectRatio = a.getFloat(R.styleable.AspectRatioImageView_aspectRatio, DEFAULT_ASPECT_RATIO)
            a.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val newHeight = (measuredWidth/aspectRatio).toInt()
        setMeasuredDimension(measuredWidth, newHeight)
    }
}