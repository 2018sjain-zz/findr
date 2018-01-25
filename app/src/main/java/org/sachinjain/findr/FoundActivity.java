package org.sachinjain.findr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FoundActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private TextView mResult1;
    private TextView mResult2;
    private TextView mResult3;
    private Button mBack;
    private List<Post> postList;
    private String base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);

        mSpinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        base = " Item: \n Location: \n Reward: \n Name: \n Contact: ";

        postList = new ArrayList<>();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference posts = database.getReference("posts");

        mResult1 = (TextView)findViewById(R.id.result1);
        mResult2 = (TextView)findViewById(R.id.result2);
        mResult3 = (TextView)findViewById(R.id.result3);
        String status = mSpinner.getSelectedItem().toString();

        if (status.equals("Recent")){
            String[] post1 = base.split("\n");
            String[] post2 = base.split("\n");
            String[] post3 = base.split("\n");

            post1[0] += "Shoes";
            post1[1] += "Chem Commons";
            post1[2] += "$20";
            post1[3] += "Sachin Jain";
            post1[4] += "(703) 508 - 9090";
            String temp1 = TextUtils.join("\n", post1);
            mResult1.setText(temp1);

            post2[0] += "Wallet";
            post2[1] += "Nobel Commons";
            post2[2] += "$50";
            post2[3] += "Pranav Avasarala";
            post2[4] += "(703) 934 - 3245";
            String temp2 = TextUtils.join("\n", post2);
            mResult2.setText(temp2);

            post3[0] += "Keychain";
            post3[1] += "Locker Room";
            post3[2] += "$5";
            post3[3] += "Erick Tian";
            post3[4] += "ericktian@gmail.com";
            String temp3 = TextUtils.join("\n", post3);
            mResult3.setText(temp3);
        }

        else if (status.equals("Reward")){
            String[] post1 = base.split("\n");
            String[] post2 = base.split("\n");
            String[] post3 = base.split("\n");

            post1[0] += "Shoes";
            post1[1] += "Chem Commons";
            post1[2] += "$20";
            post1[3] += "Sachin Jain";
            post1[4] += "(703) 508 - 9090";
            String temp1 = TextUtils.join("\n", post1);
            mResult2.setText(temp1);

            post2[0] += "Wallet";
            post2[1] += "Nobel Commons";
            post2[2] += "$50";
            post2[3] += "Pranav Avasarala";
            post2[4] += "(703) 934 - 3245";
            String temp2 = TextUtils.join("\n", post2);
            mResult1.setText(temp2);

            post3[0] += "Keychain";
            post3[1] += "Locker Room";
            post3[2] += "$5";
            post3[3] += "Erick Tian";
            post3[4] += "ericktian@gmail.com";
            String temp3 = TextUtils.join("\n", post3);
            mResult3.setText(temp3);
        }


        mBack = (Button)findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
