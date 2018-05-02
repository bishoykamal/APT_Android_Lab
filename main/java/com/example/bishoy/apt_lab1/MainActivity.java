package com.example.bishoy.apt_lab1;

import android.app.ActionBar;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab=getActionBar();


        List<Reminder> reminders=new ArrayList<>();

        for(int i=0;i<20;i++)
        {
            Reminder t=new Reminder();
            t.setText("Reminder "+Integer.toString(i));
            if(i%2==0) {

            t.setImportant(false);
            }
            else{ t.setImportant(true);}
            reminders.add(t);

        }

        ListAdapter adapter=new CustomAdapter(this,reminders);
        ListView listView=(ListView) findViewById(R.id.mainlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListView dialoglist=new ListView(MainActivity.this);
                String[] dialogitems={"Edit Reminder","Delete Reminder"};
                ArrayAdapter<String> dialogadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,dialogitems);
                dialoglist.setAdapter(dialogadapter);
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setView(dialoglist);
                final AlertDialog dialog2=builder.create();
                dialog2.show();
                dialoglist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            dialog2.dismiss();
                            final Dialog dialog = new Dialog(MainActivity.this);
                            dialog.setContentView(R.layout.dialog_custom);
                            TextView text = (TextView) dialog.findViewById(R.id.maintitle);
                            text.setText("Edit reminder");
                            LinearLayout linearLayout=(LinearLayout) dialog.findViewById(R.id.mainlayout);
                            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                            dialog.setCancelable(true);
                            Button close=(Button) dialog.findViewById(R.id.cancel);
                            close.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();


                        }
                    }
                });



            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.newreminder){
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.dialog_custom);
            dialog.setCancelable(true);
            LinearLayout linearLayout=(LinearLayout) dialog.findViewById(R.id.mainlayout);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            Button close=(Button) dialog.findViewById(R.id.cancel);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
            return true;
        }else if(id==R.id.exitaction){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
