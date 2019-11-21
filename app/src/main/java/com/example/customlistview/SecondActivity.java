package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView=findViewById(R.id.datashowlist);
        Intent intent = getIntent();

        HashMap<Integer, ArrayList<String>> dataset = (HashMap<Integer, ArrayList<String>>) intent.getSerializableExtra("data");

        Log.e("testing",dataset.toString());
        ArrayList<dataset> finadataser=new ArrayList<>();

        for(int i =0;i<dataset.size();i++){

            ArrayList<String> datas=dataset.get(i);


            String name=datas.get(0);
            String email=datas.get(1);
            String pass=datas.get(2);
            String cpas=datas.get(3);

            finadataser.add(new dataset(name,email,pass,cpas));
            Toast.makeText(this,"data added",Toast.LENGTH_LONG).show();
        }

        arrayAdapter arrayAdapter=new arrayAdapter(this,finadataser);
        listView.setAdapter(arrayAdapter);

    }

    private class dataset {
        private String user;
        private String email;
        private String pwd;
        private String cPwd;

        public dataset(String user, String email, String pwd, String cPwd ) {
            this.user = user;
            this.email = email;
            this.pwd = pwd;
            this.cPwd = cPwd;
        }
    }

    private class arrayAdapter extends ArrayAdapter<dataset> {

        public arrayAdapter(Context context, ArrayList<dataset> users) {
            super(context, 0, users);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            dataset dataset=getItem(position);
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.dataview, parent, false);
            }
            TextView user=convertView.findViewById(R.id.uName);
            TextView email=convertView.findViewById(R.id.uEmail);
            TextView pwd=convertView.findViewById(R.id.uPwd);
            TextView cPwd=convertView.findViewById(R.id.uCpwd);

            user.setText(dataset.user);
            email.setText(dataset.email);
            pwd.setText(dataset.pwd);
            cPwd.setText(dataset.cPwd);

            return convertView;
        }
    }


}
