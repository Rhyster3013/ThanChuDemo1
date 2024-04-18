package com.example.thanchu.Event;

import com.example.thanchu.Models.Card;
import com.example.thanchu.Models.CardCharacter;

public class CardEvent {
    private Card card;

    public CardEvent(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}
