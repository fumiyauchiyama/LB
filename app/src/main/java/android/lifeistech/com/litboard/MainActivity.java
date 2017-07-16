package android.lifeistech.com.litboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMug = database.getReference("message");

    ListView mListView;
    Button mButton;

    ArrayList<Post> items;

    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.list_view);
        mButton = (Button)findViewById(R.id.button);
        //mButton.setOnClickListener();

        items = new ArrayList<>();
        postAdapter = new PostAdapter(this,0,items);

        mListView.setAdapter(postAdapter);


        refMug.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Post value = dataSnapshot.getValue(Post.class);

                items.add(value);

                postAdapter.clear();
                postAdapter.addAll(items);
                postAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void jumpryoku(View v){
        Intent intent = new Intent(this,PostActivity.class);
        startActivity(intent);
    }



}
