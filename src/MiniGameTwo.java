import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MiniGameTwo {
    private JPanel MiniTwoPanel;
    private JButton a;
    private JButton b;
    private JButton c;
    private JButton startButton;
    private JLabel QuestionLabel;
    int tmp;
    String[] questions = {"1 + 3", "5 - 2", "4 * 6", "10 / 2", "8 + 2", "9 - 4", "7 * 3", "12 / 3", "6 + 9", "15 - 7", "2 * 5", "16 / 4", "8 + 7", "11 - 6", "3 * 4"};
    int[] questionsInt = {1 + 3, 5 - 2, 4 * 6, 10 / 2, 8 + 2, 9 - 4, 7 * 3, 12 / 3, 6 + 9, 15 - 7, 2 * 5, 16 / 4, 8 + 7, 11 - 6, 3 * 4};
    private void picKRandQues(){
        Random rand = new Random();
        int QuesNum = rand.nextInt(0,questions.length);
        String QuesString = questions[QuesNum];
        QuestionLabel.setText(QuesString);
        tmp = rand.nextInt(1,4);
        int max = questionsInt[QuesNum]+3;
        int min = questionsInt[QuesNum]-3;
        if(tmp==1){
            a.setText(String.valueOf( questionsInt[QuesNum]));
        }else {
            int temp;
            do {
                temp = rand.nextInt(min, max);
                a.setText(String.valueOf(temp));
            } while (temp == questionsInt[QuesNum]);
        }
        if(tmp==2){
            b.setText(String.valueOf( questionsInt[QuesNum]));
        }else {
            int temp;
            do {
                temp = rand.nextInt(min, max);
                b.setText(String.valueOf(temp));
            } while (temp == questionsInt[QuesNum]);
        }
        if(tmp==3){
            c.setText(String.valueOf( questionsInt[QuesNum]));
        }else {
            int temp;
            do {
                temp = rand.nextInt(min, max);
                c.setText(String.valueOf(temp));
            } while (temp == questionsInt[QuesNum]);
        }
    }
    public MiniGameTwo() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                picKRandQues();
            }
        });
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tmp==1){
                    JOptionPane.showMessageDialog(null, "Correct");
                }else{
                    JOptionPane.showMessageDialog(null, "Fail!");
                }
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tmp==2){
                    JOptionPane.showMessageDialog(null, "Correct");
                }else{
                    JOptionPane.showMessageDialog(null, "Fail!");
                }
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tmp==3){
                    JOptionPane.showMessageDialog(null, "Correct");
                }else{
                    JOptionPane.showMessageDialog(null, "Fail!");
                }
            }
        });
    }
}
