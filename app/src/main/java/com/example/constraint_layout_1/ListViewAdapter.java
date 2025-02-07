package com.example.constraint_layout_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassNama> arrayList;

    public ListViewAdapter(Context context){
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(Home_Act.classNamaArrayList);
    }

    public class  ViewHolder{
        TextView nama;
    }

    @Override
    public int getCount() {
        return Home_Act.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Act.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, null);
            holder.nama = (TextView) view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.nama.setText(Home_Act.classNamaArrayList.get(i).getNama());
        return view;
    }
}

