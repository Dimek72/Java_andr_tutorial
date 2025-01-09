
package com.example.name;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void openSecondActivity(View view) {
        startActivityForResult(new Intent(this, SecondActivity.class), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            try {

                String jsonData = data.getStringExtra("jsonData");
                JSONObject jsonObject = new JSONObject(jsonData);


                String name = jsonObject.getString("name");
                String surname = jsonObject.getString("surname");


                textView.setText(name + " " + surname);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
