package com.example.b10706.termproject;
//import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Calendar");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.FragA:
                ActionBar actionBar1 = getSupportActionBar();

                if(actionBar1!=null)
                {
                    actionBar1.setDisplayHomeAsUpEnabled(true);
                    actionBar1.setTitle("monthly");
                }
                getFragmentManager().beginTransaction().replace(R.id.activity_frag,new FragA()).addToBackStack(null).commit();
                return true;
            case R.id.FragB:
                ActionBar actionBar2 = getSupportActionBar();
                if(actionBar2!=null)
                {
                    actionBar2.setDisplayHomeAsUpEnabled(true);
                    actionBar2.setTitle("weekly");
                }
                getFragmentManager().beginTransaction().replace(R.id.activity_frag,new FragB()).addToBackStack(null).commit();
                return true;
            case R.id.FragC:
                ActionBar actionBar3 = getSupportActionBar();
                if(actionBar3!=null)
                {
                    actionBar3.setDisplayHomeAsUpEnabled(true);
                    actionBar3.setTitle("daily");
                }
                getFragmentManager().beginTransaction().replace(R.id.activity_frag,new FragC()).addToBackStack(null).commit();
                return true;
            case R.id.FragD:
                ActionBar actionBar4 = getSupportActionBar();
                if(actionBar4!=null)
                {
                    actionBar4.setDisplayHomeAsUpEnabled(true);
                    actionBar4.setTitle("add");
                }
                getFragmentManager().beginTransaction().replace(R.id.activity_frag,new FragD()).addToBackStack(null).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
