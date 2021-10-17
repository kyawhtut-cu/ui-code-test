package com.kyawhut.ui.codetest.rv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kyawhut.ui.codetest.base.BaseAdapter
import com.kyawhut.ui.codetest.base.BaseViewHolder
import com.kyawhut.ui.codetest.databinding.CardGalleryBinding
import com.kyawhut.ui.codetest.rv.viewholder.GalleryViewHolder

/**
 * @author kyawhtut
 * @date 10/17/21
 */
class GalleryAdapter : BaseAdapter<String>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, String> {
        return GalleryViewHolder(
            CardGalleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}
