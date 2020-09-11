package com.example.contactlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int newContactScreenCode = 6;

    String sName,sPhoneNumber,sAddress,sWebsite;
    Button btnNewContact;
    LinearLayout loContact;
    ImageView btnCall,btnAddress,btnWebsite;
    TextView tvContactName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loContact = findViewById(R.id.contact);
        btnNewContact = findViewById(R.id.btnNewContact);
        btnCall = findViewById(R.id.btnCall);
        btnAddress = findViewById(R.id.btnAddress);
        btnWebsite = findViewById(R.id.btnWebsite);
        tvContactName = findViewById(R.id.tvContactName);

        loContact.setVisibility(View.GONE);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == newContactScreenCode)
        {
            if (resultCode == RESULT_OK)
            {


                sName = data.getStringExtra("sName");
                sPhoneNumber = data.getStringExtra("sPhoneNumber");
                sAddress= data.getStringExtra("sAddress");
                sWebsite= data.getStringExtra("sWebsite");

                tvContactName.setText(sName);
                loContact.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newContactScreen = new Intent(MainActivity.this,com.example.contactlist.newContact.class);
                startActivityForResult(newContactScreen,newContactScreenCode);

            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+sPhoneNumber));
                startActivity(call);
            }
        });

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent website = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+sWebsite));
                startActivity(website);
            }
        });
        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+sAddress));
                startActivity(map);
            }
        });
    }
}