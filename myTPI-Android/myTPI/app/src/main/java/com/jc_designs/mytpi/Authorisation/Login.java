package com.jc_designs.mytpi.Authorisation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jc_designs.mytpi.Home;
import com.jc_designs.mytpi.R;
import com.jc_designs.mytpi.globalVariables;
import com.jc_designs.mytpi.Tutorial;

public class Login extends AppCompatActivity {

    EditText emailField;
    EditText passwordField;
    Button signinButton;

    TextView signupRef;
    TextView forgotPass;

    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authListener;

    private Boolean firstTime = null;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        emailField = (EditText)findViewById(R.id.emailField);
        passwordField = (EditText)findViewById(R.id.passwordField);
        signinButton = (Button)findViewById(R.id.signinButton);

        signupRef = (TextView)findViewById(R.id.signupRef);

        signupRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.removeAuthStateListener(authListener);

                Intent intent = new Intent(Login.this, Signup.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        forgotPass = (TextView)findViewById(R.id.forgotPassword);
        forgotPass.setVisibility(View.INVISIBLE);


        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emailField.equals("")){
                    auth.sendPasswordResetEmail(emailField.getText().toString());
                    globalVariables.makeToast(Login.this, "An email has been sent.");
                } else {
                    globalVariables.makeToast(Login.this, "Please enter a valid email address.");
                }
            }
        });


        //LISTENER
        auth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    globalVariables.UID = auth.getCurrentUser().getUid();

                    auth.removeAuthStateListener(authListener);


                    if (isFirstTime()) {
                        Intent intent = new Intent(Login.this, Tutorial.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(Login.this, Home.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }


                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };



        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isNetworkAvailable()) {

                    if (!emailField.getText().toString().equals("") && !passwordField.getText().toString().equals("")) {
                        login(emailField.getText().toString(), passwordField.getText().toString());

                    }else{
                        globalVariables.makeToast(Login.this, "Fields are Empty");
                    }
                } else {
                    globalVariables.makeToast(Login.this, "Please connect to the Internet");
                }


            }
        });

    }

    //Check network connectivity
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }


    public void login(String email, String password){
        auth.addAuthStateListener(authListener);

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(Login.this, task.getException().getMessage().toString(),
                                    Toast.LENGTH_SHORT).show();

                            forgotPass.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }





    private boolean isFirstTime() {
        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.apply();
            }
        }
        return firstTime;
    }



}
