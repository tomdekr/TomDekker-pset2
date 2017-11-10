package com.example.tom_d.madlibs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> List = new ArrayList<>();
        List.add("madlib0_simple.txt");
        List.add("madlib1_tarzan.txt");
        List.add("madlib2_university.txt");
        List.add("madlib3_clothes.txt");
        List.add("madlib4_dance.txt");

        Random random = new Random();
        String randomlist = List.get(random.nextInt(List.size()));

        try {
            InputStream loadStory = getAssets().open(randomlist);
            story = new Story(loadStory);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void goToSecond(View view) {


        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("MadLibStory", story);
        startActivity(intent);

    }

}


