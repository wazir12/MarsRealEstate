package com.example.myconnect2internetapp.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.myconnect2internetapp.network.MarsProperty


/**
 * The [ViewModel] that is associated with the [DetailFragment].
 */
class DetailViewModel(@Suppress("UNUSED_PARAMETER")marsProperty: MarsProperty, app: Application) :
    AndroidViewModel(app) {
}