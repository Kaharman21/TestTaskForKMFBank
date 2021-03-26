package kz.kazdream.testtaskforkmfbank.registration.data

import kz.kazdream.testtaskforkmfbank.common.model.User
import kz.kazdream.testtaskforkmfbank.common.retrofit.RetrofitModule
import retrofit2.Response

class RegistrationRepository {

    suspend fun registerUser(user: User): Response<User>{
        return RetrofitModule.retrofitApi.registerUser(user)
    }
}