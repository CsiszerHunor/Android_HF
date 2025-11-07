package com.example.activitystatesavetwo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "StateSaveTwo";
    private EditText editText;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    // 👉 Állapot mentése (pl. képernyő elforgatás előtt)
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("editTextValue", editText.getText().toString());
        outState.putBoolean("checkBoxValue", checkBox.isChecked());
        Log.d(TAG, "onSaveInstanceState()");
    }

    // 👉 Állapot visszaállítása (pl. elforgatás után)
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String text = savedInstanceState.getString("editTextValue");
        boolean checked = savedInstanceState.getBoolean("checkBoxValue");

        editText.setText(text);
        checkBox.setChecked(checked);

        Log.d(TAG, "onRestoreInstanceState()");
    }
}
