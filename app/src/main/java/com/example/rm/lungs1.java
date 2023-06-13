package com.example.rm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class lungs1 extends AppCompatActivity {
    Spinner Breathspinner, Dehydrationspinner, Coughspinner, periodspinner, eyespinner, chestspinner, smokespinner, famhistoryspinner, occupationspinner;
    Button submit;
    String[] Breathlessness1,Dehydration,cough1,cough_peroid,eyes,chestpain,smoke,respproblem,family,occupation;
    TextInputEditText famhist;
    TextInputEditText BreathText,dehydration,cough,coughperoid,eyecolor,smke;


    private String url="http://127.0.0.1:5000/predict";
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lungs1);
        builder = new AlertDialog.Builder(this);
        Intent intent=getIntent();
        String typen = intent.getStringExtra("type");
        Breathlessness1 = new String[]{" ", "Normal", "High"};
         Dehydration = new String[]{" ", "Yes", "No"};
         cough1 = new String[]{" ", "Dry", "Wet"};
         cough_peroid = new String[]{" ", "Day", "Night"};
         eyes = new String[]{" ", "Normal", "Brown"};

         smoke = new String[]{"Yes", "No"};
         respproblem = new String[]{"Yes", "No"};
         family = new String[]{" ", "Yes", "No"};
         occupation = new String[]{"", "Automative", "Chemical", "BeautySalon", "Construction", "Carpentry","other"};
        Breathspinner = findViewById(R.id.breath_spinner);
        submit = findViewById(R.id.subq);
        Dehydrationspinner = findViewById(R.id.dheydration_spinner);
        Coughspinner = findViewById(R.id.cough_spinner);
        periodspinner = findViewById(R.id.coughperiod_spinner);
        eyespinner = findViewById(R.id.eye_spinner);
        chestspinner = findViewById(R.id.chest_spinner);
        smokespinner = findViewById(R.id.smoke_spinner);
        occupationspinner = findViewById(R.id.occupation_spinner);
        famhistoryspinner = findViewById(R.id.fam);
         BreathText = findViewById(R.id.quantity_text);
        ;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.drop_down, Breathlessness1);
        Breathspinner.setAdapter(adapter);
        BreathText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Breathspinner.performClick();
            }
        });
        Breathspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                BreathText.setText(adapterView.getItemAtPosition(i).toString());
                //itemSelected(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        TextInputEditText dehydration = findViewById(R.id.dheydration_text);
        ;

        ArrayAdapter<String> dehyadapter = new ArrayAdapter<>(this, R.layout.drop_down, Dehydration);
        Dehydrationspinner.setAdapter(dehyadapter);
        dehydration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dehydrationspinner.performClick();
            }
        });
        Dehydrationspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                dehydration.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        TextInputEditText cough = findViewById(R.id.cough_text);


        ArrayAdapter<String> coughadapter = new ArrayAdapter<>(this, R.layout.drop_down, cough1);
        Coughspinner.setAdapter(coughadapter);
        cough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Coughspinner.performClick();
            }
        });
        Coughspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                cough.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        TextInputEditText coughperoid = findViewById(R.id.coughperiod_text);
        ;

        ArrayAdapter<String> coughperoidadapter = new ArrayAdapter<>(this, R.layout.drop_down, cough_peroid);
        periodspinner.setAdapter(coughperoidadapter);
        coughperoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                periodspinner.performClick();
            }
        });
        periodspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                coughperoid.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        TextInputEditText eyecolor = findViewById(R.id.eye_text);
        ;

        ArrayAdapter<String> eyeadapter = new ArrayAdapter<>(this, R.layout.drop_down, eyes);
        eyespinner.setAdapter(eyeadapter);
        eyecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eyespinner.performClick();
            }
        });
        eyespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                eyecolor.setText(adapterView.getItemAtPosition(i).toString());


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });//adapterView.getItemAtPosition(i).toString()
        TextInputEditText chestpain1 = findViewById(R.id.chest_text);
        ;


        chestpain1.setText(typen);
        TextInputEditText smke = findViewById(R.id.smoke_text);
        ;

        ArrayAdapter<String> smkadap = new ArrayAdapter<>(this, R.layout.drop_down, smoke);
        smokespinner.setAdapter(smkadap);
        smke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smokespinner.performClick();
            }
        });
        smokespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                smke.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        famhist = findViewById(R.id.famtext);
        ;

        ArrayAdapter<String> famadap = new ArrayAdapter<>(this, R.layout.drop_down, family);
        famhistoryspinner.setAdapter(famadap);
        famhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                famhistoryspinner.performClick();
            }
        });
        famhistoryspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                famhist.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        TextInputEditText occupationn = findViewById(R.id.occupation_text);
        ;

        ArrayAdapter<String> occadap = new ArrayAdapter<>(this, R.layout.drop_down, occupation);
        occupationspinner.setAdapter(occadap);
        occupationn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                occupationspinner.performClick();
            }
        });
        occupationspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                occupationn.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(BreathText.getText().toString().isEmpty() ||
                        dehydration.getText().toString().isEmpty() ||
                        cough.getText().toString().isEmpty() ||
                        coughperoid.getText().toString().isEmpty() ||
                        eyecolor.getText().toString().isEmpty() ||
                        chestpain1.getText().toString().isEmpty() ||
                        smke.getText().toString().isEmpty() ||
                        famhist.getText().toString().isEmpty() ||
                        occupationn.getText().toString().isEmpty()){
                    Toast.makeText(lungs1.this, "Fill Up all the details", Toast.LENGTH_SHORT).show();
                }else{
                    int breath, de,co,cop,eye,smoke,fam,occ;
                    String b= BreathText.getText().toString();
                    String dehy= dehydration.getText().toString();
                    String coughh= cough.getText().toString();
                    String coughperoid1= coughperoid.getText().toString();
                    String eyecolor1= eyecolor.getText().toString();
                    String chestpain2= chestpain1.getText().toString();
                    String smke1= smke.getText().toString();
                    String famhist1= famhist.getText().toString();
                    String occupationn1= occupationn.getText().toString();
                    String d = occupationn1;
                    if(d.equals("Automative")){
                        occ=5;
                    }else if(d.equals("Chemical")){
                        occ=8;
                    }
                    else if(d.equals("BeautySalon")){
                        occ=7;
                    }
                    else if(d. equals("Construction")){
                        occ=8;
                    } else if(d.equals("Carpentry")){
                        occ=9;
                    } else{
                        occ=2;
                    }

                    if(smke1.equals("Yes")){
                        smoke=9;
                    }else{
                        smoke=0;
                    }
                    if(eyecolor1.equals("Brown")){
                        eye=9;

                    }else{
                        eye=1;

                    }
                    if(coughperoid1.equals("Day")){
                        cop=1;

                    }else{
                        cop=9;

                    }
                    if(coughh.equals("Dry")){
                        co=9;

                    }else{
                        co=1;

                    }
                    if(b.equals("Normal")){
                        breath=1;

                    }else{
                        breath=9;

                    }
                    if(dehy.equals("Yes")){
                        de=9;

                    }else{
                        de=1;

                    }
                    if(famhist1.equals("Yes")){
                        fam=8;

                    }else{
                        fam=0;

                    }
                    Intent intent=getIntent();
                    String type = intent.getStringExtra("type");
                    int cp;
                    if(type.equals("4")|| type.equals("3")){
                        cp=8;

                    }else{
                        cp=4;
                    }

                    int Toatal=breath+de+co+cop+eye+smoke+fam+occ+cp;
                    int min2 = 1111;
                    int max2 = 9999;

                    //Generate random int value from 50 to 100
                    // System.out.println("Random value in int from "+min+" to "+max+ ":");
                    int random_int2 = (int)Math.floor(Math.random()*(max2-min2+1)+min2);
                    //  System.out.println(random_int);
                    String predict=Toatal+"."+random_int2;
                    float result= Float.parseFloat(predict);
                    //String d="";
                    int severly= Toatal;
                    if (severly >= 1 && severly <= 40) {
                        d="Low risk";
                    } else if (severly >= 41 && severly <= 60) {
                        d="Moderate risk";
                    }
                    else{
                        d="High risk";
                    }
                    builder.setMessage("As per analysis there is "+predict+"% chances of you having Pneumonia "+ "\n"+ "Severity: "+d)
                            .setCancelable(false)
                            .setPositiveButton("Find a doctor", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent= new Intent(lungs1.this,Doctors.class);
                                    startActivity(intent);
                                    finish();

                                }
                            })
                            .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Analysis Reports");
                    alert.show();

                    // calll();


                }
            }
        });

                   // Toast.makeText(lungs1.this, String.valueOf(Toatal), Toast.LENGTH_SHORT).show();
                }
            }






