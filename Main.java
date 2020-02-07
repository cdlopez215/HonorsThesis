/**
 * Christian Lopez
 * Dhantin Kumar
 * Spring 2020
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class Main {
    Random random = new Random();
    App window = new App("Thesis", 600, 600);
    Chord currentChord = new Chord();
    Chord[] chords = new Chord[8];
    String style = "Classical";

    public static void main(String[] args) {
        Main object = new Main();
        object.buildChords();
        object.generateString();
        object.listenToMic();
    }

    //Chord object
    final class Chord {
        private int state = 3;
        private int root = 3;
        private int third = 5;
        private int fifth = 7;
        private boolean[] canGoTo = new boolean[8];

        public void playChord() {
            playSound(root);
            playSound(third);
            playSound(fifth);
            sleep();
        }
    }

    //create all chords and store in chords[]
    public void buildChords(){
        Chord firstChord = new Chord();
        firstChord.state = 1;
        firstChord.root = 1;
        firstChord.third = 3;
        firstChord.fifth = 5;

        Chord secondChord = new Chord();
        secondChord.state = 2;
        secondChord.root = 2;
        secondChord.third = 4;
        secondChord.fifth = 6;

        Chord thirdChord = new Chord();
        thirdChord.state = 3;
        thirdChord.root = 3;
        thirdChord.third = 5;
        thirdChord.fifth = 7;

        Chord fourthChord = new Chord();
        fourthChord.state = 4;
        fourthChord.root = 4;
        fourthChord.third = 6;
        fourthChord.fifth = 1;

        Chord fifthChord = new Chord();
        fifthChord.state = 5;
        fifthChord.root = 5;
        fifthChord.third = 7;
        fifthChord.fifth = 1;

        Chord sixthChord = new Chord();
        sixthChord.state = 6;
        sixthChord.root = 6;
        sixthChord.third = 1;
        sixthChord.fifth = 3;
        
        Chord seventhChord = new Chord();
        seventhChord.state = 7;
        seventhChord.root = 7;
        seventhChord.third = 2;
        seventhChord.fifth = 4;

        currentChord = thirdChord;
        chords[0] = firstChord;
        chords[1] = secondChord;
        chords[2] = thirdChord;
        chords[3] = fourthChord;
        chords[4] = fifthChord;
        chords[5] = sixthChord;
        chords[6] = seventhChord;

        adjustChords();
    }

    //define relationships
    public void adjustChords(){
        switch(style) {
            case "Classical":
                currentChord = chords[2];
                chords[1].canGoTo[4] = true;
                chords[1].canGoTo[6] = true;
                chords[2].canGoTo[5] = true;
                chords[3].canGoTo[4] = true;
                chords[3].canGoTo[6] = true;
                chords[4].canGoTo[0] = true;
                chords[4].canGoTo[2] = true;
                chords[5].canGoTo[1] = true;
                chords[5].canGoTo[3] = true;
                chords[6].canGoTo[0] = true;
                chords[6].canGoTo[2] = true;
                break;
            case "ClassicalMinor":
                currentChord = chords[2];
                chords[1].canGoTo[4] = true;
                chords[1].canGoTo[6] = true;
                chords[2].canGoTo[5] = true;
                chords[3].canGoTo[4] = true;
                chords[3].canGoTo[6] = true;
                chords[4].canGoTo[0] = true;
                chords[4].canGoTo[2] = true;
                chords[5].canGoTo[1] = true;
                chords[5].canGoTo[3] = true;
                //chords[6].canGoTo[0] = true;
                chords[6].canGoTo[2] = true;
                //gotta edit sounds to add minors
                break;
            case "Jazz":
                currentChord = chords[2];
                chords[2].canGoTo[5] = true;
                chords[5].canGoTo[1] = true;
                chords[1].canGoTo[4] = true;
                chords[4].canGoTo[0] = true;
                break;
            case "Blues":
                currentChord = chords[0];
                chords[0].canGoTo[3] = true;
                chords[3].canGoTo[0] = true;
                chords[0].canGoTo[4] = true;
                chords[4].canGoTo[3] = true;
                chords[4].canGoTo[0] = true;
                break;
            default:
                break;
        }
    }

    public void addRule(Chord originChord, int destChord){
        boolean temp = chords[originChord.root].canGoTo[destChord];

        if(!temp) {
            chords[originChord.root].canGoTo[destChord] = true;
        } else {
            //error
        }
    }

    public void removeRule(Chord originChord, int destChord){
        boolean temp = chords[originChord.root].canGoTo[destChord];

        if(temp) {
            chords[originChord.root].canGoTo[destChord] = false;
        } else {
            //error
        }
    }

    public void removeChord(Chord chord){
        for(int i = 0; i < chords.length; i++){
            chords[i].canGoTo[chord.root] = false;
        }
    }

    public void addChord(Chord chord){
        for(int i = 0; i < chords.length; i++){
            chords[i].canGoTo[chord.root] = false;
        }
    }

    public void listenToMic(){

        AudioFormat format = new AudioFormat(44100, 16, 2, true, true);

        DataLine.Info targetInfo = new DataLine.Info(TargetDataLine.class, format);
        DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class, format);

        try {
            TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
            targetLine.open(format);
            targetLine.start();

            SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(sourceInfo);
            sourceLine.open(format);
            sourceLine.start();

            int numBytesRead;
            byte[] targetData = new byte[targetLine.getBufferSize() / 5];

            while (true) {
                numBytesRead = targetLine.read(targetData, 0, targetData.length);

                if (numBytesRead == -1)	break;

                sourceLine.write(targetData, 0, numBytesRead);
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void generateString(){
        int rand = 0;
        do{

            window.chord = currentChord.state;
            window.repaint();
            currentChord.playChord();

            boolean next = false;
            while(!next) {
                rand = random.nextInt(chords.length);
                next = currentChord.canGoTo[rand];
            }
            currentChord = chords[rand];
        }while(currentChord.state != 1);

        window.chord = currentChord.state;
        window.repaint();
        currentChord.playChord();
    }

    //Calls individual methods for playing sound files
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

    //Individual methods for each sound file
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

    void playBb() {
        System.out.println("Bb");
        String note = "Bb";
        playFile(note);
    }

    void playC() {
        System.out.println("C");
        String note = "C";
        playFile(note);
    }

    void playCs() {
        System.out.println("C#");
        String note = "C#";
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

    void playEb() {
        System.out.println("Eb");
        String note = "Eb";
        playFile(note);
    }

    void playF() {
        System.out.println("F");
        String note = "F";
        playFile(note);
    }

    void playFs() {
        System.out.println("F#");
        String note = "F#";
        playFile(note);
    }

    void playG() {
        System.out.println("G");
        String note = "G";
        playFile(note);
    }

    void playGs() {
        System.out.println("G#");
        String note = "G#";
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

    //Actually plays sound files
    void playFile(String note) {
        if(style == "ClassicalMinor"){
            switch(note){
                case "E":
                    note = "Eb";
                    break;
                case "A":
                    note = "G#";
                    break;
                case "B":
                    note = "Bb";
                    break;
                default:
                    break;
            }
        } else if (style == "Jazz" && currentChord == chords[2]){
            switch(note) {
                case "G":
                    note = "F#";
                    break;
            }
        }
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(this.getClass().getResource(note + ".wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
