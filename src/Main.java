package src;

/**
 * Christian Lopez
 * Dhantin Kumar
 * Spring 2020
 *
 * Elaborate styles
 * Different voices
 *
 */

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;

public class Main {

    //variable declaration
    Random random = new Random();
    App window = new App();
    Chord currentChord, nextChord = new Chord();
    //Piano keyboard = new Piano();

    int currentNote, nextNote;
    Chord[] chords = new Chord[7];
    long timeDelay = 1;
    Transposition transpose = new Transposition();
    int timeVar;
    int numPass = 0;
    int[] roots = new int[100];
    int numNotes = 0;

    static List<Clip> players = new ArrayList<Clip>();
    ArrayList<List<Clip>> queue = new ArrayList<List<Clip>>();

    /**
     * Contains information about notes in chord, which group of chords each is able to go to
     * Contains playChord() method that doesn't actually make sound
     * playChord() creates mediaPlayers for each note in the chord, adds the mediaPlayers to an ArrayList,
     * and adds that ArrayList to another ArrayList ("queue") for playback without delay
     */
    final class Chord {
        private int state = 3;
        private int root = 3;
        private int third = 5;
        private int fifth = 7;
        private boolean isActive = true;
        private boolean[] canGoTo = new boolean[8];

        public void playChord() {
            players = new ArrayList<Clip>();

            if(numNotes < 100) {
                roots[numNotes] = root;
                numNotes++;
            }

            System.out.println("\n");
            playSound(root);
            System.out.print(" ");
            playSound(third);
            System.out.print(" ");
            playSound(fifth);
            System.out.println();
            //playMelody(currentNote);

            queue.add(players);
        }
    }

    /**
     * Builds chords[], an array of the 8 chords present in each key
     * Each index of chords[] is a single chord with 4 notes defined - root, third, fifth, and state (the melody note, not always the root)
     *
     * chords[] remains unchanged regardless of key
     * Transpositions are considered in Transposition.java
     */
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

    /**
     * Define relationships between each key
     * These are the templates or presets users can choose from
     */
    public void adjustChords(){
        String style = transpose.getStyle();

        switch(style) {
            case "Classical":
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

        window.createAndShowGui();
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                window.canGoTo[i][j] = chords[i].canGoTo[j];
            }
        }
        window.repaint();
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

    public void adjustRules(){
        for(int i = 0; i < 7; i++){
            chords[i].isActive = window.isActive[i];
            for(int j = 0; j < 7; j++){
                chords[i].canGoTo[j] = window.canGoTo[i][j];
            }
        }
    }

    /**
     * Replaced generateString() from Version 1.0
     *
     * The user-entered melody is stored in Piano.notesEntered
     * The 0th index represents the 1st note, 1st index represents 2nd note, etc
     * The first chord is assigned by hard-coding
     * Next chords are sent to checkNextChord which returns either true or false, depending on if there is at least 1 possible chord to move to that contains the melody note
     * If true, global Chord variable nextChord is updated
     * If false, the next note is stored in the audio queue as a pickup note to the next chord and nextNextChord is called, which checks the same rules for the following note
     */
    public void generateStringFromInput(){
        while(true) {

            roots = new int[100];
            numNotes = 0;
            queue = new ArrayList<>();
            adjustChords();

            while (!Piano.entered) {
                sleep();
            }

            for(int i = 0; i < chords.length; i++) {
                if(!Piano.chordBools[i]) {
                    chords[i].isActive = false;
                }
            }

            adjustRules();

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

            for (int i = 0; i < Piano.numNotes; i++) {

                currentNote = Piano.notesEntered[i];

                if (i < Piano.numNotes - 1) {
                    nextNote = Piano.notesEntered[i + 1];
                } else if (i == Piano.numNotes-1) {
                        resolve();
                        System.out.print("\n\n***********");
                        i = Piano.numNotes;
                }

                boolean nextBool = false;
                int skipCounter = 0;

                currentChord.playChord();

                while(!nextBool){
                    nextBool = checkNextChord(currentChord, nextNote);
                    if(!nextBool){
                        currentChord.canGoTo[nextNote-1] = true; //should be i, not nextNote-1 //test this
                        skipCounter++;
                            if(i+skipCounter < Piano.numNotes-1) {
                            nextNote = Piano.notesEntered[i + 1 + skipCounter];
                        } else if(i + skipCounter >= Piano.numNotes-1){
                            resolve();
                            nextBool = true;
                        }
                    }
                }

                currentChord = nextChord;
                i += skipCounter;
            }

            if(numNotes < 100) {
                playQueue();
            } else {
                System.out.println("No sequence possible");
            }

            while(Piano.entered){
                sleep();
            }
        }
    }

    /**
     * Plays MediaPlayer queue
     * Audio is broken up without it
     */
    public void playQueue(){
        numNotes = 0;
        timeVar = Piano.timeVar / 60;

        System.out.println("Y");

        for(int i = 0; i < queue.size(); i++){
            for(Clip mp : queue.get(i)){
                mp.start();
            }
            sleep(i);
        }
    }

    /**
     * If a melody can't or doesn't resolve on its own, resolve() is called
     * Finds a path from currentChord to the resolution
     */
    public void resolve(){
        int rand = 0;
        boolean next = false;

        if(currentChord.canGoTo[0] && chords[0].isActive){
            currentChord = chords[0];
            currentNote = currentChord.root;
            currentChord.playChord();
        } else {

            while (!next) {

                rand = random.nextInt(chords.length);
                if (chords[rand].isActive) {
                    next = currentChord.canGoTo[rand];
                }
            }

            currentChord = chords[rand];
            currentNote = currentChord.root;
            currentChord.playChord();
            if (currentChord != chords[0] && numNotes < 100) {
                resolve();
            } else {
                return;
            }
        }
    }

    /**
     * Compares next note to canGoTo values of the current Chord
     * Returns true if at least one valid chord progression option
     * Also updates global Chord variable nextChord, used after resolve() method call
     * Returns false if 0 options
     *
     * @param current
     * @param next
     * @return
     */
    public boolean checkNextChord(Chord current, int next){
        int rand = 0;
        boolean returnValue = false;
        int chordsPossible = 0;
        Chord[] nextValues = new Chord[7];

        for(int i = 1; i < 7; i++){
            boolean checkChord = current.canGoTo[i];
            if(checkChord){
                if((chords[i].root == next || chords[i].third == next || chords[i].fifth == next) && chords[i].isActive){
                    returnValue = true;
                    nextValues[chordsPossible] = chords[i];
                    chordsPossible++;
                }
            }
        }

        if(returnValue) {
            rand = random.nextInt(chordsPossible);
            nextChord = nextValues[rand];
        } else {
            addSingleNote(next);
        }

        return returnValue;
    }

    /**
     * Used to store melody note in mediaPlayer alongside rest of chord
     * Separated from playSound() because of a higher octave and higher volume
     * @param note
     */
    public void playMelody(int note){
        String noteName = transpose.findNoteName(note);
        String type = transpose.getInstrument();

        try {
            String bip = type + "_" + noteName + ".wav";
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(bip)));
            players.add(clip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to store individual notes of a chord in players, an ArrayList inside queue
     * @param note
     */
    void playSound(int note) {
        String noteName = transpose.findNoteName(note);
        String type = transpose.getInstrument();

        try {
            String bip = type + "_" + noteName + ".wav";
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(bip)));
            players.add(clip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to store pickup notes in queue
     * @param next
     */
    void addSingleNote(int next){
        String noteName = transpose.findNoteName(next);
        players = new ArrayList<Clip>();
        String type = transpose.getInstrument();

        try {
            String bip = type + "_" + noteName + ".wav";
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(bip)));
            players.add(clip);
        } catch (Exception e) {
            e.printStackTrace();
        }

        queue.add(players);
    }

    void error() {
        System.out.print("ERROR");
    }

    public int findNumPassingTones(int index){
        int numPass = 0;

        for(int i = 1; i < queue.size() - index; i++){
            if(queue.get(index+i).size() == 1){
                numPass++;
            } else {
                return numPass;
            }
        }

        return numPass;
    }

    /**
     * Adjusts time delay
     * Responds to user input and pickup notes
     * Checks for two pickups
     * @param index
     */
    void sleep(int index) {
        try {

            if(queue.get(index).size() == 1){
                if(numPass == 1){
                    timeDelay = 250 / timeVar;
                } else if(numPass > 1){
                    timeDelay = 500 / timeVar / numPass;
                }
            } else{
                window.chord = roots[numNotes];
                numNotes++;
                window.repaint();

                numPass = findNumPassingTones(index);
                if(numPass == 0){
                    timeDelay = 1000 / timeVar;
                } else if(numPass == 1){
                    timeDelay = 750 / timeVar;
                } else if(numPass > 1){
                    timeDelay = 500 / timeVar;
                }
            }

            TimeUnit.MILLISECONDS.sleep(timeDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Only used in while loop waiting for user input
     */
    void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main object = new Main();
        object.buildChords();
        object.generateStringFromInput();
    }
}
