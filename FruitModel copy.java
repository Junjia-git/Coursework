
public class FruitModel {
	private final static String[] CARD_STRS = new String[] { "Ace", "King", "Queen", "Jack", "Joker" };
	private static final int DEFAULT_MONEY = 100;

	private int balance;
	private int card1;
	private int card2;
	private int card3;

	/**
	 * @param balance
	 */
	public FruitModel() {
		reset();
	}

	public void reset() {
		setBalance(DEFAULT_MONEY);
		setCard1(1);
		setCard2(2);
		setCard3(3);
	}

	public String checkCards() {
		// If at least one joker
		int countOfJoker = 0;
		if (card1 == 4) {
			++countOfJoker;
		}
		if (card2 == 4) {
			++countOfJoker;
		}
		if (card3 == 4) {
			++countOfJoker;
		}
		if (countOfJoker > 0) {
			int deduct = countOfJoker * 25;
			balance -= deduct;
			return String.format("%d joker(s): you lose %d points", countOfJoker, deduct);
		} else {
			// If all three cards are the same
			if (card1 == card2 && card1 == card3) {
				balance += 50;
				return "Three of a kind - you win 50 points";
			}
			// If two of the cards are the same
			if (card1 == card2 || card1 == card3 || card2 == card3) {
				balance += 20;
				return "Two of a kind - you win 20 points";
			}
		}

		return "All three cards are different";
	}

	// These entails setting each of the cards randomly to any card from the
	// available set: ¡°Ace¡±, ¡°King¡±, ¡°Queen¡±, ¡°Jack¡± or ¡°Joker¡± (each of the four
	// outcomes is equally likely
	public void randCards() {
		card1 = Utils.randBetween(0, 4);
		card2 = Utils.randBetween(0, 4);
		card3 = Utils.randBetween(0, 4);
	}

	public String getCard1Str() {
		return CARD_STRS[card1];
	}

	public String getCard2Str() {
		return CARD_STRS[card2];
	}

	public String getCard3Str() {
		return CARD_STRS[card3];
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return the card1
	 */
	public int getCard1() {
		return card1;
	}

	/**
	 * @param card1
	 *            the card1 to set
	 */
	public void setCard1(int card1) {
		this.card1 = card1;
	}

	/**
	 * @return the card2
	 */
	public int getCard2() {
		return card2;
	}

	/**
	 * @param card2
	 *            the card2 to set
	 */
	public void setCard2(int card2) {
		this.card2 = card2;
	}

	/**
	 * @return the card3
	 */
	public int getCard3() {
		return card3;
	}

	/**
	 * @param card3
	 *            the card3 to set
	 */
	public void setCard3(int card3) {
		this.card3 = card3;
	}

}
