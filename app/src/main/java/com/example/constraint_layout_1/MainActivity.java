package com.example.constraint_layout_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
                            "Email : " + mail + " dan Password : " + pwd + " | Login Sukses", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email atau Password Salah !!!", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }
}