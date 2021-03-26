package kz.kazdream.testtaskforkmfbank.registration.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.kazdream.testtaskforkmfbank.registration.data.RegistrationRepository
import kz.kazdream.testtaskforkmfbank.common.model.User
import retrofit2.Response

class RegistrationViewModel: ViewModel() {

    private val repository = RegistrationRepository()   // для Коина мало времени ;(

    private val _response = MutableLiveData<Response<User>>()
    val response: LiveData<Response<User>> = _response

    fun registerUser(user: User){
        viewModelScope.launch {
            _response.postValue(repository.registerUser(user))
        }
    }
}