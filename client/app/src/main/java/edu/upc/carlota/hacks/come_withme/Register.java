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
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class Register extends AppCompatActivity {

    private EditText etName, etPassword, etMail;
    private Button login;
    private String nameRegister, password, emailRegister;
    private Boolean[] weekDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.weekDays = new Boolean [5];
        Arrays.fill(weekDays, false);

        etName = (EditText) findViewById(R.id.nameRegister);
        etPassword = (EditText) findViewById(R.id.password);
        etMail = (EditText) findViewById(R.id.emailRegister);

        login = (Button) findViewById(R.id.btnLogin);
        TextView register = (TextView) findViewById(R.id.btnRegister);

        Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.schools_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);

        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        String[] items = new String[] { "Female", "Male", "Other" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Preferences.class));
            }
        });
    }

    //CHECKBOXES
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_monday:
                if (checked)
                weekDays[0] = true;
            else
                // No Mondays
                break;
            case R.id.checkbox_tuesday:
                if (checked)
                    weekDays[1] = true;
            else
                // No Tuesdays
                break;
            case R.id.checkbox_wednesday:
                if (checked)
                    weekDays[2] = true;
            else
                // No Wednesdays
                break;
            case R.id.checkbox_thursday:
                if (checked)
                    weekDays[3] = true;
            else
                // No Thrusdays
                break;
            case R.id.checkbox_friday:
                if (checked)
                    weekDays[4] = true;
            else
                // No Fridays
                break;
            // TODO: Day of the week
        }
    }

}
