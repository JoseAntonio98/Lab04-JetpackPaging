package org.idnp.jetpackpagingsample.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.idnp.jetpackpagingsample.R
import org.idnp.jetpackpagingsample.entities.Country

class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name_en_text = view.findViewById<TextView>(R.id.textViewName) as TextView
    private val capital_en_text = view.findViewById<TextView>(R.id.textViewCapital) as TextView
    private val km2_text = view.findViewById<TextView>(R.id.textViewKm) as TextView

    fun bind(country: Country) {
        with(country) {
            name_en_text.text = name_en.toString()
            capital_en_text.text = capital_en.toString()
            km2_text.text = km2.toString()
        }
    }
}