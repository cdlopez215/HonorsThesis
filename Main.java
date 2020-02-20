/**
 * Christian Lopez
 * Dhantin Kumar
 * Spring 2020
 *
 * Tempo, note lengths
 *
 * Elaborate styles
 * Different voices
 * Fix console printing in Transposition.java
 *
 * Remove keys not in user selected key
 * Maybe add a start button and variable number of chords?
 */

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;

public class Main {
    Random random = new Random();
    App window = new App();
    Piano keyboard = new Piano();
    Chord currentChord, nextChord = new Chord();
    int currentNote, nextNote;
    Chord[] chords = new Chord[8];
    String style = "Classical";
    long timeDelay = 1;
    Transposition transpose = new Transposition();
    int timeVar;

    List<MediaPlayer> players = new ArrayList<MediaPlayer>();
    ArrayList<List<MediaPlayer>> queue = new ArrayList<List<MediaPlayer>>();

    final JFXPanel fxPanel = new JFXPanel();

    public static void main(String[] args) {
        Main object = new Main();
        object.buildChords();
        //object.generateString();
        object.generateStringFromInput();
    }

    //Chord object
    final class Chord {
        private int state = 3;
        private int root = 3;
        private int third = 5;
        private int fifth = 7;
        private boolean[] canGoTo = new boolean[8];

        public void playChord() {
            players = new ArrayList<MediaPlayer>();

            System.out.println("\n");
            playSound(root);
            System.out.print(" ");
            playSound(third);
            System.out.print(" ");
            playSound(fifth);
            System.out.println();
            playMelody(currentNote);

            /** for(MediaPlayer mp : players){
                mp.play();
            } **/

            queue.add(players);
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
        fifthChord.fifth = 2;

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
                chords[2].canGoTo[1] = true;
                chords[2].canGoTo[3] = true;
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
                chords[2].canGoTo[1] = true;
                chords[2].canGoTo[3] = true;
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
            //change current chord - maybe add return value Chord?
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

    public void changeTempo(int time){
        timeDelay = time;
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

    public void generateStringFromInput(){
        while(true) {
            while (!Piano.entered) {
                sleep();
            }

            currentNote = Piano.notesEntered[0];
            nextNote = Piano.notesEntered[1];

            switch (currentNote) {
                case 1:
                    currentChord = chords[5];
                    break;
                case 2:
                    currentChord = chords[1];
                    break;
                case 3:
                    currentChord = chords[2];
                    break;
                case 4:
                    currentChord = chords[3];
                    break;
                case 5:
                    currentChord = chords[2];
                    break;
                case 6:
                    currentChord = chords[5];
                    break;
                case 7:
                    currentChord = chords[2];
                    break;
            }

            for (int i = 0; i < 8; i++) {
                currentNote = Piano.notesEntered[i];

                if (i < 7) {
                    nextNote = Piano.notesEntered[i + 1];
                } else if (i == 7) {
                    if (currentNote == 0 || currentNote == 2 || currentNote == 4) {
                        currentChord = chords[0];
                    } else {
                        System.out.println("\n***********");
                        resolve();
                        i = 8;
                    }
                }

                boolean nextBool = checkNextChord(currentChord, nextNote);

                if (nextBool) {
                    currentChord.playChord();
                    currentChord = nextChord;
                } else {
                    currentChord.playChord();
                    System.out.println();
                    addSingleNote(nextNote);

                    //to find next next chord
                    if (i < 6) {
                        nextNote = Piano.notesEntered[i + 2];
                    } else {
                        //break
                    }

                    boolean nextNextBool = checkNextChord(currentChord, nextNote);
                    if (!nextNextBool) {
                        addSingleNote(nextNote);

                        //to find next next NEXT chord
                        boolean nextNextNextBool = checkNextChord(currentChord, nextNote);
                        if (!nextNextNextBool) {
                            if (i == 6) {
                                System.out.println("\n***********");
                                resolve();
                                i = 8;
                            } else {
                                System.out.println("\nNo string creatable");
                            }
                        }
                        i++;
                    } else {
                        currentChord = nextChord;
                    }
                    i++;
                }
            }

            playQueue();

            while(Piano.entered){
                sleep();
            }
        }
    }

    public void playQueue(){
        timeVar = Piano.timeVar / 60;

        for(int i = 0; i < queue.size(); i++){
            for(MediaPlayer mp : queue.get(i)){
                mp.play();
            }
            sleep(i);
        }
    }

    public void resolve(){
        int rand = 0;
        boolean next = false;

        while(!next) {
            rand = random.nextInt(chords.length);
            next = currentChord.canGoTo[rand];
        }

        currentChord = chords[rand];
        currentNote = currentChord.root;
        currentChord.playChord();
        if(currentChord != chords[0]){
            resolve();
        } else {
            return;
        }
    }

    public boolean checkNextChord(Chord current, int next){
        int rand = 0;
        boolean returnValue = false;
        int chordsPossible = 0;
        Chord[] nextValues = new Chord[7];

        for(int i = 1; i < 8; i++){
            boolean checkChord = current.canGoTo[i];
            if(checkChord){

                if(chords[i].root == next || chords[i].third == next || chords[i].fifth == next){
                    returnValue = true;
                    nextValues[chordsPossible] = chords[i];
                    chordsPossible++;
                }
            }
        }

        if(returnValue) {
            rand = random.nextInt(chordsPossible);
            nextChord = nextValues[rand];
        }

        return returnValue;
    }

    public void playMelody(int note){
        String noteName;

        noteName = transpose.findMelodyNoteName(note);
        try {
            String bip = noteName + ".mp3";
            Media hit = new Media(new File(bip).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.setVolume(100);

            players.add(mediaPlayer);

            //mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Calls individual methods for playing sound files
    void playSound(int note) {

        String noteName = transpose.findNoteName(note);
        try {
            String bip = noteName + ".mp3";
            Media hit = new Media(new File(bip).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.setVolume(50);

            players.add(mediaPlayer);

            //mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addSingleNote(int next){
        String noteName = transpose.findNoteName(next);
        players = new ArrayList<MediaPlayer>();

        try {
            String bip = noteName + ".mp3";
            Media hit = new Media(new File(bip).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.setVolume(75);
            players.add(mediaPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        queue.add(players);
    }

    void error() {
        System.out.print("ERROR");
    }

    void sleep(int index) {
        try {
            if(index == 0 || index == queue.size()){
                timeDelay = timeVar * 500;
            } else if (index != queue.size()-1 && queue.get(index + 1).size() == 1){
                if(index != queue.size()-2 && queue.get(index + 2).size() == 1){
                    timeDelay = timeVar * 250;
                } else {
                    timeDelay = timeVar * 375;
                }
            } else if (queue.get(index).size() == 1){
                timeDelay = timeVar * 125;
            } else {
                timeDelay = timeVar * 500;
            }

            TimeUnit.MILLISECONDS.sleep(timeDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
