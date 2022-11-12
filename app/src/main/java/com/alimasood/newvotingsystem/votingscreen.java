package com.alimasood.newvotingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;

public class votingscreen extends AppCompatActivity {
    boolean check=false;

    String votingquestionid;
    TextView votingquestion;
   CheckBox op1,op2,op3,op4,op5,op6,op7,op8,op9,op10,op11;
    FirebaseFirestore db ;
    FirebaseFirestoreSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votingscreen);
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
                        votingquestionid=document.getId().toString();
                    }
                }
                else {

                }
                op3.setText(votingquestionid);
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
}