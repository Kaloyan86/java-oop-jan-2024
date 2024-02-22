package working_with_abstractions._2_card_rank;

import working_with_abstractions.CardUtils;

public class Main {

    public static void main(String[] args) {
        // CardRank.printCardRank();

        CardUtils.printCards(CardRank.values(), "Rank");
    }
}
