package br.edu.unochapeco.mapbeer

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : SupportMapFragment(), OnMapReadyCallback, GoogleMap.OnMapClickListener{

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMapAsync(this)
    }

    @SuppressLint("MissingPermission")

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.isMyLocationEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMapClickListener(this)

        val house = LatLng(-27.074323, -52.637181)

        val marker = MarkerOptions()

        mMap.addMarker(marker.position(house).title("Maker in my house").snippet("Test")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer_foreground)))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(house, 17F))


//        mMap.mapType =  GoogleMap.MAP_TYPE_SATELLITE
    }

    override fun onMapClick(p0: LatLng?) {
//        Toast.makeText(context, "Coordenadas: " + p0.toString(), Toast.LENGTH_SHORT).show()

        val lat = p0!!.latitude
        val lon = p0.longitude


        val marcador = LatLng(lat,lon)
        val marker = MarkerOptions()
//
        mMap.addMarker(marker.position(marcador).title("Maker in my house").snippet("Test")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer_foreground)))
    }

    fun typeMap(id: Int){
        when(id){
            1-> mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            2-> mMap.mapType =  GoogleMap.MAP_TYPE_SATELLITE
            3-> mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
        }

    }
}