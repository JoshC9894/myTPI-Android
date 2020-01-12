package com.jc_designs.mytpi.Appliances;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jc_designs.mytpi.R;
import com.jc_designs.mytpi.globalVariables;
import com.jc_designs.mytpi.utilities.FirebaseHelper;

public class ModelSearchMEWP extends AppCompatActivity {


    ListView lv;
    ProgressBar pb;
    DatabaseReference db;
    FirebaseHelper helper;
    MEWPCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_search_mewp);


        lv = (ListView)findViewById(R.id.mewp_model_list);
        pb = (ProgressBar)findViewById(R.id.modelLoading);

        pb.setVisibility(View.VISIBLE);
        lv.setVisibility(View.GONE);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView make = (TextView) view.findViewById(R.id.mewpMake);
                TextView model = (TextView) view.findViewById(R.id.mewpModel);
                TextView desc = (TextView) view.findViewById(R.id.mewpDesc);
                TextView swl = (TextView) view.findViewById(R.id.mewpSWL);
                TextView ph = (TextView) view.findViewById(R.id.mewpPlatform);
                TextView wh = (TextView) view.findViewById(R.id.mewpWorking);
                TextView reach = (TextView) view.findViewById(R.id.mewpReach);
                TextView persons = (TextView) view.findViewById(R.id.mewpPersons);

                globalVariables.SELECTED_MEWP.setMake(make.getText().toString());
                globalVariables.SELECTED_MEWP.setModel(model.getText().toString());
                globalVariables.SELECTED_MEWP.setDescription(desc.getText().toString());
                globalVariables.SELECTED_MEWP.setSWL(swl.getText().toString());
                globalVariables.SELECTED_MEWP.setWorking(wh.getText().toString());
                globalVariables.SELECTED_MEWP.setPlatform(ph.getText().toString());
                globalVariables.SELECTED_MEWP.setReach(reach.getText().toString());
                globalVariables.SELECTED_MEWP.setPersons(persons.getText().toString());

                Toast.makeText(ModelSearchMEWP.this, "You have selected : " + model.getText().toString(), Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        //Async Task

        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);
        adapter = new MEWPCustomAdapter(ModelSearchMEWP.this, helper.retrieveData());

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                updateUI();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addModel();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mewp_model_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.sync) {
            updateUILoading();
        }
        return false;
    }


    private void updateUI(){
        lv.setAdapter(adapter);
        lv.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);
    }

    private void updateUILoading(){

        pb.setVisibility(View.VISIBLE);
        lv.setVisibility(View.GONE);
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                updateUI();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void addModel() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ModelSearchMEWP.this);
        View view = getLayoutInflater().inflate(R.layout.add_model, null);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        final EditText modelField = (EditText)view.findViewById(R.id.addModelField);
        final EditText makeField = (EditText)view.findViewById(R.id.addMakeField);
        final EditText descField = (EditText)view.findViewById(R.id.addDescField);
        final EditText swlField = (EditText)view.findViewById(R.id.addSWLField);
        final EditText whField = (EditText)view.findViewById(R.id.addWHField);
        final EditText phField = (EditText)view.findViewById(R.id.addPHField);
        final EditText reachField = (EditText)view.findViewById(R.id.addReachField);
        final EditText personsField = (EditText)view.findViewById(R.id.addPersonsField);
        Button addButton = (Button)view.findViewById(R.id.addModelButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!modelField.getText().toString().equals("")
                        && !makeField.getText().toString().equals("")
                        && !descField.getText().toString().equals("")
                        && !swlField.getText().toString().equals("")
                        && !whField.getText().toString().equals("")
                        && !phField.getText().toString().equals("")
                        && !reachField.getText().toString().equals("")
                        && !personsField.getText().toString().equals("")) {
                    //All Fields are filled
                    String model = modelField.getText().toString();
                    String make = makeField.getText().toString();
                    String desc = descField.getText().toString();
                    String swl = swlField.getText().toString();
                    String wh = whField.getText().toString();
                    String ph = phField.getText().toString();
                    String reach = reachField.getText().toString();
                    String persons = personsField.getText().toString();

                    MEWP m = new MEWP();

                    m.setMake(make);
                    m.setModel(model);
                    m.setDescription(desc);
                    m.setSWL(swl);
                    m.setWorking(wh);
                    m.setPlatform(ph);
                    m.setReach(reach);
                    m.setPersons(persons);

                    if (helper.save(m)){
                        updateUI();

                        globalVariables.SELECTED_MEWP.setMake(make);
                        globalVariables.SELECTED_MEWP.setModel(model);
                        globalVariables.SELECTED_MEWP.setDescription(desc);
                        globalVariables.SELECTED_MEWP.setSWL(swl);
                        globalVariables.SELECTED_MEWP.setWorking(wh);
                        globalVariables.SELECTED_MEWP.setPlatform(ph);
                        globalVariables.SELECTED_MEWP.setReach(reach);
                        globalVariables.SELECTED_MEWP.setPersons(persons);

                        dialog.dismiss();
                        finish();
                    } else {
                        Toast.makeText(ModelSearchMEWP.this, "Error: Please try again", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(ModelSearchMEWP.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private class Async extends AsyncTask<ListView, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(ListView... listViews) {


            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean) {
            }
        }
    }

}

