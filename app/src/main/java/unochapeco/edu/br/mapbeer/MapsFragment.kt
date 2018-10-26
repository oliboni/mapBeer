package unochapeco.edu.br.mapbeer

import android.annotation.SuppressLint
import android.app.Activity
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : SupportMapFragment(), OnMapReadyCallback, GoogleMap.OnMapClickListener {


    private lateinit var mMap: GoogleMap
    private val TAG: String = "MapsFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_maps)
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



        // Add a marker in house and move the camera
        val house = LatLng(-33.87365, 151.20689)

        var marker = MarkerOptions()

        marker.position(house)
        marker.title("Maker in my house")

        mMap.addMarker(marker)

        mMap.moveCamera(CameraUpdateFactory.newLatLng(house))
//        mMap.animateCamera(CameraUpdateFactory.zoomBy(20F),3000,null)


        mMap.mapType =  GoogleMap.MAP_TYPE_SATELLITE
    }

    override fun onMapClick(p0: LatLng?) {
        Toast.makeText( context, "Coordenadas: " + p0.toString(), Toast.LENGTH_SHORT).show()

    }
}
