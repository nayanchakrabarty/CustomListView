package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText eTuser, eTemail, eTpass, eTconfirmPass;
    Button  bAdd, bShow;
     HashMap<Integer, ArrayList<String>> userlist ;
     ArrayList<String> dataArray ;

     int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userlist = new HashMap<>();

        eTuser = findViewById(R.id.editTextUserName);
        eTemail = findViewById(R.id.editTextEmail);
        eTpass = findViewById(R.id.editTextPassword);
        eTconfirmPass = findViewById(R.id.editTextConfirmPassword);

        bAdd = findViewById(R.id.buttonAdd);
        bShow = findViewById(R.id.buttonShow);


        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eTuser.getText().toString();
                String email = eTemail.getText().toString();
                String pwd = eTpass.getText().toString();
                String conPwd = eTconfirmPass.getText().toString();

                dataArray = new ArrayList<>();
                dataArray.add(name);
                dataArray.add(email);
                dataArray.add(pwd);
                dataArray.add(conPwd);

                userlist.put(i,dataArray);
                Toast.makeText(MainActivity.this,"data added",Toast.LENGTH_LONG).show();
                Log.e("total data",userlist.toString());
                i++;
            }
        });

        bShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, SecondActivity.class);
                j.putExtra("data", userlist);
                Log.e("datas",userlist.toString());
                startActivity(j);
            }
        });



    }

}
