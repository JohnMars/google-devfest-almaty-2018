package kz.kolesa.devfest.advertdetails.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class GalleryAdapter(
        fragmentManager: FragmentManager,
        private val imageUrls: List<String>
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = GalleryFragment().apply {
        arguments = Bundle().apply {
            putString(IMAGE_URL_KEY, imageUrls[position])
        }
    }

    override fun getCount(): Int = imageUrls.size
}