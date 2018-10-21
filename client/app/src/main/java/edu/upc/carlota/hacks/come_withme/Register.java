package edu.upc.carlota.hacks.come_withme;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private Button Register;
    private int pWhere, pWhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText etUserame = (EditText) findViewById(R.id.nameRegister);
        String usernameR = etUserame.getText().toString();
        EditText etPassword = (EditText) findViewById(R.id.passwordRegister);
        String passwordR = etPassword.getText().toString();
        EditText etMail = (EditText) findViewById(R.id.emailRegister);
        String emailR = etMail.getText().toString();
        EditText etBio = (EditText) findViewById(R.id.bio);
        String bio = etBio.getText().toString();

        Register = (Button) findViewById(R.id.buttonOK);

        Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);
        Spinner staticSpinnerHours = (Spinner) findViewById(R.id.static_spinner_hours);
        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.schools_array,
                        android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> staticAdapterHours = ArrayAdapter
                .createFromResource(this, R.array.hours_array,
                        android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> staticAdapterGenre = ArrayAdapter
                .createFromResource(this, R.array.gender_array,
                        android.R.layout.simple_spinner_item);


        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        staticAdapterHours
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        staticAdapterGenre
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
        staticSpinnerHours.setAdapter(staticAdapterHours);
        dynamicSpinner.setAdapter(staticAdapterGenre);

        String school = staticSpinner.getSelectedItem().toString();
        Integer time = staticSpinnerHours.getSelectedItemPosition();
        String gendre = dynamicSpinner.getSelectedItem().toString();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postCredentials(usernameR, passwordR, emailR, bio, time, school, gendre);

                startActivity(new Intent(Register.this, Navigation.class));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_prefWhat:
                if (checked)
                    pWhat = 1;
                    break;
            case R.id.radio_bar:
                if (checked)
                    pWhat = 2;
                    break;
            case R.id.radio_indif:
                if (checked)
                    pWhat = 3;
                    break;

            case R.id.radio_outdoors:
                if (checked)
                    pWhere = 1;
                    break;
            case R.id.radio_indoors:
                if (checked)
                    pWhere = 2;
                    break;
            case R.id.radio_indifPlace:
                if (checked)
                    pWhere = 3;
                    break;
        }
    }



    //función para llamar a la API
    private void postCredentials(String usernameR, String passwordR, String emailR, String bio, Integer time, String school, String gendre) {

        APICommunicator apiCommunicator = new APICommunicator();
        Response.Listener responseListener = (Response.Listener<CustomRequest.CustomResponse>) response -> {
            JSONObject jsonObject;
            String mail = null;
            String hora = null;
            try {
                jsonObject = new JSONObject();
                mail = jsonObject.getString("mail");
                hora = jsonObject.getString("time");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            startActivity(new Intent(Register.this, Navigation.class));
            finish();
        };

        Response.ErrorListener errorListener = error -> {
            Log.i("error","error");
        };

        Map<String, Object> params = new HashMap<>();
        params.put("name", usernameR);
        params.put("password", passwordR);
        params.put("email", emailR);
        params.put("bio", bio);
        params.put("gender", gendre);
        params.put("time", time);
        params.put("pWhere", pWhere);
        params.put("pWhat", pWhat);
        params.put("school", school);

        apiCommunicator.postRequest(getApplicationContext(), "/contact" , responseListener, errorListener, params);
    }

}
