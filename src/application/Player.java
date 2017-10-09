/**
 * @author Steve McIntosh
 * @version v.01, 07-10-2017
 * 
 */
package application;

/**
 * @author mcintosh47303
 *
 */
public class Player extends Hand {
	private boolean wins;
	private String result;
	private int winsRecord;
	private int lossRecord;

	public Player() {
		super();
	}
	
	/**
	 * @return the wins
	 */
	public boolean isWins() {
		return wins;
	}

	/**
	 * @param wins
	 *            the wins to set
	 */
	public void setWins(boolean wins, String result) {
		this.wins = wins;
		this.result = result;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return this.result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the winsRecord
	 */
	public int getWinRecord() {
		return winsRecord;
	}

	/**
	 * @param winsRecord
	 *            the winsRecord to set
	 */
	public void wins() {
		this.winsRecord++;
	}

	/**
	 * @return the lossRecord
	 */
	public int getLossRecord() {
		return lossRecord;
	}

	/**
	 * @param lossRecord
	 *            the lossRecord to set
	 */
	public void loses() {
		this.lossRecord++;
	}

}
