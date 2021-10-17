package com.kyawhut.ui.codetest.data.model

/**
 * @author kyawhtut
 * @date 10/17/21
 */
data class ActionModel private constructor(
    val actionTitle: String,
    val actionSummary: String,
    val actionRight: String,
    val actionIcon: Int,
) {
    class Builder {
        var actionTitle: String = ""
        var actionSummary: String = ""
        var actionRight: String = ""
        var actionIcon: Int = 0

        fun build(): ActionModel = ActionModel(actionTitle, actionSummary, actionRight, actionIcon)
    }
}

fun actionModel(block: ActionModel.Builder.() -> Unit): ActionModel {
    return ActionModel.Builder().also(block).build()
}
