package com.example.thanchu.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thanchu.Interfaces.SharedViewModel;
import com.example.thanchu.Models.Card;
import com.example.thanchu.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link card_play#newInstance} factory method to
 * create an instance of this fragment.
 */
public class card_play extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView txvName, txvImage, txvArtist, txvDescription, txvElement;
    private SharedViewModel viewModel;

    public card_play() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment card_play.
     */
    // TODO: Rename and change types and number of parameters
    public static card_play newInstance(String param1, String param2) {
        card_play fragment = new card_play();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_play, container, false);

        txvName = view.findViewById(R.id.txvName);
        txvImage = view.findViewById(R.id.imgIllustration);
        txvArtist = view.findViewById(R.id.txvArtist);
        txvDescription = view.findViewById(R.id.txvDescription);
        txvElement = view.findViewById(R.id.txvElement);

        // Lắng nghe sự thay đổi của LiveData và cập nhật TextView
        viewModel.getCard().observe(getViewLifecycleOwner(), new Observer<Card>() {
            @Override
            public void onChanged(Card card) {
                // Cập nhật TextView với thông tin của đối tượng Card
                txvName.setText(card.getName());
                txvImage.setText(card.getImage());
                txvArtist.setText(card.getArtist());
                txvDescription.setText(card.getDescription());
            }
        });

        viewModel.getType().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String type) {
                // Cập nhật TextView với dữ liệu từ Spinner
                switch (type){
                    case "Kế sách":
                        view.setBackgroundColor(Color.BLUE);
                        break;
                    case "Cơ bản":
                        view.setBackgroundColor(Color.rgb(144, 238, 144));
                        break;
                    case "Trang bị":
                        view.setBackgroundColor(Color.rgb(0, 100, 0));
                        break;
                }
            }
        });

        viewModel.getNumber().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer number) {
                // Update the TextView with the new number
                txvElement.setText(String.valueOf(number));
            }
        });

        viewModel.getElement().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String element) {
                //viewModel.setNumber(Integer.parseInt(txvElement.getText().toString()));
                switch (element){
                    case "Lửa":
                        txvElement.setBackgroundColor(Color.RED);
                        txvElement.setTextColor(Color.BLACK);
                        viewModel.setColor("Đỏ");
                        break;
                    case "Nước":
                        txvElement.setBackgroundColor(Color.BLUE);
                        txvElement.setTextColor(Color.WHITE);
                        viewModel.setColor("Đen");
                        break;
                    case "Gió":
                        txvElement.setBackgroundColor(Color.GRAY);
                        txvElement.setTextColor(Color.BLACK);
                        viewModel.setColor("Đỏ");
                        break;
                    case "Đất":
                        txvElement.setBackgroundColor(Color.rgb(165, 42, 42));
                        txvElement.setTextColor(Color.WHITE);
                        viewModel.setColor("Đen");
                        break;
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void setCard(String name, String image, String artist, String description, String element, String number){

    }

}