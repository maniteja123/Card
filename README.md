# Card
Object oriented design for card

##Class design
*int Value
*int Suit

##Poker
A K Q J 10 9 8 7 6 5 4 3 2
. Set of 5 cards
. Royal Flush ( 10, J, Q, K, A) Same suit
. Straight flush ( A sequence of same suit)
* Four of a kind
* Full House (3 same, 2 same)
* Flush (Same suit)
* Straight (sequence of different suits)
* Three of a kind
* Two pairs
* Pairs
* High card ( when all players have none of above, the one with the highest card wins)

##Rummy
* Melds - Can be sets or runs
* Sets - Same valued cards, can be of different suits, minimum 3 cards
* Run consists of at least three consecutive cards of the same suit
* Must Contain 2 sequences - Both natural or one natural sequence and one with wild card

##Hearts
* Q of spades -13pts
* Every heart - 1pt
* If a player has all these cards - everyone else gets 26 pts
* Else the player picks up all the pts.
