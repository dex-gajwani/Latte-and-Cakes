package com.example.latteandcakes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SubmitOrder extends Fragment {

    Button submitorders;
    EditText order;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public SubmitOrder() {

    }


    public static SubmitOrder newInstance(String param1, String param2) {
        SubmitOrder fragment = new SubmitOrder();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_submit_order, container, false);
        submitorders = view.findViewById(R.id.ordersubmit);
        order = view.findViewById(R.id.order);

        submitorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailString = (String) order.getText().toString();

           Intent i = new Intent(Intent.ACTION_SEND);
    i.setType("message/rfc822");
    i.putExtra(Intent.EXTRA_EMAIL,new String[]{"cafe@email.com"});
    i.putExtra(Intent.EXTRA_SUBJECT, "Roasted Beans Cafe");
    i.putExtra(Intent.EXTRA_TEXT, "My Name: "+emailString+"\nAnd my Order: " +
            "");
    try {
        startActivity(Intent.createChooser(i, "Send email with...?"));
    } catch (android.content.ActivityNotFoundException exception) {
        Toast.makeText(SubmitOrder.this.getActivity(), "No email clients installed on device!", Toast.LENGTH_LONG).show();
    }

           }
        });


        return view;

    }
}