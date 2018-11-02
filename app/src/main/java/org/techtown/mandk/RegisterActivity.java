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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

/**
 * Created by LG on 2017-11-25.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText emailText,passwordText,nameText,phoneNumText;
    ProgressBar progressBar;
    String userName, userPhoneNum;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("会員加入");

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        emailText = (EditText)findViewById(R.id.idText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        nameText = (EditText)findViewById(R.id.nameText);
        phoneNumText = (EditText)findViewById(R.id.phoneNumText);

        Button registerButton = (Button)findViewById(R.id.registerButton);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        mAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailText.getText().toString().trim();
                String userPassword = passwordText.getText().toString().trim();
                userName = nameText.getText().toString().trim();
                userPhoneNum = phoneNumText.getText().toString().trim();

                if (email.isEmpty()){
                    emailText.setError("メールを入力してください。");
                    emailText.requestFocus();
                    return;
                }

                if ( !Patterns.EMAIL_ADDRESS.matcher(email).matches() ) {
                    emailText.setError("メールの規定を守ってください。");
                    emailText.requestFocus();
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

                if (userName.isEmpty()){
                    nameText.setError("名前を入力してください。");
                    nameText.requestFocus();
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()) {

                            //名前,携帯番号プロフィールに入力してくれる
                            FirebaseUser user = mAuth.getCurrentUser(); // 現在のユーザーデータを受け取る

                            if (user != null ){
                                UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(userName).build();

                                user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            // プロフィールアップデートが成功したとき
                                            Toast.makeText(getApplicationContext(),"成功的に加入されました。", Toast.LENGTH_SHORT).show();
                                            mAuth.signOut();
                                            finish();
                                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                                        }
                                        //プロフィールアップデートが失敗したとき
                                        else {
                                            Toast.makeText(getApplicationContext(),"問題が発生して会員加入が不可能です。", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });
                            }
                        } else {

                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getApplicationContext(),"このメールはもう加入している電子メールです。",Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });



            }
        });
    }
}