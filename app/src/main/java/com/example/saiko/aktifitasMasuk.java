package com.example.saiko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class aktifitasMasuk extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        auth = FirebaseAuth.getInstance();  //Get firebase auth instance

        inputEmail = (EditText) findViewById(R.id.email_edt_txt);
        inputPassword = (EditText) findViewById(R.id.pass_edt_txt);
        btnLogin = (Button) findViewById(R.id.login_btn);

    btnLogin.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String email = inputEmail.getText().toString();
            final String password = inputPassword.getText().toString();
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Mohon masukkan E-mail Anda", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "Mohon masukkan kata sandi Anda", Toast.LENGTH_SHORT).show();
                return;
            }
            //authenticate user
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(aktifitasMasuk.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            //progressBar.setVisibility(View.GONE);
                            if (!task.isSuccessful()) {
                                // there was an error
                                if (password.length() < 6) {
                                    inputPassword.setError("Kata sandi terlalu pendek");
                                } else {
                                    Toast.makeText(aktifitasMasuk.this, ("E-mail atau kata sandi yang dimasukkan salah"), Toast.LENGTH_LONG).show();
                                }
                            } else if (task.isSuccessful()){
                                Intent intent = new Intent(aktifitasMasuk.this, aktifitasUtama.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
        }
    });
    }

    public void launchLogin(View view) {
        Intent intent = new Intent(this, aktifitasUtama.class);
        startActivity(intent);
    }
}
