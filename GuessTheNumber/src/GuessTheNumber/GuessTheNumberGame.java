package chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumberGame extends JFrame {

    private final int randomNumber;
    private final JTextField textField;
    private final JLabel label;
    private final JButton guessButton;
    private int attempts;

    public GuessTheNumberGame() {
        // Generate a random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;

        setTitle("Guess the Number Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Enter your guess:");
        add(label);

        textField = new JTextField(10);
        add(textField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());
        add(guessButton);

        attempts = 0;

        setVisible(true);
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(textField.getText());
                attempts++;

                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                    dispose();
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GuessTheNumberGame();
        });
    }
}