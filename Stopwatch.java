import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Stopwatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    private int elapsedTime = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int millisec = 0;

    private String leadername1 = "N/A";
    private String leadername2 = "N/A";
    private String leadername3 = "N/A";


    private int leaderboard1=0;
    private int leaderboard2=0;
    private int leaderboard3=0;

    private boolean started = false;
    private String seconds_string = String.format("%02d", seconds);
    private String minutes_string = String.format("%02d", minutes);
    private String millisec_string = String.format("%02d", millisec);

    Timer timer = new Timer(1, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime = elapsedTime + 10;
            millisec = (elapsedTime / 10) % 1000;
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            millisec_string = String.format("%02d", millisec);
            timeLabel.setText(minutes_string + ":" + seconds_string + ":" + millisec_string);

        }

    });


    Stopwatch() {

        timeLabel.setText(minutes_string + ":" + seconds_string + ":" + millisec_string);
        timeLabel.setBounds(70, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(70, 200, 200, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(70, 250, 200, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {

            if (!started) {
                started = true;
                startButton.setText("STOP");
                start();
            } else {
                started = false;
                startButton.setText("START");
                stop();
            }

        }
        if (e.getSource() == resetButton) {
            started = false;
            startButton.setText("START");
            reset();
        }

    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();

        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        millisec = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        millisec_string = String.format("%02d", millisec);
        timeLabel.setText(minutes_string + ":" + seconds_string + ":" + millisec_string);
    }

    public void updateleaderboard()
    {
        if (elapsedTime > leaderboard1)
        {
            int temp1 = leaderboard1;
            int temp2 = leaderboard2;
            leaderboard1 = elapsedTime;
            leaderboard2= temp1;
            leaderboard3= temp2;
        }
    }

    public void setupleaderboard()
    {
        JTextField Leaderboard = new JTextField();
        Leaderboard.setText(leadername1 + "00:00:00");
        Leaderboard.setBounds();
    }
}
