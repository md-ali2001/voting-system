package com.alimasood.newvotingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class resultsactivity extends AppCompatActivity {
    FirebaseFirestore db ;
    TextView op1,op2,op3,op4,op5,op6,op7,op8,op9,op10,op11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultsactivity);
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
                        String c=document.getId();


                        DocumentReference doc=db.collection("votingquestion").document(c);
                        doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if(documentSnapshot.exists())
                                {
                                    String opc1,opc2,opc3,opc4,opc5,opc6,opc7,opc8,opc9,opc10,opc11,opr1=" ",opr2=" ",opr3=" ",opr4=" ",opr5=" ",opr6=" ",opr7=" ",opr8=" ",opr9=" ",opr10=" ",opr11=" ";
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



                                    opr11=documentSnapshot.getString("op11");

                                    if(!opr1.equals(" "))
                                    {opc1=documentSnapshot.getString("opc1");
                                        op1.setText(opr1+" : "+opc1);}
                                    else
                                        op1.setVisibility(View.INVISIBLE);

                                    if(!opr2.equals(" "))
                                    {
                                        opc2=documentSnapshot.getString("opc2");
                                        op2.setText(opr2+" : "+opc2);}
                                    else
                                        op2.setVisibility(View.INVISIBLE);

                                    if(!opr3.equals(" ")){
                                        opc3=documentSnapshot.getString("opc3");
                                        op3.setText(opr3+" : "+opc3);}
                                    else
                                        op3.setVisibility(View.INVISIBLE);

                                    if(!opr4.equals(" ")){
                                        opc4=documentSnapshot.getString("opc4");
                                        op4.setText(opr4+" : "+opc4);}
                                    else
                                        op4.setVisibility(View.INVISIBLE);

                                    if(!opr5.equals(" ")){
                                        opc5=documentSnapshot.getString("opc5");
                                        op5.setText(opr5+" : "+opc5);}
                                    else
                                        op5.setVisibility(View.INVISIBLE);

                                    if(!opr6.equals(" ")){
                                        opc6=documentSnapshot.getString("opc6");
                                        op6.setText(opr6+" : "+opc6);}

                                        else
                                        op6.setVisibility(View.INVISIBLE);

                                    if(!opr7.equals(" ")){
                                        opc7=documentSnapshot.getString("opc7");
                                        op7.setText(opr7+" : "+opc7);}
                                    else
                                        op7.setVisibility(View.INVISIBLE);


                                    if(!opr8.equals(" ")){
                                        opc8=documentSnapshot.getString("opc8");
                                        op8.setText(opr8+" : "+opc8);}
                                    else
                                        op8.setVisibility(View.INVISIBLE);


                                    if(!opr9.equals(" ")){
                                        opc9=documentSnapshot.getString("opc9");
                                        op9.setText(opr9+" : "+opc9);}
                                    else
                                        op9.setVisibility(View.INVISIBLE);

                                    if(!opr10.equals(" ")){
                                        opc10=documentSnapshot.getString("opc10");
                                        op10.setText(opr10+" : "+opc10);}
                                    else
                                        op10.setVisibility(View.INVISIBLE);

                                    if(!opr11.equals(" ")){
                                        opc11=documentSnapshot.getString("opc11");
                                        op11.setText(opr11+" : "+opc11);}
                                    else
                                        op11.setVisibility(View.INVISIBLE);









                                    doc.get().addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {

                                        }
                                    });








                                }
                                else{

                                    Toast.makeText(resultsactivity.this, "went wrong", Toast.LENGTH_SHORT).show();


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
}