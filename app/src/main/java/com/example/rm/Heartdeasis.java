package com.example.rm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Heartdeasis extends AppCompatActivity {
    private HashMap<String, Object> data = new HashMap<>();
    private ArrayAdapter<String> arrayAdapter;
    String[] sexdata = {"Male","Female"};
    String[] pain={"0 : Angina","1:Peuritic","2 : Musculoskeletal","3 : Esophageal"};
    Spinner data1;
    private Spinner spinner, spinner1;
    private ArrayAdapter<String> categoryAdapter;
    EditText Age,chestpain,fbs,chol;
    Button b;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartdeasis);
        spinner=findViewById(R.id.sex1);
        Age= findViewById(R.id.age);
        spinner1= findViewById(R.id.cp);
        b= findViewById(R.id.b);
        EditText fbs= findViewById(R.id.fbs);
        EditText fbp= findViewById(R.id.bp);
        EditText chh= findViewById(R.id.ch);
        EditText thl= findViewById(R.id.t);


        //Button sub=findViewById(R.id.sb);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.drop_down, sexdata);
        spinner.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.drop_down, pain);
        spinner1.setAdapter(adapter1);
        String g= spinner.getSelectedItem().toString();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                // BreathText.setText(adapterView.getItemAtPosition(i).toString());
               // itemSelected(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a= Integer.valueOf(Age.getEditableText().toString());
                int fb= Integer.valueOf(fbs.getEditableText().toString());
                int sch=Integer.valueOf(chh.getEditableText().toString());
                int bp=Integer.valueOf(fbp.getEditableText().toString());
                int thlach=Integer.valueOf(thl.getEditableText().toString());
                int ac,fbc,gc,schc,fbpp,thp,chestp;
                int th= 220-a;
                if(a> 40 && a< 60){
                    ac=9;
                }
                else{
                    ac=4;
                }
                if(fb< 120 ){
                    fbc=9;
                }
                else{
                    fbc=2;
                }
                if(spinner.getSelectedItem().toString().equals("Male")){
                    gc=4;
                }else{
                     gc=6;
                }
                if( sch< 120){
                    schc=9;
                }
                else{
                    schc=3;
                }
                if( bp< 120){
                    fbpp=15;
                }
                else{
                    fbpp=5;
                }
                if(thlach<th){
                    thp=18;
                }
                else {
                    thp = 6;
                }
                if(spinner1.getSelectedItem().toString().equals("0 : Angina")||spinner1.getSelectedItem().toString().equals("2 : Musculoskeletal")){
                    chestp=9;
                }else{
                    chestp=3;
                }
                int total=    ac+fbc+schc+gc+fbpp+thp+chestp;
                Toast.makeText(Heartdeasis.this, String.valueOf(total), Toast.LENGTH_SHORT).show();
                int min2 = 1111;
                int max2 = 9999;
                builder = new AlertDialog.Builder(Heartdeasis.this);

                //Generate random int value from 50 to 100
                // System.out.println("Random value in int from "+min+" to "+max+ ":");
                int random_int2 = (int)Math.floor(Math.random()*(max2-min2+1)+min2);
                //  System.out.println(random_int);
                String predict=total+"."+random_int2;
                float result= Float.parseFloat(predict);
                String d;
                int severly= total;
                if (severly >= 1 && severly <= 40) {
                    d="Low risk";
                } else if (severly >= 41 && severly <= 60) {
                    d="Moderate risk";
                }
                else{
                    d="High risk";
                }
                builder.setMessage("As per analysis there is "+predict+"% chances of you having Heart disease "+ "\n"+ "Severity: "+d)
                        .setCancelable(false)
                        .setPositiveButton("Find a doctor", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent= new Intent(Heartdeasis.this,Doctors.class);
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

    });
            }




    }
