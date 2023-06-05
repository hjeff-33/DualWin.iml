import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Board {
    private JPanel ViewBoard;
    private JButton Start;
    private JButton R1C5;
    private JButton R1C4;
    private JButton R1C3;
    private JButton R1C2;
    private JButton R1C1;
    private JButton R4C6;
    private JButton R5C6;
    private JButton R5C5;
    private JButton R5C4;
    private JButton R5C3;
    private JButton R5C2;
    private JButton End;
    private JButton R3C6;
    private JButton R3C5;
    private JButton R3C4;
    private JButton R3C3;
    private JButton R3C2;
    private JButton R3C1;
    private JButton rollDiceButton;
    public  JLabel Player1;
    public  JLabel Player2;
    public  JLabel Player3;
    public  JLabel Player4;
    private JButton R2C1;
    private JLabel Turn;
    boolean alreadyExecuted = false;
    int SnakeStart=0;
    int SnakeEnd=0;
    int SnakeStart1=0;
    int SnakeEnd1=0;
    int LadderStart=0;
    int LadderEnd=0;
    int LadderStart1=0;
    int LadderEnd1=0;
    int rounds=1;
    int roll;
    boolean PlayerOneTurn=true;
    boolean PlayerTwoTurn=false;
    boolean PlayerThreeTurn=false;
    boolean PlayerFourTurn=false;
    JButton[] LOCATION = {Start,R1C5,R1C4,R1C3,R1C2,R1C1,R2C1,R3C1,R3C2,R3C3,R3C4,R3C5,R3C6,R4C6,R5C6,R5C5,R5C4,R5C3,R5C2,End};
    public Board() {
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!alreadyExecuted) {
                    PlayGameSetUp();
                    alreadyExecuted = true;
                }
            }
        });
        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                roll = rand.nextInt(1,7);
                rollDiceButton.setText(String.valueOf(roll));
                rounds++;
                if(rounds>Application.PLAYERS.length){
                    rounds = 1;
                }
                if(rounds == 1){
                    Turn.setText("Player 1 Turn");
                    PlayerOneTurn = true;
                    PlayerTwoTurn = false;
                    PlayerThreeTurn = false;
                    PlayerFourTurn = false;
                }
                if(rounds == 2){
                    Turn.setText("Player 2 Turn");
                    PlayerOneTurn = false;
                    PlayerTwoTurn = true;
                    PlayerThreeTurn = false;
                    PlayerFourTurn = false;
                }
                if(rounds == 3){
                    Turn.setText("Player 3 Turn");
                    PlayerOneTurn = false;
                    PlayerTwoTurn = false;
                    PlayerThreeTurn = true;
                    PlayerFourTurn = false;
                }
                if(rounds == 4){
                    Turn.setText("Player 4 Turn");
                    PlayerOneTurn = false;
                    PlayerTwoTurn = false;
                    PlayerThreeTurn = false;
                    PlayerFourTurn = true;
                }
            }
        });
    }
    public static void ShowGame(){
        JFrame inputFrame = new JFrame("Input");
        inputFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        inputFrame.setContentPane(new Board().ViewBoard);
        inputFrame.setSize(1080, 720);
        inputFrame.setVisible(true);
        JOptionPane.showMessageDialog(null, "Press Start to Play!");
    }
    public void PlayGameSetUp(){
        Random rand = new Random();
        boolean ValuesUnique;
        do {
            SnakeStart = rand.nextInt(1, LOCATION.length - 3);
            SnakeEnd = rand.nextInt(SnakeStart + 1, LOCATION.length - 2);
            SnakeStart1 = rand.nextInt(1, LOCATION.length - 3);
            SnakeEnd1 = rand.nextInt(SnakeStart1 + 1, LOCATION.length - 1);
            LadderStart = rand.nextInt(3, LOCATION.length - 1);
            LadderEnd = rand.nextInt(0, LadderStart - 1);
            LadderStart1 = rand.nextInt(2, LOCATION.length - 1);
            LadderEnd1 = rand.nextInt(0, LadderStart1 - 1);

            ValuesUnique = (SnakeStart != SnakeEnd) && (SnakeStart1 != SnakeEnd1) && (LadderStart != LadderEnd) && (LadderStart1 != LadderEnd1)
                    && (SnakeStart != SnakeStart1) && (SnakeStart != SnakeEnd1) && (SnakeEnd != SnakeStart1) && (SnakeEnd != SnakeEnd1)
                    && (LadderStart != SnakeStart) && (LadderStart != SnakeEnd) && (LadderStart != SnakeStart1) && (LadderStart != SnakeEnd1) && (LadderStart != LadderStart1) && (LadderStart != LadderEnd) && (LadderStart != LadderEnd1)
                    && (LadderEnd != SnakeStart) && (LadderEnd != SnakeEnd) && (LadderEnd != SnakeStart1) && (LadderEnd != SnakeEnd1) && (LadderEnd != LadderStart1) && (LadderEnd != LadderEnd1)
                    && (LadderStart1 != SnakeStart) && (LadderStart1 != SnakeEnd) && (LadderStart1 != SnakeStart1) && (LadderStart1 != SnakeEnd1) && (LadderStart1 != LadderStart) && (LadderStart1 != LadderEnd) && (LadderStart1 != LadderEnd1)
                    && (LadderEnd1 != SnakeStart) && (LadderEnd1 != SnakeEnd) && (LadderEnd1 != SnakeStart1) && (LadderEnd1 != SnakeEnd1) && (LadderEnd1 != LadderStart) && (LadderEnd1 != LadderEnd) && (LadderEnd1 != LadderStart1);

        } while (!ValuesUnique);

        LOCATION[SnakeStart].setBackground(Color.GREEN);
        LOCATION[SnakeEnd].setBackground(Color.GREEN);
        LOCATION[SnakeStart].setText("Snake");
        LOCATION[SnakeEnd].setText("Snake");

        LOCATION[SnakeStart1].setBackground(Color.RED);
        LOCATION[SnakeEnd1].setBackground(Color.RED);
        LOCATION[SnakeStart1].setText("Snake");
        LOCATION[SnakeEnd1].setText("Snake");

        LOCATION[LadderStart].setBackground(Color.YELLOW);
        LOCATION[LadderEnd].setBackground(Color.YELLOW);
        LOCATION[LadderStart].setText("Ladder");
        LOCATION[LadderEnd].setText("Ladder");

        LOCATION[LadderStart1].setBackground(Color.BLUE);
        LOCATION[LadderEnd1].setBackground(Color.BLUE);
        LOCATION[LadderStart1].setText("Ladder");
        LOCATION[LadderEnd1].setText("Ladder");

        if(Application.PLAYERS.length==2){
             Player1.setText("");
             Player2.setText(Application.PLAYERS[0]);
             Player3.setText(Application.PLAYERS[1]);
             Player4.setText("");
         }
        if(Application.PLAYERS.length==3){
            Player1.setText(Application.PLAYERS[0]);
            Player2.setText(Application.PLAYERS[1]);
            Player3.setText(Application.PLAYERS[2]);
            Player4.setText("");
        }
        if(Application.PLAYERS.length==4){
            Player1.setText(Application.PLAYERS[0]);
            Player2.setText(Application.PLAYERS[1]);
            Player3.setText(Application.PLAYERS[2]);
            Player4.setText(Application.PLAYERS[3]);
        }
        Turn.setText("Player 1 Turn");
        PlayGame();
    }
    public void PlayGame(){
        int Player1Pos = 0;
        int Player2Pos = 0;
        int Player3Pos = 0;
        int Player4Pos = 0;
        if(PlayerOneTurn){
            Player1Pos= Player1Pos+roll;
        }
        if(PlayerTwoTurn){
            Player2Pos= Player2Pos+roll;
        }
        if(PlayerThreeTurn){
            Player3Pos= Player3Pos+roll;
        }
        if(PlayerFourTurn){
            Player4Pos= Player4Pos+roll;
        }


    }
}
