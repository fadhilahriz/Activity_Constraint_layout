package com.example.constraint_layout_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Act extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;

    private  ListViewAdapter adapter;

    String[] listNama;
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle b = new Bundle();
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);

        listNama = new String[]{"Inayah","Ilham","Eris","Fikri","Maul",
                "Intan","Vina","Gita","Vian","Lutfi"};

        list = findViewById(R.id.listkontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i<listNama.length;i++){
             ClassNama classNama = new ClassNama(listNama[i]);
             classNamaArrayList.add(classNama);
         }

         adapter = new ListViewAdapter(this);
         list.setAdapter(adapter);

         list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String nama = classNamaArrayList.get(position).getNama();
                 b.putString("a",nama.trim());
                 PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                 pm.setOnMenuItemClickListener(Home_Act.this);
                 pm.inflate(R.menu.popup_menu);
                 pm.show();
             }
         });
    }
    @Override
    public  boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                i = new Intent(getApplicationContext(),ActLihatData.class);
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini Untuk edit Kontak",Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}