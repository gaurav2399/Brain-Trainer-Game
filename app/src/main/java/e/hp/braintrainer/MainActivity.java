package e.hp.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //i1=(Intent)findViewById(android.R.layout.my_intent)
    }

    public void go(View view) {
       Intent i1=new Intent(this,Second_Activity.class);
       startActivity(i1);
    }
}
