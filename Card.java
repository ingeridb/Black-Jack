public class Card{
    public String suite;
    public char value;

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
