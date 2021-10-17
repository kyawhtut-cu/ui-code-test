package com.kyawhut.ui.codetest.rv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kyawhut.ui.codetest.base.BaseAdapter
import com.kyawhut.ui.codetest.base.BaseViewHolder
import com.kyawhut.ui.codetest.databinding.CardCarouselViewBinding
import com.kyawhut.ui.codetest.rv.viewholder.CarouselViewHolder

/**
 * @author kyawhtut
 * @date 10/14/21
 */
class CarouselAdapter(
    itemClickListener: (Int, String) -> Unit,
) : BaseAdapter<String>(itemClickListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, String> {
        return CarouselViewHolder(
            CardCarouselViewBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            itemClickListener
        )
    }
}
