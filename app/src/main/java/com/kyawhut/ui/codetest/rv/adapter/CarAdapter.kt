package com.kyawhut.ui.codetest.rv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kyawhut.ui.codetest.base.BaseAdapter
import com.kyawhut.ui.codetest.base.BaseViewHolder
import com.kyawhut.ui.codetest.databinding.CardCarViewBinding
import com.kyawhut.ui.codetest.rv.viewholder.CarViewHolder

/**
 * @author kyawhtut
 * @date 10/17/21
 */
class CarAdapter(
    itemClickListener: (Int, String) -> Unit
) : BaseAdapter<String>(itemClickListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, String> {
        return CarViewHolder(
            CardCarViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClickListener
        )
    }
}