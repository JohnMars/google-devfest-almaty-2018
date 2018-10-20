package kz.kolesa.devfest.advertlist.adapter

import androidx.recyclerview.widget.DiffUtil
import kz.kolesa.devfest.domain.entity.Advertisement

object AdvertisementDiffUtil : DiffUtil.ItemCallback<Advertisement>() {

    override fun areItemsTheSame(
            oldItem: Advertisement,
            newItem: Advertisement
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
            oldItem: Advertisement,
            newItem: Advertisement
    ): Boolean = oldItem == newItem
}