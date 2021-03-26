package kz.kazdream.testtaskforkmfbank.registration

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import kz.kazdream.testtaskforkmfbank.R
import kz.kazdream.testtaskforkmfbank.common.BaseFragment
import kz.kazdream.testtaskforkmfbank.common.model.User
import kz.kazdream.testtaskforkmfbank.common.utils.showToast
import kz.kazdream.testtaskforkmfbank.registration.presentation.RegistrationViewModel
import retrofit2.Response

class RegistrationFragment: BaseFragment(R.layout.fragment_registration) {

    private lateinit var regBtn: Button
    private lateinit var viewModel: RegistrationViewModel
    private lateinit var usernameEdt: EditText
    private lateinit var firstnameEdt: EditText
    private lateinit var lastnameEdt: EditText
    private lateinit var emailEdt: EditText
    private lateinit var passwordEdt: EditText
    private lateinit var phoneEdt: EditText
    private lateinit var userstatusEdt: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initViews(view)
        setupListeners()
    }

    private fun setupListeners() {
        regBtn.setOnClickListener {
//            val user = User("kaharman21", "", "", "", "", "", 1)
            if (usernameEdt.length() == 0 || firstnameEdt.length() == 0 || lastnameEdt.length() == 0 || emailEdt.length() == 0
                || passwordEdt.length() == 0 || phoneEdt.length() == 0 || userstatusEdt.length() == 0)
            {
                showToast("Заполните все поля")
            } else {
                viewModel.registerUser(getUserDetails())
            }
        }
    }

    private fun getUserDetails(): User {
        val username = usernameEdt.text.toString()
        val firstname = firstnameEdt.text.toString()
        val lastname = lastnameEdt.text.toString()
        val email = emailEdt.text.toString()
        val password = passwordEdt.text.toString()
        val phone = phoneEdt.text.toString()
        val userstatus = (userstatusEdt.text.toString()).toInt()

        return User(
            username,
            firstname,
            lastname,
            email,
            password,
            phone,
            userstatus
        )
    }

    private fun initViews(view: View) {
        regBtn = view.findViewById(R.id.reg_btn)
        usernameEdt = view.findViewById(R.id.username_edt)
        firstnameEdt = view.findViewById(R.id.firstname_edt)
        lastnameEdt = view.findViewById(R.id.lastname_edt)
        emailEdt = view.findViewById(R.id.email_edt)
        passwordEdt = view.findViewById(R.id.password_edt)
        phoneEdt = view.findViewById(R.id.phone_edt)
        userstatusEdt = view.findViewById(R.id.userstatus_edt)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        viewModel.response.observe(this.viewLifecycleOwner, ::handleResponse)
    }

    private fun handleResponse(response: Response<User>?) {
        Log.d("TAG", "Response ${response?.body().toString()}")
        if (response!!.isSuccessful){
            showToast("Пользователь добавлен")
        } else {
            showToast("Ошибка")
        }
    }
}