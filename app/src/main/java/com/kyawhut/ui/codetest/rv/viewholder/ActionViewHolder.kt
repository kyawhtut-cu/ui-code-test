package com.kyawhut.ui.codetest.rv.viewholder

import com.kyawhut.ui.codetest.base.BaseViewHolder
import com.kyawhut.ui.codetest.data.model.ActionModel
import com.kyawhut.ui.codetest.databinding.CardActionBinding

/**
 * @author kyawhtut
 * @date 10/17/21
 */
class ActionViewHolder(
    vb: CardActionBinding
) : BaseViewHolder<CardActionBinding, ActionModel>(vb) {

    override fun bind() {
        vb.apply {
            actionTitle = data!!.actionTitle
            actionSummary = data!!.actionSummary
            actionRight = data!!.actionRight
            actionIcon = data!!.actionIcon
            executePendingBindings()
        }
    }
}
