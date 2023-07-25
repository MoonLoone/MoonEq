package com.example.eqtest.domain.management

import android.Manifest
import android.app.Activity
import androidx.core.app.ActivityCompat
import com.example.eqtest.tools.EqConstants

fun requestExternalStorage(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_SMS,
            ),
            EqConstants.RequestCodes.ExternalRequestCode.id,
        )
    }
