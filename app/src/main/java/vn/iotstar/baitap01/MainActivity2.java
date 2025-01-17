package vn.iotstar.baitap01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "OddEvenCounter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtVw_generated = findViewById(R.id.txtVw_generated);
        TextView txtVw_counter = findViewById(R.id.txtVw_counter);

        Button btn_beginCau4 = findViewById(R.id.btn_begin);
        btn_beginCau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] numbers = new int[10];
                int oddCount = 0, evenCount = 0;
                Random random = new Random();

                StringBuilder numbersStringBuilder = new StringBuilder("Số đã tạo: ");
                StringBuilder logStringBuilder = new StringBuilder();

                // Generate random numbers and count odd/even
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = random.nextInt(100); // Generate numbers between 0 and 99
                    numbersStringBuilder.append(numbers[i]).append(" ");
                    logStringBuilder.append(numbers[i]).append(" ");

                    if (numbers[i] % 2 == 0) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                }

                // Update the UI
                txtVw_generated.setText(numbersStringBuilder.toString());
                txtVw_counter.setText("Đếm số chẵn: " + evenCount + ", Đếm số lẻ: " + oddCount);

                // Log the results
                Log.d(TAG, "Số đã tạo: " + logStringBuilder.toString());
                Log.d(TAG, "Đếm số chẵn: " + evenCount + ", Đếm số lẻ: " + oddCount);
            }
        });

        Button btn_Cau2 = findViewById(R.id.btn_Cau2);
        btn_Cau2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });

        Button btn_Cau5 = findViewById(R.id.btn_Cau5);
        btn_Cau5.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });
    }
}