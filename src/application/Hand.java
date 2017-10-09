package application;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<BlackJackCard> cards = new ArrayList<BlackJackCard>();
	public boolean stands, fiveCardCharlie = false;

	public Hand() {
		stands = false;
	}

	/**
	 * @return the fiveCardCharlie
	 */
	public boolean isFiveCardCharlie() {
		return this.fiveCardCharlie;
	}

	/**
	 * @return the cards
	 */
	public List<BlackJackCard> getCards() {
		return cards;
	}

	public void reset() {
		cards.clear();
	}

	/**
	 * @param cards
	 *            the cards to set
	 */
	public void setCards(List<BlackJackCard> cards) {
		this.cards = cards;
	}

	public void addCard(BlackJackCard card) {
		this.cards.add(card);
		if (this.cards.size() >= 5 && this.getTotalValue() < 21) {
			this.fiveCardCharlie = true;
		} else {
			this.fiveCardCharlie = false;
		}
	}

	public boolean hasBlackJack() {
		if (getTotalValue() == 21)
			return true;
		else
			return false;
	}

	public int getTotalValue() {
		int total = 0;
		boolean hasAce = false;
		int aces = 0;
		for (BlackJackCard card : this.cards) {
			if (card.getFace() == 1) {
				hasAce = true;
				aces++;
			}
			total += card.getValue();
		}
		if (hasAce) {
			for (int x = 0; x < aces; x++) {
				if (total > 21) {
					total = total - 10;
				}
			}
		}
		return total;
	}

}
