import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

/**
 * BlackJack --- program to play Black Jack with two players
 * @author    Ingerid Bergesen
 */

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

   /**
   * Play BlackJack with two players
   * @param No parameters
   * @return No return value.
   */
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


    /**
    * Starts the first round of the game. Each player draw two cards,
    * and check for possible winners
    * @param two Players; dealer and player, and a Deck.
    * @return boolean: true if there is a winner.
    */
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

    /**
    * Conutines the game for the player. The player draw new card(s)
    * based on the rules.
    * @param Two Players; dealer and player, and a Deck.
    * @return boolean: true if there is a winner.
    */
    private boolean playerContinue(Player player, Player dealer, Deck deck){
        while(!player.higherThan17 && !player.lostGame){
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

    /**
    * Conutines the game for the dealer. The dealer draw new cards
    * based on the rules. Determines the winner.
    * @param Two Players; dealer and player, and a Deck.
    * @return No return value
    */
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

    /**
    * Print out winner-output in terminal
    * @param Three Players; dealer, player and  the winner
    * (either the dealer or the player).
    * @return No return value
    */
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
