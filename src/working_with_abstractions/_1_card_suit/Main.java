package working_with_abstractions._1_card_suit;

import working_with_abstractions.CardUtils;

public class Main {

    public static void main(String[] args) {

//       CardSuit.printCardSuits();
        CardUtils.printCards(CardSuit.values(), "Suit");
    }
}
