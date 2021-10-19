import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class BlackJack{

    public Player winner;
    public Deck deck;
    public Player player;
    public Player dealer;

    public BlackJack(Deck deck, Player player, Player dealer){
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    public void playBlackJack(){
        if(firstRound(player, dealer, deck)){
            printWinner(winner, player, dealer);
        }else{
            if (playerContinue(player, dealer, deck)){
                printWinner(winner, player, dealer);
            } else{
                dealerContinue(player, dealer, deck);
                printWinner(winner, player, dealer);
            }
        }
    }

    private boolean firstRound(Player player, Player dealer, Deck deck){
        for (int i = 0; i < 2; i++){
            player.drawCard(deck);
            dealer.drawCard(deck);
        }
        if (player.blackJack && dealer.blackJack){
            winner = player;
            return true;
        } else if(player.lostGame && dealer.lostGame){
            winner = dealer;
            return true;
        } else{
            return false;
        }
    }

    private boolean playerContinue(Player player, Player dealer, Deck deck){
        while(!player.higherThan17 && !player.lostGame){
            System.out.println("player trekker nytt kort");
            player.drawCard(deck);
        }
        if (player.blackJack){
            winner = player;
            return true;
        } else if(player.lostGame){
            winner = dealer;
            return true;
        }
        return false;
    }

    private void dealerContinue(Player player, Player dealer, Deck deck){
        while(dealer.handValue <= player.handValue && !dealer.lostGame){
            System.out.println("dealer trekker nytt kort");
            dealer.drawCard(deck);
        }
        if (dealer.lostGame){
            winner = player;
        } else if(dealer.blackJack){
            winner = dealer;
        } else{
            if (dealer.handValue > player.handValue){
                winner = dealer;
            } else if(player.handValue > dealer.handValue){
                winner = player;
            }else{
                winner = player;
            }
        }
    }

    private void printWinner(Player winner, Player player, Player dealer){
        System.out.println(winner.name);
        System.out.print(player.name + ": ");
        System.out.print(player.hand.get(0));
        for (int i = 1; i < player.hand.size(); i++){
            System.out.print(", " + player.hand.get(i));
        }
        System.out.print("\n" + dealer.name + ": " + dealer.hand.get(0));
        for (int i = 1; i < dealer.hand.size(); i++){
            System.out.print(", " + dealer.hand.get(i));
        }
        System.out.println("\n");
    }
}
