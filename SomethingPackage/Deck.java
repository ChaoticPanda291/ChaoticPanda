package SomethingPackage;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
private ArrayList<Card> deck  = new ArrayList<Card>();
public  Deck() // makes a 6-deck of cards
{
    for(int i=0; i< 24 ; i++) {
        for(int j = 0; j< 72; j++){ 
            if (i < 4 && j < 12) {
            deck.add(new Card(i,j));
            }
            else if (i < 8 && j < 24) {
                i = (int) (i/2);
                j = (int) (j/2);
                deck.add(new Card(i,j));
            }
            else if (i < 12 && j < 36) {
                i = (int) (i/3);
                j = (int) (j/3);
                deck.add(new Card(i,j));
             }
            else if (i < 16 && j < 48) {
                i = (int) (i/4);
                j = (int) (j/4);
                deck.add(new Card(i,j));
            }
            else if (i < 20 && j < 60) {
                i = (int) (i/5);
                j = (int) (j/5);
                 deck.add(new Card(i,j));
             }
            else if (i < 24 && j < 72) {
                i = (int) (i/6);
                j = (int) (j/6);
                 deck.add(new Card(i,j));
            }
        }
    }
}

public void shuffle() { //shuffles deck 
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