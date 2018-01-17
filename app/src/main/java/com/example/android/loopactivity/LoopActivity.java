package com.example.android.loopactivity;

import android.content.Intent;
import android.os.AsyncTask;

import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {

    private int number;
    private TextView loopStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        loopStatus = (TextView) findViewById(R.id.status_textview);


    }

    public void PassToAsync() {
        try {
            number = 0;

        } catch (Exception e) {
            return;
        }
        AsynCounter asynCounter = new AsynCounter();
        asynCounter.execute(number);

    }

    private class AsynCounter extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            loopStatus.setText("Starting loop...");

        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int count = number;
            for (int i = count; i <= 100000; i++) {
                count = i;
                publishProgress(i);
            }

            return count;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            loopStatus.setText("Loops completed: " + progress[0]);
        }

        @Override
        protected void onPostExecute(Integer result) {
            loopStatus.setText("Loops completed: " + result);
            Intent intent = new Intent(LoopActivity.this, LoginActivity.class);

        }


    }
}