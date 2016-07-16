package com.activity.catingub.textstylercatingub;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private CheckBox mBold;
    private CheckBox mItalic;
    private RadioGroup mColor;
    private EditText text;
    private TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        change();
    }



    public void change() {

        text = (EditText) findViewById(R.id.etTxt);
        result = (TextView) findViewById(R.id.result);
        mBold = (CheckBox) findViewById(R.id.bold);
        mItalic = (CheckBox) findViewById(R.id.italic);
        mColor = (RadioGroup) findViewById(R.id.color);


        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                result.setText(text.getText());


            }


        });


        mItalic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mItalic.isChecked() && mBold.isChecked()) {
                  result.setTypeface(null, Typeface.BOLD_ITALIC);
                } else if (mItalic.isChecked()) {
                    result.setTypeface(null, Typeface.ITALIC);
                } else if (mBold.isChecked()) {
                    result.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                } else {
                    result.setTypeface(null, Typeface.NORMAL);
                }
            }
        });

        mBold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mItalic.isChecked() && mBold.isChecked()) {
                    result.setTypeface(null, Typeface.BOLD_ITALIC);
                } else if (mBold.isChecked()) {
                    result.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                } else if (mItalic.isChecked()) {
                    result.setTypeface(null, Typeface.ITALIC);
                } else {
                    result.setTypeface(null, Typeface.NORMAL);
                }


            }
        });

        mColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = mColor.getCheckedRadioButtonId();
                if (id == R.id.rdRed){
                    result.setTextColor(Color.RED);
                }
                else  if (id == R.id.rdBlue){
                    result.setTextColor(Color.BLUE);
                }
                else if (id == R.id.rdGreen){
                    result.setTextColor(Color.GREEN);
                }
            }
        });

    }
}
