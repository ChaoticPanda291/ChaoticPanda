package SomethingPackage;
import java.util.ArrayList;
import java.util.Arrays;

class Dealer {
ArrayList<Card> hand = new ArrayList<>();//represents the dealer's hand
private int handv = 0;//value of the dealer's hand (starts at 0)
private Card[] aHand = new Card[]{};//used to convert the dealer's hand to an array
private int AceCounter = 0;//counts the aces in the dealer's hand
Dealer(Deck deck) //dealer to play against
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
            AceCounter++;
        }
        while(AceCounter > 0 && handv>21)
        {
            handvalue -= 10;
            AceCounter--;
        }
    }
}
/*
 * Prints the dealer's first card (the card face up at the beginning of a blackjack game).
 */
public void showFirstCard()
{
    Card[] firstCard = new Card[]{};
    firstCard = hand.toArray(firstCard);
    System.out.println("["+firstCard[0]+"]");
}
/*
 * Gives the dealer another card and updates the value of his hand. Takes into account the value of aces.
 */
public void Hit(Deck deck)
{
    hand.add(deck.drawCard());
    aHand = hand.toArray(aHand);
    handv = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handv += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && handvalue>21)
        {
            handv-=10;
            AceCounter--;
        }
    }
}
/*
 * Determines if the dealer wants to hit according to classic Blackjack rules.
 */
public boolean wantsToHit()
{
    if(handv<17)
    {
        return true;
    }
    return false;
}
/*
 * Returns true if the dealer has blackjack.
 */
public boolean hasBlackJack()
{
    if(hand.size()==2 && handv==21)
    {
        System.out.println("The dealer has blackjack!");
        return true;
    }
    return false;
}
/*
 * Prints the dealer's hand.
 */
public void showHand()
{
    System.out.println(hand);
}
/*
 * Returns the value of the dealer's hand.
 */
public int getHandV()
{
    return handv;
}
/*
 * Determines if a dealer has busted.
 */
public boolean busted(int handv)
{
    if(handv>21)
    {
        System.out.println("The dealer busted!");
        return true;
    }
    return false;
}
/*
 * Takes the turn for the dealer and returns the value of his hand.
 */
public int takeTurn(Deck deck)
{
    while(wantsToHit())
    {
        System.out.println("The dealer hits");
        Hit(deck);
        if(busted(handv))
        {
            break;
        }
    }
    if(handv<=21)
    {
        System.out.print("The dealer stands.");
    }
    return handv;
}
}