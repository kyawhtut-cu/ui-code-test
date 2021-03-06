package com.kyawhut.ui.codetest.utils.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.kyawhut.ui.codetest.base.BaseAdapter
import com.kyawhut.ui.codetest.utils.glide.GlideApp

/**
 * @author kyawhtut
 * @date 10/13/21
 */
object ViewBindingUtils {

    enum class LayoutType {
        HORIZONTAL_LAYOUT, VERTICAL_LAYOUT, GRIDLAYOUT
    }


    @JvmStatic
    @BindingAdapter("imageURL")
    fun ImageView.load(url: String?) {
        GlideApp.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    }

    @JvmStatic
    @BindingAdapter("loadResource")
    fun ImageView.loadResource(res: Int?) {
        if (res == null) return
        this.setImageResource(res)
    }

    @JvmStatic
    @BindingAdapter("adapter", "layoutManger", "itemCount", requireAll = false)
    fun RecyclerView.bindAdapter(
        adapter: BaseAdapter<*>?,
        layoutType: LayoutType?,
        itemCount: Int?
    ) {
        if (adapter == null) return
        this.apply {
            this.adapter = adapter
            layoutManager = when (layoutType) {
                LayoutType.HORIZONTAL_LAYOUT -> LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                LayoutType.VERTICAL_LAYOUT -> LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                LayoutType.GRIDLAYOUT -> GridLayoutManager(context, itemCount ?: 1)
                else -> LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }
}
