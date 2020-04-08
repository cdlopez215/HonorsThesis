/**
 * Christian Lopez
 * Dhantin Kumar
 * Spring 2020
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JPanel implements ActionListener {

    int OVAL_WIDTH = 75;
    int OVAL_HEIGHT = 75;

    int ROW_ADJUST, COLUMN_ADJUST;
    private JFrame frame;

    int mostRecent = 0, backUp, lastSideUsed;
    int[] roots = new int[100];
    boolean fillSquares = false;
    int numNote = 0;

    boolean canGoTo[][] = new boolean[7][7];
    JButton jb0 = new JButton("I");
    JButton jb1 = new JButton("ii");
    JButton jb2 = new JButton("iii");
    JButton jb3 = new JButton("IV");
    JButton jb4 = new JButton("V");
    JButton jb5 = new JButton("vi");
    JButton jb6 = new JButton("vii");

    JButton jb8 = new JButton("I");
    JButton jb9 = new JButton("ii");
    JButton jb10 = new JButton("iii");
    JButton jb11 = new JButton("IV");
    JButton jb12 = new JButton("V");
    JButton jb13 = new JButton("vi");
    JButton jb14 = new JButton("vii");

    Color backgroundColor = Color.decode("#FAFAFB");
    Color buttonColor = Color.decode("#E1ECF4");
    Color actionButtonColor = Color.decode("#0095FF");
    Color actionButtonTextColor = Color.decode("#FFFFFF");
    Color textColor = Color.decode("#39739D");

    boolean isActive[] = {true, true, true, true, true, true, true};

    int chord;
    boolean created = false;

    public void createAndShowGui() {
        if (!created) {
            created = true;
            ROW_ADJUST = 600 / 8;
            COLUMN_ADJUST = 400 / 6;

            frame = new JFrame("Chord frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setLayout(null);
            this.setForeground(buttonColor);
            this.setBackground(backgroundColor);
            this.add(Box.createRigidArea(new Dimension(0, 10)));

            //chords on left
            jb0.setBackground(buttonColor);
            jb0.setForeground(textColor);
            jb0.setFont(new Font("Arial", Font.PLAIN, 40));
            jb0.setName("lc0");
            jb0.setActionCommand("lc0");
            jb0.addActionListener(this);

            jb1.setBackground(buttonColor);
            jb1.setFont(new Font("Arial", Font.PLAIN, 40));
            jb1.setForeground(textColor);
            jb1.setName("lc1");
            jb1.setActionCommand("lc1");
            jb1.addActionListener(this);

            jb2.setBackground(buttonColor);
            jb2.setForeground(textColor);
            jb2.setFont(new Font("Arial", Font.PLAIN, 40));
            jb2.setName("lc2");
            jb2.setActionCommand("lc2");
            jb2.addActionListener(this);

            jb3.setBackground(buttonColor);
            jb3.setForeground(textColor);
            jb3.setFont(new Font("Arial", Font.PLAIN, 40));
            jb3.setName("lc3");
            jb3.setActionCommand("lc3");
            jb3.addActionListener(this);

            jb4.setBackground(buttonColor);
            jb4.setForeground(textColor);
            jb4.setFont(new Font("Arial", Font.PLAIN, 40));
            jb4.setName("lc4");
            jb4.setActionCommand("lc4");
            jb4.addActionListener(this);

            jb5.setBackground(buttonColor);
            jb5.setForeground(textColor);
            jb5.setFont(new Font("Arial", Font.PLAIN, 40));
            jb5.setName("lc5");
            jb5.setActionCommand("lc5");
            jb5.addActionListener(this);

            jb6.setBackground(buttonColor);
            jb6.setForeground(textColor);
            jb6.setFont(new Font("Arial", Font.PLAIN, 40));
            jb6.setName("lc6");
            jb6.setActionCommand("lc6");
            jb6.addActionListener(this);

            jb0.setBounds(COLUMN_ADJUST, ROW_ADJUST * 1 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb0);

            jb1.setBounds(COLUMN_ADJUST, ROW_ADJUST * 2 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb1);

            jb2.setBounds(COLUMN_ADJUST, ROW_ADJUST * 3 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb2);

            jb3.setBounds(COLUMN_ADJUST, ROW_ADJUST * 4 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb3);

            jb4.setBounds(COLUMN_ADJUST, ROW_ADJUST * 5 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb4);

            jb5.setBounds(COLUMN_ADJUST, ROW_ADJUST * 6 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb5);

            jb6.setBounds(COLUMN_ADJUST, ROW_ADJUST * 7 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb6);

            //chords on right
            jb8.setBackground(buttonColor);
            jb8.setForeground(textColor);
            jb8.setFont(new Font("Arial", Font.PLAIN, 40));
            jb8.setName("rc0");
            jb8.setActionCommand("rc0");
            jb8.addActionListener(this);

            jb9.setBackground(buttonColor);
            jb9.setForeground(textColor);
            jb9.setFont(new Font("Arial", Font.PLAIN, 40));
            jb9.setName("rc1");
            jb9.setActionCommand("rc1");
            jb9.addActionListener(this);

            jb10.setBackground(buttonColor);
            jb10.setForeground(textColor);
            jb10.setFont(new Font("Arial", Font.PLAIN, 40));
            jb10.setName("rc2");
            jb10.setActionCommand("rc2");
            jb10.addActionListener(this);

            jb11.setBackground(buttonColor);
            jb11.setForeground(textColor);
            jb11.setFont(new Font("Arial", Font.PLAIN, 40));
            jb11.setName("rc3");
            jb11.setActionCommand("rc3");
            jb11.addActionListener(this);

            jb12.setBackground(buttonColor);
            jb12.setForeground(textColor);
            jb12.setFont(new Font("Arial", Font.PLAIN, 40));
            jb12.setName("rc4");
            jb12.setActionCommand("rc4");
            jb12.addActionListener(this);

            jb13.setBackground(buttonColor);
            jb13.setForeground(textColor);
            jb13.setFont(new Font("Arial", Font.PLAIN, 40));
            jb13.setName("rc5");
            jb13.setActionCommand("rc5");
            jb13.addActionListener(this);

            jb14.setBackground(buttonColor);
            jb14.setForeground(textColor);
            jb14.setFont(new Font("Arial", Font.PLAIN, 40));
            jb14.setName("rc6");
            jb14.setActionCommand("rc6");
            jb14.addActionListener(this);

            jb8.setBounds(COLUMN_ADJUST * 4, ROW_ADJUST * 1 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb8);

            jb9.setBounds(COLUMN_ADJUST * 4, ROW_ADJUST * 2 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb9);

            jb10.setBounds(COLUMN_ADJUST * 4, ROW_ADJUST * 3 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb10);

            jb11.setBounds(COLUMN_ADJUST * 4, ROW_ADJUST * 4 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb11);

            jb12.setBounds(COLUMN_ADJUST * 4, ROW_ADJUST * 5 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb12);

            jb13.setBounds(COLUMN_ADJUST * 4, ROW_ADJUST * 6 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb13);

            jb14.setBounds(COLUMN_ADJUST * 4, ROW_ADJUST * 7 - (50), OVAL_WIDTH, OVAL_HEIGHT);
            this.add(jb14);

            JButton singleChord = new JButton("Add/Remove chord");
            singleChord.setBackground(actionButtonColor);
            singleChord.setForeground(actionButtonTextColor);
            singleChord.setFont(new Font("Arial", Font.PLAIN, 20));
            singleChord.setName("singleChord");
            singleChord.setActionCommand("singleChord");
            singleChord.addActionListener(this);

            singleChord.setBounds(50, 560, 300, 25);
            this.add(singleChord);

            JButton doubleChord = new JButton("Add/Remove relationship");
            doubleChord.setBackground(actionButtonColor);
            doubleChord.setForeground(actionButtonTextColor);
            doubleChord.setFont(new Font("Arial", Font.PLAIN, 20));
            doubleChord.setName("doubleChord");
            doubleChord.setActionCommand("doubleChord");
            doubleChord.addActionListener(this);

            doubleChord.setBounds(50, 590, 300, 25);
            this.add(doubleChord);

            JLabel originLabel = new JLabel("Origin");
            originLabel.setForeground(textColor);
            originLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            originLabel.setBounds(75, 0, 100, 25);
            this.add(originLabel);

            JLabel destinationLabel = new JLabel("Destination");
            destinationLabel.setForeground(textColor);
            destinationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            destinationLabel.setBounds(250, 0, 100, 25);
            this.add(destinationLabel);

            frame.add(this);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setSize(400, 650);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        JButton jb = null;
        String name = "";

        jb = (JButton) obj;
        name = jb.getName();

        switch (name) {
            case "lc0":
                backUp = mostRecent;
                mostRecent = 0;
                lastSideUsed = 0;
                break;
            case "lc1":
                backUp = mostRecent;
                mostRecent = 1;
                lastSideUsed = 0;
                break;
            case "lc2":
                backUp = mostRecent;
                mostRecent = 2;
                lastSideUsed = 0;
                break;
            case "lc3":
                backUp = mostRecent;
                mostRecent = 3;
                lastSideUsed = 0;
                break;
            case "lc4":
                backUp = mostRecent;
                mostRecent = 4;
                lastSideUsed = 0;
                break;
            case "lc5":
                backUp = mostRecent;
                mostRecent = 5;
                lastSideUsed = 0;
                break;
            case "lc6":
                backUp = mostRecent;
                mostRecent = 6;
                lastSideUsed = 0;
                break;
            case "rc0":
                backUp = mostRecent;
                mostRecent = 0;
                lastSideUsed = 1;
                break;
            case "rc1":
                backUp = mostRecent;
                mostRecent = 1;
                lastSideUsed = 1;
                break;
            case "rc2":
                backUp = mostRecent;
                mostRecent = 2;
                lastSideUsed = 1;
                break;
            case "rc3":
                backUp = mostRecent;
                mostRecent = 3;
                lastSideUsed = 1;
                break;
            case "rc4":
                backUp = mostRecent;
                mostRecent = 4;
                lastSideUsed = 1;
                break;
            case "rc5":
                backUp = mostRecent;
                mostRecent = 5;
                lastSideUsed = 1;
                break;
            case "rc6":
                backUp = mostRecent;
                mostRecent = 6;
                lastSideUsed = 1;
                break;
            case "singleChord":
                updateColor();
                if (isActive[mostRecent]) {
                    isActive[mostRecent] = false;
                } else {
                    isActive[mostRecent] = true;
                }
                repaint();
                break;
            case "doubleChord":
                if (lastSideUsed == 1) {
                    boolean temp = this.canGoTo[backUp][mostRecent];
                    if (temp) {
                        this.canGoTo[backUp][mostRecent] = false;
                    } else {
                        this.canGoTo[backUp][mostRecent] = true;
                    }
                }
                repaint();
                break;

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(backgroundColor);
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(textColor);
        g2.setStroke(new BasicStroke(2));

        //lines
        for (int leftChord = 0; leftChord < 7; leftChord++) {
            for (int rightChord = 0; rightChord < 7; rightChord++) {
                if (this.canGoTo[leftChord][rightChord]) {
                    g2.drawLine(COLUMN_ADJUST + (OVAL_WIDTH), ROW_ADJUST * (leftChord + 1) - 25, COLUMN_ADJUST * 5 - (OVAL_WIDTH - 10), ROW_ADJUST * (rightChord + 1) - 25);
                }
            }
        }

        if(fillSquares){
            switch(roots[numNote]){
                case 1:
                    jb0.setBackground(textColor);
                    jb1.setBackground(buttonColor);
                    jb2.setBackground(buttonColor);
                    jb3.setBackground(buttonColor);
                    jb4.setBackground(buttonColor);
                    jb5.setBackground(buttonColor);
                    jb6.setBackground(buttonColor);
                    break;
                case 2:
                    jb0.setBackground(buttonColor);
                    jb1.setBackground(textColor);
                    jb2.setBackground(buttonColor);
                    jb3.setBackground(buttonColor);
                    jb4.setBackground(buttonColor);
                    jb5.setBackground(buttonColor);
                    jb6.setBackground(buttonColor);
                    break;
                case 3:
                    jb0.setBackground(buttonColor);
                    jb1.setBackground(buttonColor);
                    jb2.setBackground(textColor);
                    jb3.setBackground(buttonColor);
                    jb4.setBackground(buttonColor);
                    jb5.setBackground(buttonColor);
                    jb6.setBackground(buttonColor);
                    break;
                case 4:
                    jb0.setBackground(buttonColor);
                    jb1.setBackground(buttonColor);
                    jb2.setBackground(buttonColor);
                    jb3.setBackground(textColor);
                    jb4.setBackground(buttonColor);
                    jb5.setBackground(buttonColor);
                    jb6.setBackground(buttonColor);
                    break;
                case 5:
                    jb0.setBackground(buttonColor);
                    jb1.setBackground(buttonColor);
                    jb2.setBackground(buttonColor);
                    jb3.setBackground(buttonColor);
                    jb4.setBackground(textColor);
                    jb5.setBackground(buttonColor);
                    jb6.setBackground(buttonColor);
                    break;
                case 6:
                    jb0.setBackground(buttonColor);
                    jb1.setBackground(buttonColor);
                    jb2.setBackground(buttonColor);
                    jb3.setBackground(buttonColor);
                    jb4.setBackground(buttonColor);
                    jb5.setBackground(textColor);
                    break;
                case 7:
                    jb0.setBackground(buttonColor);
                    jb1.setBackground(buttonColor);
                    jb2.setBackground(buttonColor);
                    jb3.setBackground(buttonColor);
                    jb4.setBackground(buttonColor);
                    jb5.setBackground(textColor);
                    jb6.setBackground(buttonColor);
                    break;
            }
        }
        numNote++;
    }

    void updateColor() {
        switch (mostRecent) {
            case 0:
                if (isActive[0]) {
                    jb0.setBackground(Color.GRAY);
                    jb8.setBackground(Color.GRAY);
                } else {
                    jb0.setBackground(buttonColor);
                    jb8.setBackground(buttonColor);
                }
                break;
            case 1:
                if (isActive[1]) {
                    jb1.setBackground(Color.GRAY);
                    jb9.setBackground(Color.GRAY);
                } else {
                    jb1.setBackground(buttonColor);
                    jb9.setBackground(buttonColor);
                }
                break;
            case 2:
                if (isActive[2]) {
                    jb2.setBackground(Color.GRAY);
                    jb10.setBackground(Color.GRAY);
                } else {
                    jb2.setBackground(buttonColor);
                    jb10.setBackground(buttonColor);
                }
                break;
            case 3:
                if (isActive[3]) {
                    jb3.setBackground(Color.GRAY);
                    jb11.setBackground(Color.GRAY);
                } else {
                    jb3.setBackground(buttonColor);
                    jb11.setBackground(buttonColor);
                }
                break;
            case 4:
                if (isActive[4]) {
                    jb4.setBackground(Color.GRAY);
                    jb12.setBackground(Color.GRAY);
                } else {
                    jb4.setBackground(buttonColor);
                    jb12.setBackground(buttonColor);
                }
                break;
            case 5:
                if (isActive[5]) {
                    jb5.setBackground(Color.GRAY);
                    jb13.setBackground(Color.GRAY);
                } else {
                    jb5.setBackground(buttonColor);
                    jb13.setBackground(buttonColor);
                }
                break;
            case 6:
                if (isActive[6]) {
                    jb6.setBackground(Color.GRAY);
                    jb14.setBackground(Color.GRAY);
                } else {
                    jb6.setBackground(buttonColor);
                    jb14.setBackground(buttonColor);
                }
                break;
        }

    }
}