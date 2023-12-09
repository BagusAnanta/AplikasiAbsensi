package com.bsoftware.aplikasiabsensi.sharePreference

import android.app.Activity
import android.content.Context

class SharePreferenceLogin(var activity : Activity){

    // init sharepreflogin
    private val sharePrefLogin = activity.getSharedPreferences("LoginSharePref", Context.MODE_PRIVATE)
    private val sharePrefEdit = sharePrefLogin.edit()

    // set and get login status
    fun setLoginState(isLogin : Boolean){
        sharePrefEdit.apply {
            putBoolean(LOGINSTATEKEY,isLogin)
            commit()
        }
    }

    fun getLoginState() : Boolean {
        return sharePrefLogin.getBoolean(LOGINSTATEKEY,false)
    }

    fun setUsername(username : String){
        sharePrefEdit.apply {
            putString(USERNAMEKEY,username)
            commit()
        }
    }

    fun getUsername() : String{
        return sharePrefLogin.getString(USERNAMEKEY,"")!!
    }


    companion object{
        private val LOGINSTATEKEY : String = "onLoginStateKey"
        private val USERNAMEKEY : String = "usernameKey"
    }
}