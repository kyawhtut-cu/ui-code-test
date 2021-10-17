package com.kyawhut.ui.codetest.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.kyawhut.ui.codetest.BR
import com.kyawhut.ui.codetest.R
import com.kyawhut.ui.codetest.base.BaseActivity
import com.kyawhut.ui.codetest.databinding.ActivitySearchBinding
import com.kyawhut.ui.codetest.rv.adapter.CarAdapter
import com.kyawhut.ui.codetest.ui.detail.CarDetailActivity

/**
 * @author kyawhtut
 * @date 10/16/21
 */
class SearchActivity : BaseActivity<ActivitySearchBinding>() {

    override val layoutID: Int
        get() = R.layout.activity_search
    override val onClickName: Int
        get() = BR.onClickListener

    private val carAdapter: CarAdapter by lazy {
        CarAdapter { _, _ ->
            startActivity(Intent(this, CarDetailActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (0 until 15).forEach {
            carAdapter.addItem("$it")
        }

        vb.apply {
            carAdapter = this@SearchActivity.carAdapter
            executePendingBindings()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.action_back -> super.onBackPressed()
        }
    }
}
