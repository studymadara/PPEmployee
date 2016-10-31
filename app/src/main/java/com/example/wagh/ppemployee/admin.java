package com.example.wagh.ppemployee;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wagh on 23/10/16.
 */
public class admin extends AppCompatActivity {

    RecyclerView rv1;
    FloatingActionButton rab1;

    SQLiteDatabase mydb;
    String tablename1="Employee";

    String ademail,adpass,adname,adcontact;

    String adpost="RegionalManager";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);


        //this is where recyclerview is used for displaying the amount of users the admin has created

        //for now only data input process is in progress and later we will start with displaying the no of users


        rv1=(RecyclerView)findViewById(R.id.rv1);

        //my first implementation of floating button...yay,,

        rab1=(FloatingActionButton)findViewById(R.id.firstfloatingbutton);

        rab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this is where alertbox is config and the id creation process generation starts from this point

                //disclaimer no database is used till the point

                //first local data will be used properly and then we will look forward to cloud database

                //basically here i tried to combine the alertbox with the custom layout

                final AlertDialog.Builder alertDialogbuilt = new AlertDialog.Builder(admin.this);

                LayoutInflater inflater = (admin.this).getLayoutInflater();

                final View diaglog = inflater.inflate(R.layout.alertlayout, null);

                alertDialogbuilt.setView(diaglog);

                TextView postcreationedit=(TextView)diaglog.findViewById(R.id.posttextview);

                postcreationedit.setText("Add Regional Manager");

                final EditText nameetalertlay = (EditText) diaglog.findViewById(R.id.nameetalertlayout);

                final EditText emailetalertlay = (EditText) diaglog.findViewById(R.id.emailetalertllayout);

                final EditText passetalertlay = (EditText) diaglog.findViewById(R.id.passetalertllayout);

                final EditText contactetalertlay = (EditText) diaglog.findViewById(R.id.contactetalertllayout);

                alertDialogbuilt.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        adname = nameetalertlay.getText().toString();
                        ademail = emailetalertlay.getText().toString();
                        adpass = passetalertlay.getText().toString();
                        adcontact = contactetalertlay.getText().toString();

                        Toast.makeText(getApplicationContext(), "Addition Done Successfully", Toast.LENGTH_LONG).show();

                        nameetalertlay.setText("");
                        emailetalertlay.setText("");
                        passetalertlay.setText("");
                        contactetalertlay.setText("");






                    }
                });

                alertDialogbuilt.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });

                alertDialogbuilt.show();
            }






            }
        );


    }


    void databasefeed()
    {
        try
        {
            //data insertion is very simple same instance can be created

            //need to work on that for now main functionality is been focused

            mydb=this.openOrCreateDatabase(tablename1,MODE_PRIVATE,null);

            mydb.execSQL("INSERT INTO "+tablename1+" (E_POST,E_NAME,E_EMAILID,E_PASS,E_CONTACT) VALUES ('"+adpost+"','"+adname+"','"+adpass+"','"+adcontact+"',)");

        }
        catch (Exception e)
        {
            Log.e("DATA","Insert",e);

        }
        finally {
            mydb.close();
        }





    }

}
