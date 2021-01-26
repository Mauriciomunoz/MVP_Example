package com.mapp.mvp_examplekotlin

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mapp.mvp_examplekotlin.databinding.ActivityMainBinding
import com.mapp.mvp_examplekotlin.presenter.LoginPresenter
import com.mapp.mvp_examplekotlin.view.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {

    lateinit var binding: ActivityMainBinding
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        loginPresenter = LoginPresenter(this)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener(View.OnClickListener {
            loginPresenter.setName(binding.inName.text.toString())
            loginPresenter.setEmail(binding.inEmail.text.toString())
            loginPresenter.loginCredentials()
        })

    }

    override fun onResult() {
        binding.txtOutput.text = loginPresenter.user.name + " " + loginPresenter.user.email
    }

}