package com.example.mvpppatternexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    EditText mUsername, mPassword;
    LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressBar.setVisibility(View.VISIBLE);
                doLogin();
            }
        });

        mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        mLoginViewModel.status.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String status) {
                mProgressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUI() {
        mProgressBar = findViewById(R.id.progress_login);
        mUsername = findViewById(R.id.user_name);
        mPassword = findViewById(R.id.password);
    }

    private void doLogin() {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();
        mLoginViewModel.doLogin(username, password);
    }
}
