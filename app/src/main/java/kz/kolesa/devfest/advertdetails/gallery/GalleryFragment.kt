package kz.kolesa.devfest.advertdetails.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_gallery.view.fragment_gallery_image_view
import kz.kolesa.devfest.R
import kz.kolesa.devfest.extension.load
import java.lang.IllegalArgumentException

const val IMAGE_URL_KEY = "image_url"

class GalleryFragment : Fragment() {

    private lateinit var imageUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageUrl = arguments?.getString(IMAGE_URL_KEY, null)
                ?: throw IllegalArgumentException("You should pass $IMAGE_URL_KEY to this Fragment")
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_gallery, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.fragment_gallery_image_view.load(imageUrl)
    }
}