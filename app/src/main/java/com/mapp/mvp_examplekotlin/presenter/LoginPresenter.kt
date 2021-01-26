package com.mapp.mvp_examplekotlin.presenter

import com.mapp.mvp_examplekotlin.model.User
import com.mapp.mvp_examplekotlin.view.ILoginView


//This class works does everything
class LoginPresenter{

    var loginView: ILoginView
    var user: User

    constructor(loginView: ILoginView){
        this.loginView = loginView
        this.user = User("","")
    }

    fun setName(name: String){
        user.name = name
    }

    fun setEmail(email: String){
        user.email = email
    }

    fun loginCredentials(){
        loginView.onResult()
    }

}