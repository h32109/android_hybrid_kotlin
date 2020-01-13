package com.example.mapapp



import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    private var mMap: GoogleMap? = null
    val PERMISSIONS = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.mapapp.R.layout.activity_maps)



        val mapFragment = supportFragmentManager
            .findFragmentById(com.example.mapapp.R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }



    override fun onMapReady(googleMap: GoogleMap) {



        mMap = googleMap



        val SEOUL = LatLng(37.56, 126.97)



        val markerOptions = MarkerOptions()
        markerOptions.position(SEOUL)
        markerOptions.title("서울")
        markerOptions.snippet("한국의 수도")
        mMap!!.addMarker(markerOptions)



        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(SEOUL))
        mMap!!.animateCamera(CameraUpdateFactory.zoomTo(10f))
    }
}
