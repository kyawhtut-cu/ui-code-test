package com.kyawhut.ui.codetest.rv.viewholder

import com.kyawhut.ui.codetest.base.BaseViewHolder
import com.kyawhut.ui.codetest.databinding.CardCarViewBinding

/**
 * @author kyawhtut
 * @date 10/17/21
 */
class CarViewHolder(
    vb: CardCarViewBinding,
    itemClickListener: (Int, String) -> Unit
) : BaseViewHolder<CardCarViewBinding, String>(vb, itemClickListener) {

    override fun bind() {
    }
}
