package com.example.hariprasad.thelocalherald;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText penName, passWord;
    TextView registerPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        penName = (EditText)findViewById(R.id.etPenname_main);
        passWord = (EditText)findViewById(R.id.etPassword_main);
        registerPage = (TextView)findViewById(R.id.tvRegister_main);

        registerPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });

    }

    public void OnLogin(View view)
    {
        String penname = penName.getText().toString();
        String password = passWord.getText().toString();
        String type = "login";

        loginBackground lbw = new loginBackground(this);
        lbw.execute(type,penname,password);

    }

}
