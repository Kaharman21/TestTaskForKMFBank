package kz.kazdream.testtaskforkmfbank

import android.os.Bundle
import android.view.View
import android.widget.Button
import kz.kazdream.testtaskforkmfbank.common.BaseFragment
import kz.kazdream.testtaskforkmfbank.registration.RegistrationFragment
import kz.kazdream.testtaskforkmfbank.user_info.UserInfoFragment

class StartFragment : BaseFragment(R.layout.fragment_start) {

    private lateinit var regBtn: Button
    private lateinit var userInfoBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setupListeners()
    }

    private fun initViews(view: View) {
        regBtn = view.findViewById(R.id.registration_btn)
        userInfoBtn = view.findViewById(R.id.user_info_btn)
    }

    private fun setupListeners() {
        regBtn.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.addToBackStack(null)?.replace(
                    R.id.fragment_container,
                    RegistrationFragment()
                )?.commit()
        }

        userInfoBtn.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.addToBackStack(null)?.replace(
                    R.id.fragment_container,
                    UserInfoFragment()
                )?.commit()
        }
    }
}