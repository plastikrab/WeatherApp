package dev.plastikrab.weatherapp.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import javax.inject.Inject

class PermissionsManager @Inject constructor(
    private val context: Activity
) {
    companion object {
        private val PERMISSIONS = arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
    }

    fun checkPermissions() {
        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(
                context,
                PERMISSIONS,
                0
            )
        }
    }

    fun hasRequiredPermissions(): Boolean {
        return PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }
}