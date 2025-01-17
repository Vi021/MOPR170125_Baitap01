package vn.iotstar.baitap01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editTxt_input = findViewById(R.id.editTxt_input);
        TextView txtVw_result = findViewById(R.id.txtVw_result);
        Button btn_toast = findViewById(R.id.btn_toast);

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTxt_input.getText().toString().trim();

                // Split input by space into words, reverse and convert each word to uppercase
                if (!inputText.isEmpty()) {
                    List<String> words = Arrays.asList(inputText.split("\\s+"));
                    Collections.reverse(words); // Reverse the list of words
                    StringBuilder result = new StringBuilder();

                    // Convert each word to uppercase and append to result
                    for (String word : words) {
                        result.append(word.toUpperCase()).append(" ");
                    }

                    String finalResult = result.toString().trim();
                    txtVw_result.setText(finalResult);

                    // Display a Toast message
                    Toast.makeText(MainActivity3.this, finalResult, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity3.this, R.string.cau5Warning, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btn_return = findViewById(R.id.btn_return);
        btn_return.setOnClickListener(view -> {
            this.finish();
        });
    }
}