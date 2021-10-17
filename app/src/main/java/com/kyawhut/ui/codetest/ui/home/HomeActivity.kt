package com.kyawhut.ui.codetest.ui.home

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kyawhut.ui.codetest.R
import com.kyawhut.ui.codetest.base.BaseActivity
import com.kyawhut.ui.codetest.databinding.ActivityHomeBinding
import com.kyawhut.ui.codetest.databinding.MapMarkerViewBinding
import com.kyawhut.ui.codetest.ui.search.SearchActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>(), OnMapReadyCallback {

    companion object {
        private const val ZOOM_LEVEL: Float = 16f
    }

    override val layoutID: Int
        get() = R.layout.activity_home

    private lateinit var googleMap: GoogleMap

    private val isHasLocationPermission: Boolean
        get() = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        vb.rentView.setOnGoClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        if (!isHasLocationPermission) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        this.googleMap.isTrafficEnabled = true
        this.googleMap.uiSettings.isCompassEnabled = false
        this.googleMap.uiSettings.isZoomGesturesEnabled = true
        this.googleMap.uiSettings.isRotateGesturesEnabled = false
        this.googleMap.uiSettings.isScrollGesturesEnabled = true
        this.googleMap.uiSettings.isScrollGesturesEnabledDuringRotateOrZoom = true
        this.googleMap.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(17.3366759, 96.4893953),
                ZOOM_LEVEL
            )
        )
        this.googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(17.3366759, 96.4893953))
                .icon(getMarkerIcon(2, true))
                .draggable(false)
                .visible(true)
        ).showInfoWindow()

        this.googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(17.3367364, 96.4893749))
                .icon(getMarkerIcon(3, true))
                .draggable(false)
                .visible(true)
        ).showInfoWindow()

        this.googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(17.3367473, 96.4890597))
                .icon(getMarkerIcon(6, true))
                .draggable(false)
                .visible(true)
        ).showInfoWindow()
    }

    private fun getMarkerIcon(position: Int, status: Boolean): BitmapDescriptor? {
        val markerView = MapMarkerViewBinding.inflate(
            LayoutInflater.from(this),
            null,
            false
        )
        markerView.tvCount.text = "$position"
        markerView.tvCarStatus.text = if (status) "Available" else "Unavailable"
        markerView.root.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        markerView.root.layout(0, 0, markerView.root.measuredWidth, markerView.root.measuredHeight)
        markerView.root.buildDrawingCache()
        val markerBitmap = Bitmap.createBitmap(
            markerView.root.measuredWidth,
            markerView.root.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(markerBitmap)
        markerView.root.background?.draw(canvas)
        markerView.root.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(markerBitmap)
    }
}
