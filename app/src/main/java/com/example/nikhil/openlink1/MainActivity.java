//WORK WITH IDDD METHOD
// CHANGE OBJECT TO LONG AND STRING (SPECIFIC)


package com.example.nikhil.openlink1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//Map<String,Object> userss = new HashMap<String, Object>();

public class MainActivity extends AppCompatActivity {

    Long uuser;
    String singleUser;
    String s;
    EditText mpost;
    TextView mopenThisLink;
    TextView mDisplayText;
    Button mpostLink;
    Button mOpenLink;
    private String userId;
    String enteredlinkurl;
    public FirebaseDatabase mFirebaseInstance;
    public DatabaseReference mFirebaseDatabase;
    public FirebaseDatabase mFirebaseInstancee;
    public DatabaseReference mFirebaseDatabasee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users");
        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("idd");


        mpost = (EditText) findViewById(R.id.post);
        mopenThisLink =  (TextView) findViewById(R.id.showLinks);
        mDisplayText =  (TextView) findViewById(R.id.text);
        mpostLink =  (Button) findViewById(R.id.button);
        mOpenLink = (Button) findViewById(R.id.open);

       mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");


        mFirebaseInstancee = FirebaseDatabase.getInstance();
        mFirebaseDatabasee = mFirebaseInstance.getReference("idd");



        reff.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                     /*  ArrayList<String> phoneNumbers = new ArrayList<>();

                        Map<String, String> userrr = (HashMap<String, String>)
                                dataSnapshot.getValue();

                        for (Map.Entry<String, String> entry : userrr.entrySet()){

                           // userId = mFirebaseDatabase.push().getKey();

                            //Get user map
                            //String singleUser = (String)  entry.getValue();
                            //  s = entry.toString();
                            String singleUser =  entry.getValue();
                            String temp = singleUser.toString();
                            //Get phone field and append to list
                            phoneNumbers.add((String) temp);
                        }*/

                        //dataSnapshot.getValue();
                       //iddd((Map<String,String>) dataSnapshot.getValue());


                         uuser = (Long) dataSnapshot.getValue();
                        mFirebaseDatabasee.setValue(uuser+1);
                        mDisplayText.setText(uuser.toString());

                       // getid((Map<String,Object>) dataSnapshot.getValue());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });


       ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot

                       //dataSnapshot.getValue();
//                        userss = (Map<String, Object>) dataSnapshot.getValue();

                        collectPhoneNumbers((Map<String,Object>) dataSnapshot.getValue());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });






    }

    public void postLink(View v)
    {
        enteredlinkurl = mpost.getText().toString();
        mopenThisLink.setText(enteredlinkurl);
        userId = mFirebaseDatabase.push().getKey();
        uuser = uuser+1;
        User user = new User(enteredlinkurl,uuser,"dummy@email");

        mFirebaseDatabase.child(userId).setValue(user);


    }





    private void iddd(Map<String,String> users) {

        ArrayList<String> phoneNumbers = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, String> entry : users.entrySet()){

            //Get user map
            String singleUser = entry.getValue();
            //Get phone field and append to list
            phoneNumbers.add(singleUser);
        }

        System.out.println(phoneNumbers.toString());
        mDisplayText.setText(" hello ");
    }


    private void collectPhoneNumbers(Map<String,Object> users) {

        ArrayList<String> phoneNumbers = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()){

           // userId = mFirebaseDatabase.push().getKey();

            //Get user map
          //String singleUser = (String)  entry.getValue();
           //  s = entry.toString();
          Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            phoneNumbers.add((String) singleUser.get("link" ));
        }

        System.out.println(phoneNumbers.toString());
       // System.out.println(s);
       // System.out.println(singleUser);

    }

/*
    private void iddd(Map<String,String> users) {

        ArrayList<String> phoneNumberss = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, String> entry : users.entrySet()){

            userId = mFirebaseDatabase.push().getKey();

            //Get user map

//            Map singleUser = (Map) entry.getValue();
            String singleUser =  entry.getValue();
            //Get phone field and append to list
           // phoneNumbers.add((Long) singleUser.get("id" ));
           // int singleUser = (int)  entry.getValue();
            //  s = entry.toString();
           // Integer singleUser = (Integer ) entry.getValue();
            //Get phone field and append to list
        // phoneNumberss.add((Long) singleUser.get("idd" ));
            phoneNumberss.add(singleUser);

        }

        System.out.println(phoneNumberss);
        // System.out.println(s);
        // System.out.println(singleUser);

    }*/

}

