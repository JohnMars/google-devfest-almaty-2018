package kz.kolesa.devfest.advertdetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_advert_details.activity_advert_details_call
import kotlinx.android.synthetic.main.activity_advert_details.activity_advert_details_parameters
import kotlinx.android.synthetic.main.activity_advert_details.activity_advert_details_price
import kotlinx.android.synthetic.main.activity_advert_details.activity_advert_details_specification
import kotlinx.android.synthetic.main.activity_advert_details.activity_advert_details_text
import kotlinx.android.synthetic.main.activity_advert_details.activity_advert_details_title
import kotlinx.android.synthetic.main.activity_advert_details.activity_advert_details_view_pager
import kotlinx.android.synthetic.main.layout_item_parameter.view.layout_item_parameter_label
import kotlinx.android.synthetic.main.layout_item_parameter.view.layout_item_parameter_value
import kz.kolesa.devfest.R
import kz.kolesa.devfest.advertdetails.gallery.GalleryAdapter
import kz.kolesa.devfest.domain.entity.Advertisement
import kz.kolesa.devfest.presentation.Event

const val ADVERT_ID_KEY = "advert_id"

class AdvertDetailsActivity : AppCompatActivity() {

    private lateinit var advertDetailsViewModel: AdvertDetailsViewModel
    private lateinit var galleryViewPager: ViewPager
    private lateinit var titleTextView: TextView
    private lateinit var textTextView: TextView
    private lateinit var specificationTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var parametersLinearLayout: LinearLayout
    private lateinit var callFab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advert_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        galleryViewPager = activity_advert_details_view_pager
        titleTextView = activity_advert_details_title
        textTextView = activity_advert_details_text
        specificationTextView = activity_advert_details_specification
        priceTextView = activity_advert_details_price
        parametersLinearLayout = activity_advert_details_parameters
        callFab = activity_advert_details_call
        callFab.setOnClickListener {
            advertDetailsViewModel.onCallClicked()
        }
        initViewModel()
        observeLiveData()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> true.also { onBackPressed() }
            else -> false
        }
    }

    private fun initViewModel() {
        TODO("Инициализировать ViewModel")
    }

    private fun observeLiveData() {
        TODO("Реализовать подписку на LiveData")
    }

    private fun onNavigationEventReceived(event: Event<AdvertDetailsNavigation>) {
        val navigation = event.getContentIfNotHandled()
        when (navigation) {
            is AdvertDetailsNavigation.Call -> {
                val phoneNumber = navigation.phoneNumber
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber)))
            }
        }
    }

    private fun getAdvertisementId(): Long {
        val advertId = intent.getLongExtra(ADVERT_ID_KEY, -1)
        if (advertId == -1L) {
            throw IllegalArgumentException("You should pass $ADVERT_ID_KEY into intent")
        }

        return advertId
    }

    private fun onAdvertisementUpdated(advertisement: Advertisement) {
        supportActionBar?.title = advertisement.title
        galleryViewPager.adapter = GalleryAdapter(
                fragmentManager = supportFragmentManager,
                imageUrls = advertisement.photos.map { it.url }
        )
        titleTextView.text = advertisement.title
        textTextView.text = advertisement.text
        specificationTextView.text = advertisement.specification
        priceTextView.text = getString(R.string.activity_advert_details_price, advertisement.price)
        val layoutInflater = LayoutInflater.from(this)
        advertisement.parameters.forEach {
            val parameterView = layoutInflater.inflate(R.layout.layout_item_parameter,
                    parametersLinearLayout, false)
            parameterView.layout_item_parameter_label.text = it.label
            parameterView.layout_item_parameter_value.text = it.value
            parametersLinearLayout.addView(parameterView)
        }
        callFab.show()
    }
}