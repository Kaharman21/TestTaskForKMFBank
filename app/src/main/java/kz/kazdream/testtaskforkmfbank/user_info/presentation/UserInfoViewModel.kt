package kz.kazdream.testtaskforkmfbank.user_info.presentation

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import kz.kazdream.testtaskforkmfbank.common.model.User
import kz.kazdream.testtaskforkmfbank.registration.data.RegistrationRepository
import kz.kazdream.testtaskforkmfbank.user_info.data.UserInfoRepository
import retrofit2.Response

class UserInfoViewModel(
    application: Application
): AndroidViewModel(application){

    private val repository = UserInfoRepository(application)   // для Коина мало времени ;(

    private val _userInfoResponse = MutableLiveData<User>()
    val userInfoResponse: LiveData<User> = _userInfoResponse

    fun getUserInfo(userName: String){
        viewModelScope.launch {
//            _userInfoResponse.postValue(repository.getUserInfo(userName))
            repository.getUserInfoNew(
                success = {
                    _userInfoResponse.postValue(it)
                },
                fail = {

                },
                userName,
                viewModelScope
            )
        }
    }
}