package com.alimasood.newvotingsystem;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;

public class votingscreen extends AppCompatActivity {
    boolean check=false;
    String getcount;
    int getcountint;

  public String votingquestionid;
    TextView votingquestion;
   CheckBox op1,op2,op3,op4,op5,op6,op7,op8,op9,op10,op11;
    FirebaseFirestore db ;
    FirebaseFirestoreSettings settings;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votingscreen);

        submit=findViewById(R.id.submit);

        votingquestion=findViewById(R.id.votingquestion);
        op1=findViewById(R.id.op1);
        op2=findViewById(R.id.op2);
        op3=findViewById(R.id.op3);
        op4=findViewById(R.id.op4);
        op5=findViewById(R.id.op5);
        op6=findViewById(R.id.op6);
        op7=findViewById(R.id.op7);
        op8=findViewById(R.id.op8);
        op9=findViewById(R.id.op9);
        op10=findViewById(R.id.op10);
        op11=findViewById(R.id.op11);
        db = FirebaseFirestore.getInstance();
        db.collection("votingquestion").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful())
                {
                    for(QueryDocumentSnapshot document : task.getResult())
                    {
                        votingquestion.setText(document.getId());

                        DocumentReference doc=db.collection("votingquestion").document(votingquestion.getText().toString());
                        doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if(documentSnapshot.exists())
                                {
                                    String opr1=" ",opr2=" ",opr3=" ",opr4=" ",opr5=" ",opr6=" ",opr7=" ",opr8=" ",opr9=" ",opr10=" ",opr11=" ";
                                    opr1=documentSnapshot.getString("op1");
                                    opr2=documentSnapshot.getString("op2");
                                    opr3=documentSnapshot.getString("op3");
                                    opr4=documentSnapshot.getString("op4");
                                    opr5=documentSnapshot.getString("op5");
                                    opr6=documentSnapshot.getString("op6");
                                    opr7=documentSnapshot.getString("op7");
                                    opr8=documentSnapshot.getString("op8");
                                    opr9=documentSnapshot.getString("op9");
                                    opr10=documentSnapshot.getString("op10");
                                    opr11=documentSnapshot.getString("op11");

                                    if(!opr1.equals(" "))
                                        op1.setText(opr1);
                                    else
                                        op1.setVisibility(View.INVISIBLE);

                                    if(!opr2.equals(" "))
                                        op2.setText(opr2);
                                    else
                                        op2.setVisibility(View.INVISIBLE);

                                    if(!opr3.equals(" "))
                                        op3.setText(opr3);
                                    else
                                        op3.setVisibility(View.INVISIBLE);

                                    if(!opr4.equals(" "))
                                        op4.setText(opr4);
                                    else
                                        op4.setVisibility(View.INVISIBLE);

                                    if(!opr5.equals(" "))
                                        op5.setText(opr5);
                                    else
                                        op5.setVisibility(View.INVISIBLE);

                                    if(!opr6.equals(" "))
                                        op6.setText(opr6);
                                    else
                                        op6.setVisibility(View.INVISIBLE);

                                    if(!opr7.equals(" "))
                                        op7.setText(opr7);
                                    else
                                        op7.setVisibility(View.INVISIBLE);


                                    if(!opr8.equals(" "))
                                        op8.setText(opr8);
                                    else
                                        op8.setVisibility(View.INVISIBLE);


                                    if(!opr9.equals(" "))
                                        op9.setText(opr9);
                                    else
                                        op9.setVisibility(View.INVISIBLE);

                                    if(!opr10.equals(" "))
                                        op10.setText(opr10);
                                    else
                                        op10.setVisibility(View.INVISIBLE);

                                    if(!opr11.equals(" "))
                                        op11.setText(opr11);
                                    else
                                        op11.setVisibility(View.INVISIBLE);









                                    doc.get().addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {

                                        }
                                    });








                                }
                                else{

                                    Toast.makeText(votingscreen.this, "went wrong", Toast.LENGTH_SHORT).show();


                                }


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });



                    }
                }
                else
                {

                }




            }
        });




    }

    public void oncheck(View v)
    {

        String checkboxidstring=""+v.getTag()+"";

        if(checkboxidstring.equals("op1"))
        {op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}

        if(checkboxidstring.equals("op2"))
        {op1.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}


        if(checkboxidstring.equals("op3"))
        {op2.setChecked(false);
        op1.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}

        if(checkboxidstring.equals("op4"))

        {op2.setChecked(false);
        op3.setChecked(false);
        op1.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}

        if(checkboxidstring.equals("op5"))
        {op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op1.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}


        if(checkboxidstring.equals("op6"))
        {op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op1.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}

        if(checkboxidstring.equals("op7"))
        {op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op1.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}
        if(checkboxidstring.equals("op8"))
        {op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op1.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}
        if(checkboxidstring.equals("op9"))
        {op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op1.setChecked(false);
        op10.setChecked(false);
        op11.setChecked(false);}
        if(checkboxidstring.equals("op10"))
        {op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op1.setChecked(false);
        op11.setChecked(false);}
        if(checkboxidstring.equals("op11"))
        {op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        op9.setChecked(false);
        op10.setChecked(false);
        op1.setChecked(false);}
    }

    public void submit(View v)
    {

        if(op1.isChecked())
        {
     getcount="opc1";

        }

        if(op2.isChecked())
        {
            getcount="opc2";

        }

        if(op3.isChecked())
        {
            getcount="opc3";

        }

        if(op4.isChecked())
        {
            getcount="opc4";
        }

        if(op5.isChecked())
        {
            getcount="opc5";

        }

        if(op6.isChecked())
        {
            getcount="opc6";

        }

        if(op7.isChecked())
        {
            getcount="opc7";

        }

        if(op8.isChecked())
        {
            getcount="opc8";

        }

        if(op9.isChecked())
        {
            getcount="opc9";

        }

        if(op10.isChecked())
        {
            getcount="opc10";

        }

        if(op11.isChecked())
        {
            getcount="opc11";

        }



        DocumentReference doc=db.collection("votingquestion").document(votingquestion.getText().toString());
        String c=votingquestion.getText().toString();

        doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {
                    String optioncount=documentSnapshot.getString(getcount);

                    getcountint=parseInt(optioncount);
                    getcountint++;
                    optioncount=""+getcountint+"";
                    Map<String, Object> votingquestion = new HashMap<>();

                   votingquestion.put(getcount,optioncount);

                    db.collection("votingquestion").document( c).update(votingquestion);

//




                    doc.get().addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });








                }
                else{

                    Toast.makeText(votingscreen.this, "cnic not registered/invalid", Toast.LENGTH_SHORT).show();


                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        submit.setVisibility(View.INVISIBLE);



    }


    public void resultsactivity(View v)
    {
        Intent myIntent = new Intent(votingscreen.this, resultsactivity.class);

       votingscreen.this.startActivity(myIntent);

    }
}