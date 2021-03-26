package kz.kazdream.testtaskforkmfbank.common.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}