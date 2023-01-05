package com.example.android_lab_6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private static final int PICK_CONTACT =1 ;
    EditText contact;
    EditText message;
    private static final int REQUEST_CONTACT = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        Button selectContacts = findViewById(R.id.selectcontact);
        contact = findViewById(R.id.contact);
        message = findViewById(R.id.message);


        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(contact.getText().toString(), null, message.getText().toString(), pi, null);
                Toast.makeText(getApplicationContext(),"Message sent",Toast.LENGTH_LONG);
            }
        });



    }





}