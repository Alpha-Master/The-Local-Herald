package com.example.hariprasad.thelocalherald;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText name, email, password, phonenumber,penname,website,gender,locality,pincode,repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main2);
        name = (EditText)findViewById(R.id.etUsername_Reg);
        email = (EditText)findViewById(R.id.etUserEmail_Reg);
        password = (EditText)findViewById(R.id.etUserPassword_Reg);
        repassword = (EditText)findViewById(R.id.etUserRepassword_Reg);
        phonenumber = (EditText)findViewById(R.id.etUserMobileNo_Reg);
        penname = (EditText)findViewById(R.id.etUserPenname_Reg);
        website = (EditText)findViewById(R.id.etUserWebsite_Reg);
        gender = (EditText)findViewById(R.id.etUserGender_Reg);
        locality = (EditText)findViewById(R.id.etUserLocality_Reg);
        pincode = (EditText)findViewById(R.id.etUserPIN_Reg);
    }

    public void OnReg(View view)
    {
        String str_name = name.getText().toString();
        String str_email = email.getText().toString();
        String str_password = password.getText().toString();
        String str_repassword = repassword.getText().toString();
        String str_phonenumber = phonenumber.getText().toString();
        String str_penname = penname.getText().toString();
        String str_website = website.getText().toString();
        String str_gender = gender.getText().toString();
        String str_locality = locality.getText().toString();
        String str_pincode = pincode.getText().toString();
        String type = "register";
        if(str_repassword.equals(str_password)){
            loginBackground lbw = new loginBackground(this);
            lbw.execute(type,str_name,str_email,str_password,str_phonenumber,str_penname,str_website,str_gender,str_locality,str_pincode);
        }
        else {
            Toast.makeText(getApplicationContext(),"Passwords doesnt match",Toast.LENGTH_LONG).show();
        }

    }
}
