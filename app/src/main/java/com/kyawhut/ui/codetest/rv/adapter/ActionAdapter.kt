package com.kyawhut.ui.codetest.rv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kyawhut.ui.codetest.base.BaseAdapter
import com.kyawhut.ui.codetest.base.BaseViewHolder
import com.kyawhut.ui.codetest.data.model.ActionModel
import com.kyawhut.ui.codetest.databinding.CardActionBinding
import com.kyawhut.ui.codetest.rv.viewholder.ActionViewHolder

/**
 * @author kyawhtut
 * @date 10/17/21
 */
class ActionAdapter : BaseAdapter<ActionModel>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, ActionModel> {
        return ActionViewHolder(
            CardActionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}
