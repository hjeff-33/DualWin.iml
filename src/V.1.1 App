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
    }//Copys an array and grows it by one
    public Application() {
        addAnotherPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PLAYERS.length<3) {
                    PLAYERS = GrowArray(PLAYERS);
                    PLAYERS[PLAYERINDEX] = NAME_ENTER.getText();
                    PLAYERINDEX++;
                    NAME_ENTER.setText("");// adds  the players name to an array when called
                }else{
                    JOptionPane.showMessageDialog(null, "YOU CAN PLAY WITH FOUR PLAYERS"+"\nPRESS PLAY GAME");
                }
            }
        });
        playGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PLAYERINDEX != 0) {
                    PLAYERS[PLAYERINDEX] = NAME_ENTER.getText();
                    PLAYERINDEX++;
                    JFrame inputFrame = (JFrame) SwingUtilities.getWindowAncestor(viewIntro);
                    inputFrame.dispose();
                    Board.ShowGame();
                } else {
                    JOptionPane.showMessageDialog(null, "YOU NEED AT LEAST TWO PLAYER TO PLAY");
                }
            }
        });
        NAME_ENTER.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
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
    public static void main(String[] args) {
        JFrame inputFrame = new JFrame("Input");
        inputFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        inputFrame.setContentPane(new Application().viewIntro);
        inputFrame.setSize(190, 170);
        inputFrame.setVisible(true);
    }
}
