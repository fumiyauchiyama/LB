package android.lifeistech.com.litboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity
        implements View.OnClickListener{

    //for firevase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMug = database.getReference("message");

    EditText mUsernameText;
    EditText mPostText;
    Button mPostButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mUsernameText = (EditText)findViewById(R.id.username);
        mPostText = (EditText)findViewById(R.id.message);
        mPostButton = (Button) findViewById(R.id.post);


    }

    @Override
    public void onClick(View v){
        int id = v.getId();

        switch (id){
            case R.id.post:

                //投稿を作る
                String messege = mPostText.getText().toString();
                String userName = mUsernameText.getText().toString();
                Post post = new Post(userName,messege);

                //投稿
                refMug.push().setValue(post);


                finish();
                break;
        }
    }
}
