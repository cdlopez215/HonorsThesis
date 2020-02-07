/**
 * Christian Lopez
 * Dhantin Kumar
 * Spring 2020
 */

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    int FIRST_ROW_OFFSET;
    int SECOND_ROW_OFFSET;
    int THIRD_ROW_OFFSET;
    int FOURTH_ROW_OFFSET;

    int FIRST_COLUMN_OFFSET;
    int SECOND_COLUMN_OFFSET;
    int THIRD_COLUMN_OFFSET;
    int FOURTH_COLUMN_OFFSET;

    int OVAL_WIDTH = 75;
    int OVAL_HEIGHT = 75;
    int STRING_ADJUST = OVAL_WIDTH / 2;

    int chord;

    public App(String title, int width, int height) {
        createWindow(title, width, height);
    }

    public void createWindow(String title, int width, int height) {
        setTitle(title);
        setVisible(true);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FIRST_ROW_OFFSET = height / 5;
        SECOND_ROW_OFFSET = height / 5 * 2;
        THIRD_ROW_OFFSET = height / 5 * 3;
        FOURTH_ROW_OFFSET = height / 5 * 4;

        FIRST_COLUMN_OFFSET = width / 5;
        SECOND_COLUMN_OFFSET = width / 5 * 2;
        THIRD_COLUMN_OFFSET = width / 5 * 3;
        FOURTH_COLUMN_OFFSET = width / 5 * 4;

        setTitle(title);
        setVisible(true);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {

        super.paint(g);
        g.setColor(Color.GRAY);
        super.paint(g);

        g.setColor(Color.GRAY);
        g.fillOval(SECOND_COLUMN_OFFSET, FIRST_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
        g.fillOval(SECOND_COLUMN_OFFSET, SECOND_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
        g.fillOval(FIRST_COLUMN_OFFSET, THIRD_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
        g.fillOval(THIRD_COLUMN_OFFSET, THIRD_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
        g.fillOval(FOURTH_COLUMN_OFFSET, THIRD_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
        g.fillOval(SECOND_COLUMN_OFFSET, FOURTH_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
        g.fillOval(FOURTH_COLUMN_OFFSET, FOURTH_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);

        //should change to individual string variables, get width of each string and adjust accordingly
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("ii", SECOND_COLUMN_OFFSET + STRING_ADJUST - 10, FIRST_ROW_OFFSET + STRING_ADJUST + 12);
        g.drawString("vi", SECOND_COLUMN_OFFSET + STRING_ADJUST - 14, SECOND_ROW_OFFSET + STRING_ADJUST + 12);
        g.drawString("iii", FIRST_COLUMN_OFFSET + STRING_ADJUST - 13, THIRD_ROW_OFFSET + STRING_ADJUST + 12);
        g.drawString("V", THIRD_COLUMN_OFFSET + STRING_ADJUST - 11, THIRD_ROW_OFFSET + STRING_ADJUST + 12);
        g.drawString("vii", FOURTH_COLUMN_OFFSET + STRING_ADJUST - 17, THIRD_ROW_OFFSET + STRING_ADJUST + 12);
        g.drawString("IV", SECOND_COLUMN_OFFSET + STRING_ADJUST - 14, FOURTH_ROW_OFFSET + STRING_ADJUST + 12);
        g.drawString("I", FOURTH_COLUMN_OFFSET + STRING_ADJUST - 5, FOURTH_ROW_OFFSET + STRING_ADJUST + 12);

        g.setColor(Color.GRAY);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, FIRST_ROW_OFFSET + OVAL_HEIGHT, THIRD_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, FIRST_ROW_OFFSET + OVAL_HEIGHT, FOURTH_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, FIRST_ROW_OFFSET + OVAL_HEIGHT, FIRST_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, FIRST_ROW_OFFSET + OVAL_HEIGHT, SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, SECOND_ROW_OFFSET);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, FIRST_ROW_OFFSET + OVAL_HEIGHT, FIRST_COLUMN_OFFSET - OVAL_WIDTH / 2, THIRD_ROW_OFFSET + OVAL_HEIGHT / 2);
        g.drawLine(FIRST_COLUMN_OFFSET - OVAL_WIDTH / 2, THIRD_ROW_OFFSET + OVAL_HEIGHT / 2, SECOND_COLUMN_OFFSET, FOURTH_ROW_OFFSET + OVAL_HEIGHT / 2);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, SECOND_ROW_OFFSET + OVAL_HEIGHT, FIRST_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, SECOND_ROW_OFFSET + OVAL_HEIGHT, THIRD_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, SECOND_ROW_OFFSET + OVAL_HEIGHT, FOURTH_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, SECOND_ROW_OFFSET + OVAL_HEIGHT, SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, FOURTH_ROW_OFFSET);
        g.drawLine(FIRST_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET + OVAL_HEIGHT, SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, FOURTH_ROW_OFFSET);
        g.drawLine(THIRD_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET + OVAL_HEIGHT, SECOND_COLUMN_OFFSET + OVAL_WIDTH / 2, FOURTH_ROW_OFFSET);
        g.drawLine(THIRD_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET + OVAL_HEIGHT, FOURTH_COLUMN_OFFSET + OVAL_WIDTH / 2, FOURTH_ROW_OFFSET);
        g.drawLine(FOURTH_COLUMN_OFFSET + OVAL_WIDTH / 2, THIRD_ROW_OFFSET + OVAL_HEIGHT, FOURTH_COLUMN_OFFSET + OVAL_WIDTH / 2, FOURTH_ROW_OFFSET);
        g.drawLine(SECOND_COLUMN_OFFSET + OVAL_WIDTH, FOURTH_ROW_OFFSET + OVAL_HEIGHT / 2, FOURTH_COLUMN_OFFSET, FOURTH_ROW_OFFSET + OVAL_HEIGHT / 2);

        //Changes current chord to blue
        g.setColor(Color.BLUE);
        switch (chord) {
            case 1:
                g.fillOval(FOURTH_COLUMN_OFFSET, FOURTH_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
                break;
            case 2:
                g.fillOval(SECOND_COLUMN_OFFSET, FIRST_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
                break;
            case 3:
                g.fillOval(FIRST_COLUMN_OFFSET, THIRD_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
                break;
            case 4:
                g.fillOval(SECOND_COLUMN_OFFSET, FOURTH_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
                break;
            case 5:
                g.fillOval(THIRD_COLUMN_OFFSET, THIRD_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
                break;
            case 6:
                g.fillOval(SECOND_COLUMN_OFFSET, SECOND_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
                break;
            case 7:
                g.fillOval(FOURTH_COLUMN_OFFSET, THIRD_ROW_OFFSET, OVAL_WIDTH, OVAL_HEIGHT);
                break;
            default:
                break;
        }
    }
}