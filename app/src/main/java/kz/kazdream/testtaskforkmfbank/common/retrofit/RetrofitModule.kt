package kz.kazdream.testtaskforkmfbank.common.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitModule {

    private const val BASE_URL = "https://petstore.swagger.io"

//    private val json = Json {
//        ignoreUnknownKeys = true
//    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitApi: RetrofitApi = retrofit.create()
}