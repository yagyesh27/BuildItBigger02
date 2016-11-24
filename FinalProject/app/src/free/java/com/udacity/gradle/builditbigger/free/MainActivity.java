package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.MyJavaClass;
import com.mfusion.androidlibrary.MainAndroidActivity;
import com.udacity.gradle.builditbigger.AsyncJokeDownloader;
import com.udacity.gradle.builditbigger.IDownloadListener;
import com.udacity.gradle.builditbigger.R;


public class MainActivity extends ActionBarActivity {

    MyJavaClass myClass = new MyJavaClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","Free");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

        new AsyncJokeDownloader(new IDownloadListener() {
            @Override
            public void downloadCompleted(String j) {
                Intent in = new Intent(getApplicationContext(), MainAndroidActivity.class);
                in.putExtra("joke", j);
                startActivity(in);
            }
        }).downloadJoke();

    }


}
