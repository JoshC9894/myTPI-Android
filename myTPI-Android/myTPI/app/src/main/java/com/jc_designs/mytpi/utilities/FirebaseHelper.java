package com.jc_designs.mytpi.utilities;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.jc_designs.mytpi.Appliances.MEWP;

import java.util.ArrayList;


public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved;
    ArrayList<MEWP> mewps = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }


    //Save Data
    public Boolean save(MEWP mewp) {
        if(mewp == null){
            saved = false;
        } else {
            try {
                db.child("MEWPs").child(mewp.getModel()).child("Model").setValue(mewp.getModel());
                db.child("MEWPs").child(mewp.getModel()).child("Make").setValue(mewp.getMake());
                db.child("MEWPs").child(mewp.getModel()).child("Description").setValue(mewp.getDescription());
                db.child("MEWPs").child(mewp.getModel()).child("SWL").setValue(mewp.getSWL());
                db.child("MEWPs").child(mewp.getModel()).child("Platform").setValue(mewp.getPlatform());
                db.child("MEWPs").child(mewp.getModel()).child("Persons").setValue(mewp.getPersons());
                db.child("MEWPs").child(mewp.getModel()).child("Reach").setValue(mewp.getReach());
                db.child("MEWPs").child(mewp.getModel()).child("Working").setValue(mewp.getWorking());

                saved = true;
            } catch (DatabaseException e) {
                e.printStackTrace();
                saved = false;
            }
        }

        return saved;
    }



    //Get data and fill ArrayList
    private void fetchData(DataSnapshot dataSnapshot){
        mewps.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren()) {

            MEWP mewp = new MEWP();
            mewp.setModel(ds.getKey());

            if (ds.child("Model").getValue() != null) {
                mewp.setModel(ds.child("Model").getValue().toString());
            } else {
                mewp.setModel("");
            }

            if (ds.child("Make").getValue() != null) {
                mewp.setMake(ds.child("Make").getValue().toString());
            } else {
                mewp.setMake("");
            }

            if (ds.child("SWL").getValue() != null) {
                mewp.setSWL(ds.child("SWL").getValue().toString());
            } else {
                mewp.setSWL("");
            }

            if (ds.child("Description").getValue() != null) {
                mewp.setDescription(ds.child("Description").getValue().toString());
            } else {
                mewp.setDescription("");
            }

            if (ds.child("Persons").getValue() != null) {
                mewp.setPersons(ds.child("Persons").getValue().toString());
            } else {
                mewp.setPersons("");
            }

            if (ds.child("Platform").getValue() != null) {
                mewp.setPlatform(ds.child("Platform").getValue().toString());
            } else {
                mewp.setPlatform("");
            }

            if (ds.child("Reach").getValue() != null) {
                mewp.setReach(ds.child("Reach").getValue().toString());
            } else {
                mewp.setReach("");
            }

            if (ds.child("Working").getValue() != null) {
                mewp.setWorking(ds.child("Working").getValue().toString());
            } else {
                mewp.setWorking("");
            }

            mewps.add(mewp);
        }
    }

    public ArrayList<MEWP> retrieveData() {

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return mewps;
    }

    public int getLength() {
        return mewps.size();
    }
}
