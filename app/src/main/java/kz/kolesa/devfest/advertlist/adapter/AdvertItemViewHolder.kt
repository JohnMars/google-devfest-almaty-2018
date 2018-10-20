package kz.kolesa.devfest.advertlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_advert.view.layout_item_advert_image
import kotlinx.android.synthetic.main.layout_item_advert.view.layout_item_advert_price
import kotlinx.android.synthetic.main.layout_item_advert.view.layout_item_advert_specification
import kotlinx.android.synthetic.main.layout_item_advert.view.layout_item_advert_title
import kz.kolesa.devfest.R
import kz.kolesa.devfest.domain.entity.Advertisement
import kz.kolesa.devfest.extension.load

class AdvertItemViewHolder(
        view: View
) : RecyclerView.ViewHolder(view) {

    private val titleView = view.layout_item_advert_title
    private val specification = view.layout_item_advert_specification
    private val imageView = view.layout_item_advert_image
    private val priceView = view.layout_item_advert_price

    fun onBind(advertisement: Advertisement) {
        val resources = itemView.context.resources
        titleView.text = advertisement.title
        specification.text = advertisement.specification
        advertisement.photos.firstOrNull()?.let {
            imageView.load(it.url)
        }
        priceView.text = resources.getString(R.string.layout_item_advert_price, advertisement.price)
    }
}