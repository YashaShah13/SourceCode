package com.example.yasha.asynctaskassignment;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button msg1,msg2,startTask;
    EditText length;
    ProgressBar progressBar;
    TextView tv1,tv2;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        length=(EditText)findViewById(R.id.ET1);
        msg1=(Button)findViewById(R.id.button);
        msg2=(Button)findViewById(R.id.button3);
        startTask=(Button)findViewById(R.id.button2);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView5);



        msg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ToastIt("Responding to button1 on UI Thread");

            }
        });

        msg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ToastIt("Responding to button2 on UI Thread");

            }
        });

        startTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    x = Integer.valueOf(length.getText().toString());
                    if(x<100)
                    {
                        ToastIt("Enter values only greater than 100");
                    }
                    else {

                        new LongTask().execute(x);
                    }
                }catch (Exception e)
                {
                    ToastIt("Enter numaric values only");
                }
                tv2.setText("");


            }
        });
    }

    public class LongTask extends AsyncTask<Integer,Integer,Void>
    {

        @Override
        protected Void doInBackground(Integer... integers) {


             x=integers[0];


            for(int i=0;i<(x/100);i++)
            {

                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(x/100);
            progressBar.setVisibility(View.VISIBLE);
            tv1.setVisibility(View.VISIBLE);


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressBar.setVisibility(View.GONE);
            tv1.setVisibility(View.GONE);
            tv2.setText("Task took "+x+" milliseconds");
            tv1.setVisibility(View.GONE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
        }
    }
    void ToastIt(String toast)
    {
        Toast.makeText(this,toast,Toast.LENGTH_LONG).show();
    }
}
