package com.to_letbd.to_letbd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class MyCustomAdapter extends ArrayAdapter<AddInformation> implements View.OnClickListener {
    private Context mcontext;
    private ArrayList<AddInformation> data;
    public ArrayList<AddInformation> informations;
    public MyCustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<AddInformation> objects) {
        super(context, resource, objects);
        this.mcontext=context;
        this.data=objects;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mconvertview=convertView;
        if (mconvertview==null){
            LayoutInflater from = LayoutInflater.from(getContext());
            mconvertview = from.inflate(R.layout.custom, null);
        }
        AddInformation student = data.get(position);
        ImageView imageView= (ImageView) mconvertview.findViewById(R.id.imageView);
        Button btncall= (Button) mconvertview.findViewById(R.id.btncall);
        Button btnLocation= (Button) mconvertview.findViewById(R.id.btnLocation);
        Button btnsendmail= (Button) mconvertview.findViewById(R.id.btnsendmail);
        TextView tvcontact = (TextView) mconvertview.findViewById(R.id.textView);
        TextView  tvmail = (TextView) mconvertview.findViewById(R.id.textView2);
        TextView  tvname = (TextView) mconvertview.findViewById(R.id.textView3);
        TextView  tvlocation = (TextView) mconvertview.findViewById(R.id.textView4);
        TextView  tvdetails = (TextView) mconvertview.findViewById(R.id.textView5);

        tvcontact.setText("Contact No: "+student.getContactNO());
        tvmail.setText("Mail: "+student.getMail());
        tvname.setText("Name: "+student.getName());
        tvlocation.setText("Location: "+student.getLocation());
        tvdetails.setText("Details: "+student.getDetails());
        btnLocation.setOnClickListener(this);
        //String contactNO = student.getContactNO();
       btnsendmail.setOnClickListener(this);
        btncall.setOnClickListener(this);
        return mconvertview;
    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.btnLocation:

        break;
    case R.id.btncall:

        break;
    case R.id.btnsendmail:

        break;
}
    }
}
