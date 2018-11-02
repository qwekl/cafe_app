package org.techtown.mandk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by LG on 2017-11-25.
 */

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    ProgressBar progressBar;

    EditText EmailText, passwordText;
    Button loginButton;
    TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mAuth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressbar2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ログイン");

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        EmailText = (EditText)findViewById(R.id.idText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        loginButton = (Button)findViewById(R.id.loginButton);
        registerButton = (TextView)findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = EmailText.getText().toString().trim();
                String userPassword = passwordText.getText().toString().trim();


                if (email.isEmpty()){
                    EmailText.setError("メールを入力してください。");
                    EmailText.requestFocus();
                    return;
                }

                if ( !Patterns.EMAIL_ADDRESS.matcher(email).matches() ) {
                    EmailText.setError("メールの規定を守ってください。");
                    EmailText.requestFocus();
                    return;
                }

                if (userPassword.isEmpty()){
                    passwordText.setError("パスワードを入力してください。");
                    passwordText.requestFocus();
                    return;
                }

                if (userPassword.length()<6) {
                    passwordText.setError("パスワードは6文字以上入力してください。");
                    passwordText.requestFocus();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(email, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()) {
                            finish();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplication(),"ID,パスワードが間違っています。", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }

}