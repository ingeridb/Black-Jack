import java.util.Stack;
import java.util.List;
import java.util.Collections;

public class Deck{

    public Stack<Card> cards = new Stack<Card>();
    public Deck(List<String> cardList){
        setDeck(cardList);
    }

    public void setDeck(List<String> cardList){

        Collections.reverse(cardList); //Reverse the list to get the right order

        for (int i = 0; i < cardList.size(); i++){
            char value;

            //To check for e.g. D10 to make sure it gets the whole number:
            if(cardList.get(i).length() == 3){
                value = cardList.get(i).substring(1, 3).charAt(0);
            }else{
                value = cardList.get(i).substring(1, 2).charAt(0);
            }

            Card card = new Card(cardList.get(i).substring(0, 1), value);
            cards.push(card);
        }
    }

}
