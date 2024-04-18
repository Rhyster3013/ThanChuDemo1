package com.example.thanchu.Event;

import com.example.thanchu.Models.Card;
import com.example.thanchu.Models.CardCharacter;

public class CardEvent {
    private CardCharacter card;

    public CardEvent(CardCharacter card) {
        this.card = card;
    }

    public CardCharacter getCard() {
        return card;
    }
}
