package org.idnp.jetpackpagingsample.paging

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import org.idnp.jetpackpagingsample.database.CountryDatabase
import org.idnp.jetpackpagingsample.entities.Country
import org.idnp.jetpackpagingsample.model.CountryRepository

class CountryViewModel (app: Application) : AndroidViewModel(app){

    //private val countryRepository: CountryRepository = CountryRepository(app)
    val countryDao = CountryDatabase.getInstance(app.applicationContext).countryDao()

    fun items(): Flow<PagingData<Country>> {

        val pager = Pager(
            PagingConfig(
                pageSize = 5,
                enablePlaceholders = false,
                prefetchDistance = 3)
        ) {
            countryDao.pagingSource()
            //CountryPagingSource(countryRepository)
        }.flow.cachedIn(viewModelScope)

        return pager

    }
}