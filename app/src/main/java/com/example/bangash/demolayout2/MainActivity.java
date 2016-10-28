package com.example.bangash.demolayout2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvItems = (ListView) findViewById(R.id.lvItmes);
        String arr[] = {"English","Urdu","Netwroking"};
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, arr);
        lvItems.setAdapter(adapter);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.actionbarColor));
        }

    }






    private class CustomListViewAdapter extends ArrayAdapter<String> {


        Context context;
        String data[];
        int images[];

        public CustomListViewAdapter(Context context, String data[]) {


            super(context, R.layout.custom_layout, data);
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(R.layout.custom_layout, parent, false);
            Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
            Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner2);
            TextView tvSubject= (TextView) v.findViewById(R.id.tvSubject);
            tvSubject.setText(data[position]);
            String arr[]={"1","2","3"};
            ArrayAdapter arrayAdapter=new ArrayAdapter(context,R.layout.custom_text_spinner,R.id.cutomText,arr);
            spinner.setAdapter(arrayAdapter);
            spinner2.setAdapter(arrayAdapter);
//            TextView tvName = (TextView) v.findViewById(R.id.tvName);
//            tvName.setText(data[position]);
//            iv.setImageResource(images[position]);
            return v;
        }
    }
}
