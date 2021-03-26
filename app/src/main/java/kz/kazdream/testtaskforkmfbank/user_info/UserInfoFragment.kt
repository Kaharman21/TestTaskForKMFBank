package kz.kazdream.testtaskforkmfbank.user_info

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kz.kazdream.testtaskforkmfbank.R
import kz.kazdream.testtaskforkmfbank.common.BaseFragment
import kz.kazdream.testtaskforkmfbank.common.model.User
import kz.kazdream.testtaskforkmfbank.user_info.presentation.UserInfoViewModel
import kz.kazdream.testtaskforkmfbank.user_info.presentation.UserInfoViewModelFactory

class UserInfoFragment: BaseFragment(R.layout.fragment_user_info) {

    private val viewModel: UserInfoViewModel by viewModels{
        UserInfoViewModelFactory(requireContext().applicationContext as Application)
    }
    private lateinit var textView: TextView
    private lateinit var enterUserName: EditText
    private lateinit var searchBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initViewModel()
        setupListeners()
    }

    private fun setupListeners() {
        searchBtn.setOnClickListener {
            if (enterUserName.length() != 0) {
                val username = enterUserName.text.toString()
                searchUser(username)
            }
        }
    }

    private fun searchUser(username: String) {
        viewModel.getUserInfo(username)
    }

    private fun initViews(view: View) {
        textView = view.findViewById(R.id.user_info_textview)
        searchBtn = view.findViewById(R.id.get_user_info_btn)
        enterUserName = view.findViewById(R.id.enter_user_name)
    }

    private fun initViewModel() {
//        viewModel = ViewModelProvider(this).get(UserInfoViewModel::class.java)
        viewModel.userInfoResponse.observe(this.viewLifecycleOwner, ::handleResponse)
    }

    private fun handleResponse(user: User?) {
        Log.d("TAG", "Response ${user?.toString()}")
        textView.text = user?.toString()
    }
}