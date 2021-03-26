package kz.kazdream.testtaskforkmfbank.common.retrofit

import kz.kazdream.testtaskforkmfbank.common.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitApi {

    @POST("/v2/user")
    suspend fun registerUser(@Body user: User): Response<User>

    @GET("https://petstore.swagger.io/v2/user/{username}")
    suspend fun getUserInfo(
        @Path("username") userName: String
    ): Response<User>
}