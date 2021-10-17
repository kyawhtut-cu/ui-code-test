package com.kyawhut.ui.codetest.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kyawhut.ui.codetest.BR
import com.kyawhut.ui.codetest.R
import com.kyawhut.ui.codetest.base.BaseActivity
import com.kyawhut.ui.codetest.data.model.ActionModel
import com.kyawhut.ui.codetest.data.model.actionModel
import com.kyawhut.ui.codetest.databinding.ActivityCarDetailBinding
import com.kyawhut.ui.codetest.rv.adapter.ActionAdapter
import com.kyawhut.ui.codetest.rv.adapter.GalleryAdapter

/**
 * @author kyawhtut
 * @date 10/17/21
 */
class CarDetailActivity : BaseActivity<ActivityCarDetailBinding>() {

    override val layoutID: Int
        get() = R.layout.activity_car_detail

    override val onClickName: Int
        get() = BR.onClickListener

    private val galleryAdapter: GalleryAdapter by lazy {
        GalleryAdapter()
    }

    private val actionAdapter: ActionAdapter by lazy {
        ActionAdapter()
    }

    private val dummyAction: List<ActionModel> by lazy {
        listOf(
            actionModel {
                actionTitle = "Estimate Total"
                actionSummary = "*Amount is not final"
                actionRight = "S$52.00"
                actionIcon = R.drawable.ic_arrow_right
            },
            actionModel {
                actionTitle = "Need help?"
                actionIcon = R.drawable.ic_help
            },
            actionModel {
                actionTitle = "Cancel this booking"
                actionIcon = R.drawable.ic_cancel
            }
        )
    }

    private val dummyGallery: List<String> by lazy {
        listOf(
            "https://previews.123rf.com/images/antpkr/antpkr1705/antpkr170500003/78336509-car-parking-interior-shopping-mall.jpg",
            "https://c8.alamy.com/comp/J0E9BT/car-parking-interior-shopping-mall-J0E9BT.jpg",
            "https://thumbs.dreamstime.com/z/car-parking-disabled-people-shopping-mall-car-parking-disabled-people-shopping-mall-indoor-parking-shopping-161257140.jpg",
            "https://res.cloudinary.com/twenty20/private_images/t_watermark-criss-cross-10/v1611006308000/photosp/96746783-01f4-44f9-877c-3c561b0859b9/stock-photo-blue-parking-lot-white-background-white-parking-cars-car-park-modern-architecture-birmingham-bullring-96746783-01f4-44f9-877c-3c561b0859b9.jpg"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        galleryAdapter.addAll(dummyGallery)

        actionAdapter.addAll(dummyAction)

        vb.apply {
            carouselView.addCarousel(*dummyGallery.toTypedArray())
            galleryAdapter = this@CarDetailActivity.galleryAdapter
            actionAdapter = this@CarDetailActivity.actionAdapter
            executePendingBindings()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.action_back -> super.onBackPressed()
            R.id.action_copy_booking_id -> Toast.makeText(
                this,
                "Copied booking id",
                Toast.LENGTH_LONG
            ).show()
            R.id.action_add_to_calendar -> Toast.makeText(
                this,
                "Added to calendar",
                Toast.LENGTH_LONG
            ).show()
            R.id.action_extend -> Toast.makeText(
                this,
                "Extend clicked",
                Toast.LENGTH_LONG
            ).show()
            R.id.action_direction -> Toast.makeText(
                this,
                "Clicked Direction",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
