package com.example.mistik.chatapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class GroupActivity extends AppCompatActivity {

    private FirebaseListAdapter<GroupList> adapter;
    RelativeLayout activity_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        activity_group = (RelativeLayout)findViewById(R.id.activity_group);

        if (FirebaseAuth.getInstance().getCurrentUser() == null){

            Intent signIntent = new Intent(GroupActivity.this, GetStartedActivity.class);
            startActivity(signIntent);
            //startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(),SIGN_IN_REQUEST_CODE);
        } else {
            Snackbar.make(activity_group, "Hosgeldin " + FirebaseAuth.getInstance().getCurrentUser().getEmail(), Snackbar.LENGTH_SHORT).show();

            displayGroupList();
        }
    }

    private void displayGroupList() {
        ListView listOfGroup = (ListView)findViewById(R.id.list_of_group);
        adapter = new FirebaseListAdapter<GroupList>(this,GroupList.class, R.layout.list_item_group, FirebaseDatabase.getInstance().getReference().child("groups")){
            @Override
            protected void populateView(View v, GroupList model, int position) {
                TextView groupName, coordinateX, coordinateY;
                groupName = (TextView) v.findViewById(R.id.group_name);
                coordinateX = (TextView) v.findViewById(R.id.coordinate_x);
                coordinateY = (TextView) v.findViewById(R.id.coordinate_y);

                groupName.setText(model.getGroupName());
                coordinateX.setText(model.getCoordinateX().toString());
                coordinateY.setText(model.getCoordinateY().toString());
            }
        };
        listOfGroup.setAdapter(adapter);
    }
}
