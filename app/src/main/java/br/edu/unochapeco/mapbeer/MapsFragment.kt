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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
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

        var lat = p0!!.latitude
        var lon = p0.longitude


        var marcador = LatLng(lat,lon)
        val marker = MarkerOptions()
//
        mMap.addMarker(marker.position(marcador).title("Maker in my house").snippet("Test")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer_foreground)))
    }
}