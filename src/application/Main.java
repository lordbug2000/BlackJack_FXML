package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;

public class Main extends Application {
	public static boolean headers = false;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("BlackJack_Table.fxml"));
			Scene scene = new Scene(root, 510, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Deck deck = new Deck();
	public static Player player = new Player();
	public static Hand dealer = new Hand();
	public Image heart = new Image("file://heart.png");
	public Image diamond = new Image("file://diamond.png");
	public Image spade = new Image("file://spade.png");
	public Image club = new Image("file://club.png");
	public static int game = 0, rounds = 0;

	public static void main(String[] args) throws IOException {
		PrintStream out = new PrintStream(new FileOutputStream("log.csv", true));
		out.println(
				"\"Date\",\"Game Number\",\"Player Hand\",\"Player Final Score\", \"Dealer Hands\",\"Dealer Final Score\",\"Final Result\",\"Session W:L Record\"");
		out.close();
		launch(args);
	}

	@FXML
	private Button hit, stand, fold, quit, play, PopQuit, PopPlay;

	@FXML
	private TextField DealerScore, PlayerScore;

	@FXML
	private TextField Player_1, Player_2, Player_3, Player_4, Player_5, Player_6, Dealer_1, Dealer_2, Dealer_3,
			Dealer_4, Dealer_5, Dealer_6, PopUp_Window;

	@FXML
	private ImageView Player_1_H, Player_1_D, Player_1_S, Player_1_C, Player_1_H2, Player_1_D2, Player_1_S2,
			Player_1_C2, Player_2_H, Player_2_D, Player_2_S, Player_2_C, Player_2_H2, Player_2_D2, Player_2_S2,
			Player_2_C2, Player_3_H, Player_3_D, Player_3_S, Player_3_C, Player_3_H2, Player_3_D2, Player_3_S2,
			Player_3_C2, Player_4_H, Player_4_D, Player_4_S, Player_4_C, Player_4_H2, Player_4_D2, Player_4_S2,
			Player_4_C2, Player_5_H, Player_5_D, Player_5_S, Player_5_C, Player_5_H2, Player_5_D2, Player_5_S2,
			Player_5_C2, Dealer_1_H, Dealer_1_D, Dealer_1_S, Dealer_1_C, Dealer_1_H2, Dealer_1_D2, Dealer_1_S2,
			Dealer_1_C2, Dealer_2_H, Dealer_2_D, Dealer_2_S, Dealer_2_C, Dealer_2_H2, Dealer_2_D2, Dealer_2_S2,
			Dealer_2_C2, Dealer_3_H, Dealer_3_D, Dealer_3_S, Dealer_3_C, Dealer_3_H2, Dealer_3_D2, Dealer_3_S2,
			Dealer_3_C2, Dealer_4_H, Dealer_4_D, Dealer_4_S, Dealer_4_C, Dealer_4_H2, Dealer_4_D2, Dealer_4_S2,
			Dealer_4_C2, Dealer_5_H, Dealer_5_D, Dealer_5_S, Dealer_5_C, Dealer_5_H2, Dealer_5_D2, Dealer_5_S2,
			Dealer_5_C2;

	@FXML
	public void showHands() throws FileNotFoundException {
		PlayerScore.setText("" + player.getTotalValue());
		DealerScore.setText("" + dealer.getTotalValue());
		List<BlackJackCard> pCards = player.getCards();
		List<BlackJackCard> dCards = dealer.getCards();
		int size;
		String suit;
		if (pCards.size() > dCards.size()) // if player has more cards
			size = pCards.size();
		else // if dealer has more cards
			size = dCards.size();
		for (int i = 0; i < size; i++) {
			try { // tries to show player's next card
				int face = pCards.get(i).getFace();
				String faceValue = null;
				if (face > 1 & face < 11) {
					faceValue = "" + face;
				} else {
					switch (face) {
					case 1:
						faceValue = "A";
						break;
					case 11:
						faceValue = "J";
						break;
					case 12:
						faceValue = "Q";
						break;
					case 13:
						faceValue = "K";
						break;
					}
				}
				switch (i) {
				case 0:
					Player_1.setText(faceValue);
					suit = pCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Player_1.setStyle("-fx-text-inner-color: red;");
						Player_1_H.setManaged(true);
						Player_1_H.setVisible(true);
						Player_1_C.setManaged(false);
						Player_1_C.setVisible(false);
						Player_1_S.setManaged(false);
						Player_1_S.setVisible(false);
						Player_1_D.setManaged(false);
						Player_1_D.setVisible(false);
						Player_1_H2.setManaged(true);
						Player_1_H2.setVisible(true);
						Player_1_C2.setManaged(false);
						Player_1_C2.setVisible(false);
						Player_1_S2.setManaged(false);
						Player_1_S2.setVisible(false);
						Player_1_D2.setManaged(false);
						Player_1_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Player_1.setStyle("-fx-text-inner-color: red;");
						Player_1_D.setManaged(true);
						Player_1_D.setVisible(true);
						Player_1_C.setManaged(false);
						Player_1_C.setVisible(false);
						Player_1_S.setManaged(false);
						Player_1_S.setVisible(false);
						Player_1_H.setManaged(false);
						Player_1_H.setVisible(false);
						Player_1_D2.setManaged(true);
						Player_1_D2.setVisible(true);
						Player_1_C2.setManaged(false);
						Player_1_C2.setVisible(false);
						Player_1_S2.setManaged(false);
						Player_1_S2.setVisible(false);
						Player_1_H2.setManaged(false);
						Player_1_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Player_1.setStyle("-fx-text-inner-color: black;");
						Player_1_S.setManaged(true);
						Player_1_S.setVisible(true);
						Player_1_C.setManaged(false);
						Player_1_C.setVisible(false);
						Player_1_H.setManaged(false);
						Player_1_H.setVisible(false);
						Player_1_D.setManaged(false);
						Player_1_D.setVisible(false);
						Player_1_S2.setManaged(true);
						Player_1_S2.setVisible(true);
						Player_1_C2.setManaged(false);
						Player_1_C2.setVisible(false);
						Player_1_D2.setManaged(false);
						Player_1_D2.setVisible(false);
						Player_1_H2.setManaged(false);
						Player_1_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Player_1.setStyle("-fx-text-inner-color: black;");
						Player_1_C.setManaged(true);
						Player_1_C.setVisible(true);
						Player_1_H.setManaged(false);
						Player_1_H.setVisible(false);
						Player_1_S.setManaged(false);
						Player_1_S.setVisible(false);
						Player_1_D.setManaged(false);
						Player_1_D.setVisible(false);
						Player_1_C2.setManaged(true);
						Player_1_C2.setVisible(true);
						Player_1_D2.setManaged(false);
						Player_1_D2.setVisible(false);
						Player_1_S2.setManaged(false);
						Player_1_S2.setVisible(false);
						Player_1_H2.setManaged(false);
						Player_1_H2.setVisible(false);
					}
					break;
				case 1:
					Player_2.setText(faceValue);
					suit = pCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Player_2.setStyle("-fx-text-inner-color: red;");
						Player_2_H.setManaged(true);
						Player_2_H.setVisible(true);
						Player_2_C.setManaged(false);
						Player_2_C.setVisible(false);
						Player_2_S.setManaged(false);
						Player_2_S.setVisible(false);
						Player_2_D.setManaged(false);
						Player_2_D.setVisible(false);
						Player_2_H2.setManaged(true);
						Player_2_H2.setVisible(true);
						Player_2_C2.setManaged(false);
						Player_2_C2.setVisible(false);
						Player_2_S2.setManaged(false);
						Player_2_S2.setVisible(false);
						Player_2_D2.setManaged(false);
						Player_2_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Player_2.setStyle("-fx-text-inner-color: red;");
						Player_2_D.setManaged(true);
						Player_2_D.setVisible(true);
						Player_2_C.setManaged(false);
						Player_2_C.setVisible(false);
						Player_2_S.setManaged(false);
						Player_2_S.setVisible(false);
						Player_2_H.setManaged(false);
						Player_2_H.setVisible(false);
						Player_2_D2.setManaged(true);
						Player_2_D2.setVisible(true);
						Player_2_C2.setManaged(false);
						Player_2_C2.setVisible(false);
						Player_2_S2.setManaged(false);
						Player_2_S2.setVisible(false);
						Player_2_H2.setManaged(false);
						Player_2_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Player_2.setStyle("-fx-text-inner-color: black;");
						Player_2_S.setManaged(true);
						Player_2_S.setVisible(true);
						Player_2_C.setManaged(false);
						Player_2_C.setVisible(false);
						Player_2_H.setManaged(false);
						Player_2_H.setVisible(false);
						Player_2_D.setManaged(false);
						Player_2_D.setVisible(false);
						Player_2_S2.setManaged(true);
						Player_2_S2.setVisible(true);
						Player_2_C2.setManaged(false);
						Player_2_C2.setVisible(false);
						Player_2_D2.setManaged(false);
						Player_2_D2.setVisible(false);
						Player_2_H2.setManaged(false);
						Player_2_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Player_2.setStyle("-fx-text-inner-color: black;");
						Player_2_C.setManaged(true);
						Player_2_C.setVisible(true);
						Player_2_H.setManaged(false);
						Player_2_H.setVisible(false);
						Player_2_S.setManaged(false);
						Player_2_S.setVisible(false);
						Player_2_D.setManaged(false);
						Player_2_D.setVisible(false);
						Player_2_C2.setManaged(true);
						Player_2_C2.setVisible(true);
						Player_2_D2.setManaged(false);
						Player_2_D2.setVisible(false);
						Player_2_S2.setManaged(false);
						Player_2_S2.setVisible(false);
						Player_2_H2.setManaged(false);
						Player_2_H2.setVisible(false);
					}
					break;
				case 2:
					Player_3.setText(faceValue);
					suit = pCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Player_3.setStyle("-fx-text-inner-color: red;");
						Player_3_H.setManaged(true);
						Player_3_H.setVisible(true);
						Player_3_C.setManaged(false);
						Player_3_C.setVisible(false);
						Player_3_S.setManaged(false);
						Player_3_S.setVisible(false);
						Player_3_D.setManaged(false);
						Player_3_D.setVisible(false);
						Player_3_H2.setManaged(true);
						Player_3_H2.setVisible(true);
						Player_3_C2.setManaged(false);
						Player_3_C2.setVisible(false);
						Player_3_S2.setManaged(false);
						Player_3_S2.setVisible(false);
						Player_3_D2.setManaged(false);
						Player_3_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Player_3.setStyle("-fx-text-inner-color: red;");
						Player_3_D.setManaged(true);
						Player_3_D.setVisible(true);
						Player_3_C.setManaged(false);
						Player_3_C.setVisible(false);
						Player_3_S.setManaged(false);
						Player_3_S.setVisible(false);
						Player_3_H.setManaged(false);
						Player_3_H.setVisible(false);
						Player_3_D2.setManaged(true);
						Player_3_D2.setVisible(true);
						Player_3_C2.setManaged(false);
						Player_3_C2.setVisible(false);
						Player_3_S2.setManaged(false);
						Player_3_S2.setVisible(false);
						Player_3_H2.setManaged(false);
						Player_3_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Player_3.setStyle("-fx-text-inner-color: black;");
						Player_3_S.setManaged(true);
						Player_3_S.setVisible(true);
						Player_3_C.setManaged(false);
						Player_3_C.setVisible(false);
						Player_3_H.setManaged(false);
						Player_3_H.setVisible(false);
						Player_3_D.setManaged(false);
						Player_3_D.setVisible(false);
						Player_3_S2.setManaged(true);
						Player_3_S2.setVisible(true);
						Player_3_C2.setManaged(false);
						Player_3_C2.setVisible(false);
						Player_3_D2.setManaged(false);
						Player_3_D2.setVisible(false);
						Player_3_H2.setManaged(false);
						Player_3_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Player_3.setStyle("-fx-text-inner-color: black;");
						Player_3_C.setManaged(true);
						Player_3_C.setVisible(true);
						Player_3_H.setManaged(false);
						Player_3_H.setVisible(false);
						Player_3_S.setManaged(false);
						Player_3_S.setVisible(false);
						Player_3_D.setManaged(false);
						Player_3_D.setVisible(false);
						Player_3_C2.setManaged(true);
						Player_3_C2.setVisible(true);
						Player_3_D2.setManaged(false);
						Player_3_D2.setVisible(false);
						Player_3_S2.setManaged(false);
						Player_3_S2.setVisible(false);
						Player_3_H2.setManaged(false);
						Player_3_H2.setVisible(false);
					}
					break;
				case 3:
					Player_4.setText(faceValue);
					suit = pCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Player_4.setStyle("-fx-text-inner-color: red;");
						Player_4_H.setManaged(true);
						Player_4_H.setVisible(true);
						Player_4_C.setManaged(false);
						Player_4_C.setVisible(false);
						Player_4_S.setManaged(false);
						Player_4_S.setVisible(false);
						Player_4_D.setManaged(false);
						Player_4_D.setVisible(false);
						Player_4_H2.setManaged(true);
						Player_4_H2.setVisible(true);
						Player_4_C2.setManaged(false);
						Player_4_C2.setVisible(false);
						Player_4_S2.setManaged(false);
						Player_4_S2.setVisible(false);
						Player_4_D2.setManaged(false);
						Player_4_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Player_4.setStyle("-fx-text-inner-color: red;");
						Player_4_D.setManaged(true);
						Player_4_D.setVisible(true);
						Player_4_C.setManaged(false);
						Player_4_C.setVisible(false);
						Player_4_S.setManaged(false);
						Player_4_S.setVisible(false);
						Player_4_H.setManaged(false);
						Player_4_H.setVisible(false);
						Player_4_D2.setManaged(true);
						Player_4_D2.setVisible(true);
						Player_4_C2.setManaged(false);
						Player_4_C2.setVisible(false);
						Player_4_S2.setManaged(false);
						Player_4_S2.setVisible(false);
						Player_4_H2.setManaged(false);
						Player_4_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Player_4.setStyle("-fx-text-inner-color: black;");
						Player_4_S.setManaged(true);
						Player_4_S.setVisible(true);
						Player_4_C.setManaged(false);
						Player_4_C.setVisible(false);
						Player_4_H.setManaged(false);
						Player_4_H.setVisible(false);
						Player_4_D.setManaged(false);
						Player_4_D.setVisible(false);
						Player_4_S2.setManaged(true);
						Player_4_S2.setVisible(true);
						Player_4_C2.setManaged(false);
						Player_4_C2.setVisible(false);
						Player_4_D2.setManaged(false);
						Player_4_D2.setVisible(false);
						Player_4_H2.setManaged(false);
						Player_4_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Player_4.setStyle("-fx-text-inner-color: black;");
						Player_4_C.setManaged(true);
						Player_4_C.setVisible(true);
						Player_4_H.setManaged(false);
						Player_4_H.setVisible(false);
						Player_4_S.setManaged(false);
						Player_4_S.setVisible(false);
						Player_4_D.setManaged(false);
						Player_4_D.setVisible(false);
						Player_4_C2.setManaged(true);
						Player_4_C2.setVisible(true);
						Player_4_D2.setManaged(false);
						Player_4_D2.setVisible(false);
						Player_4_S2.setManaged(false);
						Player_4_S2.setVisible(false);
						Player_4_H2.setManaged(false);
						Player_4_H2.setVisible(false);
					}
					break;
				case 4:
					Player_5.setText(faceValue);
					suit = pCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Player_5.setStyle("-fx-text-inner-color: red;");
						Player_5_H.setManaged(true);
						Player_5_H.setVisible(true);
						Player_5_C.setManaged(false);
						Player_5_C.setVisible(false);
						Player_5_S.setManaged(false);
						Player_5_S.setVisible(false);
						Player_5_D.setManaged(false);
						Player_5_D.setVisible(false);
						Player_5_H2.setManaged(true);
						Player_5_H2.setVisible(true);
						Player_5_C2.setManaged(false);
						Player_5_C2.setVisible(false);
						Player_5_S2.setManaged(false);
						Player_5_S2.setVisible(false);
						Player_5_D2.setManaged(false);
						Player_5_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Player_5.setStyle("-fx-text-inner-color: red;");
						Player_5_D.setManaged(true);
						Player_5_D.setVisible(true);
						Player_5_C.setManaged(false);
						Player_5_C.setVisible(false);
						Player_5_S.setManaged(false);
						Player_5_S.setVisible(false);
						Player_5_H.setManaged(false);
						Player_5_H.setVisible(false);
						Player_5_D2.setManaged(true);
						Player_5_D2.setVisible(true);
						Player_5_C2.setManaged(false);
						Player_5_C2.setVisible(false);
						Player_5_S2.setManaged(false);
						Player_5_S2.setVisible(false);
						Player_5_H2.setManaged(false);
						Player_5_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Player_5.setStyle("-fx-text-inner-color: black;");
						Player_5_S.setManaged(true);
						Player_5_S.setVisible(true);
						Player_5_C.setManaged(false);
						Player_5_C.setVisible(false);
						Player_5_H.setManaged(false);
						Player_5_H.setVisible(false);
						Player_5_D.setManaged(false);
						Player_5_D.setVisible(false);
						Player_5_S2.setManaged(true);
						Player_5_S2.setVisible(true);
						Player_5_C2.setManaged(false);
						Player_5_C2.setVisible(false);
						Player_5_D2.setManaged(false);
						Player_5_D2.setVisible(false);
						Player_5_H2.setManaged(false);
						Player_5_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Player_5.setStyle("-fx-text-inner-color: black;");
						Player_5_C.setManaged(true);
						Player_5_C.setVisible(true);
						Player_5_H.setManaged(false);
						Player_5_H.setVisible(false);
						Player_5_S.setManaged(false);
						Player_5_S.setVisible(false);
						Player_5_D.setManaged(false);
						Player_5_D.setVisible(false);
						Player_5_C2.setManaged(true);
						Player_5_C2.setVisible(true);
						Player_5_D2.setManaged(false);
						Player_5_D2.setVisible(false);
						Player_5_S2.setManaged(false);
						Player_5_S2.setVisible(false);
						Player_5_H2.setManaged(false);
						Player_5_H2.setVisible(false);
					}
					break;
				}
			} catch (IndexOutOfBoundsException e) { // if player has no next
													// card but dealer does
				switch (i) {
				case 0:
					Player_1.setText("");
					break;
				case 1:
					Player_2.setText("");
					break;
				case 2:
					Player_3.setText("");
					break;
				case 3:
					Player_4.setText("");
					break;
				case 4:
					Player_5.setText("");
					break;
				}
			}

			try { // tries to show dealer's next card
				int face = dCards.get(i).getFace();
				String faceValue = null;
				if (face > 1 & face < 11) {
					faceValue = "" + face;
				} else {
					switch (face) {
					case 1:
						faceValue = "A";
						break;
					case 11:
						faceValue = "J";
						break;
					case 12:
						faceValue = "Q";
						break;
					case 13:
						faceValue = "K";
						break;
					}
				}
				switch (i) {
				case 0:
					Dealer_1.setText(faceValue);
					suit = dCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Dealer_1.setStyle("-fx-text-inner-color: red;");
						Dealer_1_H.setManaged(true);
						Dealer_1_H.setVisible(true);
						Dealer_1_C.setManaged(false);
						Dealer_1_C.setVisible(false);
						Dealer_1_S.setManaged(false);
						Dealer_1_S.setVisible(false);
						Dealer_1_D.setManaged(false);
						Dealer_1_D.setVisible(false);
						Dealer_1_H2.setManaged(true);
						Dealer_1_H2.setVisible(true);
						Dealer_1_C2.setManaged(false);
						Dealer_1_C2.setVisible(false);
						Dealer_1_S2.setManaged(false);
						Dealer_1_S2.setVisible(false);
						Dealer_1_D2.setManaged(false);
						Dealer_1_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Dealer_1.setStyle("-fx-text-inner-color: red;");
						Dealer_1_D.setManaged(true);
						Dealer_1_D.setVisible(true);
						Dealer_1_C.setManaged(false);
						Dealer_1_C.setVisible(false);
						Dealer_1_S.setManaged(false);
						Dealer_1_S.setVisible(false);
						Dealer_1_H.setManaged(false);
						Dealer_1_H.setVisible(false);
						Dealer_1_D2.setManaged(true);
						Dealer_1_D2.setVisible(true);
						Dealer_1_C2.setManaged(false);
						Dealer_1_C2.setVisible(false);
						Dealer_1_S2.setManaged(false);
						Dealer_1_S2.setVisible(false);
						Dealer_1_H2.setManaged(false);
						Dealer_1_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Dealer_1.setStyle("-fx-text-inner-color: black;");
						Dealer_1_S.setManaged(true);
						Dealer_1_S.setVisible(true);
						Dealer_1_C.setManaged(false);
						Dealer_1_C.setVisible(false);
						Dealer_1_H.setManaged(false);
						Dealer_1_H.setVisible(false);
						Dealer_1_D.setManaged(false);
						Dealer_1_D.setVisible(false);
						Dealer_1_S2.setManaged(true);
						Dealer_1_S2.setVisible(true);
						Dealer_1_C2.setManaged(false);
						Dealer_1_C2.setVisible(false);
						Dealer_1_D2.setManaged(false);
						Dealer_1_D2.setVisible(false);
						Dealer_1_H2.setManaged(false);
						Dealer_1_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Dealer_1.setStyle("-fx-text-inner-color: black;");
						Dealer_1_C.setManaged(true);
						Dealer_1_C.setVisible(true);
						Dealer_1_H.setManaged(false);
						Dealer_1_H.setVisible(false);
						Dealer_1_S.setManaged(false);
						Dealer_1_S.setVisible(false);
						Dealer_1_D.setManaged(false);
						Dealer_1_D.setVisible(false);
						Dealer_1_C2.setManaged(true);
						Dealer_1_C2.setVisible(true);
						Dealer_1_D2.setManaged(false);
						Dealer_1_D2.setVisible(false);
						Dealer_1_S2.setManaged(false);
						Dealer_1_S2.setVisible(false);
						Dealer_1_H2.setManaged(false);
						Dealer_1_H2.setVisible(false);
					}
					break;
				case 1:
					Dealer_2.setText(faceValue);
					suit = dCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Dealer_2.setStyle("-fx-text-inner-color: red;");
						Dealer_2_H.setManaged(true);
						Dealer_2_H.setVisible(true);
						Dealer_2_C.setManaged(false);
						Dealer_2_C.setVisible(false);
						Dealer_2_S.setManaged(false);
						Dealer_2_S.setVisible(false);
						Dealer_2_D.setManaged(false);
						Dealer_2_D.setVisible(false);
						Dealer_2_H2.setManaged(true);
						Dealer_2_H2.setVisible(true);
						Dealer_2_C2.setManaged(false);
						Dealer_2_C2.setVisible(false);
						Dealer_2_S2.setManaged(false);
						Dealer_2_S2.setVisible(false);
						Dealer_2_D2.setManaged(false);
						Dealer_2_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Dealer_2.setStyle("-fx-text-inner-color: red;");
						Dealer_2_D.setManaged(true);
						Dealer_2_D.setVisible(true);
						Dealer_2_C.setManaged(false);
						Dealer_2_C.setVisible(false);
						Dealer_2_S.setManaged(false);
						Dealer_2_S.setVisible(false);
						Dealer_2_H.setManaged(false);
						Dealer_2_H.setVisible(false);
						Dealer_2_D2.setManaged(true);
						Dealer_2_D2.setVisible(true);
						Dealer_2_C2.setManaged(false);
						Dealer_2_C2.setVisible(false);
						Dealer_2_S2.setManaged(false);
						Dealer_2_S2.setVisible(false);
						Dealer_2_H2.setManaged(false);
						Dealer_2_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Dealer_2.setStyle("-fx-text-inner-color: black;");
						Dealer_2_S.setManaged(true);
						Dealer_2_S.setVisible(true);
						Dealer_2_C.setManaged(false);
						Dealer_2_C.setVisible(false);
						Dealer_2_H.setManaged(false);
						Dealer_2_H.setVisible(false);
						Dealer_2_D.setManaged(false);
						Dealer_2_D.setVisible(false);
						Dealer_2_S2.setManaged(true);
						Dealer_2_S2.setVisible(true);
						Dealer_2_C2.setManaged(false);
						Dealer_2_C2.setVisible(false);
						Dealer_2_D2.setManaged(false);
						Dealer_2_D2.setVisible(false);
						Dealer_2_H2.setManaged(false);
						Dealer_2_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Dealer_2.setStyle("-fx-text-inner-color: black;");
						Dealer_2_C.setManaged(true);
						Dealer_2_C.setVisible(true);
						Dealer_2_H.setManaged(false);
						Dealer_2_H.setVisible(false);
						Dealer_2_S.setManaged(false);
						Dealer_2_S.setVisible(false);
						Dealer_2_D.setManaged(false);
						Dealer_2_D.setVisible(false);
						Dealer_2_C2.setManaged(true);
						Dealer_2_C2.setVisible(true);
						Dealer_2_D2.setManaged(false);
						Dealer_2_D2.setVisible(false);
						Dealer_2_S2.setManaged(false);
						Dealer_2_S2.setVisible(false);
						Dealer_2_H2.setManaged(false);
						Dealer_2_H2.setVisible(false);
					}
					break;
				case 2:
					Dealer_3.setText(faceValue);
					suit = dCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Dealer_3.setStyle("-fx-text-inner-color: red;");
						Dealer_3_H.setManaged(true);
						Dealer_3_H.setVisible(true);
						Dealer_3_C.setManaged(false);
						Dealer_3_C.setVisible(false);
						Dealer_3_S.setManaged(false);
						Dealer_3_S.setVisible(false);
						Dealer_3_D.setManaged(false);
						Dealer_3_D.setVisible(false);
						Dealer_3_H2.setManaged(true);
						Dealer_3_H2.setVisible(true);
						Dealer_3_C2.setManaged(false);
						Dealer_3_C2.setVisible(false);
						Dealer_3_S2.setManaged(false);
						Dealer_3_S2.setVisible(false);
						Dealer_3_D2.setManaged(false);
						Dealer_3_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Dealer_3.setStyle("-fx-text-inner-color: red;");
						Dealer_3_D.setManaged(true);
						Dealer_3_D.setVisible(true);
						Dealer_3_C.setManaged(false);
						Dealer_3_C.setVisible(false);
						Dealer_3_S.setManaged(false);
						Dealer_3_S.setVisible(false);
						Dealer_3_H.setManaged(false);
						Dealer_3_H.setVisible(false);
						Dealer_3_D2.setManaged(true);
						Dealer_3_D2.setVisible(true);
						Dealer_3_C2.setManaged(false);
						Dealer_3_C2.setVisible(false);
						Dealer_3_S2.setManaged(false);
						Dealer_3_S2.setVisible(false);
						Dealer_3_H2.setManaged(false);
						Dealer_3_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Dealer_3.setStyle("-fx-text-inner-color: black;");
						Dealer_3_S.setManaged(true);
						Dealer_3_S.setVisible(true);
						Dealer_3_C.setManaged(false);
						Dealer_3_C.setVisible(false);
						Dealer_3_H.setManaged(false);
						Dealer_3_H.setVisible(false);
						Dealer_3_D.setManaged(false);
						Dealer_3_D.setVisible(false);
						Dealer_3_S2.setManaged(true);
						Dealer_3_S2.setVisible(true);
						Dealer_3_C2.setManaged(false);
						Dealer_3_C2.setVisible(false);
						Dealer_3_D2.setManaged(false);
						Dealer_3_D2.setVisible(false);
						Dealer_3_H2.setManaged(false);
						Dealer_3_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Dealer_3.setStyle("-fx-text-inner-color: black;");
						Dealer_3_C.setManaged(true);
						Dealer_3_C.setVisible(true);
						Dealer_3_H.setManaged(false);
						Dealer_3_H.setVisible(false);
						Dealer_3_S.setManaged(false);
						Dealer_3_S.setVisible(false);
						Dealer_3_D.setManaged(false);
						Dealer_3_D.setVisible(false);
						Dealer_3_C2.setManaged(true);
						Dealer_3_C2.setVisible(true);
						Dealer_3_D2.setManaged(false);
						Dealer_3_D2.setVisible(false);
						Dealer_3_S2.setManaged(false);
						Dealer_3_S2.setVisible(false);
						Dealer_3_H2.setManaged(false);
						Dealer_3_H2.setVisible(false);
					}
					break;
				case 3:
					Dealer_4.setText(faceValue);
					suit = dCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Dealer_4.setStyle("-fx-text-inner-color: red;");
						Dealer_4_H.setManaged(true);
						Dealer_4_H.setVisible(true);
						Dealer_4_C.setManaged(false);
						Dealer_4_C.setVisible(false);
						Dealer_4_S.setManaged(false);
						Dealer_4_S.setVisible(false);
						Dealer_4_D.setManaged(false);
						Dealer_4_D.setVisible(false);
						Dealer_4_H2.setManaged(true);
						Dealer_4_H2.setVisible(true);
						Dealer_4_C2.setManaged(false);
						Dealer_4_C2.setVisible(false);
						Dealer_4_S2.setManaged(false);
						Dealer_4_S2.setVisible(false);
						Dealer_4_D2.setManaged(false);
						Dealer_4_D2.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Dealer_4.setStyle("-fx-text-inner-color: red;");
						Dealer_4_D.setManaged(true);
						Dealer_4_D.setVisible(true);
						Dealer_4_C.setManaged(false);
						Dealer_4_C.setVisible(false);
						Dealer_4_S.setManaged(false);
						Dealer_4_S.setVisible(false);
						Dealer_4_H.setManaged(false);
						Dealer_4_H.setVisible(false);
						Dealer_4_D2.setManaged(true);
						Dealer_4_D2.setVisible(true);
						Dealer_4_C2.setManaged(false);
						Dealer_4_C2.setVisible(false);
						Dealer_4_S2.setManaged(false);
						Dealer_4_S2.setVisible(false);
						Dealer_4_H2.setManaged(false);
						Dealer_4_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Dealer_4.setStyle("-fx-text-inner-color: black;");
						Dealer_4_S.setManaged(true);
						Dealer_4_S.setVisible(true);
						Dealer_4_C.setManaged(false);
						Dealer_4_C.setVisible(false);
						Dealer_4_H.setManaged(false);
						Dealer_4_H.setVisible(false);
						Dealer_4_D.setManaged(false);
						Dealer_4_D.setVisible(false);
						Dealer_4_S2.setManaged(true);
						Dealer_4_S2.setVisible(true);
						Dealer_4_C2.setManaged(false);
						Dealer_4_C2.setVisible(false);
						Dealer_4_D2.setManaged(false);
						Dealer_4_D2.setVisible(false);
						Dealer_4_H2.setManaged(false);
						Dealer_4_H2.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Dealer_4.setStyle("-fx-text-inner-color: black;");
						Dealer_4_C.setManaged(true);
						Dealer_4_C.setVisible(true);
						Dealer_4_H.setManaged(false);
						Dealer_4_H.setVisible(false);
						Dealer_4_S.setManaged(false);
						Dealer_4_S.setVisible(false);
						Dealer_4_D.setManaged(false);
						Dealer_4_D.setVisible(false);
						Dealer_4_C2.setManaged(true);
						Dealer_4_C2.setVisible(true);
						Dealer_4_D2.setManaged(false);
						Dealer_4_D2.setVisible(false);
						Dealer_4_S2.setManaged(false);
						Dealer_4_S2.setVisible(false);
						Dealer_4_H2.setManaged(false);
						Dealer_4_H2.setVisible(false);
					}
					break;
				case 4:
					Dealer_5.setText(faceValue);
					suit = dCards.get(i).getSuit();
					if (suit.toLowerCase().equals("hearts")) {
						// Console.appendText("\nHearts");
						Dealer_5.setStyle("-fx-text-inner-color: red;");
						Dealer_5_H.setManaged(true);
						Dealer_5_H.setVisible(true);
						Dealer_5_C.setManaged(false);
						Dealer_5_C.setVisible(false);
						Dealer_5_S.setManaged(false);
						Dealer_5_S.setVisible(false);
						Dealer_5_D.setManaged(false);
						Dealer_5_D.setVisible(false);
					} else if (suit.toLowerCase().equals("diamonds")) {
						// Console.appendText("\nDiamonds");
						Dealer_5.setStyle("-fx-text-inner-color: red;");
						Dealer_5_D.setManaged(true);
						Dealer_5_D.setVisible(true);
						Dealer_5_C.setManaged(false);
						Dealer_5_C.setVisible(false);
						Dealer_5_S.setManaged(false);
						Dealer_5_S.setVisible(false);
						Dealer_5_H.setManaged(false);
						Dealer_5_H.setVisible(false);
					} else if (suit.toLowerCase().equals("spades")) {
						// Console.appendText("\nSpades");
						Dealer_5.setStyle("-fx-text-inner-color: black;");
						Dealer_5_S.setManaged(true);
						Dealer_5_S.setVisible(true);
						Dealer_5_C.setManaged(false);
						Dealer_5_C.setVisible(false);
						Dealer_5_H.setManaged(false);
						Dealer_5_H.setVisible(false);
						Dealer_5_D.setManaged(false);
						Dealer_5_D.setVisible(false);
					} else if (suit.toLowerCase().equals("clubs")) {
						// Console.appendText("\nClubs");
						Dealer_5.setStyle("-fx-text-inner-color: black;");
						Dealer_5_C.setManaged(true);
						Dealer_5_C.setVisible(true);
						Dealer_5_H.setManaged(false);
						Dealer_5_H.setVisible(false);
						Dealer_5_S.setManaged(false);
						Dealer_5_S.setVisible(false);
						Dealer_5_D.setManaged(false);
						Dealer_5_D.setVisible(false);
					}
					break;
				}
			} catch (IndexOutOfBoundsException e) { // if dealer has no next
													// card but player does
				if (dCards.size() == 1 && dealer.getTotalValue() < 17) // if
																		// it's
																		// first
																		// draw
																		// and
																		// dealer's
					// second card is still hidden
					switch (i) {
					case 0:
						Dealer_1.setText("?");
						break;
					case 1:
						Dealer_2.setText("?");
						break;
					case 2:
						Dealer_3.setText("?");
						break;
					case 3:
						Dealer_4.setText("?");
						break;
					case 4:
						Dealer_5.setText("?");
						break;
					}
				else // if not first draw and all cards can be shown
					switch (i) {
					case 0:
						Dealer_1.setText("");
						break;
					case 1:
						Dealer_2.setText("");
						break;
					case 2:
						Dealer_3.setText("");
						break;
					case 3:
						Dealer_4.setText("");
						break;
					case 4:
						Dealer_5.setText("");
						break;
					}
			}
		}
	}

	@FXML
	protected void onHit(ActionEvent event) throws FileNotFoundException {
		if (player.getTotalValue() >= 21 || dealer.getTotalValue() >= 21) {
			// Console.appendText("\nYou Can't hit again! the game is over!");
		}
		boolean gameOver = false;
		// Console.appendText("\nHit!");
		player.addCard(deck.getCard());
		deck.removeCard();
		if (rounds != 0) {
			gameOver = dealerTurn();
		} else {
			if (dealer.hasBlackJack()) { // 21 == Dealer Win
				player.setWins(false, "Dealer 21!");
				gameOver = true;
			} else if (player.hasBlackJack()) { // 21 == Player Win
				player.setWins(true, "Player 21!");
				gameOver = true;
			} else if (player.isFiveCardCharlie()) { // Five Card Charlie ==
														// Player
														// Win
				player.setWins(true, "5 Card Charlie!");
				gameOver = true;
			} else if (player.getTotalValue() > 21) { // Player Bust == Dealer
														// Win
				player.setWins(false, "Player Bust!");
				gameOver = true;
			} else if (dealer.getTotalValue() > 21) { // Dealer Bust == Player
														// Win
				player.setWins(true, "Dealer Bust!");
				gameOver = true;
			}
		}
		rounds++;
		showHands();

		if (gameOver) {
			game++;
			if (player.isWins()) {
				PopPlay.setManaged(true);
				PopPlay.setVisible(true);
				PopQuit.setManaged(true);
				PopQuit.setVisible(true);
				PopUp_Window.setText(player.getResult());
				PopUp_Window.setManaged(false);
				PopUp_Window.setVisible(true);
				player.wins();
			} else {
				PopPlay.setManaged(true);
				PopPlay.setVisible(true);
				PopQuit.setManaged(true);
				PopQuit.setVisible(true);
				PopUp_Window.setText(player.getResult());
				PopUp_Window.setManaged(false);
				PopUp_Window.setVisible(true);
				player.loses();
			}
			hit.setDisable(true);
			stand.setDisable(true);
			fold.setDisable(true);
			play.setDisable(false);
		}

		/*
		 * if (player.isFiveCardCharlie() || gameOver || player.getTotalValue()
		 * >= 21 || dealer.getTotalValue() >= 21) { if
		 * (player.isFiveCardCharlie()) { PopUp_Window.setManaged(true);
		 * PopUp_Window.setVisible(true); PopPlay.setManaged(true);
		 * PopPlay.setVisible(true); PopQuit.setManaged(true);
		 * PopQuit.setVisible(true); PopUp_Window.setText("5 Card Charlie!");
		 * 
		 * } else if (player.getTotalValue() > 21) {
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("You Bust!"); } else if (player.hasBlackJack())
		 * {
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("21! You Win!"); } hit.setDisable(true);
		 * stand.setDisable(true); fold.setDisable(true);
		 * play.setDisable(false); }
		 */

	}

	@FXML
	public boolean dealerTurn() throws FileNotFoundException {
		boolean gameOver = false;

		// System.out.println(dealer.getTotalValue());
		showHands();
		if (dealer.getTotalValue() < 17) {
			dealer.addCard(deck.getCard());
			deck.removeCard();
			showHands();
		}
		// System.out.println(dealer.getTotalValue());
		if (dealer.getTotalValue() >= 17) {
			showHands();
			dealer.stands = true;
		}
		rounds++;
		showHands();
		/*
		 * if (dealer.getTotalValue() > 21) {
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("Dealer Bust!"); gameOver = true; } else if
		 * (dealer.hasBlackJack() && !player.hasBlackJack()) { // game // ends
		 * // with // dealer // having // blackjack
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("You Lose!"); gameOver = true;
		 * 
		 * } else if (dealer.hasBlackJack() && player.hasBlackJack()) { // game
		 * // ends // in // a // tie // of // blackjack
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("Tie 21!!"); gameOver = true; } } else {
		 * showHands(); }
		 * 
		 * if (!gameOver) { // if the game is not already over after the
		 * dealer's // turn if (player.hasBlackJack()) { // player is exactly 21
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("21! You Win!"); gameOver = true; } else if
		 * (player.getTotalValue() > 21) { // player is above 21
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("You Bust!"); gameOver = true; } else if
		 * (player.stands && dealer.getTotalValue() >= 17) { // if // player //
		 * stands // and // dealer // stands if (player.getTotalValue() >
		 * dealer.getTotalValue()) { // if // player // beats // dealer
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("You Win!"); gameOver = true; } else { // if
		 * dealer beats player
		 * 
		 * PopUp_Window.setManaged(true); PopUp_Window.setVisible(true);
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("You Lose!"); gameOver = true; } } }
		 * player.stands = false; if (dealer.getTotalValue() >= 17 &&
		 * player.getTotalValue() > dealer.getTotalValue()) { // Dealer //
		 * stands PopUp_Window.setManaged(true); // Player higher
		 * PopUp_Window.setVisible(true); // Than dealer
		 * PopPlay.setManaged(true); PopPlay.setVisible(true);
		 * PopQuit.setManaged(true); PopQuit.setVisible(true);
		 * PopUp_Window.setText("You Win!"); gameOver = true; }
		 */
		// System.out.println(player.stands + " - " + dealer.stands);
		if (player.stands || dealer.getTotalValue() >= 21 || player.getTotalValue() >= 21 || player.isFiveCardCharlie()
				|| dealer.isFiveCardCharlie()) {
			if (dealer.hasBlackJack()) { // 21 == Dealer Win
				player.setWins(false, "Dealer 21!");
				gameOver = true;
			} else if (player.hasBlackJack()) { // 21 == Player Win
				player.setWins(true, "Player 21!");
				gameOver = true;
			} else if (player.isFiveCardCharlie()) { // Five Card Charlie ==
														// Player
														// Win
				player.setWins(true, "5 Card Charlie!");
				gameOver = true;
			} else if (dealer.isFiveCardCharlie()) { // Five Card Charlie ==
														// Player
				// Win
				player.setWins(false, "Dealer 5 Card Charlie!");
				gameOver = true;
			} else if (player.getTotalValue() > 21) { // Player Bust == Dealer
														// Win
				player.setWins(false, "Player Bust!");
				gameOver = true;
			} else if (dealer.getTotalValue() > 21) { // Dealer Bust == Player
														// Win
				player.setWins(true, "Dealer Bust!");
				gameOver = true;
			} else if (dealer.getTotalValue() < player.getTotalValue() && player.stands
					&& dealer.getTotalValue() < 17) { // Player
														// stands,
														// dealer
														// lower,
														// not
														// over
														// 17
														// ==
														// dealer
														// draws
														// again
				gameOver = false;
			} else if (player.getTotalValue() == dealer.getTotalValue() && player.stands) { // Tie
																							// ==
				// Push,
				// No
				// win
				// No
				// loss,
				// no
				// Blackjacks
				player.setWins(true, "Tie!");
				gameOver = true;
			} else if (player.stands && dealer.stands) {
				if (player.getTotalValue() > dealer.getTotalValue()) { // Player
					// better
					// than
					// dealer,
					// Dealer
					// over
					// 17
					// ==
					// Player
					// Win
					player.setWins(true, "Player Wins!");
					gameOver = true;
				} else if (dealer.getTotalValue() > player.getTotalValue()) { // Dealer
					// better
					// than
					// player,
					// Player
					// Standing
					// ==
					// Dealer
					// Win
					showHands();
					player.setWins(false, "Dealer Wins!");
					gameOver = true;
				} else if (player.getTotalValue() == dealer.getTotalValue()) {

					player.setWins(true, "Tie 2");
					gameOver = true;
				}
			} else {
				player.setWins(true, "Err:" + dealer.getTotalValue() + "-" + player.getTotalValue());
				System.out.println(player.stands + " - " + dealer.stands);
				gameOver = true;
			}
		}

		/*Date date = new Date();
		PrintStream out = new PrintStream(new FileOutputStream("log.csv", true));
		out.print("\"" + date.toString() + "\",");
		out.print("\"Game #" + game + "\",");
		out.print("\"" + player.getCards() + "\",\"" + player.getTotalValue() + "\",");
		out.print("\"" + dealer.getCards() + "\",\"" + dealer.getTotalValue() + "\",");
		out.print("\"" + player.getResult() + "\",");
		out.print("\"" + player.getWinRecord() + ":" + player.getLossRecord() + "\",");
		out.println();
		out.flush();
		out.close();*/
		return gameOver;
	}

	@FXML
	protected void onStand(ActionEvent event) throws FileNotFoundException {
		player.stands = true;
		boolean gameOver = false;
		gameOver = dealerTurn();
		rounds++;
		if (gameOver) {
			game++;
			if (player.isWins()) {
				PopPlay.setManaged(true);
				PopPlay.setVisible(true);
				PopQuit.setManaged(true);
				PopQuit.setVisible(true);
				PopUp_Window.setText(player.getResult());
				PopUp_Window.setManaged(false);
				PopUp_Window.setVisible(true);
				player.wins();
			} else {
				PopPlay.setManaged(true);
				PopPlay.setVisible(true);
				PopQuit.setManaged(true);
				PopQuit.setVisible(true);
				PopUp_Window.setText(player.getResult());
				PopUp_Window.setManaged(false);
				PopUp_Window.setVisible(true);
				player.loses();
			}
			hit.setDisable(true);
			stand.setDisable(true);
			fold.setDisable(true);
			play.setDisable(false);
		} else {
			hit.setDisable(true);
			stand.setDisable(false);
			fold.setDisable(true);
			play.setDisable(false);
		}

		if (dealer.hasBlackJack()) { // 21 == Dealer Win
			player.setWins(false, "Dealer 21!");
			gameOver = true;
		} else if (player.hasBlackJack()) { // 21 == Player Win
			player.setWins(true, "Player 21!");
			gameOver = true;
		} else if (player.isFiveCardCharlie()) { // Five Card Charlie ==
													// Player
													// Win
			player.setWins(true, "5 Card Charlie!");
			gameOver = true;
		} else if (player.getTotalValue() > 21) { // Player Bust == Dealer
													// Win
			player.setWins(false, "Player Bust!");
			gameOver = true;
		} else if (dealer.getTotalValue() > 21) { // Dealer Bust == Player
													// Win
			player.setWins(true, "Dealer Bust!");
			gameOver = true;
		}

		/*Date date = new Date();
		PrintStream out = new PrintStream(new FileOutputStream("log.csv", true));
		out.print("\"" + date.toString() + "\",");
		out.print("\"Game #" + game + "\",");
		out.print("\"" + player.getCards() + "\",\"" + player.getTotalValue() + "\",");
		out.print("\"" + dealer.getCards() + "\",\"" + dealer.getTotalValue() + "\",");
		out.print("\"" + player.getResult() + "\",");
		out.print("\"" + player.getWinRecord() + ":" + player.getLossRecord() + "\",");
		out.println();
		out.flush();
		out.close();*/
	}

	@FXML
	protected void onFold(ActionEvent event) throws FileNotFoundException {
		hit.setDisable(true);
		stand.setDisable(true);
		fold.setDisable(true);
		play.setDisable(false);
		PopUp_Window.setManaged(true);
		PopUp_Window.setVisible(true);
		PopPlay.setManaged(true);
		PopPlay.setVisible(true);
		PopQuit.setManaged(true);
		PopQuit.setVisible(true);
		PopUp_Window.setText("You Fold.");
		game++;
	}

	@FXML
	protected void onPlay(ActionEvent event) throws FileNotFoundException {

		if (game > 0) {
			Date date = new Date();
			PrintStream out = new PrintStream(new FileOutputStream("log.csv", true));
			out.print("\"" + date.toString() + "\",");
			out.print("\"Game #" + game + "\",");
			out.print("\"" + player.getCards() + "\",\"" + player.getTotalValue() + "\",");
			out.print("\"" + dealer.getCards() + "\",\"" + dealer.getTotalValue() + "\",");
			out.print("\"" + player.getResult() + "\",");
			out.print("\"" + player.getWinRecord() + ":" + player.getLossRecord() + "\",");
			out.println();
			out.flush();
			out.close();
		}

		player.setResult(null);

		PopUp_Window.setManaged(false);
		PopUp_Window.setVisible(false);
		PopPlay.setManaged(false);
		PopPlay.setVisible(false);
		PopQuit.setManaged(false);
		PopQuit.setVisible(false);

		Player_1_H.setManaged(false);
		Player_1_H.setVisible(false);
		Player_1_C.setManaged(false);
		Player_1_C.setVisible(false);
		Player_1_S.setManaged(false);
		Player_1_S.setVisible(false);
		Player_1_D.setManaged(false);
		Player_1_D.setVisible(false);
		Player_2_H.setManaged(false);
		Player_2_H.setVisible(false);
		Player_2_C.setManaged(false);
		Player_2_C.setVisible(false);
		Player_2_S.setManaged(false);
		Player_2_S.setVisible(false);
		Player_2_D.setManaged(false);
		Player_2_D.setVisible(false);
		Player_3_H.setManaged(false);
		Player_3_H.setVisible(false);
		Player_3_C.setManaged(false);
		Player_3_C.setVisible(false);
		Player_3_S.setManaged(false);
		Player_3_S.setVisible(false);
		Player_3_D.setManaged(false);
		Player_3_D.setVisible(false);
		Player_4_H.setManaged(false);
		Player_4_H.setVisible(false);
		Player_4_C.setManaged(false);
		Player_4_C.setVisible(false);
		Player_4_S.setManaged(false);
		Player_4_S.setVisible(false);
		Player_4_D.setManaged(false);
		Player_4_D.setVisible(false);
		Player_5_H.setManaged(false);
		Player_5_H.setVisible(false);
		Player_5_C.setManaged(false);
		Player_5_C.setVisible(false);
		Player_5_S.setManaged(false);
		Player_5_S.setVisible(false);
		Player_5_D.setManaged(false);
		Player_5_D.setVisible(false);
		Player_1_H2.setManaged(false);
		Player_1_H2.setVisible(false);
		Player_1_C2.setManaged(false);
		Player_1_C2.setVisible(false);
		Player_1_S2.setManaged(false);
		Player_1_S2.setVisible(false);
		Player_1_D2.setManaged(false);
		Player_1_D2.setVisible(false);
		Player_2_H2.setManaged(false);
		Player_2_H2.setVisible(false);
		Player_2_C2.setManaged(false);
		Player_2_C2.setVisible(false);
		Player_2_S2.setManaged(false);
		Player_2_S2.setVisible(false);
		Player_2_D2.setManaged(false);
		Player_2_D2.setVisible(false);
		Player_3_H2.setManaged(false);
		Player_3_H2.setVisible(false);
		Player_3_C2.setManaged(false);
		Player_3_C2.setVisible(false);
		Player_3_S2.setManaged(false);
		Player_3_S2.setVisible(false);
		Player_3_D2.setManaged(false);
		Player_3_D2.setVisible(false);
		Player_4_H2.setManaged(false);
		Player_4_H2.setVisible(false);
		Player_4_C2.setManaged(false);
		Player_4_C2.setVisible(false);
		Player_4_S2.setManaged(false);
		Player_4_S2.setVisible(false);
		Player_4_D2.setManaged(false);
		Player_4_D2.setVisible(false);
		Player_5_H2.setManaged(false);
		Player_5_H2.setVisible(false);
		Player_5_C2.setManaged(false);
		Player_5_C2.setVisible(false);
		Player_5_S2.setManaged(false);
		Player_5_S2.setVisible(false);
		Player_5_D2.setManaged(false);
		Player_5_D2.setVisible(false);

		Dealer_1_H.setManaged(false);
		Dealer_1_H.setVisible(false);
		Dealer_1_C.setManaged(false);
		Dealer_1_C.setVisible(false);
		Dealer_1_S.setManaged(false);
		Dealer_1_S.setVisible(false);
		Dealer_1_D.setManaged(false);
		Dealer_1_D.setVisible(false);
		Dealer_2_H.setManaged(false);
		Dealer_2_H.setVisible(false);
		Dealer_2_C.setManaged(false);
		Dealer_2_C.setVisible(false);
		Dealer_2_S.setManaged(false);
		Dealer_2_S.setVisible(false);
		Dealer_2_D.setManaged(false);
		Dealer_2_D.setVisible(false);
		Dealer_3_H.setManaged(false);
		Dealer_3_H.setVisible(false);
		Dealer_3_C.setManaged(false);
		Dealer_3_C.setVisible(false);
		Dealer_3_S.setManaged(false);
		Dealer_3_S.setVisible(false);
		Dealer_3_D.setManaged(false);
		Dealer_3_D.setVisible(false);
		Dealer_4_H.setManaged(false);
		Dealer_4_H.setVisible(false);
		Dealer_4_C.setManaged(false);
		Dealer_4_C.setVisible(false);
		Dealer_4_S.setManaged(false);
		Dealer_4_S.setVisible(false);
		Dealer_4_D.setManaged(false);
		Dealer_4_D.setVisible(false);
		Dealer_5_H.setManaged(false);
		Dealer_5_H.setVisible(false);
		Dealer_5_C.setManaged(false);
		Dealer_5_C.setVisible(false);
		Dealer_5_S.setManaged(false);
		Dealer_5_S.setVisible(false);
		Dealer_5_D.setManaged(false);
		Dealer_5_D.setVisible(false);
		Dealer_1_H2.setManaged(false);
		Dealer_1_H2.setVisible(false);
		Dealer_1_C2.setManaged(false);
		Dealer_1_C2.setVisible(false);
		Dealer_1_S2.setManaged(false);
		Dealer_1_S2.setVisible(false);
		Dealer_1_D2.setManaged(false);
		Dealer_1_D2.setVisible(false);
		Dealer_2_H2.setManaged(false);
		Dealer_2_H2.setVisible(false);
		Dealer_2_C2.setManaged(false);
		Dealer_2_C2.setVisible(false);
		Dealer_2_S2.setManaged(false);
		Dealer_2_S2.setVisible(false);
		Dealer_2_D2.setManaged(false);
		Dealer_2_D2.setVisible(false);
		Dealer_3_H2.setManaged(false);
		Dealer_3_H2.setVisible(false);
		Dealer_3_C2.setManaged(false);
		Dealer_3_C2.setVisible(false);
		Dealer_3_S2.setManaged(false);
		Dealer_3_S2.setVisible(false);
		Dealer_3_D2.setManaged(false);
		Dealer_3_D2.setVisible(false);
		Dealer_4_H2.setManaged(false);
		Dealer_4_H2.setVisible(false);
		Dealer_4_C2.setManaged(false);
		Dealer_4_C2.setVisible(false);
		Dealer_4_S2.setManaged(false);
		Dealer_4_S2.setVisible(false);
		Dealer_4_D2.setManaged(false);
		Dealer_4_D2.setVisible(false);
		Dealer_5_H2.setManaged(false);
		Dealer_5_H2.setVisible(false);
		Dealer_5_C2.setManaged(false);
		Dealer_5_C2.setVisible(false);
		Dealer_5_S2.setManaged(false);
		Dealer_5_S2.setVisible(false);
		Dealer_5_D2.setManaged(false);
		Dealer_5_D2.setVisible(false);

		play.setDisable(true);
		hit.setDisable(false);
		stand.setDisable(false);
		fold.setDisable(false);

		player.reset();
		dealer.reset();

		Dealer_1.setText("");
		Dealer_2.setText("");
		Dealer_3.setText("");
		Dealer_4.setText("");
		Dealer_5.setText("");
		Player_1.setText("");
		Player_2.setText("");
		Player_3.setText("");
		Player_4.setText("");
		Player_5.setText("");

		player.stands = false;
		dealer.stands = false;

		deck = new Deck();
		deck.shuffleList();

		rounds = 0;

		for (int i = 0; i < 2; i++) { // deals first two cards to player and
										// first card to dealer
			player.addCard(deck.getCard());
			deck.removeCard();
			if (i < 1) {
				dealer.addCard(deck.getCard());
				deck.removeCard();
			}
		}
		showHands();
		dealer.addCard(deck.getCard());
		deck.removeCard();
		if (dealer.hasBlackJack()) {
			showHands();

			PopUp_Window.setManaged(true);
			PopUp_Window.setVisible(true);
			PopPlay.setManaged(true);
			PopPlay.setVisible(true);
			PopQuit.setManaged(true);
			PopQuit.setVisible(true);
			PopUp_Window.setText("Dealer 21!");
			hit.setDisable(true);
			stand.setDisable(true);
			fold.setDisable(true);
			play.setDisable(false);

		}
		if (player.hasBlackJack()) {
			showHands();

			PopUp_Window.setManaged(true);
			PopUp_Window.setVisible(true);
			PopPlay.setManaged(true);
			PopPlay.setVisible(true);
			PopQuit.setManaged(true);
			PopQuit.setVisible(true);
			PopUp_Window.setText("21! You Win!");
			hit.setDisable(true);
			stand.setDisable(true);
			fold.setDisable(true);
			play.setDisable(false);
		}
		if (player.getTotalValue() > 21) {
			showHands();

			PopUp_Window.setManaged(true);
			PopUp_Window.setVisible(true);
			PopPlay.setManaged(true);
			PopPlay.setVisible(true);
			PopQuit.setManaged(true);
			PopQuit.setVisible(true);
			PopUp_Window.setText("You Bust!");
			hit.setDisable(true);
			stand.setDisable(true);
			fold.setDisable(true);
			play.setDisable(false);
		}
	}

	@FXML
	protected void onQuit(ActionEvent event) throws FileNotFoundException {
		PopUp_Window.setManaged(true);
		PopUp_Window.setVisible(true);
		PopPlay.setManaged(true);
		PopPlay.setVisible(true);
		PopQuit.setManaged(true);
		PopQuit.setVisible(true);
		PopUp_Window.setText("Goodbye!");

		Date date = new Date();
		PrintStream out = new PrintStream(new FileOutputStream("log.csv", true));
		out.print("\"" + date.toString() + "\",");
		out.print("\"Game #" + game + "\",");
		out.print("\"" + player.getCards() + "\",\"" + player.getTotalValue() + "\",");
		out.print("\"" + dealer.getCards() + "\",\"" + dealer.getTotalValue() + "\",");
		out.print("\"" + player.getResult() + "\",");
		out.print("\"" + player.getWinRecord() + ":" + player.getLossRecord() + "\",");
		out.println();
		out.flush();
		out.close();
		
		System.exit(0);
	}
}
