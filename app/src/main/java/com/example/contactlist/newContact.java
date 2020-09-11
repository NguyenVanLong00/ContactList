package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class newContact extends AppCompatActivity {

    EditText etName,etPhoneNumber,etAddress,etWebsite;
    Button btnSave;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etWebsite = findViewById(R.id.etWebsite);
        btnBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnSave);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeScreem = new Intent(newContact.this,com.example.contactlist.MainActivity.class);
                startActivity(homeScreem);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty() || etAddress.getText().toString().isEmpty()
                        || etPhoneNumber.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty())
                {
                    Toast.makeText(newContact.this,"Please enter all feild",Toast.LENGTH_LONG).show();
                }
                else
                {
                    String sName,sPhoneNumber,sAddress,sWebsite;
                    sName = etName.getText().toString();
                    sPhoneNumber = etPhoneNumber.getText().toString().trim();
                    sAddress = etAddress.getText().toString();
                    sWebsite=etWebsite.getText().toString();

                    Intent homeScreen = new Intent(newContact.this,com.example.contactlist.MainActivity.class);
                    homeScreen.putExtra("sName",sName);
                    homeScreen.putExtra("sPhoneNumber",sPhoneNumber);
                    homeScreen.putExtra("sAddress",sAddress);
                    homeScreen.putExtra("sWebsite",sWebsite);

                    setResult(RESULT_OK,homeScreen);
                    newContact.this.finish();

                }
            }
        });

    }
}