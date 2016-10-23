package com.example.wagh.ppemployee;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText emailID,emailPass;
    String semailID,semailPass;
    Button Signin;

    SQLiteDatabase mydb;
    String tablename1="Employee";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailID=(EditText)findViewById(R.id.mainEmail);
        emailPass=(EditText)findViewById(R.id.mainPass);
        Signin=(Button)findViewById(R.id.signin);

        databaseopen();


        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                semailID=emailID.getText().toString();
                semailPass=emailPass.getText().toString();

                databaseopen();



                if(semailID.equals("Admin") && semailPass.equals("Admin"))
                {
                    Toast.makeText(getApplicationContext(),"Done!!",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();

                }

            }
        });



    }


    void databaseopen()
    {
        mydb=this.openOrCreateDatabase(tablename1,MODE_PRIVATE,null);

        mydb.execSQL("CREATE TABLE IF NOT EXISTS "+tablename1 +"(E_POST VARCHAR2, E_NAME VARCHAR2, "+
                "E_EMAILID VARCHAR2, E_PASS VARCHAR2, E_CONTACT VARCHAR2)");


    }

    void dataverify()
    {

        String verify_post;

        Cursor identify=mydb.rawQuery("SELECT E_EMAILID,E_PASS,E_POST FROM"+tablename1+
                                      "WHERE E_EMAILID=='"+semailID+"' AND E_PASS=='"+emailPass+"'",null);

        int pemailid=identify.getColumnIndex("E_EMAILID");
        int pemailpass=identify.getColumnIndex("E_PASS");
        int ppost=identify.getColumnIndex("E_POST");

        identify.moveToFirst();

        if (identify!=null)
        {
            verify_post=identify.getString(ppost);
            Toast.makeText(MainActivity.this,verify_post,Toast.LENGTH_SHORT);

            if (verify_post.equals("Admin"))
            {
                //some intent for this special guy
            }
            else if (verify_post.equals("RegionalManager"))
            {
                //some Intent for future
            }
            else if (verify_post.equals("Manager"))
            {
                //some intent for this guy
            }
            else if (verify_post.equals("Employee"))
            {
                //some intent for the actual employee
            }

        }

        identify.close();

    }


}
