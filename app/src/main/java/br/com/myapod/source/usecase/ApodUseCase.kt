package br.com.myapod.source.usecase

import br.com.myapod.source.ApodRepository
import br.com.myapod.source.remote.response.ApodResponse
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class ApodUseCase @Inject constructor(
    private val apodRepository: ApodRepository
) {

    suspend fun getApodList(): List<ApodResponse> {
        val apodList = mutableListOf<ApodResponse>()

        val calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        for (i in 0..11) {
            val newDate = sdf.format(Date(calendar.timeInMillis))

            if (apodRepository.getApod((newDate)).mediaType == "image"){
                apodList.add(apodRepository.getApod(newDate))
            }

            calendar.add(Calendar.DATE, -1)

        }

        return apodList

    }


}