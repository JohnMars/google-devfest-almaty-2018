package kz.kolesa.devfest.advertlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_advert_list.activity_advert_list_recycler_view
import kz.kolesa.devfest.R
import kz.kolesa.devfest.advertdetails.ADVERT_ID_KEY
import kz.kolesa.devfest.advertdetails.AdvertDetailsActivity
import kz.kolesa.devfest.advertlist.adapter.AdvertListAdapter
import kz.kolesa.devfest.domain.entity.Advertisement

/**
 * UI controller для экрана со списком объявлении
 */
class AdvertListActivity : AppCompatActivity() {

    private lateinit var advertListAdapter: AdvertListAdapter
    private lateinit var advertListViewModel: AdvertListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advert_list)
        advertListAdapter = AdvertListAdapter(onItemClickListener = this::onAdvertItemClicked)
        activity_advert_list_recycler_view.apply {
            adapter = advertListAdapter
        }
        advertListViewModel = ViewModelProviders
                .of(this)
                .get(AdvertListViewModel::class.java)
    }

    private fun updateView(advertisements: List<Advertisement>) {
        advertListAdapter.submitList(advertisements)
    }

    private fun onAdvertItemClicked(advertisement: Advertisement) {
        val intent = Intent(this@AdvertListActivity, AdvertDetailsActivity::class.java)
        intent.apply {
            putExtra(ADVERT_ID_KEY, advertisement.id)
        }
        startActivity(intent)
    }
}