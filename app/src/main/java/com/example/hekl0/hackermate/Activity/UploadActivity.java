package com.example.hekl0.hackermate.Activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hekl0.hackermate.R;
import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadActivity extends AppCompatActivity {

    private TessBaseAPI m_tess;
    TextView textTargetUri;
    ImageView targetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Button buttonLoadImage = (Button) findViewById(R.id.uploadbtn);
        textTargetUri = (TextView) findViewById(R.id.txt_result);
        targetImage = (ImageView) findViewById(R.id.image_to_be_processed);

        buttonLoadImage.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });


        try {
            prepareLanguageDir();
            m_tess = new TessBaseAPI();
            m_tess.init(String.valueOf(getFilesDir()), "vie");
        } catch (Exception e) {
            // Logging here
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                targetImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // copy file from assets to another folder due to accessible
    private void copyFile() throws IOException {
        // work with assets folder
        AssetManager assMng = getAssets();
        InputStream is = assMng.open("tessdata/end.traineddata");
        OutputStream os = new FileOutputStream(getFilesDir() + "/tessdata/end.traineddata");
        byte[] buffer = new byte[1024];
        int read;
        while ((read = is.read(buffer)) != -1) {
            os.write(buffer, 0, read);
        }

        is.close();
        os.flush();
        os.close();
    }

    private void prepareLanguageDir() throws IOException {
        File dir = new File(getFilesDir() + "/tessdata");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File trainedData = new File(getFilesDir() + "/tessdata/vie.traineddata");
        if (!trainedData.exists()) {
            copyFile();
        }
    }


}
