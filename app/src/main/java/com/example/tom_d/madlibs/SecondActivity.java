package com.example.tom_d.madlibs;

import android.content.Context;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    Story story;
    Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("MadLibStory");

        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setText(story.getPlaceholderRemainingCount() + "word's remaining");

        TextView editText = (TextView) findViewById(R.id.textView4);
        editText.setHint(story.getNextPlaceholder());
        editText.setText("");

        okButton = (Button) findViewById(R.id.okButton);
        //setup button listener
        okButton.setOnClickListener(new View.OnClickListener() {
            //insert onClick here
            public void onClick(View view) {
                try {
                    transferWords();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void transferWords() throws IOException {
        //to do : function that checks remaining words when new word is filled in
        //      - statement that saves
        TextView editText = (TextView) findViewById(R.id.editText);
        story.fillInPlaceholder(editText.getText().toString());

        if (story.getPlaceholderRemainingCount() != 0) {
            TextView textView4 = (TextView) findViewById(R.id.textView4);
            textView4.setHint(story.getNextPlaceholder());
            editText.setText("");

            TextView textView5 = (TextView) findViewById(R.id.textView5);
            textView5.setText(story.getPlaceholderRemainingCount() + "word's remaining");

        } else {
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra("ResultStory", story.toString());
            startActivity(intent);
            finish();

        }

    }

}