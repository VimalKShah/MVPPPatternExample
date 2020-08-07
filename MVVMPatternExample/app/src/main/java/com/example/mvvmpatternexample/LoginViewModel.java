package com.example.mvvmpatternexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    MutableLiveData<String> status = new MutableLiveData<>();

    void doLogin(String username, String password) {
        UserModel userModel = new UserModel(username, password);
        String msg = "Login failed";
        if(userModel.checkValidity()) {
            msg = "Login Successful";
        }
        status.postValue(msg);
    }
}
