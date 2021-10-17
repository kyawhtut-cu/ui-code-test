package com.kyawhut.ui.codetest.rv.viewholder

import com.kyawhut.ui.codetest.base.BaseViewHolder
import com.kyawhut.ui.codetest.databinding.CardCarouselViewBinding

/**
 * @author kyawhtut
 * @date 10/14/21
 */
class CarouselViewHolder(
    vb: CardCarouselViewBinding,
    itemClickListener: (Int, String) -> Unit,
) : BaseViewHolder<CardCarouselViewBinding, String>(vb, itemClickListener) {

    override fun bind() {
        vb.apply {
            image = data ?: ""
            executePendingBindings()
        }
    }
}
