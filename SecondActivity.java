
package com.example.name;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void sendData(View view) {
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText surnameEditText = findViewById(R.id.surnameEditText); // Dodane

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", nameEditText.getText().toString());
            jsonObject.put("surname", surnameEditText.getText().toString()); // Dodane
        } catch (Exception e) {
            e.printStackTrace();
        }


        Intent intent = new Intent();
        intent.putExtra("jsonData", jsonObject.toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
