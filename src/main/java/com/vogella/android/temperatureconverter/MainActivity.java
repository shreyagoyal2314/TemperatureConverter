package com.vogella.android.temperatureconverter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            Button printButton = (Button) findViewById(R.id.printButton);
            printButton.setEnabled(false);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.calculateButton) {
            if (editText.getText().length() == 0) {
                Toast.makeText(this, "Please enter a valid number!!!", Toast.LENGTH_LONG);
                return;
            }
            float textValue = Float.parseFloat(editText.getText().toString());
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.celsius:
                    editText.setText(String.valueOf(ConverterUtil.farhenheitToCelsius(textValue)));
                    ((RadioButton) findViewById(R.id.celsius)).setChecked(false);
                    ((RadioButton) findViewById(R.id.farhenhiet)).setChecked(true);
                    break;
                case R.id.farhenhiet:
                    editText.setText(String.valueOf(ConverterUtil.celsiusToFarhenheit(textValue)));
                    ((RadioButton) findViewById(R.id.celsius)).setChecked(true);
                    ((RadioButton) findViewById(R.id.farhenhiet)).setChecked(false);
                    break;
            }
        } else if (view.getId() == R.id.printButton) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                printScreen();
            } else {
                Toast.makeText(this, "Printing not supported for Android versions below Kitkat",
                        Toast.LENGTH_LONG);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void printScreen() {
        PrintManager printManager = (PrintManager) getActivity().getSystemService(Context.PRINT_SERVICE);

        String jobName = getActivity().getString(R.string.app_name) + " Document";

        printManager.print(jobName, new MyPrintDocumentAdapter(getActivity(), findViewById(R.id.mainLayout)),
                null);
    }

    public Activity getActivity() {
        return this;
    }
}
