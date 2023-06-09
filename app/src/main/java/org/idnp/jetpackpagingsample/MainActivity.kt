package org.idnp.jetpackpagingsample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.idnp.jetpackpagingsample.adapters.CountryAdapter
import org.idnp.jetpackpagingsample.data.countries_list
import org.idnp.jetpackpagingsample.database.CountryDatabase
import org.idnp.jetpackpagingsample.paging.CountryViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel by viewModels<CountryViewModel>()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val pagingAdapter = CountryAdapter()

        recyclerView.adapter = pagingAdapter
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

        lifecycleScope.launch {
            viewModel.items().collectLatest { pageData ->
                pagingAdapter.submitData(pageData)
            }
        }

        init_database()

    }

    private fun init_database() {
        val countryDao = CountryDatabase.getInstance(this.applicationContext).countryDao()

        GlobalScope.launch {
            for (i in countries_list) {
                countryDao.insert(i)
            }
        }
    }

}