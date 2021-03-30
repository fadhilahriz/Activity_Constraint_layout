package com.example.constraint_layout_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edmail, edpwd;
    Button btsignin;
    String mail,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btsignin=findViewById(R.id.button1);
        edmail=findViewById(R.id.editText1);
        edpwd=findViewById(R.id.editText2);
        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail=edmail.getText().toString();
                pwd=edpwd.getText().toString();

                if(mail.equals("fadhil@mail.com") && pwd.equals("12345678")) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("p1",mail.trim());
                    b.putString("p2",pwd.trim());

                    Intent i = new Intent(MainActivity.this, Hal2.class );
                    i.putExtras(b);
                    startActivity(i);
                }
                else if(mail.equals("") || pwd.equals("")){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password Tidak Boleh Kosong", Toast.LENGTH_LONG);
                    t.show();
                }
                else if(!mail.equals("fadhil@mail.com") && pwd.equals("12345678")){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email Salah !!!", Toast.LENGTH_LONG);
                    t.show();
                }
                else if(mail.equals("fadhil@mail.com") && !pwd.equals("12345678")) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Password Salah !!!", Toast.LENGTH_LONG);
                    t.show();
                }
                else if(!mail.equals("fadhil@mail.com") && !pwd.equals("12345678")){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password Salah !!!", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent in = new Intent(getApplicationContext(), Home_Act.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}