package e.hp.braintrainer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Second_Activity extends AppCompatActivity {
    TextView timer;
    TextView question;
    Button playAgain;
    Button b1,b2,b3,b4;
    TextView result,finalResult;
    int answer,totalQuestion=0,rightAnswer=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        playAgain=(Button)findViewById(R.id.playAgain);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        result=(TextView)findViewById(R.id.result);

        finalResult=(TextView)findViewById(R.id.final_result);
        b1.setTag(Integer.valueOf(1));
        b2.setTag(Integer.valueOf(2));

        b3.setTag(Integer.valueOf(3));
        b4.setTag(Integer.valueOf(4));
        timer=(TextView)findViewById(R.id.timer);
        question=(TextView)findViewById(R.id.question);
        answer=setOptions();

       // boolean b1clicked=false;
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                timer.setText("0s");
                playAgain.setVisibility(View.VISIBLE);
                b1.setClickable(false);
                b2.setClickable(false);
                b3.setClickable(false);
                b4.setClickable(false);
                MediaPlayer mpl=MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                mpl.start();

            }
        }.start();

    }
    public int  setOptions(){
        totalQuestion++;
        int m1,m2;
        m1=new Random().nextInt(50)+1;
        m2=new Random().nextInt(50)+1;
        question.setText(m1+" + "+m2);
        int sum=m1+m2;
        int answer=new Random().nextInt(4)+1;
        int option1=new Random().nextInt(101);
        int option2=new Random().nextInt(101);
        int option3=new Random().nextInt(101);
        //int q=(Integer)b1.getTag();
        //Log.i("tag:",String.valueOf(q));
        Log.i(" 1value:",String.valueOf(m1));
        Log.i(" 2value:",String.valueOf(m2));
        Log.i("option1:",String.valueOf(option1));
        Log.i("option2:",String.valueOf(option2));
        Log.i("option3:",String.valueOf(option3));
        //Log.i("info:","in function");
        Log.i("answer:",String.valueOf(answer));
        //if(option1!=option2&&option2!=option3) {
            if ((int)b1.getTag() == answer) {
                b1.setText(String.valueOf(sum));
                b2.setText(String.valueOf(option1));
                b3.setText(String.valueOf(option2));
                b4.setText(String.valueOf(option3));
            } else if ((int)b2.getTag() == answer) {
                b1.setText(String.valueOf(option1));
                b2.setText(String.valueOf(sum));
                b3.setText(String.valueOf(option2));
                b4.setText(String.valueOf(option3));
            } else if ((int)b3.getTag() == answer) {
                b1.setText(String.valueOf(option2));
                b2.setText(String.valueOf(option1));
                b3.setText(String.valueOf(sum));
                b4.setText(String.valueOf(option3));
            } else {
                b1.setText(String.valueOf(option3));
                b2.setText(String.valueOf(option1));
                b3.setText(String.valueOf(option2));
                b4.setText(String.valueOf(sum));
            }

            finalResult.setText(rightAnswer+"/"+totalQuestion);
            return answer;

    }

    public void opt4(View view) {
        int q1=(Integer)b4.getTag();
        if(q1==answer){
            //Toast.makeText(this,"CORRECT!!!",Toast.LENGTH_SHORT).show();
            rightAnswer++;
            result.setText("CORRECT ANSWER!!!");
        }
        else{
           // Toast.makeText(this,"WRONG ANSWER!!!",Toast.LENGTH_SHORT).show();
        result.setText("WRONG ANSWER!!!");}
        answer=setOptions();

    }

    public void opt3(View view) {
        int q1=(Integer)b3.getTag();
        if(q1==answer){
           // Toast.makeText(this,"CORRECT!!!",Toast.LENGTH_SHORT).show();
            result.setText("CORRECT ANSWER!!!");
            rightAnswer++;
        }
        else{
           // Toast.makeText(this,"WRONG ANSWER!!!",Toast.LENGTH_SHORT).show();
            result.setText("WRONG ANSWER!!!");}
        answer=setOptions();

    }

    public void opt2(View view) {
        int q1=(Integer)b2.getTag();
        if(q1==answer){
            //Toast.makeText(this,"CORRECT!!!",Toast.LENGTH_SHORT).show();
            result.setText("CORRECT ANSWER!!!");
            rightAnswer++;
        }
        else{
           // Toast.makeText(this,"WRONG ANSWER!!!",Toast.LENGTH_SHORT).show();

            result.setText("WRONG ANSWER!!!");}
        answer=setOptions();

    }

    public void opt1(View view) {
        //Toast.makeText(this,"answer is"+answer,Toast.LENGTH_SHORT).show();
        int q1=(Integer)b1.getTag();
        if(q1==answer){
           // Toast.makeText(this,"CORRECT!!!",Toast.LENGTH_SHORT).show();
            result.setText("CORRECT ANSWER!!!");
            rightAnswer++;
        }
        else{
           // Toast.makeText(this,"WRONG ANSWER!!!",Toast.LENGTH_SHORT).show();

            result.setText("WRONG ANSWER!!!");}
        answer=setOptions();

    }

    public void playAgain(View view) {
        Intent i1=new Intent(this,MainActivity.class);
        startActivity(i1);
        this.finish();
    }
}
