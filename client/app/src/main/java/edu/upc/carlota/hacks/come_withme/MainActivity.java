package edu.upc.carlota.hacks.come_withme;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private TextInputLayout errorUsername, errorPassword;
    private Button login;
    private String username, password;

//    private Resources res = this.getResources();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);

        errorUsername = (TextInputLayout) findViewById(R.id.username_up);
        errorPassword = (TextInputLayout) findViewById(R.id.password_up);

        login = (Button) findViewById(R.id.btnLogin);
        TextView register = (TextView) findViewById(R.id.btnRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setEnabled(false);
                login.setText("Loading...");
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                String camponecesario = "Necessary field";

                if (username.length() == 0) {
                    errorUsername.setErrorEnabled(true);
                    errorUsername.setError(camponecesario);
                    // etUsername.getBackground().setColorFilter(getResources().getColor(R.color.red_500_primary), PorterDuff.Mode.SRC_ATOP);
                    if (password.length() != 0) {
                        errorPassword.setErrorEnabled(false);
                        etPassword.getBackground().clearColorFilter();
                    }
                }

                if (password.length() == 0) {
                    errorPassword.setErrorEnabled(true);
                    errorPassword.setError(camponecesario);
                    //etPassword.getBackground().setColorFilter(getResources().getColor(R.color.red_500_primary), PorterDuff.Mode.SRC_ATOP);
                    if (username.length() != 0) {
                        errorUsername.setErrorEnabled(false);
                        etUsername.getBackground().clearColorFilter();
                    }
                } else {
                    errorUsername.setErrorEnabled(false);
                    errorPassword.setErrorEnabled(false);

                    //postCredentials(username, password);
                    startActivity(new Intent(MainActivity.this, Navigation.class));
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }

    //función para llamar a la API
    /*private void postCredentials(String user, String password) {

        APICommunicator apiCommunicator = new APICommunicator();
        Response.Listener responseListener = (Response.Listener<CustomRequest.CustomResponse>) response -> {
            JSONObject jsonObject;
            String username2 = null;
            String password2 = null;
            try {
                jsonObject = new JSONObject();
                username2 = jsonObject.getString("username");
                password2 = jsonObject.getString("password");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            startActivity(new Intent(MainActivity.this, Navigation.class));
            finish();
        };

        Response.ErrorListener errorListener = error -> {
            etPassword.getText().clear();
            login.setEnabled(true);
            login.setText("LOGIN");
        };

        Map<String, Object> params = new HashMap<>();
        params.put("username", user);
        params.put("password", password);

        apiCommunicator.postRequest(getApplicationContext(), "/login" , responseListener, errorListener, params);
    }*/
}
