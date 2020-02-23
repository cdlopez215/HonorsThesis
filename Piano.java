import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class Piano implements ActionListener {

    private JFrame frame;
    private JTextArea entryBox;
    private JComboBox instrument;
    private JComboBox style;
    private JTextArea tempo;
    private JComboBox key;
    
    private String[] notes = {"C","D","E","F","G","A","B"};
    private String[] instruments = {"Piano", "Voice", "Horn", "Violin"};
    private String[] keys = {"C", "C#", "D", "D#/Eb", "E", "F", "F#", "G", "G#/Ab", "A", "Bb", "B"};
    private String[] styles = {"Classical", "Minor Classical", "Jazz", "Blues"};

    private Color customColor = new Color(42, 141, 254);
    private Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

    //Variables used by other classes
    static boolean entered;
    static public int[] notesEntered = new int[100];
    static int numNotes = 0, transpositionKey = 0;
    static int timeVar = 120;
    String styleInput = "Classical", instrumentInput = "Piano", keyInput = "C";

    /**
     * GUI construction
     */
    public Piano(){
        clearSound(); //The first sound is always grainy or delayed, so this method plays a silent sound file before anything else

        frame = new JFrame("Thesis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Main panel
        Container mainPanel = frame.getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setForeground(Color.WHITE);
        mainPanel.setBackground(Color.GRAY);
        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));

        //Panel from instrument, tempo, key, voice
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
        topPanel.setForeground(Color.WHITE);
        topPanel.setBackground(Color.GRAY);
        topPanel.add(Box.createRigidArea(new Dimension(180,0)));

        // Instrument label
        JLabel instrumentLabel = new JLabel("Instrument:");
        instrumentLabel.setForeground(Color.WHITE);
        instrumentLabel.setBackground(Color.BLACK);
        topPanel.add(instrumentLabel);
        topPanel.add(Box.createRigidArea(new Dimension(20,0)));

        // Instrument combo box
        instrument = new JComboBox(instruments);
        instrument.setName("instrument");
        instrument.addActionListener(this);
        instrument.setForeground(Color.BLACK);
        instrument.setBackground(customColor);
        topPanel.add(instrument);
        topPanel.add(Box.createRigidArea(new Dimension(20,0)));

        // Style label
        JLabel styleLabel = new JLabel("Style:");
        styleLabel.setForeground(Color.WHITE);
        styleLabel.setBackground(Color.BLACK);
        topPanel.add(styleLabel);
        topPanel.add(Box.createRigidArea(new Dimension(20,0)));

        // Style combo box
        style = new JComboBox(styles);
        style.setName("style");
        style.addActionListener(this);
        style.setForeground(Color.BLACK);
        style.setBackground(customColor);
        topPanel.add(style);
        topPanel.add(Box.createRigidArea(new Dimension(20,0)));

        // Tempo label
        JLabel tempoLabel = new JLabel("Tempo:");
        tempoLabel.setForeground(Color.WHITE);
        tempoLabel.setBackground(Color.BLACK);
        topPanel.add(tempoLabel);
        topPanel.add(Box.createRigidArea(new Dimension(20,0)));

        // Tempo text area
        tempo = new JTextArea();
        tempo.setName("tempo");
        tempo.setText("120");
        tempo.setFont(new Font("Ariel", Font.BOLD, 14));
        tempo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //nothing
            }

            @Override
            public void focusLost(FocusEvent e) {
                timeVar = Integer.parseInt(tempo.getText());
            }
        });
        tempo.setBorder(border);
        tempo.setForeground(Color.BLACK);
        tempo.setBackground(customColor);
        topPanel.add(tempo);
        topPanel.add(Box.createRigidArea(new Dimension(20,0)));

        // Key label
        JLabel keyLabel = new JLabel("Key:");
        styleLabel.setForeground(Color.WHITE);
        styleLabel.setBackground(Color.BLACK);
        topPanel.add(keyLabel);
        topPanel.add(Box.createRigidArea(new Dimension(20,0)));

        // Key combo box
        key = new JComboBox(keys);
        key.setName("key");
        key.addActionListener(this);
        key.setForeground(Color.BLACK);
        key.setBackground(customColor);
        topPanel.add(key);
        topPanel.add(Box.createRigidArea(new Dimension(20,0)));

        // Add topPanel to mainPanel
        mainPanel.add(topPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));

        JLayeredPane pianoKeyPanel = makeKeys();
        mainPanel.add(pianoKeyPanel);

        // Notes panel
        JPanel notesPanel = new JPanel();
        notesPanel.setLayout(new BoxLayout(notesPanel,BoxLayout.X_AXIS));
        notesPanel.setForeground(Color.WHITE);
        notesPanel.setBackground(Color.GRAY);
        notesPanel.add(Box.createRigidArea(new Dimension(100, 0)));

        // Make notes label
        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setForeground(Color.WHITE);
        notesLabel.setBackground(Color.GRAY);
        notesPanel.add(notesLabel);
        notesPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        // Create entry box
        entryBox = new JTextArea();
        entryBox.setBorder(border);
        entryBox.setFont(new Font("Ariel", Font.BOLD, 14));
        entryBox.setForeground(Color.BLACK);
        entryBox.setBackground(customColor);
        notesPanel.add(entryBox);
        notesPanel.add(Box.createRigidArea(new Dimension(100, 0)));

        // Add the top panel to the main panel
        mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
        mainPanel.add(notesPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 25)));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.setForeground(Color.WHITE);
        buttonPanel.setBackground(Color.GRAY);
        buttonPanel.add(Box.createRigidArea(new Dimension(50, 20)));

        // Create the reset button
        JButton playButton = new JButton("Play");
        playButton.setName("play");
        playButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(Color.BLACK);
        playButton.addActionListener(this);

        buttonPanel.add(playButton);
        //mainPanel.add(Box.createRigidArea(new Dimension(50, 20)));

        // Create the reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setName("reset");
        resetButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(Color.BLACK);
        resetButton.addActionListener(this);

        buttonPanel.add(resetButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(50, 20)));

        mainPanel.add(buttonPanel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(900,320);

    }

    /**
     * Creates panel containing keys
     * @return
     */
    public JLayeredPane makeKeys(){
        // Initialize
        String name = "";
        int x = 320;
        int y = 0;

        JLayeredPane keyBoard = new JLayeredPane();
        keyBoard.setPreferredSize(new Dimension(900,162));
        keyBoard.add(Box.createRigidArea(new Dimension(x, 0)));

            for(int j=0; j<7; j++) {
                switch(j){
                    case 0:
                        name = "A4";
                        break;
                    case 1:
                        name = "B4";
                        break;
                    case 2:
                        name = "C5";
                        break;
                    case 3:
                        name = "D5";
                        break;
                    case 4:
                        name = "E5";
                        break;
                    case 5:
                        name = "F5";
                        break;
                    case 6:
                        name = "G5";
                        break;
                }
                JButton jb = new JButton();
                jb.setName(name);
                jb.setActionCommand(name);
                jb.addActionListener(this);
                jb.setBounds(x, y, 35, 162);
                keyBoard.add(jb, new Integer(1));
                keyBoard.add(Box.createRigidArea(new Dimension(2, 0)));
                x += 37;
            }

        x = 320;

            JButton jb0 = new JButton();
            jb0.setBackground(Color.BLACK);
            jb0.setName("A-4");
            jb0.setActionCommand("A-4");
            jb0.addActionListener(this);

            JButton jb1 = new JButton();
            jb1.setBackground(Color.BLACK);
            jb1.setName("C-5");
            jb1.setActionCommand("C-5");
            jb1.addActionListener(this);

            JButton jb2 = new JButton();
            jb2.setBackground(Color.BLACK);
            jb2.setName("D-5");
            jb2.setActionCommand("D-5");
            jb2.addActionListener(this);

            JButton jb3 = new JButton();
            jb3.setBackground(Color.BLACK);
            jb3.setName("F-5");
            jb3.setActionCommand("F-5");
            jb3.addActionListener(this);

            JButton jb4 = new JButton();
            jb4.setBackground(Color.BLACK);
            jb4.setName("G-5");
            jb4.setActionCommand("G-5");
            jb4.addActionListener(this);

            // Place the 5 keys
            jb0.setBounds(20+(x),y,25, 65);
            keyBoard.add(jb0,new Integer(2));

            jb1.setBounds(90+(x),y,25,65);
            keyBoard.add(jb3,new Integer(2));

            jb2.setBounds(130+(x),y,25,65);
            keyBoard.add(jb1,new Integer(2));

            jb3.setBounds(200+(x),y,25,65);
            keyBoard.add(jb2,new Integer(2));

            jb4.setBounds(240+(x),y,25,65);
            keyBoard.add(jb4,new Integer(2));

        return keyBoard;
    }

    /** Creates a piano object. */
    public static void main(String[] args) {
        new Piano();
    }

    public void playSong(){
        for(int i = 0; i < 8; i++){
            System.out.print(notesEntered[i] + ", ");
        }
    }

    /**
     * Responds to user input
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = "";
        JButton jb = null;
        String name = "";

        Object obj = e.getSource();

        //Action is ComboBox from topPanel
        if (obj instanceof JComboBox){
            styleInput = (String)style.getSelectedItem();
            if(styleInput.equals("Minor Classical")){
                styleInput = "ClassicalMinor";
            }

            //Updates from topPanel, used by Transposition.java and Main.java
            instrumentInput = (String)instrument.getSelectedItem();
            keyInput = (String)key.getSelectedItem();
            transpositionKey = findTranspositionKey(keyInput);
        }

        //Action is a Button click
        else{
            jb = (JButton)obj;
            name = jb.getName();
        }

        //Action was Reset button
        if (name.equals("reset")){
            entered = false;
            numNotes = 0;
            entryBox.setText("");
        }
        //Action was Play button
        else if (name.equals("play")){
            System.out.println("Entered: ");
            for(int i = 0; i < numNotes; i++){
                System.out.print(notesEntered[i] + " ");
            }
            entered = true; // triggers method in Main.generateStringFromInput()
        }

        else if(obj instanceof JComboBox){
            // Do nothing
        }

        // A key was clicked
        else{
            command = jb.getActionCommand();
            entryBox.append(command+" ");

            if(numNotes < 8) {
                switch (command) {
                    case ("C5"):
                        notesEntered[numNotes] = 1;  // Store note in notesEntered
                        playFile("c5");         // Play sound file as input response
                        numNotes++;                  // Increment index counter
                        break;
                    case ("C-5"):
                        playFile("c-5");
                        break;
                    case ("D5"):
                        notesEntered[numNotes] = 2;
                        playFile("d5");
                        numNotes++;
                        break;
                    case ("D-5"):
                        playFile("d-5");
                        break;
                    case ("E5"):
                        notesEntered[numNotes] = 3;
                        playFile("e5");
                        numNotes++;
                        break;
                    case ("F5"):
                        notesEntered[numNotes] = 4;
                        playFile("f5");
                        numNotes++;
                        break;
                    case ("F-5"):
                        playFile("f-5");
                        break;
                    case ("G5"):
                        notesEntered[numNotes] = 5;
                        playFile("g5");
                        numNotes++;
                        break;
                    case ("G-5"):
                        playFile("g-5");
                        break;
                    case ("A4"):
                        notesEntered[numNotes] = 6;
                        playFile("a5");
                        numNotes++;
                        break;
                    case ("A-4"):
                        playFile("a-5");
                        break;
                    case ("B4"):
                        notesEntered[numNotes] = 7;
                        playFile("b5");
                        numNotes++;
                        break;
                    case ("B-4"):
                        playFile("b-5");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Used when a user clicks a key
     * @param note
     */
    void playFile(String note){
        try {
            String bip = note + ".wav";
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(bip)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initial sound to remove grainy or delayed first audio
     */
    void clearSound(){
        try {
            String bip = "a4.wav";
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(bip)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructors for Transposition.java
     * @return
     */
    public int getKey(){
        return transpositionKey;
    }
    public String getStyle(){
        return styleInput;
    }

    public int findTranspositionKey(String note){
        int returnValue = 0;
        switch(note){
            case "C":
                returnValue = 0;
                break;
            case "C#":
                returnValue = 1;
                break;
            case "D":
                returnValue = 2;
                break;
            case "D#/Eb":
                returnValue = 3;
                break;
            case "E":
                returnValue = 4;
                break;
            case "F":
                returnValue = 5;
                break;
            case "F#":
                returnValue = 6;
                break;
            case "G":
                returnValue = 7;
                break;
            case "G#/Ab":
                returnValue = 8;
                break;
            case "A":
                returnValue = 9;
                break;
            case "Bb":
                returnValue = 10;
                break;
            case "B":
                returnValue = 11;
                break;
        }
        return returnValue;
    }
}