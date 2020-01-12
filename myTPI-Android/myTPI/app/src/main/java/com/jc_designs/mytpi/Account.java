package com.jc_designs.mytpi;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.jc_designs.mytpi.Authorisation.Login;

/**
 * Created by Joshua on 19/01/2017.
 */
public class Account extends Fragment {

    View myView;

    EditText newName;
    EditText newEmail;

    Button update;
    Button requestPassword;
    Button deleteButton;

    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_account, container, false);
        return myView;
    }



    @Override
    public void onStart() {
        super.onStart();


        //Create Auth Listener
        auth = FirebaseAuth.getInstance();

        listener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    Intent i = new Intent(getActivity(), Login.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    auth.removeAuthStateListener(listener);
                    getActivity().finish();
                }
            }
        };


        newName = (EditText)myView.findViewById(R.id.updateNameField);
        newEmail = (EditText)myView.findViewById(R.id.updateEmailField);
        update = (Button)myView.findViewById(R.id.updateButton);
        requestPassword = (Button)myView.findViewById(R.id.newPasswordButton);
        deleteButton = (Button)myView.findViewById(R.id.deleteAccountButton);

        if (auth.getCurrentUser() != null) {
            newName.setText(auth.getCurrentUser().getDisplayName());
            newEmail.setText(auth.getCurrentUser().getEmail());
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = newEmail.getText().toString();
                final String name = newName.getText().toString();

                if (auth.getCurrentUser() != null) {

                    if (!email.equals("")) {
                        //Check if data has been changed
                        if (email.equals(auth.getCurrentUser().getEmail()) && name.equals(auth.getCurrentUser().getDisplayName())) {
                            globalVariables.makeToast(getActivity(), "No data has been changed.");
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            View v = getActivity().getLayoutInflater().inflate(R.layout.password_prompt, null);

                            builder.setView(v);
                            final AlertDialog dialog = builder.create();
                            dialog.show();

                            final EditText confirmPasswordField = (EditText)v.findViewById(R.id.passwordPromptField);
                            Button confirmButton = (Button)v.findViewById(R.id.confirmPasswordButton);

                            confirmButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    final String pass = confirmPasswordField.getText().toString();

                                    if (!pass.equals("")){

                                        //Re-authenticate User
                                        AuthCredential credential = EmailAuthProvider.getCredential(auth.getCurrentUser().getEmail(), pass);
                                        auth.getCurrentUser().reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    //Carry out data change
                                                    if (!email.equals(auth.getCurrentUser().getEmail())) {
                                                        auth.getCurrentUser().updateEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()){
                                                                    globalVariables.makeToast(getActivity(), "Email successfully updated.");
                                                                    newEmail.setText(email);
                                                                } else {
                                                                    globalVariables.makeToast(getActivity(), task.getException().getMessage());
                                                                }
                                                            }
                                                        });
                                                    }

                                                    if (!name.equals(auth.getCurrentUser().getDisplayName())) {
                                                        UserProfileChangeRequest update = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                                                        auth.getCurrentUser().updateProfile(update).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()){
                                                                    globalVariables.makeToast(getActivity(), "Name successfully updated.");
                                                                    newName.setText(name);
                                                                } else {
                                                                    globalVariables.makeToast(getActivity(), task.getException().getMessage());
                                                                }
                                                            }
                                                        });
                                                    }

                                                } else {
                                                    globalVariables.makeToast(getActivity(), task.getException().getMessage());
                                                }
                                            }
                                        });

                                        dialog.dismiss();

                                    } else {
                                        globalVariables.makeToast(getActivity(), "Please enter password.");
                                    }

                                }
                            });
                        }
                    }
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View v = getActivity().getLayoutInflater().inflate(R.layout.password_prompt, null);

                builder.setView(v);
                final AlertDialog dialog = builder.create();
                dialog.show();

                final EditText password = (EditText)v.findViewById(R.id.passwordPromptField);
                Button btn = (Button)v.findViewById(R.id.confirmPasswordButton);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!password.getText().toString().equals("")){
                            String pass = password.getText().toString();
                            AuthCredential credential = EmailAuthProvider.getCredential(auth.getCurrentUser().getEmail(), pass);
                            auth.getCurrentUser().reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        deleteAccount();
                                    } else {
                                        globalVariables.makeToast(getActivity(), task.getException().getMessage());
                                    }
                                }
                            });
                        } else {
                            globalVariables.makeToast(getActivity(), "Please enter password.");
                        }
                    }
                });
            }
        });

        requestPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePassword();
            }
        });

        setHasOptionsMenu(true);
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        auth.addAuthStateListener(listener);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.account_menu, menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logout:
                auth.signOut();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        auth.removeAuthStateListener(listener);
    }


    private void deleteAccount() {
        auth.getCurrentUser().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    auth.signOut();
                    globalVariables.makeToast(getActivity(), "Goodbye, we are sorry to see you go.");

                } else if (!task.isSuccessful()) {
                    globalVariables.makeToast(getActivity(), task.getException().getMessage().intern());
                }
            }
        });
    }


    private void updatePassword(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.change_password, null);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        final EditText newPassword1Field = (EditText)view.findViewById(R.id.newPasswordOneField);
        final EditText newPassword2Field = (EditText)view.findViewById(R.id.newPasswordTwoField);
        final EditText currentPasswordField = (EditText)view.findViewById(R.id.currentPasswordField);
        Button changeButton = (Button)view.findViewById(R.id.changePasswordButton);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentPass = currentPasswordField.getText().toString();
                final String newPass1 = newPassword1Field.getText().toString();
                final String newPass2 = newPassword2Field.getText().toString();

                if (!newPass1.equals("") && !newPass2.equals("") && !currentPass.equals("")){

                    //Re-authenticate User
                    AuthCredential credential = EmailAuthProvider.getCredential(auth.getCurrentUser().getEmail(), currentPass);
                    auth.getCurrentUser().reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                //Update the password
                                if (newPass1.equals(newPass2)) {

                                    auth.getCurrentUser().updatePassword(newPass1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (!task.isSuccessful()) {
                                                globalVariables.makeToast(getActivity(), task.getException().getMessage());
                                            } else if (task.isSuccessful()) {
                                                dialog.dismiss();

                                                globalVariables.makeToast(getActivity(), "Password successfully changed.");
                                            }
                                        }
                                    });
                                } else {
                                    globalVariables.makeToast(getActivity(), "Fields do not match. Please try again.");
                                }

                            } else {
                                globalVariables.makeToast(getActivity(), task.getException().getMessage());
                            }
                        }
                    });

                } else {
                    globalVariables.makeToast(getActivity(), "Please fill all fields.");
                }

            }
        });

    }


}
