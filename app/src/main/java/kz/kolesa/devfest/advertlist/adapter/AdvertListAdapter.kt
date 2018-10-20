package kz.kolesa.devfest.advertlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kz.kolesa.devfest.R
import kz.kolesa.devfest.domain.entity.Advertisement

class AdvertListAdapter(
        private var onItemClickListener: ((Advertisement) -> Unit)?
) : ListAdapter<Advertisement, AdvertItemViewHolder>(AdvertisementDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_item_advert, parent, false)

        return AdvertItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdvertItemViewHolder, position: Int) {
        val advertisement = getItem(position)
        holder.onBind(advertisement)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(advertisement)
        }
    }
}