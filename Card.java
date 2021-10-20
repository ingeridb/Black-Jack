/**
 * Card --- A card with a suite and a value.
 * @author    Ingerid Bergesen
 */
public class Card{
    public String suite;
    public char value;


    /**
    * Initialize the card. Set the suite and the values of the card.
    * @param String suite, char value
    * @return No return value.
    */
    public Card(String suite, char value){
        this.suite = suite;
        this.value = value;
    }

    public String getSuite(){
        return suite;
    }

    public char getValue(){
        return value;
    }

    @Override
    public String toString(){
        return suite + Character.toString(value);
    }
}
