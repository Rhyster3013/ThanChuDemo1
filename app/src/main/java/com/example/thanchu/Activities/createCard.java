package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.thanchu.Interfaces.SharedViewModel;
import com.example.thanchu.Models.Card;
import com.example.thanchu.R;
import com.example.thanchu.fragment.card_char;
import com.example.thanchu.fragment.card_play;
import com.example.thanchu.fragment.edit_char;
import com.example.thanchu.fragment.edit_play;

import org.greenrobot.eventbus.EventBus;

public class createCard extends AppCompatActivity {
    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_card);
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
//
//        CardDAO cardDAO =new CardDAO(createCard.this);
//        CardAdapter cardAdapter =new CardAdapter(new ArrayList<>(), cardDAO);
//
//        cardAdapter.listenCardFirestore(FirebaseFirestore.getInstance());

        EditText txbName = findViewById(R.id.txbName);
        EditText txbArtist = findViewById(R.id.txbArtist);
        EditText txbDescription = findViewById(R.id.txbDescription);
        EditText txbImage = findViewById(R.id.txbImage);

        Button btnSummit = findViewById(R.id.btnSummit);
        Button btnSave = findViewById(R.id.btnSaveCard);
        Button btnExit = findViewById(R.id.btnExit);

        Spinner spinner = findViewById(R.id.spinnerCardChoice);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(createCard.this, MainAdmin.class);
                startActivity(back);
            }
        });

//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String txbname = txbName.getText().toString();
//                String txbartist = txbArtist.getText().toString();
//                String txbdescription = txbDescription.getText().toString();
//                String txbimage = txbImage.getText().toString();
//
//                Card card = new Card(txbname, txbimage, txbartist, txbdescription);
//
//                cardAdapter.insertItem(card);
//                if(spinner.getSelectedItem().toString().equals("Character")){
//                }
//            }
//        });

        btnSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txbname = txbName.getText().toString();
                String txbartist = txbArtist.getText().toString();
                String txbdescription = txbDescription.getText().toString();
                String txbimage = txbImage.getText().toString();

                Card card = new Card(txbname, txbimage, txbartist, txbdescription);
                sharedViewModel.setCard(card);

//                Bundle bundle = new Bundle();
//
//                bundle.putSerializable("KEY_SER_CARD", card);
//                //bundle.putString("key", txbname);
//
//                // Tạo Fragment mới và đặt Bundle vào
//                if(spinner.getSelectedItem().toString().equals("Character")){
//                    card_char character = new card_char();
//                    character.setArguments(bundle);
//
//                    FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                    trans.replace(R.id.fcvCardPlay, character);
//                    trans.commit();
//                }
//                else if (spinner.getSelectedItem().toString().equals("Playing Card")) {
//                    card_play play = new card_play();
//                    play.setArguments(bundle);
//
//                    FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                    trans.replace(R.id.fcvCardPlay, play);
//                    trans.commit();
//                }
            }
        });

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