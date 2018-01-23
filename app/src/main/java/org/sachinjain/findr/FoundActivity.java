package org.sachinjain.findr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);

        mSpinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        postList = new ArrayList<>();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference posts = database.getReference("posts");

        mResult1 = (TextView)findViewById(R.id.result1);
        mResult2 = (TextView)findViewById(R.id.result2);
        mResult3 = (TextView)findViewById(R.id.result3);
        String status = mSpinner.getSelectedItem().toString();

        String[] post1 = mResult1.getText().toString().split("\n");
        String[] post2 = mResult2.getText().toString().split("\n");
        String[] post3 = mResult3.getText().toString().split("\n");
        for (int x = 0; x < post1.length; x++){
            post1[x].concat("temp\n");
            System.out.print(post1[x]);
        }
        String temp1 = TextUtils.join("", post1);
        mResult1.setText(temp1);

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
