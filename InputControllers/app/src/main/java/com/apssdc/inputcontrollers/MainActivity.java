package com.apssdc.inputcontrollers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*Radio Group  is used to  group together one or more radiobuttons
    * Radio Button is used to has two states either checked or unchecked.*/
    RadioGroup radiog;
    RadioButton radiob1,radiob2;
    /*CheckBoxes  when presenting users with group of selectable options that are  not mutually exclusive.*/
    CheckBox checkb1,checkb2,checkb3;
    /*Switch  is used to diplay  checked or unchecked state of a button  providing a slider controlling  to user
    * it is basically off/on state*/
    Switch aSwitch;
    LinearLayout linearLayout;
    /*Spinner is a dropdown list that allows users to select  one value from a set.*/
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch = findViewById(R.id.switch1);
        linearLayout = findViewById(R.id.linear1);
        spinner = findViewById(R.id.spinner1);
        final ArrayList<String> weeks = new ArrayList<>();
        weeks.add("Sunday");
        weeks.add("Monday");
        weeks.add("Tuesday");
        weeks.add("Wednesday");
        weeks.add("Thursday");
        weeks.add("Friday");
        weeks.add("Saturday");
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,weeks);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Selected "+weeks.get(position),
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radiog = findViewById(R.id.rg1);
        radiob1 = findViewById(R.id.rb1);
        radiob2 = findViewById(R.id.rb2);
        checkb1 = findViewById(R.id.check1);
        checkb2 = findViewById(R.id.check2);
        checkb3 = findViewById(R.id.check3);
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()){
                    linearLayout.setBackgroundColor(Color.GREEN);
                }else{
                    linearLayout.setBackgroundColor(Color.RED);
                }

            }
        });
      radiog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
              switch (checkedId){
                  case R.id.rb1:
                      Toast.makeText(MainActivity.this, "Male",
                              Toast.LENGTH_SHORT).show();
                      break;
                  case R.id.rb2:
                      Toast.makeText(MainActivity.this, "FeMale",
                              Toast.LENGTH_SHORT).show();
                      break;

              }

          }
      });
    }




    public void click(View view) {
        Toast.makeText(this, "You Selected Image",
                Toast.LENGTH_SHORT).show();
    }

    public void saveData(View view) {
       if(checkb1.isChecked()&&checkb2.isChecked()&&checkb3.isChecked()){
           Toast.makeText(this, ""+checkb1.getText()+","
                   +checkb2.getText()+","+checkb3.getText(), Toast.LENGTH_SHORT).show();
       }
       else if(checkb1.isChecked()&&checkb2.isChecked()){
           Toast.makeText(this, ""+checkb1.getText()+","
                   +checkb2.getText(), Toast.LENGTH_SHORT).show();

        }
       else if(checkb2.isChecked()&&checkb3.isChecked()){
           Toast.makeText(this, ""+checkb2.getText()+","+checkb3.getText(),
                   Toast.LENGTH_SHORT).show();
       }
       else if(checkb1.isChecked()&&checkb3.isChecked()){
           Toast.makeText(this, ""+checkb1.getText()+","+checkb3.getText(),
                   Toast.LENGTH_SHORT).show();
       }
       else if(checkb1.isChecked()){
           Toast.makeText(this, ""+checkb1.getText(),
                   Toast.LENGTH_SHORT).show();
       }
       else if(checkb2.isChecked()){
           Toast.makeText(this, ""+checkb2.getText(),
                   Toast.LENGTH_SHORT).show();
       }
       else if(checkb2.isChecked()){
           Toast.makeText(this, ""+checkb3.getText(),
                   Toast.LENGTH_SHORT).show();
       }


    }
}