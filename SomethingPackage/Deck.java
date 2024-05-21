package SomethingPackage;
import java.util.ArrayList;
import java.util.Random;

class Deck {
private ArrayList<Card> deck  = new ArrayList<Card>();
Deck() // makes a 6-deck of cards
{
    for(int i=0; i< 24 ; i++) {
        for(int j=0; j< 78; j++){ 
            if (i < 4 && j < 13) {
            deck.add(new Card(i,j));
            }
            else if (i < 8 && j < 26) {
                i = i/2;
                j = j/2;
                deck.add(new Card(i,j));
            }
            else if (i < 12 && j < 39) {
                i = i/3;
                j = j/3;
                deck.add(new Card(i,j));
             }
            else if (i < 16 && j < 52) {
                i = i/4;
                j = j/4;
                deck.add(new Card(i,j));
            }
            else if (i < 20 && j < 65) {
                i = i/5;
                j = j/5;
                 deck.add(new Card(i,j));
             }
            else if (i < 24 && j < 78) {
                i = i/6;
                j = j/6;
                 deck.add(new Card(i,j));
            }
        }
    }
}

public void shuffle() {//shuffles deck 
    Random random = new Random();
    Card temp;
    for(int i=0; i<200; i++) {
        int index1 = random.nextInt(deck.size()-1);
        int index2 = random.nextInt(deck.size()-1);
        temp = deck.get(index2);
        deck.set(index2, deck.get(index1));
        deck.set(index1, temp);
    }
}

public Card drawCard() { //removes the first card in the deck 
    return deck.remove(0);
}
}