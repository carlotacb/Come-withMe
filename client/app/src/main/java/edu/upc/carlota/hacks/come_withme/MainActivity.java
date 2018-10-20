package edu.upc.carlota.hacks.come_withme;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Objects;

import edu.upc.carlota.hacks.come_withme.ServerConection.PostAsyncTask;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private TextInputLayout errorUsername, errorPassword;
    private Button login;
    private String username, password;

    //private Resources res = this.getResources();

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

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                String camponecesario = res.getString(R.string.fieldnecesary);

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

                    JSONObject values = new JSONObject();

                    try {
                        values.put("username", username);
                        values.put("password", password);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    /*new PostAsyncTask("", MainActivity.this) {
                        @Override
                        protected void onPostExecute(JSONObject resObject) {

                            Boolean result = false;
                            String error = "Error";//res.getString(R.string.error);

                            try {
                                if (resObject.has("success")) {
                                    result = resObject.getBoolean("success");
                                }
                                if (!result && resObject.has("errorMessage"))
                                    error = "ERror";
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.i("asdBool", result.toString());

                            if (result) {
                                startActivity(new Intent(MainActivity.this, EditProfile.class));
                            } else {
                                Log.i("asd", "gfgffgfgf");
                                etUsername.setText("");
                                etPassword.setText("");
                                errorPassword.setErrorEnabled(true);
                                errorPassword.setError(error);
                                //etPassword.getBackground().setColorFilter(getResources().getColor(R.color.red_500_primary), PorterDuff.Mode.SRC_ATOP);
                                errorUsername.setErrorEnabled(true);
                                errorUsername.setError(error);
                                //etUsername.getBackground().setColorFilter(getResources().getColor(R.color.red_500_primary), PorterDuff.Mode.SRC_ATOP);
                            }

                        }
                    }.execute(values);


            }
        });*/

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });

    }


}
