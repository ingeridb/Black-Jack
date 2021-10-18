public class Card{
    String suite;
    int value;

    public Card(String suite, String value){
        this.suite = suite;
        this.value = value;
    }

    public String getSuite(){
        return suite;
    }

    public int getValue(){
        return value;
    }
}
