import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniGameOne {
    private JPanel GameMiniPanel;
    private JButton ReactionButton;
    private JButton Screen;
    private boolean green = false;
    public static void Mini1Setup(){
        JFrame inputFrame = new JFrame("Input");
        inputFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        inputFrame.setContentPane(new MiniGameOne().GameMiniPanel);
        inputFrame.setSize(720, 720);
        inputFrame.setVisible(true);
    }
    public void playMini1() {
        Screen.setText("");
        Screen.setBackground(Color.RED);
        int delay = 5000; // Delay in milliseconds
        int interval = 5000; // Interval in milliseconds

        // Change background to red
        Timer redTimer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Screen.setBackground(Color.RED);
                green = false;
            }
        });
        redTimer.setRepeats(false); // Execute only once
        redTimer.start();

        // Change background to green
        Timer greenTimer = new Timer(delay + interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Screen.setBackground(Color.GREEN);
                green = true;
            }
        });
        greenTimer.setRepeats(false); // Execute only once
        greenTimer.start();
    }

    public MiniGameOne() {
        Screen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMini1();
            }
        });
        ReactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (green) {
                    JOptionPane.showMessageDialog(null, "You Won");

                } else {
                    JOptionPane.showMessageDialog(null, "You Failed");
                }
            }
        });
    }
}
