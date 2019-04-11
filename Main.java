import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    static int state;

    public static void main(String[] args) {
        Random random = new Random();
        state = random.nextInt(7) + 1;

        generateString(state);
    }

    public static void generateString(int state) {
        Random random = new Random();
        int nextState;

        switch (state) {
            case 1:
                playC();
                playE();
                playG();
                sleep();
                break;
            case 2:
                playD();
                playF();
                playA();
                sleep();
                nextState = random.nextInt(2) + 1;
                if (nextState == 1) {
                    generateString(3);
                } else if (nextState == 2) {
                    generateString(5);
                } else {
                    error();
                }
                break;
            case 3:
                playE();
                playG();
                playB();
                sleep();
                nextState = random.nextInt(2) + 1;
                if (nextState == 1) {
                    generateString(2);
                } else if (nextState == 2) {
                    generateString(4);
                } else {
                    error();
                }
                break;
            case 4:
                playF();
                playA();
                playC();
                sleep();
                nextState = random.nextInt(4) + 1;
                if (nextState == 1) {
                    generateString(1);
                } else if (nextState == 2) {
                    generateString(2);
                } else if (nextState == 3) {
                    generateString(3);
                } else if (nextState == 4) {
                    generateString(5);
                } else {
                    error();
                }
                break;
            case 5:
                playG();
                playB();
                playD();
                sleep();
                nextState = random.nextInt(2) + 1;
                if (nextState == 1) {
                    generateString(1);
                } else if (nextState == 2) {
                    generateString(6);
                } else {
                    error();
                }
                break;
            case 6:
                playA();
                playC();
                playE();
                sleep();
                nextState = random.nextInt(3) + 1;
                if (nextState == 1) {
                    generateString(2);
                } else if (nextState == 2) {
                    generateString(4);
                } else if (nextState == 3) {
                    generateString(5);
                } else {
                    error();
                }
                break;
            case 7:
                playB();
                playD();
                playF();
                sleep();
                nextState = random.nextInt(2) + 1;
                if(nextState == 1){
                    generateString(1);
                } else if (nextState == 2){
                    generateString(3);
                } else{
                    error();
                }
                break;
        }
    }

    static void playA(){
        System.out.println("A");
        String note = "A";
        playSound(note);
    }
    static void playB(){
        System.out.println("B");
        String note = "B";
        playSound(note);
    }
    static void playC(){
        System.out.println("C");
        String note = "C";
        playSound(note);
    }
    static void playD(){
        System.out.println("D");
        String note = "D";
        playSound(note);
    }
    static void playE(){
        System.out.println("E");
        String note = "E";
        playSound(note);
    }
    static void playF(){
        System.out.println("F");
        String note = "F";
        playSound(note);
    }
    static void playG(){
        System.out.println("G");
        String note = "G";
        playSound(note);
    }

    static void error(){
        System.out.println("ERROR");
    }

    static void sleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    static void playSound(String note){
        try {
            File soundFile = new File("C:\\Users\\Christian\\IdeaProjects\\BonusProject\\src\\" + note + ".wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (IOException e){
            e.printStackTrace();
        } catch (LineUnavailableException e){
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }
}
