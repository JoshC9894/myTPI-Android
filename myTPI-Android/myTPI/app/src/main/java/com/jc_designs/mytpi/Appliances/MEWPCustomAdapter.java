package com.jc_designs.mytpi.Appliances;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jc_designs.mytpi.Appliances.MEWP;
import com.jc_designs.mytpi.R;

import java.util.ArrayList;

/**
 * Created by Joshua on 22/01/2017.
 */
public class MEWPCustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<MEWP> mewps;

    public static MEWP _SELECTED_MODEL;

    public MEWPCustomAdapter(Context c, ArrayList<MEWP> mewps) {
        this.c = c;
        this.mewps = mewps;
    }

    @Override
    public int getCount() {
        return mewps.size();
    }

    @Override
    public Object getItem(int i) {
        return mewps.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Inflate Layout

        if (view == null) {
            view = LayoutInflater.from(c).inflate(R.layout.mewp_model, viewGroup, false);
        }

        final TextView modelField = (TextView)view.findViewById(R.id.mewpModel);
        final TextView makeField = (TextView)view.findViewById(R.id.mewpMake);
        final TextView descField = (TextView)view.findViewById(R.id.mewpDesc);
        final TextView personsField = (TextView)view.findViewById(R.id.mewpPersons);
        final TextView platformField = (TextView)view.findViewById(R.id.mewpPlatform);
        final TextView swlField = (TextView)view.findViewById(R.id.mewpSWL);
        final TextView reachField = (TextView)view.findViewById(R.id.mewpReach);
        final TextView workingField = (TextView)view.findViewById(R.id.mewpWorking);

        if (this.getItem(i) != null) {
            final MEWP m = (MEWP) this.getItem(i);
            modelField.setText(m.getModel());
            makeField.setText(m.getMake());
            descField.setText(m.getDescription());
            personsField.setText(m.getPersons());
            platformField.setText(m.getPlatform());
            swlField.setText(m.getSWL());
            reachField.setText(m.getReach());
            workingField.setText(m.getWorking());
        }





        return view;
    }
}
