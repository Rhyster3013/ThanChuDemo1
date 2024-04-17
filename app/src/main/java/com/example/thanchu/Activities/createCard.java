package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.thanchu.R;
import com.example.thanchu.fragment.card_char;
import com.example.thanchu.fragment.card_play;
import com.example.thanchu.fragment.edit_char;
import com.example.thanchu.fragment.edit_play;

public class createCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_card);

        Spinner spinner = findViewById(R.id.spinnerCardChoice);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.choice,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // An item is selected. You can retrieve the selected item using
                // Lấy dữ liệu của mục đã chọn từ Spinner
                String selectedOption = (String) parent.getItemAtPosition(position);

                // Dựa vào dữ liệu của mục đã chọn, hiển thị Fragment tương ứng
                if (selectedOption.equals("Character")) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fcvCardPlay, new card_char())
                            .commit();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fcvEdit, new edit_char())
                            .commit();

                } else if (selectedOption.equals("Playing Card")) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fcvCardPlay, new card_play())
                            .commit();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fcvEdit, new edit_play())
                            .commit();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}