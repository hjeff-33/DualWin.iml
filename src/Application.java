import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Application {
    private JPanel viewIntro;
    private JButton playGameButton;
    private JButton addAnotherPlayerButton;
    private JTextField NAME_ENTER;
    private JLabel NAMELABEL;
    static String[] PLAYERS = new String[1]; // Array to store player names
    int PLAYERINDEX = 0; // Index to keep track of the current player position

    // Copies an array and grows it by one to add an extra spot for a player.
    // This is done so the length could be updated and used when determining the number of players playing.
    private String[] GrowArray(String[] PLAYERS) {
        String[] tmp = new String[PLAYERS.length + 1];
        for (int i = 0; i < PLAYERS.length; i++) {
            tmp[i] = PLAYERS[i];
        }
        return tmp;
    }

    public Application() {
        addAnotherPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PLAYERS.length < 3) {
                    PLAYERS = GrowArray(PLAYERS); // Grow the array to accommodate another player
                    PLAYERS[PLAYERINDEX] = NAME_ENTER.getText(); // Set the new array spot to the player's name
                    PLAYERINDEX++; // Increase the index to add the new player to a new spot
                    NAME_ENTER.setText(""); // Clear the input field for the next player's name
                } else {
                    JOptionPane.showMessageDialog(null, "YOU CAN PLAY WITH FOUR PLAYERS" + "\nPRESS PLAY GAME");
                    // Show an error message if they try to input too many players
                }
            }
        });

        playGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PLAYERINDEX != 0) {
                    PLAYERS[PLAYERINDEX] = NAME_ENTER.getText(); // Add the last player to the array
                    PLAYERINDEX++;
                    JFrame inputFrame = (JFrame) SwingUtilities.getWindowAncestor(viewIntro);
                    // Get the parent JFrame (inputFrame) of the viewIntro panel
                    // (Assuming viewIntro is added to a JFrame somewhere up the hierarchy)
                    inputFrame.dispose(); // Dispose of the input screen
                    Board.ShowGame(); // Call function to open the actual board game
                } else {
                    JOptionPane.showMessageDialog(null, "YOU NEED AT LEAST TWO PLAYERS");
                    // Show an error message if there are less than two players
                }
            }
        });

        NAME_ENTER.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (PLAYERINDEX < 3) {
                        PLAYERS = GrowArray(PLAYERS); // Grow the array  another player
                        PLAYERS[PLAYERINDEX] = NAME_ENTER.getText(); // Set the new array spot to the player's name
                        PLAYERINDEX++;
                        NAME_ENTER.setText(""); // Clear the input field for the next player's name
                    } else {
                        JOptionPane.showMessageDialog(null, "YOU CAN PLAY WITH FOUR PLAYERS" + "\nPRESS PLAY GAME");
                        // Show an error message if they try to input too many players
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame inputFrame = new JFrame("Input"); // Create a new JFrame
        inputFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Set the default close operation to exit the application when the frame is closed

        inputFrame.setContentPane(new Application().viewIntro);
        // Set the content pane of the frame to the viewIntro panel of the Application class

        inputFrame.setSize(190, 170); // Set the size of the frame
        inputFrame.setVisible(true); // Make the frame visible
    }
}
