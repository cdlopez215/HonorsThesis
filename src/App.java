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
            this.setForeground(Color.WHITE);
            this.setBackground(Color.GRAY);
            this.add(Box.createRigidArea(new Dimension(0, 10)));

            //chords on left
            jb0.setBackground(Color.BLACK);
            jb0.setName("lc0");
            jb0.setActionCommand("lc0");
            jb0.addActionListener(this);

            jb1.setBackground(Color.BLACK);
            jb1.setName("lc1");
            jb1.setActionCommand("lc1");
            jb1.addActionListener(this);

            jb2.setBackground(Color.BLACK);
            jb2.setName("lc2");
            jb2.setActionCommand("lc2");
            jb2.addActionListener(this);

            jb3.setBackground(Color.BLACK);
            jb3.setName("lc3");
            jb3.setActionCommand("lc3");
            jb3.addActionListener(this);

            jb4.setBackground(Color.BLACK);
            jb4.setName("lc4");
            jb4.setActionCommand("lc4");
            jb4.addActionListener(this);

            jb5.setBackground(Color.BLACK);
            jb5.setName("lc5");
            jb5.setActionCommand("lc5");
            jb5.addActionListener(this);

            jb6.setBackground(Color.BLACK);
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
            jb8.setBackground(Color.BLACK);
            jb8.setName("rc0");
            jb8.setActionCommand("rc0");
            jb8.addActionListener(this);

            jb9.setBackground(Color.BLACK);
            jb9.setName("rc1");
            jb9.setActionCommand("rc1");
            jb9.addActionListener(this);

            jb10.setBackground(Color.BLACK);
            jb10.setName("rc2");
            jb10.setActionCommand("rc2");
            jb10.addActionListener(this);

            jb11.setBackground(Color.BLACK);
            jb11.setName("rc3");
            jb11.setActionCommand("rc3");
            jb11.addActionListener(this);

            jb12.setBackground(Color.BLACK);
            jb12.setName("rc4");
            jb12.setActionCommand("rc4");
            jb12.addActionListener(this);

            jb13.setBackground(Color.BLACK);
            jb13.setName("rc5");
            jb13.setActionCommand("rc5");
            jb13.addActionListener(this);

            jb14.setBackground(Color.BLACK);
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
            singleChord.setBackground(Color.BLACK);
            singleChord.setName("singleChord");
            singleChord.setActionCommand("singleChord");
            singleChord.addActionListener(this);

            singleChord.setBounds(100, 560, 200, 25);
            this.add(singleChord);

            JButton doubleChord = new JButton("Add/Remove relationship");
            doubleChord.setBackground(Color.BLACK);
            doubleChord.setName("doubleChord");
            doubleChord.setActionCommand("doubleChord");
            doubleChord.addActionListener(this);

            doubleChord.setBounds(100, 590, 200, 25);
            this.add(doubleChord);

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
                    boolean temp = canGoTo[backUp][mostRecent];
                    if (temp) {
                        canGoTo[backUp][mostRecent] = false;
                    } else {
                        canGoTo[backUp][mostRecent] = true;
                    }
                }
                repaint();
                break;

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));

        //lines
        for (int leftChord = 0; leftChord < 7; leftChord++) {
            for (int rightChord = 0; rightChord < 7; rightChord++) {
                if (canGoTo[leftChord][rightChord]) {
                    g2.drawLine(COLUMN_ADJUST + (OVAL_WIDTH), ROW_ADJUST * (leftChord + 1) - 25, COLUMN_ADJUST * 5 - (OVAL_WIDTH - 10), ROW_ADJUST * (rightChord + 1) - 25);
                }
            }
        }
    }

    void updateColor() {
        switch (mostRecent) {
            case 0:
                if (isActive[0]) {
                    jb0.setBackground(Color.GRAY);
                    jb8.setBackground(Color.GRAY);
                } else {
                    jb0.setBackground(Color.BLACK);
                    jb8.setBackground(Color.BLACK);
                }
                break;
            case 1:
                if (isActive[1]) {
                    jb1.setBackground(Color.GRAY);
                    jb9.setBackground(Color.GRAY);
                } else {
                    jb1.setBackground(Color.BLACK);
                    jb9.setBackground(Color.BLACK);
                }
                break;
            case 2:
                if (isActive[2]) {
                    jb2.setBackground(Color.GRAY);
                    jb10.setBackground(Color.GRAY);
                } else {
                    jb2.setBackground(Color.BLACK);
                    jb10.setBackground(Color.BLACK);
                }
                break;
            case 3:
                if (isActive[3]) {
                    jb3.setBackground(Color.GRAY);
                    jb11.setBackground(Color.GRAY);
                } else {
                    jb3.setBackground(Color.BLACK);
                    jb11.setBackground(Color.BLACK);
                }
                break;
            case 4:
                if (isActive[4]) {
                    jb4.setBackground(Color.GRAY);
                    jb12.setBackground(Color.GRAY);
                } else {
                    jb4.setBackground(Color.BLACK);
                    jb12.setBackground(Color.BLACK);
                }
                break;
            case 5:
                if (isActive[5]) {
                    jb5.setBackground(Color.GRAY);
                    jb13.setBackground(Color.GRAY);
                } else {
                    jb5.setBackground(Color.BLACK);
                    jb13.setBackground(Color.BLACK);
                }
                break;
            case 6:
                if (isActive[6]) {
                    jb6.setBackground(Color.GRAY);
                    jb14.setBackground(Color.GRAY);
                } else {
                    jb6.setBackground(Color.BLACK);
                    jb14.setBackground(Color.BLACK);
                }
                break;
        }

    }
}