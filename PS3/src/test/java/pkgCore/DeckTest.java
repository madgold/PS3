package pkgCore;
import static org.junit.Assert.*;
import org.junit.Test;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class DeckTest {
	@Test (expected = DeckException.class) 
	public void TestEmptyDeck() throws DeckException {
		Deck NewDeck = new Deck();
		for (int z = 1; z <= 100; z++) 
			NewDeck.Draw();
	}
	
	@Test
	public void TestDrawSuit() {
		Deck NewDeck = new Deck();
		Card NewCard = NewDeck.DrawSuit(eSuit.DIAMONDS);

		assertTrue(NewCard.geteSuit() == eSuit.DIAMONDS);
		assertTrue(NewCard.geteSuit() != eSuit.CLUBS);
		assertFalse(NewCard.geteSuit() == eSuit.CLUBS);

		assertTrue(NewCard.geteSuit() == null);
		assertNull(NewDeck.DrawSuit(eSuit.DIAMONDS));
	}
	
	@Test
	public void TestDrawRank() {
		Deck NewDeck = new Deck();
		Card NewCard = NewDeck.DrawRank(eRank.FOUR);
		assertTrue(NewCard.geteRank() == eRank.FOUR);
		assertFalse(NewCard.geteRank() == eRank.FIVE);
		
		assertTrue(NewCard.geteRank() == null);
		assertNull(NewDeck.DrawRank(eRank.FOUR));
	}
	
	@Test
	public void TestDeckRankCount() {
		Deck NewDeck = new Deck();
		assertEquals(NewDeck.CountRank(eRank.SIX), 4);
	}
	
	@Test
	public void TestDeckSuitCount() {
		Deck NewDeck = new Deck();
		assertEquals(NewDeck.CountSuit(eSuit.SPADES), 13);
	}
	
	@Test
	public void TestCardCount() {
		Deck NewDeck = new Deck();
		Card NewSuit = NewDeck.DrawSuit(eSuit.DIAMONDS);
		Card NewRank = NewDeck.DrawRank(eRank.FIVE);
		assertTrue(NewSuit.geteSuit() == eSuit.DIAMONDS);
		assertTrue(NewRank.geteRank() == eRank.FIVE);
	}

}