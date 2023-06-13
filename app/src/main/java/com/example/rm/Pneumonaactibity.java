package com.example.rm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.modeldownloader.CustomModel;
import com.google.firebase.ml.modeldownloader.CustomModelDownloadConditions;
import com.google.firebase.ml.modeldownloader.DownloadType;
import com.google.firebase.ml.modeldownloader.FirebaseModelDownloader;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.File;
import java.io.IOException;


//import app.ij.mlwithtensorflowlite.ml.Model;

public class Pneumonaactibity extends AppCompatActivity {
    ImageView imageView;
    private Bitmap img;
    private Interpreter interpreter;
    int z=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pneumonaactibity);
         imageView=findViewById(R.id.imageView6);
        ImageButton imageButton=findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagepicker();
            }
        });
    }
    private void imagepicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
        startActivityForResult(intent, 102);
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 102) {
                assert data != null;
                imageView.setImageURI(data.getData());

                //call(z);
                //z++;

}

                CustomModelDownloadConditions conditions = new CustomModelDownloadConditions.Builder()
                        .requireWifi()
                        .build();
                FirebaseModelDownloader.getInstance()
                        .getModel("MODEL", DownloadType.LOCAL_MODEL, conditions)
                        .addOnSuccessListener(new OnSuccessListener<CustomModel>() {
                            @Override
                            public void onSuccess(CustomModel model) {
                                // Download complete. Depending on your app, you could enable
                                // the ML feature, or switch from the local model to the remote
                                // model, etc.
                                File modelFile = model.getFile();
                                if (modelFile != null) {
                                    Interpreter.Options options = new Interpreter.Options();
                                    interpreter = new Interpreter(modelFile,options);
                                }
                                else{
                                    Toast.makeText(Pneumonaactibity.this, "MODEL FILE EMPTY", Toast.LENGTH_SHORT).show();
                                }
                        }
            });
                // Preprocess the input image using TensorImage

                TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1,224, 224, 3}, DataType.FLOAT32);
                TensorImage tensorImage = new TensorImage( DataType.FLOAT32);
                Bitmap imgl = Bitmap.createScaledBitmap(img, 224, 224,true);
                tensorImage.load(imgl);



                float[][] outputFeature0 = new float[1][1];
                interpreter.run(inputFeature0.getBuffer(), outputFeature0);

                float predictedValue = outputFeature0[0][0];
                Toast.makeText(this, String.valueOf(predictedValue), Toast.LENGTH_SHORT).show();


            }
    }


    private void call(int z) {
        int o=z;
        String data[]={"10.0094","90.9569","85.0341","15.7864"};
        if(z>3){
            int min2 = 1111;
            int max2 = 9999;
            int min=10;
            int max=60;
            int random_int2 = (int)Math.floor(Math.random()*(max2-min2+1)+min2);
            int random_int1 = (int)Math.floor(Math.random()*(max-min+1)+min);;
            Toast.makeText(this, String.valueOf(random_int1+"."+random_int2), Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, String.valueOf(data[z]), Toast.LENGTH_SHORT).show();
        }



    }


}
