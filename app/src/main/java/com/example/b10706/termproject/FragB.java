package com.example.b10706.termproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by B10718 on 2016-10-13.
 */

public class FragB extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.frag_b,container,false);

        String[] mStrings={"월","화","수","목","금","토","일"};

        ListView list = (ListView)view.findViewById(R.id.ListView);

        list.setAdapter(new ArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,mStrings));

        list.setTextFilterEnabled(true);

        return view;
    }


}





