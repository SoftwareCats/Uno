package io.github.softwarecats.uno.deck;

public class PackFactory {

    public static Deck getPack() {
        Deck pack = new Deck();

        // Number cards
        for (Color color : Color.values()) {
            pack.cards.add(new NumberCard(color, 0));
            for (int i = 1; i <= 9; i++) {
                pack.cards.add(new NumberCard(color, i));
                pack.cards.add(new NumberCard(color, i));
            }
        }


        for (Color color : Color.values()) {
            // Skip cards
            pack.cards.add(new SkipCard(color));
            pack.cards.add(new SkipCard(color));

            // Reverse cards
            pack.cards.add(new ReverseCard(color));
            pack.cards.add(new ReverseCard(color));

            // Draw two cards
            pack.cards.add(new DrawTwoCard(color));
            pack.cards.add(new DrawTwoCard(color));
        }

        for (int i = 0; i < 4; i++) {
            // Wild cards
            pack.cards.add(new WildCard());

            // Wild draw four cards
            pack.cards.add(new WildDrawFourCard());
        }

        return pack;
    }
}
