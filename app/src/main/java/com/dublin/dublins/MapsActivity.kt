package com.dublin.dublins
//(MD .IMRUL MAHAMUD
//STUDENT ID:18317
//MD.ROKIBUL ISLAM
//STUDENT ID:18315

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dublin.dublins.MainActivity.Companion.list

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.json.JSONObject

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    // Map veriable
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // static veriable from the mainacitivty
        // All coordinates fetch here easly to show pointer on map
        for (i in 0 until list!!.size)
        {
//{"lat":53.349562,"lng":-6.278198}
            val position = list?.get(i)?.postion
            val json_object = JSONObject(position)
            val location = LatLng(json_object.getDouble("lat"), json_object.getDouble("lng"))
            // to collect the corrdinates here
            mMap.addMarker(MarkerOptions().position(location).title(list?.get(i)?.name))
//            mMap?.animateCamera(CameraUpdateFactory.newLatLng(location),13f)
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                LatLng(location.latitude,location.longitude ), 13F ))



        }


        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
