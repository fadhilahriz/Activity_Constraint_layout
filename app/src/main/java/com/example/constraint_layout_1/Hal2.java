package com.example.constraint_layout_1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Hal2 extends AppCompatActivity {
    TextView txemail,txpass;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hal2);

        txemail=(TextView)findViewById(R.id.tvmail);
        txpass=(TextView)findViewById(R.id.tvpass);

        Bundle b2 = getIntent().getExtras();
        String nm = b2.getString("p1");
        String pw = b2.getString("p2");

        txemail.setText(nm);
        txpass.setText(pw);
    }
}
