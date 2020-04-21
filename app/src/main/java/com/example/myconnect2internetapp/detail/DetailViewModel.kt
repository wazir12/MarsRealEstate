package com.example.myconnect2internetapp.detail

import android.app.Application
import androidx.lifecycle.*
import com.example.myconnect2internetapp.network.MarsProperty as MarsProperty


/**
 * The [ViewModel] that is associated with the [DetailFragment].
 */
class DetailViewModel(marsProperty: MarsProperty, app: Application) :
    AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<MarsProperty>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<MarsProperty>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = marsProperty
    }

    // The displayPropertyPrice formatted Transformation Map LiveData, which displays the sale
    // or rental price.

    val displayPropertyPrice = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
            when (it.isRental) {
                true -> com.example.myconnect2internetapp.R.string.display_price_monthly_rental
                false -> com.example.myconnect2internetapp.R.string.display_price
            }, it.price)
    }

    // The displayPropertyType formatted Transformation Map LiveData, which displays the
    // "For Rent/Sale" String

    val displayPropertyType = Transformations.map(selectedProperty) {
        app.applicationContext.getString(com.example.myconnect2internetapp.R.string.display_type,
            app.applicationContext.getString(
                when(it.isRental) {
                    true -> com.example.myconnect2internetapp.R.string.type_rent
                    false -> com.example.myconnect2internetapp.R.string.type_sale
                }))
    }




}
