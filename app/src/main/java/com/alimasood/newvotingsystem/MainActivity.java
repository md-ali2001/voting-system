package com.alimasood.newvotingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db ;
    FirebaseFirestoreSettings settings;


    EditText registercnic,fname,sname,registerpin,logincnic,loginpin;
    String   registercnicstr,fnamestr,snamestr,registerpinstr,logincnicstr,loginpinstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();

        registercnic=findViewById(R.id.registercnic);
        fname=findViewById(R.id.fname);
        sname=findViewById(R.id.sname);
        registerpin=findViewById(R.id.registerpin);
        logincnic=findViewById(R.id.logincnic);
        loginpin=findViewById(R.id.loginpin);




    }

    public void register(View v)
    {

        registercnicstr=registercnic.getText().toString();
        fnamestr=fname.getText().toString();
        snamestr=sname.getText().toString();
        registerpinstr=registerpin.getText().toString();


        DocumentReference doc=db.collection("user").document(registercnicstr);
        doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {
                    DocumentReference doc=db.collection("userregisteredbyapp").document(registercnicstr);

                    Map<String, Object> userregisteredbyapp = new HashMap<>();

                    userregisteredbyapp.put("fname",fnamestr);
                    userregisteredbyapp.put("sname", snamestr);
                    userregisteredbyapp.put("pin",registerpinstr);
                    userregisteredbyapp.put("votedornot","0");
                    db.collection("userregisteredbyapp").document( registercnicstr);
                    db.collection("userregisteredbyapp").document(registercnicstr).set(userregisteredbyapp);



                    DocumentReference doc2=db.collection("user").document(registercnicstr);
                    doc2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if(documentSnapshot.exists()){
                                doc2.delete();
                              }
                            else
                            {

                            }

                        }
                    });
                    doc2.get().addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });








                }
                else{

                    Toast.makeText(MainActivity.this, "sorry , already registered/invalid cnic", Toast.LENGTH_SHORT).show();


                  }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });






    }

    public void login(View v)
    {
        logincnicstr=logincnic.getText().toString();

        loginpinstr=loginpin.getText().toString();


        DocumentReference doc=db.collection("userregisteredbyapp").document(logincnicstr);
        doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {
                    String retrievedpin=documentSnapshot.getString("pin");
                    String hasvotedornot=documentSnapshot.getString("votedornot");
                    String votedornot="votedornot";
                 if(retrievedpin.equals(loginpinstr))
                 {

                     if(hasvotedornot.equals("0")){

                         Map<String, Object> updatingvotedornot = new HashMap<>();

                         updatingvotedornot.put( votedornot,"1");

                         db.collection("userregisteredbyapp").document( logincnicstr).update(updatingvotedornot);

                     Intent myIntent = new Intent(MainActivity.this, votingscreen.class);
//                     myIntent.putExtra("key",logincnicstr);

                     MainActivity.this.startActivity(myIntent);}

                     else
                     {
                         Intent myIntent = new Intent(MainActivity.this, resultsactivity.class);
//                     myIntent.putExtra("key",logincnicstr);

                         MainActivity.this.startActivity(myIntent);
                     }



                 }



                 else
                 {
                     Toast.makeText(MainActivity.this, "wrong pin", Toast.LENGTH_SHORT).show();

                 }



                    doc.get().addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });








                }
                else{

                    Toast.makeText(MainActivity.this, "cnic not registered/invalid", Toast.LENGTH_SHORT).show();


                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });



    }
}



