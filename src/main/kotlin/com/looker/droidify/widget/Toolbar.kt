package com.looker.droidify.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.Toolbar

class Toolbar : Toolbar {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var initalized = false
    private var layoutDirectionChanged: Int? = null

    init {
        initalized = true
        val layoutDirection = layoutDirectionChanged
        layoutDirectionChanged = null
        if (layoutDirection != null) onRtlPropertiesChanged(layoutDirection)
    }

    override fun onRtlPropertiesChanged(layoutDirection: Int) {
        if (initalized) {
            super.onRtlPropertiesChanged(layoutDirection)
        } else {
            layoutDirectionChanged = layoutDirection
        }
    }
}
