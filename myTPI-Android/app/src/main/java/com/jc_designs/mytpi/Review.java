package com.jc_designs.mytpi;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Joshua on 28/01/2017.
 */
public class Review extends Fragment {

    View myView;

    Button appStoreReview;
    Button generalFeedback;
    Button reportBug;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_review, container, false);
        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();


        appStoreReview = (Button)myView.findViewById(R.id.reviewButton1);
        generalFeedback = (Button)myView.findViewById(R.id.reviewButton2);
        reportBug = (Button)myView.findViewById(R.id.reviewButton3);

        appStoreReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=myTPI")));
            }
        });

        generalFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"joshua.ev@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "General Feedback for myTPI");
                //i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reportBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"joshua.ev@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Bug Report for myTPI");
                //i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
