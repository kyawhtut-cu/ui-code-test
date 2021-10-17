package com.kyawhut.ui.codetest.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.kyawhut.ui.codetest.R
import com.kyawhut.ui.codetest.databinding.ComponentRentViewBinding

/**
 * @author kyawhtut
 * @date 10/16/21
 */
class ComponentRentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val vb: ComponentRentViewBinding by lazy {
        ComponentRentViewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    var visibleGO: Int = View.VISIBLE
        set(value) {
            field = value
            vb.actionGo.visibility = value
        }

    private var onGoClickListener: (() -> Unit)? = null

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ComponentRentView, 0, 0)
        try {
            visibleGO = when (a.getInt(R.styleable.ComponentRentView_visibleGO, 0)) {
                1 -> View.INVISIBLE
                2 -> View.GONE
                else -> View.VISIBLE
            }
        } finally {
            a.recycle()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        visibility = View.VISIBLE

        vb.actionGo.setOnClickListener {
            onGoClickListener?.invoke()
        }
    }

    fun setOnGoClickListener(callback: () -> Unit) {
        this.onGoClickListener = callback
    }

}
