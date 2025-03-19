import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int numberOfTries;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			numberOfTries++;
			if (guess < theNumber)
				message = guess + " is too low. Try again.";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else{
				message = guess +
						" is correct. You win " + numberOfTries + " tries";
				newGame();
			}
		} catch(Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		numberOfTries =0;
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Will's Hi-Lo Guessing Gameme");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Wills Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(63, 10, 323, 46);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Guess a number between  1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(41, 66, 295, 26);
		getContentPane().add(lblNewLabel_1);

		txtGuess = new JTextField();
		txtGuess.setBounds(342, 66, 69, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});

		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(165, 121, 99, 26);
		getContentPane().add(btnNewButton);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 171, 406, 34);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}

