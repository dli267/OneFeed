package com.example.onefeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class AccountActivity extends AppCompatActivity {

    ImageButton imgButton;
    public static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Allows user to set a profile picture by clicking on the current profile pic
        // which is stored as an image button

        /*
        imgButton = (ImageButton) findViewById(R.id.profile_pic);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GaleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(GaleryIntent, RESULT_LOAD_IMAGE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri SelectedImage = data.getData();
            String[] FilePathColumn = {MediaStore.Images.Media.DATA };

            Cursor SelectedCursor = getContentResolver().query(SelectedImage, FilePathColumn, null, null, null);
            SelectedCursor.moveToFirst();

            int columnIndex = SelectedCursor.getColumnIndex(FilePathColumn[0]);
            String picturePath = SelectedCursor.getString(columnIndex);
            SelectedCursor.close();

            //  Drawable d = new BitmapDrawable(getResources(),BitmapFactory.decodeFile(picturePath));
            // btnOpenGallery .setImageBitmap(d);
            imgButton.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            Toast.makeText(getApplicationContext(), picturePath, Toast.LENGTH_SHORT).show();

        } */

    }


}