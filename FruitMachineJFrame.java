import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FruitMachineJFrame extends JFrame {

	private static final Font FONT = new Font("Times New Roman", Font.BOLD, 20);

	private JPanel contentPane;
	private JLabel balanceLabel;
	private JLabel msgLabel;
	private JLabel resultLabel;
	private JLabel cardLabel2;

	private FruitModel model = new FruitModel();
	private JLabel cardLabel1;
	private JLabel cardLabel3;
	private JButton spinBtn;
	private JButton newGameBtn;

	/**
	 * Create the frame.
	 */
	public FruitMachineJFrame() {
		setResizable(false);
		setTitle("Fruitmachine GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		balanceLabel = new JLabel("New label");
		balanceLabel.setFont(FONT);
		balanceLabel.setBounds(23, 31, 354, 19);
		contentPane.add(balanceLabel);

		msgLabel = new JLabel("New label");
		msgLabel.setFont(FONT);
		msgLabel.setBounds(23, 90, 354, 15);
		contentPane.add(msgLabel);

		resultLabel = new JLabel("New label");
		resultLabel.setFont(FONT);
		resultLabel.setBounds(23, 143, 354, 15);
		contentPane.add(resultLabel);

		spinBtn = new JButton("spin");
		spinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.randCards();
				msgLabel.setText(model.checkCards());
				checkResult();

				showInfo();
			}
		});
		spinBtn.setFont(FONT);
		spinBtn.setBounds(421, 240, 133, 23);
		contentPane.add(spinBtn);

		newGameBtn = new JButton("new game");
		newGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGame();
			}
		});
		newGameBtn.setFont(FONT);
		newGameBtn.setBounds(421, 297, 133, 23);
		contentPane.add(newGameBtn);

		cardLabel1 = new JLabel("New label");
		cardLabel1.setFont(FONT);
		cardLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		cardLabel1.setBackground(Color.YELLOW);
		cardLabel1.setBounds(23, 212, 99, 123);
		cardLabel1.setOpaque(true);

		contentPane.add(cardLabel1);

		cardLabel2 = new JLabel("New label");
		cardLabel2.setFont(FONT);
		cardLabel2.setOpaque(true);
		cardLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		cardLabel2.setBackground(Color.YELLOW);
		cardLabel2.setBounds(149, 212, 99, 123);
		contentPane.add(cardLabel2);

		cardLabel3 = new JLabel("New label");
		cardLabel3.setFont(FONT);
		cardLabel3.setOpaque(true);
		cardLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		cardLabel3.setBackground(Color.YELLOW);
		cardLabel3.setBounds(278, 212, 99, 123);
		contentPane.add(cardLabel3);

		resetGame();
	}

	// The game continues until the player has less than 0 points, in which case the
	// player loses; or the player has at least 150 points, in which case they win.
	public void checkResult() {
		int balance = model.getBalance();

		if (balance < 0 || balance > 150) {
			if (balance < 0) {
				resultLabel.setText("You lose!");
			} else if (balance > 150) {
				resultLabel.setText("You win!");
			}
			// when the game ends in each case the spin button becomes disabled and the new
			// game button becomes enabled.
			spinBtn.setEnabled(false);
			newGameBtn.setEnabled(true);
		}

	}

	public void resetGame() {
		model.reset();
		msgLabel.setText("welcome!");
		resultLabel.setText("");
		spinBtn.setEnabled(true);
		newGameBtn.setEnabled(false);
		showInfo();
	}

	public void showInfo() {
		balanceLabel.setText("balance is " + model.getBalance());
		cardLabel1.setText(model.getCard1Str());
		cardLabel2.setText(model.getCard2Str());
		cardLabel3.setText(model.getCard3Str());
	}
}
