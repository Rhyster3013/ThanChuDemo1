package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.thanchu.Adapters.CardCharAdapter;
import com.example.thanchu.Adapters.CardPlayAdapter;
import com.example.thanchu.DAO.CardCharDAO;
import com.example.thanchu.DAO.CardPlayDAO;
import com.example.thanchu.Interfaces.SharedViewModel;
import com.example.thanchu.Interfaces.VmCard;
import com.example.thanchu.Models.Card;
import com.example.thanchu.Models.CardCharacter;
import com.example.thanchu.R;
import com.example.thanchu.fragment.card_char;
import com.example.thanchu.fragment.card_play;
import com.example.thanchu.fragment.edit_char;
import com.example.thanchu.fragment.edit_play;

import java.util.ArrayList;

public class createCard extends AppCompatActivity {
    private SharedViewModel sharedViewModel;
    private VmCard vmCard;

//    public void setNumber(Integer number) {
//        sharedViewModel.setNumber(number);
//    }
//
//    public Integer getNumber() {
//        return sharedViewModel.getNumber().getValue();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_card);
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        //vmCard = new ViewModelProvider(this).get(vmCard.class);
//
//        CardDAO cardDAO =new CardDAO(createCard.this);
//        CardAdapter cardAdapter =new CardAdapter(new ArrayList<>(), cardDAO);
//
//        cardAdapter.listenCardFirestore(FirebaseFirestore.getInstance());

        CardCharDAO cardCharDAO = new CardCharDAO(createCard.this);
        CardCharAdapter cardCharAdapter = new CardCharAdapter(new ArrayList<>(), cardCharDAO);
        CardPlayDAO cardPlayDAO = new CardPlayDAO(createCard.this);
        CardPlayAdapter cardPlayAdapter = new CardPlayAdapter(new ArrayList<>(), cardPlayDAO);

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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txbname = txbName.getText().toString();
                String txbartist = txbArtist.getText().toString();
                String txbdescription = txbDescription.getText().toString();
                String txbimage = txbImage.getText().toString();

                if(spinner.getSelectedItem().toString().equals("Character")){
                    CardCharacter card = new CardCharacter(txbname, txbimage, txbartist, txbdescription, sharedViewModel.getHp().getValue());
                    cardCharAdapter.insertItem(card);
                }

                if(spinner.getSelectedItem().toString().equals("Playing Card")){
                    CardCharAdapter adapter = new CardCharAdapter();
                    CardCharacter card = new CardCharacter(txbname, txbimage, txbartist, txbdescription, sharedViewModel.getHp().toString());
                    adapter.insertItem(card);
                }
            }
        });

        btnSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txbname = txbName.getText().toString();
                String txbartist = txbArtist.getText().toString();
                String txbdescription = txbDescription.getText().toString();
                String txbimage = txbImage.getText().toString();

                Card card = new Card(txbname, txbimage, txbartist, txbdescription);
                sharedViewModel.setCard(card);
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