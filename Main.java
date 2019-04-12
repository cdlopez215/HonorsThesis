import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    Chord chord = new Chord();

    public static void main(String[] args) {
        Main object = new Main();
        object.generateString(3);
    }

    final class Chord {
        private int state = 3;
        private int root = 3;
        private int third = 5;
        private int fifth = 7;

        public void playChord() {
            playSound(root);
            playSound(third);
            playSound(fifth);
            sleep();
        }
    }

    public void generateString(int state) {
        Random random = new Random();
        int nextState;
        System.out.println();

        switch (state) {
            case 1:
                chord.playChord();
                break;
            case 2:
                chord.playChord();
                nextState = random.nextInt(2) + 1;
                if (nextState == 1) {
                    assignState(3);
                    generateString(chord.state);
                } else if (nextState == 2) {
                    assignState(5);
                    generateString(chord.state);
                } else {
                    error();
                }
                break;
            case 3:
                chord.playChord();
                nextState = random.nextInt(3) + 1;
                if (nextState == 1) {
                    assignState(2);
                    generateString(chord.state);
                } else if (nextState == 2) {
                    assignState(4);
                    generateString(chord.state);
                } else if (nextState == 3) {
                    assignState(6);
                    generateString(chord.state);
                } else {
                    error();
                }
                break;
            case 4:
                chord.playChord();
                nextState = random.nextInt(4) + 1;
                if (nextState == 1) {
                    assignState(1);
                    generateString(chord.state);
                } else if (nextState == 2) {
                    assignState(2);
                    generateString(chord.state);
                } else if (nextState == 3) {
                    assignState(3);
                    generateString(chord.state);
                } else if (nextState == 4) {
                    assignState(5);
                    generateString(chord.state);
                } else {
                    error();
                }
                break;
            case 5:
                chord.playChord();
                assignState(1);
                generateString(chord.state);
                break;
            case 6:
                chord.playChord();
                nextState = random.nextInt(2) + 1;
                if (nextState == 1) {
                    assignState(2);
                    generateString(chord.state);
                } else if (nextState == 2) {
                    assignState(4);
                    generateString(chord.state);
                } else {
                    error();
                }
                break;
            case 7:
                chord.playChord();
                nextState = random.nextInt(2) + 1;
                if (nextState == 1) {
                    assignState(1);
                    generateString(chord.state);
                } else if (nextState == 2) {
                    assignState(3);
                    generateString(chord.state);
                } else {
                    error();
                }
                break;
        }
    }

    void assignState(int state) {
        chord.state = state;
        chord.root = state;
        if (state <= 5) {
            chord.third = state + 2;
        } else {
            chord.third = state - 5;
        }

        if (state <= 3) {
            chord.fifth = state + 4;
        } else {
            chord.fifth = state - 3;
        }
    }

    void playSound(int note) {
        switch (note) {
            case 1:
                playC();
                break;
            case 2:
                playD();
                break;
            case 3:
                playE();
                break;
            case 4:
                playF();
                break;
            case 5:
                playG();
                break;
            case 6:
                playA();
                break;
            case 7:
                playB();
                break;
        }
    }

    void playA() {
        System.out.println("A");
        String note = "A";
        playFile(note);
    }

    void playB() {
        System.out.println("B");
        String note = "B";
        playFile(note);
    }

    void playC() {
        System.out.println("C");
        String note = "C";
        playFile(note);
    }

    void playD() {
        System.out.println("D");
        String note = "D";
        playFile(note);
    }

    void playE() {
        System.out.println("E");
        String note = "E";
        playFile(note);
    }

    void playF() {
        System.out.println("F");
        String note = "F";
        playFile(note);
    }

    void playG() {
        System.out.println("G");
        String note = "G";
        playFile(note);
    }

    void error() {
        System.out.println("ERROR");
    }

    void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void playFile(String note) {
        try {
            File soundFile = new File("C:\\Users\\Christian\\IdeaProjects\\BonusProject\\src\\" + note + ".wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
