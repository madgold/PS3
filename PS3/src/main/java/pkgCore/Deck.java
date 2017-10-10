package pkgCore;
import java.util.ArrayList;
import java.util.Collections;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck
{

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {
		if (this.cardsInDeck.size() == 0) {
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);
	}
		
	public Card DrawSuit(eSuit eSuit) {
		for (Card c: this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c); 
				return c;
			}
		}
		return null;
	}
	
	public Card DrawRank(eRank eRank) {
		for (Card c: this.cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c); 
				return c;
			}
		}
		return null;
	}
	
	public int CountSuit(eSuit eSuit) {
		int iCardNumber = 0;
		for (Card c: this.cardsInDeck) {
			if (c.geteSuit() == eSuit)
				iCardNumber++;
		}
		return iCardNumber;	
	}
		
	public int CountRank(eRank eRank) {
		int iCardNumber = 0;
		for (Card c: this.cardsInDeck) {
			if (c.geteRank() == eRank)
				iCardNumber++;
		}
		return iCardNumber;	
	}

	public int CountCount(Card c) {
		for (Card cards: cardsInDeck) {
			if (cards == c)
				return 1; 
		}
		return 0;
	}

}