package com.example.student.myapplication;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivityFragment extends Fragment {
Button but;
    Card[] card;
    int z = 0;
    View rootView;
    TextView tv2;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container,
                false);

        tv2 = (TextView)  rootView.findViewById(R.id.textView);
        rootView.setBackgroundColor(Color.BLACK);
        tv2.setTextColor(Color.BLUE);


        card = new Card[52];

        for (int suit = 0; suit < 4; suit++) {
            for( int rank = 0; rank < 13; rank++) {
                card[z] = new Card(suit, rank);
                z++;
            }



        }
        card = shuffleDeck(card);
        GetterSetter.card = card;

        return rootView;
    }

    public Card[] shuffleDeck(Card[] deck) {
        Random apples = new Random();
        Card tenpCard = new Card(0, 0);
        for (int shuffleCount = 0; shuffleCount < 52; shuffleCount++) {
            int randomCard = apples.nextInt(52);
            tenpCard = deck[randomCard];
            deck[randomCard] = deck[shuffleCount];
            deck[shuffleCount] = tenpCard;
        }
        return deck;
    }


}
