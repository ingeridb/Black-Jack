# Can you beat the dealer at 21?

### Prerequisites

No prerequisites other than to have Java installed (My version: Java SE 16.0.2).

### Functionality

Play Black Jack with two players; one player (i.e. sam) and one dealer.

You can either specify a deck by providing a text file as a command line argument or you can get a new shuffled deck by not providing any arguments. 
The text file should be in this format: _D3, H4, CQ, ... , H9_

Please check out the file _teknisk test.pdf_ for more details regarding the rules of Black Jack. 

At the end it will print out the winner and the hand of cards for both players. 

### Usage


To run the program without file:
```
java Main 
```

To run the program with a specified file:

```
java Main filename
```

To run the tests

```
java GameTester
```
