import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
    int MiniGame1Spot = 0;
    int MiniGame2Spot = 0;
    boolean PlayerOneTurn=true;
    boolean PlayerTwoTurn=false;
    boolean PlayerThreeTurn=false;
    boolean PlayerFourTurn=false;
    int Player1Pos = 0;
    int Player2Pos = 0;
    int Player3Pos = 0;
    int Player4Pos = 0;
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
                PlayGame();
            }
        });
    }
    public static void ShowGame(){
        JFrame inputFrame = new JFrame("Snakes and Ladders");
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
            MiniGame1Spot = rand.nextInt(1,LOCATION.length-1);
            MiniGame2Spot = rand.nextInt(1,LOCATION.length-1);

            ValuesUnique = (SnakeStart != SnakeEnd) && (SnakeStart1 != SnakeEnd1) && (LadderStart != LadderEnd) && (LadderStart1 != LadderEnd1)
                    && (SnakeStart != SnakeStart1) && (SnakeStart != SnakeEnd1) && (SnakeEnd != SnakeStart1) && (SnakeEnd != SnakeEnd1)
                    && (LadderStart != SnakeStart) && (LadderStart != SnakeEnd) && (LadderStart != SnakeStart1) && (LadderStart != SnakeEnd1) && (LadderStart != LadderStart1) && (LadderStart != LadderEnd) && (LadderStart != LadderEnd1)
                    && (LadderEnd != SnakeStart) && (LadderEnd != SnakeEnd) && (LadderEnd != SnakeStart1) && (LadderEnd != SnakeEnd1) && (LadderEnd != LadderStart1) && (LadderEnd != LadderEnd1)
                    && (LadderStart1 != SnakeStart) && (LadderStart1 != SnakeEnd) && (LadderStart1 != SnakeStart1) && (LadderStart1 != SnakeEnd1) && (LadderStart1 != LadderStart) && (LadderStart1 != LadderEnd) && (LadderStart1 != LadderEnd1)
                    && (LadderEnd1 != SnakeStart) && (LadderEnd1 != SnakeEnd) && (LadderEnd1 != SnakeStart1) && (LadderEnd1 != SnakeEnd1) && (LadderEnd1 != LadderStart) && (LadderEnd1 != LadderEnd) && (LadderEnd1 != LadderStart1)
                    && (SnakeStart != MiniGame1Spot) && (SnakeStart != MiniGame2Spot) && (SnakeEnd != MiniGame1Spot) && (SnakeEnd != MiniGame2Spot)
                    && (SnakeStart1 != MiniGame1Spot) && (SnakeStart1 != MiniGame2Spot) && (SnakeEnd1 != MiniGame1Spot) && (SnakeEnd1 != MiniGame2Spot)
                    && (LadderStart != MiniGame1Spot) && (LadderStart != MiniGame2Spot) && (LadderEnd != MiniGame1Spot) && (LadderEnd != MiniGame2Spot)
                    && (LadderStart1 != MiniGame1Spot) && (LadderStart1 != MiniGame2Spot) && (LadderEnd1 != MiniGame1Spot) && (LadderEnd1 != MiniGame2Spot)
                    && (MiniGame1Spot != MiniGame2Spot)
                    && (SnakeStart != 0) && (SnakeStart1 != 0) && (SnakeEnd != 0) && (SnakeEnd1 != 0)
                    && (LadderStart != 0) && (LadderStart1 != 0) && (LadderEnd != 0) && (LadderEnd1 != 0)
                    && (SnakeStart != LOCATION.length - 1) && (SnakeStart1 != LOCATION.length - 1) && (SnakeEnd != LOCATION.length - 1) && (SnakeEnd1 != LOCATION.length - 1)
                    && (LadderStart != LOCATION.length - 1) && (LadderStart1 != LOCATION.length - 1) && (LadderEnd != LOCATION.length - 1) && (LadderEnd1 != LOCATION.length - 1);

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
            LOCATION[0].setText(Application.PLAYERS[0]+Application.PLAYERS[1]);
        }
        if(Application.PLAYERS.length==3){
            Player1.setText(Application.PLAYERS[0]);
            Player2.setText(Application.PLAYERS[1]);
            Player3.setText(Application.PLAYERS[2]);
            Player4.setText("");
            LOCATION[0].setText(Application.PLAYERS[0]+Application.PLAYERS[1]+Application.PLAYERS[2]);
        }
        if(Application.PLAYERS.length==4){
            Player1.setText(Application.PLAYERS[0]);
            Player2.setText(Application.PLAYERS[1]);
            Player3.setText(Application.PLAYERS[2]);
            Player4.setText(Application.PLAYERS[3]);
            LOCATION[0].setText(Application.PLAYERS[0]+Application.PLAYERS[1]+Application.PLAYERS[2]+Application.PLAYERS[3]);
        }
        Turn.setText("Player 1 Turn");
        PlayGame();
    }
    public void PlayGame(){
        String Player1PosText = LOCATION[Player1Pos].getText();
        String Player2PosText = LOCATION[Player2Pos].getText();
        String Player3PosText = LOCATION[Player3Pos].getText();
        String Player4PosText = LOCATION[Player4Pos].getText();
        if(PlayerOneTurn){
            LOCATION[Player1Pos].setText(Player1PosText.replaceAll(Application.PLAYERS[0], ""));
            LOCATION[Player1Pos].setText(Player1PosText);
            Player1Pos= Player1Pos+roll;
            if(Player1Pos == SnakeStart){
                Player1Pos = SnakeEnd;
            }
            if(Player1Pos == SnakeStart1){
                Player1Pos = SnakeEnd1;
            }
            if(Player1Pos == LadderEnd){
                Player1Pos = LadderStart;
            }
            if(Player1Pos == LadderEnd1){
                Player1Pos = LadderStart1;
            }
            if(Player1Pos == MiniGame1Spot){
                MiniGameOne.Mini1Setup();
            }
            if(Player1Pos == MiniGame2Spot){
                MiniGameTwo.MinitwoSetUp();
            }
            LOCATION[Player1Pos].setText(LOCATION[Player1Pos].getText()+"\n "+Application.PLAYERS[0]);
        }
        if(PlayerTwoTurn){
            LOCATION[Player2Pos].setText(Player2PosText.replaceAll(Application.PLAYERS[1], ""));
            LOCATION[Player2Pos].setText(Player2PosText);
            Player2Pos= Player2Pos+roll;
            if(Player2Pos>LOCATION.length){
                JOptionPane.showMessageDialog(null, "Player Two Won!!!!!");
            }
            if(Player2Pos == SnakeStart){
                Player2Pos = SnakeEnd;
            }
            if(Player2Pos == SnakeStart1){
                Player2Pos = SnakeEnd1;
            }
            if(Player2Pos == LadderEnd){
                Player2Pos = LadderStart;
            }
            if(Player2Pos == LadderEnd1){
                Player2Pos = LadderStart1;
            }
            if(Player2Pos == MiniGame1Spot){
                MiniGameOne.Mini1Setup();
            }
            if(Player2Pos == MiniGame2Spot){
                MiniGameTwo.MinitwoSetUp();
            }
            LOCATION[Player2Pos].setText(LOCATION[Player2Pos].getText()+"\n "+Application.PLAYERS[1]);
        }
        if(PlayerThreeTurn){
            LOCATION[Player3Pos].setText(Player3PosText.replaceAll(Application.PLAYERS[2], ""));
            LOCATION[Player3Pos].setText(Player3PosText);
            Player3Pos= Player3Pos+roll;
            if(Player3Pos>LOCATION.length){
                JOptionPane.showMessageDialog(null, "Player Three Won!!!!!");
            }
            if(Player3Pos == SnakeStart){
                Player3Pos = SnakeEnd;
            }
            if(Player3Pos == SnakeStart1){
                Player3Pos = SnakeEnd1;
            }
            if(Player3Pos == LadderEnd){
                Player3Pos = LadderStart;
            }
            if(Player3Pos == LadderEnd1){
                Player3Pos = LadderStart1;
            }
            if(Player3Pos == MiniGame1Spot){
                MiniGameOne.Mini1Setup();
            }
            if(Player3Pos == MiniGame2Spot){
                MiniGameTwo.MinitwoSetUp();
            }
            LOCATION[Player3Pos].setText(LOCATION[Player3Pos].getText()+"\n "+Application.PLAYERS[2]);
        }
        if(PlayerFourTurn){
            LOCATION[Player4Pos].setText(Player4PosText.replaceAll(Application.PLAYERS[3], ""));
            LOCATION[Player4Pos].setText(Player4PosText);
            Player4Pos= Player4Pos+roll;
            if(Player4Pos>LOCATION.length){
                JOptionPane.showMessageDialog(null, "Player Four Won!!!!!");
            }
            if(Player4Pos == SnakeStart){
                Player4Pos = SnakeEnd;
            }
            if(Player4Pos == SnakeStart1){
                Player4Pos = SnakeEnd1;
            }
            if(Player4Pos == LadderEnd){
                Player4Pos = LadderStart;
            }
            if(Player4Pos == LadderEnd1){
                Player4Pos = LadderStart1;
            }
            if(Player4Pos == MiniGame1Spot){
                MiniGameOne.Mini1Setup();
            }
            if(Player4Pos == MiniGame2Spot){
                MiniGameTwo.MinitwoSetUp();
            }
            LOCATION[Player4Pos].setText(LOCATION[Player4Pos].getText()+"\n "+Application.PLAYERS[3]);
        }
    }

}