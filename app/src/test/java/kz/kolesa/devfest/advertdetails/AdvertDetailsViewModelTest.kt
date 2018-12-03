package kz.kolesa.devfest.advertdetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.experimental.Unconfined
import kz.kolesa.devfest.domain.entity.FAKE_ADVERITISEMENT
import kz.kolesa.devfest.domain.repository.AdvertisementRepository
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Testing [AdvertDetailsViewModel]
 */
class AdvertDetailsViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private val mockedAdvertisementRepository: AdvertisementRepository = mock()
    private lateinit var advertDetailsViewModel: AdvertDetailsViewModel

    @Test
    fun `should request advertisement and set it to the liveData`() {
        val expectedAdvertisement = FAKE_ADVERITISEMENT
        whenever(mockedAdvertisementRepository.getAdvertisement(eq(expectedAdvertisement.id)))
                .thenReturn(FAKE_ADVERITISEMENT)

        advertDetailsViewModel = AdvertDetailsViewModel(
                advertisementId = expectedAdvertisement.id,
                advertisementRepository = mockedAdvertisementRepository,
                uiContext = Unconfined,
                ioContext = Unconfined
        )

        verify(mockedAdvertisementRepository).getAdvertisement(expectedAdvertisement.id)
        assertEquals(expectedAdvertisement, advertDetailsViewModel.advertisementLiveData.value)
    }
}