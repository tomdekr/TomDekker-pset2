package com.example.tom_d.madlibs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;



public class ThirdActivity extends AppCompatActivity {

    private Context mContext;
    String storyFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String results = intent.getStringExtra("ResultStory");
        storyFile = intent.getStringExtra("storyFile");


        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(Html.fromHtml(results));


    }
        public void goToFirst(View view){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
    }

}
