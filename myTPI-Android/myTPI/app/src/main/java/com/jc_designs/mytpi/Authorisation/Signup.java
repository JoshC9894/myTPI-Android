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
import com.google.firebase.auth.UserProfileChangeRequest;
import com.jc_designs.mytpi.Home;
import com.jc_designs.mytpi.R;
import com.jc_designs.mytpi.globalVariables;
import com.jc_designs.mytpi.Tutorial;

public class Signup extends AppCompatActivity {

    private EditText emailfield;
    private EditText passwordField;
    private EditText password2Field;
    private EditText nameField;
    private TextView loginRef;
    private Button continueButton;

    private String EMAIL;
    private String PASSWORD;
    private String PASSWORD2;
    private String FULL_NAME;

    private FirebaseAuth auth;
    private static final String TAG = "MyActivity";

    private Boolean firstTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        emailfield = (EditText)findViewById(R.id.emailField);
        passwordField = (EditText)findViewById(R.id.passwordField);
        password2Field = (EditText)findViewById(R.id.password2Field);
        nameField = (EditText)findViewById(R.id.fullNameField);
        continueButton = (Button)findViewById(R.id.continueButton);
        loginRef = (TextView)findViewById(R.id.loginRef);
        auth = FirebaseAuth.getInstance();

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isNetworkAvailable()) {
                    if (!emailfield.getText().toString().equals("") && !passwordField.getText().toString().equals("") && !password2Field.getText().toString().equals("") && !nameField.getText().toString().equals("")) {
                        EMAIL = emailfield.getText().toString();
                        PASSWORD = passwordField.getText().toString();
                        PASSWORD2 = password2Field.getText().toString();
                        FULL_NAME = nameField.getText().toString();
                        try{
                            if (PASSWORD.equals(PASSWORD2)){
                                signUp(EMAIL, PASSWORD);
                            } else {
                                globalVariables.makeToast(Signup.this, "Passwords don't match. Please try again.");
                            }
                        } catch (Exception e){}
                    }else{
                        globalVariables.makeToast(Signup.this, "Please fill out the Fields");
                    }
                } else {
                    globalVariables.makeToast(Signup.this, "Please connect to the Internet");
                }

            }
        });


        loginRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signup.this, Login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
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


    private void signUp(String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();

                            if (user != null){

                                UserProfileChangeRequest update = new UserProfileChangeRequest.Builder().setDisplayName(FULL_NAME).build();

                                user.updateProfile(update).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            if (isFirstTime()) {
                                                Intent intent = new Intent(Signup.this, Tutorial.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Intent intent = new Intent(Signup.this, Home.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(intent);
                                                finish();
                                            }
                                        }
                                    }
                                });
                            }
                        }

                        if (!task.isSuccessful()) {
                            Toast.makeText(Signup.this, task.getException().getMessage().toString(),
                                    Toast.LENGTH_SHORT).show();
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
