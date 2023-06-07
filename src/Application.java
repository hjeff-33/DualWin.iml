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
    static String[] PLAYERS = new String[1];
    int PLAYERINDEX = 0;
    private String[] GrowArray (String[] PLAYERS){
        String[] tmp = new String[PLAYERS.length+1];
        for(int i = 0; i<PLAYERS.length; i++){
            tmp[i] = PLAYERS[i];
        }
        return tmp;
    }//Copys an array and grows it by one to add an extra spot for a player. I did this so the length could be updated and used when determining the number of players playing.
    public Application() {
        addAnotherPlayerButton.addActionListener(new ActionListener() {// adds a players name to the array which will be grown by one.
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PLAYERS.length<3) {
                    PLAYERS = GrowArray(PLAYERS);// calls grow array function
                    PLAYERS[PLAYERINDEX] = NAME_ENTER.getText();// sets newe array spot to players name
                    PLAYERINDEX++;// increase index so new player can be added to a new spot.
                    NAME_ENTER.setText("");// adds  the players name to an array when called
                }else{
                    JOptionPane.showMessageDialog(null, "YOU CAN PLAY WITH FOUR PLAYERS"+"\nPRESS PLAY GAME");// error message if they tey to input to many players.
                }
            }
        });
        playGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PLAYERINDEX != 0) {
                    PLAYERS[PLAYERINDEX] = NAME_ENTER.getText();// adds last player to the array
                    PLAYERINDEX++;
                    JFrame inputFrame = (JFrame) SwingUtilities.getWindowAncestor(viewIntro);// sets input screen to a disposable object.
                    inputFrame.dispose();// disposes of the input screen
                    Board.ShowGame();// calls funtion to open the actual board game.
                } else {
                    JOptionPane.showMessageDialog(null, "YOU NEED AT LEAST TWO PLAYER TO PLAY");// error message if there are less than two players.
                }
            }
        });
        NAME_ENTER.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {// same program as the Add Player button, but it just binds it to the input button for ease of use
                super.keyReleased(e);
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    if(PLAYERINDEX<3) {
                        PLAYERS = GrowArray(PLAYERS);
                        PLAYERS[PLAYERINDEX] = NAME_ENTER.getText();
                        PLAYERINDEX++;
                        NAME_ENTER.setText("");// adds  the players name to an array when called
                    }else{
                        JOptionPane.showMessageDialog(null, "YOU CAN PLAY WITH FOUR PLAYERS"+"\nPRESS PLAY GAME");
                    }
                }
            }
        });
    }
    public static void main(String[] args) { // sets up and opens the input screen.
        JFrame inputFrame = new JFrame("Input");
        inputFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        inputFrame.setContentPane(new Application().viewIntro);
        inputFrame.setSize(190, 170);
        inputFrame.setVisible(true);
    }
}
