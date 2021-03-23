package com.example.constraint_layout_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class halreg extends AppCompatActivity {
    EditText edtNama,edtAlamat,edtEmail,edtPass,edtRepass;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_halreg);
        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.edEmailAdd);
        edtPass = findViewById(R.id.edPass);
        edtRepass = findViewById(R.id.edrepas);
        fab = findViewById(R.id.fabSimpan);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPass.getText().toString().isEmpty() ||
                        edtRepass.getText().toString().isEmpty())
                {
                    Snackbar.make(v,"Wajib isi seluruh data !!!",Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (edtPass.getText().toString().equals(edtRepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Pendaftaran Berhasil...",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(v,"Password dan Repassword harus sama !!!",Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}