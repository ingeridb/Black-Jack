import java.util.Stack;

public class Deck{

    Stack<Card> cards = new Stack<Card>();
    public Deck(String [] cardss){
        setDeck(cardss);
    }

    public void setDeck(String [] cardss){
        for (int i = 0; i < cardss.length; i++){
            Card card = new Card(cardss[i].substring(0, 1),
            cardss[i].substring(1, 2));
            cards.push(card);
        }
        System.out.println(cards.size());
    }
}
