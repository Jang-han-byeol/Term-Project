package com.example.b10706.termproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by B10718 on 2016-10-13.
 */
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class FragC extends Fragment implements OnItemClickListener, OnClickListener {

    MyDBHelper mDBHelper;
    String today;
    Cursor cursor;
    SimpleCursorAdapter adapter;

    /** Called when the activity is first created. */
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.frag_c,container,false);

        Date date = new Date();
        int year = date.getYear() + 1900;
        int mon = date.getMonth() + 1;
        int day = date.getDate();

        Intent intent = new Intent(getContext(), Detail.class);
        intent.putExtra("Param1", year + "/" + mon + "/" + day);
        today = intent.getStringExtra("Param1");

        mDBHelper = new MyDBHelper(getContext(), "Today.db", null, 1);
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        cursor = db.rawQuery(
                "SELECT * FROM today WHERE date = '" + today + "'", null);

        adapter = new SimpleCursorAdapter(getContext(),
                android.R.layout.simple_list_item_2, cursor, new String[] {
                "title", "time" }, new int[] { android.R.id.text1,
                android.R.id.text2 });

        ListView list = (ListView)view.findViewById(R.id.list1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        mDBHelper.close();

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(getActivity(), Detail.class);
        cursor.moveToPosition(position);
        intent.putExtra("ParamID", cursor.getInt(0));
        startActivityForResult(intent, 0);
    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(getActivity(), Detail.class);
        intent.putExtra("ParamDate", today);
        startActivityForResult(intent, 1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        // super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
            case 1:
                if (resultCode == RESULT_OK) {
                    // adapter.notifyDataSetChanged();
                    SQLiteDatabase db = mDBHelper.getWritableDatabase();
                    cursor = db.rawQuery("SELECT * FROM today WHERE date = '"
                            + today + "'", null);
                    adapter.changeCursor(cursor);
                    mDBHelper.close();
                }
                break;
        }
    }
}

