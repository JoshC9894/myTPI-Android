package com.jc_designs.mytpi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.jc_designs.mytpi.Appliances.Appliances_List;
import com.jc_designs.mytpi.Appliances.Machine_Database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText fleet;
    EditText serial;
    EditText client;

    private FirebaseAuth auth;

    FloatingActionButton fab;

    Machine_Database myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDB = new Machine_Database(this);

        auth = FirebaseAuth.getInstance();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newInspection();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        android.app.FragmentManager fragmentManager = getFragmentManager();
        this.setTitle("Lifting Appliances");
        fragmentManager.beginTransaction().replace(R.id.content_frame, new Appliances_List()).commit();
        fab.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.appliances) {
            return true;
        } else if (id == R.id.account) {
            return true;
        } else if (id == R.id.help) {
            return true;
        } else if (id == R.id.review){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.appliances) {
            this.setTitle("Lifting Appliances");
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Appliances_List()).commit();
            fab.setVisibility(View.VISIBLE);

        } else if (id == R.id.account) {
            this.setTitle("My Account");
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Account()).commit();
            fab.setVisibility(View.GONE);

        } else if (id == R.id.help) {
            Intent i = new Intent(Home.this, Tutorial.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        } else if (id == R.id.review) {
            this.setTitle("Review");
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Review()).commit();
            fab.setVisibility(View.GONE);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //New Inspection
    private void newInspection(){

        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        View view = getLayoutInflater().inflate(R.layout.add_inspection, null);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        fleet = (EditText)view.findViewById(R.id.editFleet);
        serial = (EditText)view.findViewById(R.id.editSerial);
        client = (EditText)view.findViewById(R.id.editClient);
        Button addButton = (Button)view.findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addApplianceData();
                dialog.dismiss();
            }
        });

    }


    public void addApplianceData() {

        //Todays Date
        DateFormat df = new SimpleDateFormat("dd MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());

        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
        String time = df2.format(Calendar.getInstance().getTime());

        String name = auth.getCurrentUser().getDisplayName().toString();

        boolean isInserted = myDB.insertData(
                fleet.getText().toString(),
                serial.getText().toString(),
                client.getText().toString(),
                date,
                " "," "," "," "," "," "," "," "," "," "," "," "," ",name," "
                ," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",
                " "," "," "," "," "," "," "," "," "," "," "," "," "," ",
                " "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",
                " "," "," "," "," "," "," "," "," "," "," "," "," "," ",
                " "," "," "," "," "," "," "," "," "," "," "," "," "," "," ", time, " ", "", "", "", "",
                ""," ", " "," "," "," "
        );

        if (isInserted) {
            Toast.makeText(Home.this, "Inspection Added", Toast.LENGTH_SHORT).show();
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Appliances_List()).commit();

        } else {
            Toast.makeText(Home.this, "Data Failed to Saved", Toast.LENGTH_SHORT).show();
        }
    }

}
