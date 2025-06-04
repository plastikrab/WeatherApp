package dev.plastikrab.weatherapp.data.device.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationListener
import android.location.LocationManager
import androidx.annotation.RequiresPermission
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.plastikrab.weatherapp.domain.entities.deviceData.Location
import dev.plastikrab.weatherapp.domain.repositories.ILocationRepository
import javax.inject.Inject


@SuppressLint("MissingPermission")
class LocationRepositoryImpl@Inject constructor(
    @ApplicationContext private val context: Context
): ILocationRepository, LocationListener {
    private var _location = Location(0.0, 0.0)
    private var locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager


    override fun getCurrentLocation(): Location {
        return _location
    }

    override fun onLocationChanged(p0: android.location.Location) {
        _location = Location(p0.latitude, p0.longitude)
    }

    init {
        startLocationUpdates()
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun startLocationUpdates() {
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            10000,
            0f,
            this)
    }
}