package com.example.b10706.termproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by B10718 on 2016-10-13.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class FragD extends Fragment implements OnClickListener,
        OnItemClickListener {
    ArrayList<String> mItems;
    ArrayAdapter<String> adapter;
    TextView textYear;
    TextView textMon;

    /** Called when the activity is first created. */
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.frag_d,container,false);

        textYear = (TextView) view.findViewById(R.id.edit1);
        textMon = (TextView) view.findViewById(R.id.edit2);

        mItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, mItems);

        GridView gird = (GridView) view.findViewById(R.id.grid1);
        gird.setAdapter(adapter);
        gird.setOnItemClickListener(this);

        Date date = new Date();// 오늘에 날짜를 세팅 해준다.
        int year = date.getYear() + 1900;
        int mon = date.getMonth() + 1;
        textYear.setText(year + "");
        textMon.setText(mon + "");

        fillDate(year, mon);

        Button btnmove = (Button) view.findViewById(R.id.bt1);
        btnmove.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        if (arg0.getId() == R.id.bt1) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            fillDate(year, mon);
        }

    }

    private void fillDate(int year, int mon) {
        mItems.clear();

        mItems.add("일");
        mItems.add("월");
        mItems.add("화");
        mItems.add("수");
        mItems.add("목");
        mItems.add("금");
        mItems.add("토");

        Date current = new Date(year - 1900, mon - 1, 1);
        int day = current.getDay(); // 요일도 int로 저장.

        for (int i = 0; i < day; i++) {
            mItems.add("");
        }

        current.setDate(32);// 32일까지 입력하면 1일로 바꿔준다.
        int last = 32 - current.getDate();

        for (int i = 1; i <= last; i++) {
            mItems.add(i + "");
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        if (mItems.get(arg2).equals("")) {
            ;
        } else {
            Intent intent = new Intent(getActivity(), ExToday.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/"
                    + textMon.getText().toString() + "/" + mItems.get(arg2));
           getActivity().startActivity(intent);
        }
    }
}