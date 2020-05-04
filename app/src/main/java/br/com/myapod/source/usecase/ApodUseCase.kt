package br.com.myapod.source.usecase

import br.com.myapod.source.ApodRepository
import br.com.myapod.source.remote.response.ApodResponse
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class ApodUseCase @Inject constructor(
    private val apodRepository: ApodRepository
) {

    suspend fun getTodayApod(): ApodResponse {

        val today = Calendar.getInstance().time

        val format = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(format, Locale.US)

        return apodRepository.getApod(sdf.format(today))
    }

    suspend fun getApodList(): List<ApodResponse> {
        val apodList = mutableListOf<ApodResponse>()
        val calendar = Calendar.getInstance()
        val format = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(format)


        apodList.add(getTodayApod())

        for (i in 0..10) {

            calendar.add(Calendar.DATE, -1)
            val result = Date(calendar.timeInMillis)
            val newDate = sdf.format(result)

            if (apodRepository.getApod((newDate)).mediaType == "image"){
                apodList.add(apodRepository.getApod(newDate))
            }

        }

        return apodList

    }


}