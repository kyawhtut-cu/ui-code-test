package com.kyawhut.ui.codetest.rv.viewholder

import com.kyawhut.ui.codetest.base.BaseViewHolder
import com.kyawhut.ui.codetest.databinding.CardGalleryBinding

/**
 * @author kyawhtut
 * @date 10/17/21
 */
class GalleryViewHolder(
    vb: CardGalleryBinding
) : BaseViewHolder<CardGalleryBinding, String>(vb) {

    override fun bind() {
        vb.apply {
            galleryURL = data
            position = adapterPosition
        }
    }
}
