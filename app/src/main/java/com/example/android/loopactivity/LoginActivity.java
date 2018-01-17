package com.example.android.loopactivity;


import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Amar on 1/16/18.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefsTesting";

    private EditText username;
    private EditText password;
    private CheckBox checkBox;
    private Button login;
    private SharedPreferences storedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        checkBox = (CheckBox) findViewById(R.id.remember);
        login = (Button) findViewById(R.id.login_button);


        Intent intent = getIntent();
        storedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = storedPreferences.edit();
                String username = LoginActivity.this.username.getText().toString();
                String password = LoginActivity.this.password.getText().toString();
                boolean remember = checkBox.isChecked();
                if (checkBox.isChecked()) {
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.putBoolean("remember", remember);
                    editor.commit();
                } else {
                    editor.putBoolean("remember", remember);
                }

                if (username.equals("user@aol.com") && password.equals("password1234")) {
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("email", username);
                    startActivity(intent);
                }

            }
        });


    }
}
