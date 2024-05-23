package SomethingPackage;
public class Card {
    
    private int rank;//represents the rank of a card
    private int suit;//represents the suit of a card
    private int value;//represents the value of a card
    private  String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private  String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
    
      
     
    Card(int s, int v) //creates a card object
    {
        rank = v;
        suit = s;
    }
    
    public String toString() //prints string
    {
        return ranks[rank]+" of "+suits[suit];
    }
    
    public int getRank() //returns rank
    {
        return rank;
    }
    
    public int getSuit() //returns suit
    {
        return suit;
    }
    
    public int getValue() //returns face value and returns 10 if its a face card 
    {
        if(rank>9)
        {
            value=10;
        }
        else if(rank==0)
        {
            value=11;
        }
        else
        {
            value=rank;
        }
        return value;
    }
     
    public void setValue(int set)
    {
        value = set;
    }
}

