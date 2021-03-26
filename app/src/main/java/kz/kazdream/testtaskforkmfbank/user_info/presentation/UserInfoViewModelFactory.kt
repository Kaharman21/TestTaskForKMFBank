package kz.kazdream.testtaskforkmfbank.user_info.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class UserInfoViewModelFactory(
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass){
        UserInfoViewModel::class.java -> UserInfoViewModel(application)
        else -> throw IllegalArgumentException("Error")
    } as T
}