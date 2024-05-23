package SomethingPackage;
import java.util.ArrayList;

public class Dealer {
ArrayList<Card> hand = new ArrayList<>();//represents the dealer's hand
private int handv = 0;//value of the dealer's hand (starts at 0)
private Card[] aHand = new Card[]{};//used to convert the dealer's hand to an array
private int AC = 0;//counts the aces in the dealer's hand
public  Dealer (Deck deck) //dealer to play against
{
    
    for(int i=0; i<2; i++)
    {
        hand.add(deck.drawCard());
    }
    aHand = hand.toArray(aHand);
    for(int i=0; i<aHand.length; i++)
    {
        handv += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AC++;
        }
        while(AC > 0 && handv>21)
        {
            handv -= 10;
            AC--;
        }
    }
}

public void showFirstCard() { // prints dealers first card

    Card[] firstCard = new Card[]{};
    firstCard = hand.toArray(firstCard);
    System.out.println("["+firstCard[0]+"]");
}

public void Hit(Deck deck) {//Gives the dealer another card and updates the value of his hand. Takes into account the value of aces.
    hand.add(deck.drawCard());
    aHand = hand.toArray(aHand);
    handv = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handv += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AC++;
        }
        while(AC>0 && handv>21)
        {
            handv-=10;
            AC--;
        }
    }
}

public boolean wantsToHit() { //tells dealer when to hit
    if(handv<17)
    {
        return true;
    }
    return false;
}

public boolean hasBlackJack() { // returns blackjack when dealer has black jack
    if(hand.size()==2 && handv==21)
    {
        System.out.println("The dealer has blackjack!");
        return true;
    }
    return false;
}

public void showHand() { //prints entire dealer hand
    System.out.println(hand);
}

public int getHandV() { // gets value of dealer hand
    return handv;
}

public boolean busted(int handv) { //determines dealer bust
    if(handv>21) {
        System.out.println("The dealer busted!");
        return true;
    }
    return false;
}

public int takeTurn(Deck deck) { //dealer turn plus value of hand
    while(wantsToHit())
    {
        System.out.println("The dealer hits");
        Hit(deck);
        if(busted(handv)) {
            break;
        }
    }
    if(handv<=21) {
        System.out.print("The dealer stands.");
    }
    return handv;
}
}