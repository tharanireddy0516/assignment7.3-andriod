package com.example.tharani.imageview;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    /*onCreate is the first method in the life cycle of an activity
     savedInstance passes data to super class,data is pull to store state of application
   * setContentView is used to set layout for the activity
   *R is a resource and it is auto generate file
   * activity_main assign an integer value*/
    // declaration
    private ImageView imageView;
    private Button galleryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//here we are creating the main method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         /*creating reference to galleryButton ad image view
         * giving reference to activity_main.xml*/
        galleryButton = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
       // Starts with action pressing on button to select file
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//here we are creating the on click method
                // here we are creating the intent
                Intent intent = new Intent();
                //here we are setting the type of intent which
                //we will pass to the another screen
                intent.setType("image/*");//For specific type add image/jpeg
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 50);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //here we are creating the onActivityResult method
        super.onActivityResult(requestCode, resultCode, data);
        //here we are applying the condition
        if(requestCode==50 && resultCode==RESULT_OK){
            //here it will Get the url from data
            Uri selectedImageUri = data.getData();
            if (null != selectedImageUri) {
                //displays image
                imageView.setImageURI(selectedImageUri);
            }
        }
    }
}

