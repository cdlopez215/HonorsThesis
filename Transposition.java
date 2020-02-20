public class Transposition {

    Piano keyboard = new Piano();

    public String findNoteName(int note){
        String noteName = "";
        int key = keyboard.getKey();
        String style = keyboard.getStyle();

        if(key == 0){
            switch(note){
                case 1:
                    System.out.print("C");
                    noteName = "c4";
                    break;
                case 2:
                    System.out.print("D");
                    noteName = "d4";
                    break;
                case 3:
                    System.out.print("E");
                    if(style.equals("Classical")){
                        noteName = "e4";
                    } else {
                        System.out.println("minor");
                        noteName = "d-4";
                    }
                    break;
                case 4:
                    System.out.print("F");
                    noteName = "f4";
                    break;
                case 5:
                    System.out.print("G");
                    noteName = "g4";
                    break;
                case 6:
                    System.out.print("A");
                    if(style.equals("Classical")){
                        noteName = "a3";
                    } else {
                        noteName = "g-3";
                    }
                    break;
                case 7:
                    System.out.print("B");
                    if(style.equals("Classical")){
                        noteName = "b3";
                    } else {
                        noteName = "a-3";
                    }
                    break;
            }
        } else if(key == 1){
            switch(note){
                case 1:
                    System.out.print("C#");
                    noteName = "c-4";
                    break;
                case 2:
                    System.out.print("D#");
                    noteName = "d-4";
                    break;
                case 3:
                    System.out.print("E#");
                    if(style.equals("Classical")){
                        noteName = "e-4";
                    } else {
                        noteName = "e4";
                    }
                    break;
                case 4:
                    System.out.print("F#");
                    noteName = "f-4";
                    break;
                case 5:
                    System.out.print("G#");
                    noteName = "g-4";
                    break;
                case 6:
                    System.out.print("A#");
                    if(style.equals("Classical")){
                        noteName = "a-3";
                    } else {
                        noteName = "a3";
                    }
                    break;
                case 7:
                    System.out.print("B#");
                    if(style.equals("Classical")){
                        noteName = "b-3";
                    } else {
                        noteName = "b3";
                    }
                    break;
            }
        } else if(key == 2){
            switch(note){
                case 1:
                    System.out.print("D");
                    noteName = "d4";
                    break;
                case 2:
                    System.out.print("E");
                    noteName = "E4";
                    break;
                case 3:
                    System.out.print("F#");
                    if(style.equals("Classical")){
                        noteName = "f-4";
                    } else {
                        noteName = "f4";
                    }
                    break;
                case 4:
                    System.out.print("G");
                    noteName = "g4";
                    break;
                case 5:
                    System.out.print("A");
                    noteName = "a4";
                    break;
                case 6:
                    System.out.print("B");
                    if(style.equals("Classical")){
                        noteName = "b3";
                    } else {
                        noteName = "a-3";
                    }
                    break;
                case 7:
                    System.out.print("C#");
                    if(style.equals("Classical")){
                        noteName = "c-3";
                    } else {
                        noteName = "c3";
                    }
                    break;
            }
        } else if(key == 3){
            switch(note){
                case 1:
                    System.out.print("Eb");
                    noteName = "d-4";
                    break;
                case 2:
                    System.out.print("F");
                    noteName = "f4";
                    break;
                case 3:
                    System.out.print("G");
                    if(style.equals("Classical")){
                        noteName = "g4";
                    } else {
                        noteName = "f-4";
                    }
                    break;
                case 4:
                    System.out.print("Ab");
                    noteName = "g-4";
                    break;
                case 5:
                    System.out.print("Bb");
                    noteName = "a-4";
                    break;
                case 6:
                    System.out.print("C");
                    if(style.equals("Classical")){
                        noteName = "c3";
                    } else {
                        noteName = "b3";
                    }
                    break;
                case 7:
                    System.out.print("D");
                    if(style.equals("Classical")){
                        noteName = "d3";
                    } else {
                        noteName = "c-3";
                    }
                    break;
            }
        } else if(key == 4){
            switch(note){
                case 1:
                    System.out.print("E");
                    noteName = "e4";
                    break;
                case 2:
                    System.out.print("F#");
                    noteName = "f-4";
                    break;
                case 3:
                    System.out.print("G#");
                    if(style.equals("Classical")){
                        noteName = "g-4";
                    } else {
                        noteName = "g4";
                    }
                    break;
                case 4:
                    System.out.print("A");
                    noteName = "a4";
                    break;
                case 5:
                    System.out.print("B");
                    noteName = "b4";
                    break;
                case 6:
                    System.out.print("C#");
                    if(style.equals("Classical")){
                        noteName = "c-3";
                    } else {
                        noteName = "c3";
                    }
                    break;
                case 7:
                    System.out.print("D#");
                    if(style.equals("Classical")){
                        noteName = "d-3";
                    } else {
                        noteName = "d3";
                    }
                    break;
            }
        } else if(key == 5){
            switch(note){
                case 1:
                    System.out.print("F");
                    noteName = "f4";
                    break;
                case 2:
                    System.out.print("G");
                    noteName = "g4";
                    break;
                case 3:
                    System.out.print("A");
                    if(style.equals("Classical")){
                        noteName = "a4";
                    } else {
                        noteName = "g-4";
                    }
                    break;
                case 4:
                    System.out.print("Bb");
                    noteName = "a-4";
                    break;
                case 5:
                    System.out.print("C");
                    noteName = "c4";
                    break;
                case 6:
                    System.out.print("D");
                    if(style.equals("Classical")){
                        noteName = "d3";
                    } else {
                        noteName = "c-3";
                    }
                    break;
                case 7:
                    System.out.print("E");
                    if(style.equals("Classical")){
                        noteName = "e3";
                    } else {
                        noteName = "d-3";
                    }
                    break;
            }
        } else if(key == 6){
            switch(note){
                case 1:
                    System.out.print("F#");
                    noteName = "f-4";
                    break;
                case 2:
                    System.out.print("G#");
                    noteName = "g-4";
                    break;
                case 3:
                    System.out.print("A#");
                    if(style.equals("Classical")){
                        noteName = "a-4";
                    } else {
                        noteName = "a4";
                    }
                    break;
                case 4:
                    System.out.print("B");
                    noteName = "b4";
                    break;
                case 5:
                    System.out.print("C#");
                    noteName = "c-4";
                    break;
                case 6:
                    System.out.print("D#");
                    if(style.equals("Classical")){
                        noteName = "d-3";
                    } else {
                        noteName = "d3";
                    }
                    break;
                case 7:
                    System.out.print("E#");
                    if(style.equals("Classical")){
                        noteName = "f3";
                    } else {
                        noteName = "e3";
                    }
                    break;
            }
        } else if(key == 7){
            switch(note){
                case 1:
                    System.out.print("G");
                    noteName = "g4";
                    break;
                case 2:
                    System.out.print("A");
                    noteName = "a4";
                    break;
                case 3:
                    System.out.print("B");
                    if(style.equals("Classical")){
                        noteName = "b4";
                    } else {
                        noteName = "a-4";
                    }
                    break;
                case 4:
                    System.out.print("C");
                    noteName = "c-4";
                    break;
                case 5:
                    System.out.print("D");
                    noteName = "d-4";
                    break;
                case 6:
                    System.out.print("E");
                    if(style.equals("Classical")){
                        noteName = "e3";
                    } else {
                        noteName = "d-3";
                    }
                    break;
                case 7:
                    System.out.print("F#");
                    if(style.equals("Classical")){
                        noteName = "f-3";
                    } else {
                        noteName = "f3";
                    }
                    break;
            }
        } else if(key == 8){
            switch(note){
                case 1:
                    System.out.print("Ab");
                    noteName = "g-4";
                    break;
                case 2:
                    System.out.print("Bb");
                    noteName = "a-4";
                    break;
                case 3:
                    System.out.print("C");
                    if(style.equals("Classical")){
                        noteName = "c4";
                    } else {
                        noteName = "b4";
                    }
                    break;
                case 4:
                    System.out.print("Db");
                    noteName = "c-4";
                    break;
                case 5:
                    System.out.print("Eb");
                    noteName = "d-4";
                    break;
                case 6:
                    System.out.print("F");
                    if(style.equals("Classical")){
                        noteName = "f3";
                    } else {
                        noteName = "e3";
                    }
                    break;
                case 7:
                    System.out.print("G");
                    if(style.equals("Classical")){
                        noteName = "g3";
                    } else {
                        noteName = "f-3";
                    }
                    break;
            }
        }  else if(key == 9){
            switch(note){
                case 1:
                    System.out.print("A");
                    noteName = "a4";
                    break;
                case 2:
                    System.out.print("B");
                    noteName = "b4";
                    break;
                case 3:
                    System.out.print("C#");
                    if(style.equals("Classical")){
                        noteName = "c-4";
                    } else {
                        noteName = "c4";
                    }
                    break;
                case 4:
                    System.out.print("D");
                    noteName = "d4";
                    break;
                case 5:
                    System.out.print("E");
                    noteName = "e4";
                    break;
                case 6:
                    System.out.print("F#");
                    if(style.equals("Classical")){
                        noteName = "f-3";
                    } else {
                        noteName = "f3";
                    }
                    break;
                case 7:
                    System.out.print("G#");
                    if(style.equals("Classical")){
                        noteName = "g-3";
                    } else {
                        noteName = "g3";
                    }
                    break;
            }
        }  else if(key == 10){
            switch(note){
                case 1:
                    System.out.print("Bb");
                    noteName = "a-4";
                    break;
                case 2:
                    System.out.print("C");
                    noteName = "c4";
                    break;
                case 3:
                    System.out.print("D");
                    if(style.equals("Classical")){
                        noteName = "d4";
                    } else {
                        noteName = "c-4";
                    }
                    break;
                case 4:
                    System.out.print("Eb");
                    noteName = "d-4";
                    break;
                case 5:
                    System.out.print("F");
                    noteName = "f4";
                    break;
                case 6:
                    System.out.print("G");
                    if(style.equals("Classical")){
                        noteName = "g3";
                    } else {
                        noteName = "f-3";
                    }
                    break;
                case 7:
                    System.out.print("A");
                    if(style.equals("Classical")){
                        noteName = "a3";
                    } else {
                        noteName = "g-3";
                    }
                    break;
            }
        } else if(key == 11){
            switch(note){
                case 1:
                    System.out.print("B");
                    noteName = "b4";
                    break;
                case 2:
                    System.out.print("C#");
                    noteName = "c-4";
                    break;
                case 3:
                    System.out.print("D#");
                    if(style.equals("Classical")){
                        noteName = "d-4";
                    } else {
                        noteName = "d4";
                    }
                    break;
                case 4:
                    System.out.print("E");
                    noteName = "e4";
                    break;
                case 5:
                    System.out.print("F#");
                    noteName = "f-4";
                    break;
                case 6:
                    System.out.print("G#");
                    if(style.equals("Classical")){
                        noteName = "g-3";
                    } else {
                        noteName = "g3";
                    }
                    break;
                case 7:
                    System.out.print("F#");
                    if(style.equals("Classical")){
                        noteName = "f-3";
                    } else {
                        noteName = "f3";
                    }
                    break;
            }
        }

        return noteName;
    }

    public String findMelodyNoteName(int note){
        String noteName = "";
        int key = keyboard.getKey();
        String style = keyboard.getStyle();

        if(key == 0){
            switch(note){
                case 1:
                    System.out.print("C");
                    noteName = "c5";
                    break;
                case 2:
                    System.out.print("D");
                    noteName = "d5";
                    break;
                case 3:
                    System.out.print("E");
                    if(style.equals("Classical")){
                        noteName = "e5";
                    } else {
                        noteName = "d-5";
                    }
                    break;
                case 4:
                    System.out.print("F");
                    noteName = "f5";
                    break;
                case 5:
                    System.out.print("G");
                    noteName = "g5";
                    break;
                case 6:
                    System.out.print("A");
                    if(style.equals("Classical")){
                        noteName = "a4";
                    } else {
                        noteName = "g-4";
                    }
                    break;
                case 7:
                    System.out.print("B");
                    if(style.equals("Classical")){
                        noteName = "b4";
                    } else {
                        noteName = "a-4";
                    }
                    break;
            }
        } else if(key == 1){
            switch(note){
                case 1:
                    System.out.print("C#");
                    noteName = "c-5";
                    break;
                case 2:
                    System.out.print("D#");
                    noteName = "d-5";
                    break;
                case 3:
                    System.out.print("E#");
                    if(style.equals("Classical")){
                        noteName = "e-5";
                    } else {
                        noteName = "e5";
                    }
                    break;
                case 4:
                    System.out.print("F#");
                    noteName = "f-5";
                    break;
                case 5:
                    System.out.print("G#");
                    noteName = "g-5";
                    break;
                case 6:
                    System.out.print("A#");
                    if(style.equals("Classical")){
                        noteName = "a-4";
                    } else {
                        noteName = "a4";
                    }
                    break;
                case 7:
                    System.out.print("B#");
                    if(style.equals("Classical")){
                        noteName = "b-4";
                    } else {
                        noteName = "b4";
                    }
                    break;
            }
        } else if(key == 2){
            switch(note){
                case 1:
                    System.out.print("D");
                    noteName = "d5";
                    break;
                case 2:
                    System.out.print("E");
                    noteName = "E5";
                    break;
                case 3:
                    System.out.print("F#");
                    if(style.equals("Classical")){
                        noteName = "f-5";
                    } else {
                        noteName = "f5";
                    }
                    break;
                case 4:
                    System.out.print("G");
                    noteName = "g5";
                    break;
                case 5:
                    System.out.print("A");
                    noteName = "a5";
                    break;
                case 6:
                    System.out.print("B");
                    if(style.equals("Classical")){
                        noteName = "b4";
                    } else {
                        noteName = "a-4";
                    }
                    break;
                case 7:
                    System.out.print("C#");
                    if(style.equals("Classical")){
                        noteName = "c-4";
                    } else {
                        noteName = "c4";
                    }
                    break;
            }
        } else if(key == 3){
            switch(note){
                case 1:
                    System.out.print("Eb");
                    noteName = "d-5";
                    break;
                case 2:
                    System.out.print("F");
                    noteName = "f5";
                    break;
                case 3:
                    System.out.print("G");
                    if(style.equals("Classical")){
                        noteName = "g5";
                    } else {
                        noteName = "f-5";
                    }
                    break;
                case 4:
                    System.out.print("Ab");
                    noteName = "g-5";
                    break;
                case 5:
                    System.out.print("Bb");
                    noteName = "a-5";
                    break;
                case 6:
                    System.out.print("C");
                    if(style.equals("Classical")){
                        noteName = "c4";
                    } else {
                        noteName = "b4";
                    }
                    break;
                case 7:
                    System.out.print("D");
                    if(style.equals("Classical")){
                        noteName = "d4";
                    } else {
                        noteName = "c-4";
                    }
                    break;
            }
        } else if(key == 4){
            switch(note){
                case 1:
                    System.out.print("E");
                    noteName = "e5";
                    break;
                case 2:
                    System.out.print("F#");
                    noteName = "f-5";
                    break;
                case 3:
                    System.out.print("G#");
                    if(style.equals("Classical")){
                        noteName = "g-5";
                    } else {
                        noteName = "g5";
                    }
                    break;
                case 4:
                    System.out.print("A");
                    noteName = "a5";
                    break;
                case 5:
                    System.out.print("B");
                    noteName = "b5";
                    break;
                case 6:
                    System.out.print("C#");
                    if(style.equals("Classical")){
                        noteName = "c-4";
                    } else {
                        noteName = "c4";
                    }
                    break;
                case 7:
                    System.out.print("D#");
                    if(style.equals("Classical")){
                        noteName = "d-4";
                    } else {
                        noteName = "d4";
                    }
                    break;
            }
        } else if(key == 5){
            switch(note){
                case 1:
                    System.out.print("F");
                    noteName = "f5";
                    break;
                case 2:
                    System.out.print("G");
                    noteName = "g5";
                    break;
                case 3:
                    System.out.print("A");
                    if(style.equals("Classical")){
                        noteName = "a5";
                    } else {
                        noteName = "g-5";
                    }
                    break;
                case 4:
                    System.out.print("Bb");
                    noteName = "a-5";
                    break;
                case 5:
                    System.out.print("C");
                    noteName = "c5";
                    break;
                case 6:
                    System.out.print("D");
                    if(style.equals("Classical")){
                        noteName = "d4";
                    } else {
                        noteName = "c-4";
                    }
                    break;
                case 7:
                    System.out.print("E");
                    if(style.equals("Classical")){
                        noteName = "e4";
                    } else {
                        noteName = "d-4";
                    }
                    break;
            }
        } else if(key == 6){
            switch(note){
                case 1:
                    System.out.print("F#");
                    noteName = "f-5";
                    break;
                case 2:
                    System.out.print("G#");
                    noteName = "g-5";
                    break;
                case 3:
                    System.out.print("A#");
                    if(style.equals("Classical")){
                        noteName = "a-5";
                    } else {
                        noteName = "a5";
                    }
                    break;
                case 4:
                    System.out.print("B");
                    noteName = "b5";
                    break;
                case 5:
                    System.out.print("C#");
                    noteName = "c-5";
                    break;
                case 6:
                    System.out.print("D#");
                    if(style.equals("Classical")){
                        noteName = "d-4";
                    } else {
                        noteName = "d4";
                    }
                    break;
                case 7:
                    System.out.print("E#");
                    if(style.equals("Classical")){
                        noteName = "f4";
                    } else {
                        noteName = "e4";
                    }
                    break;
            }
        } else if(key == 7){
            switch(note){
                case 1:
                    System.out.print("G");
                    noteName = "g5";
                    break;
                case 2:
                    System.out.print("A");
                    noteName = "a5";
                    break;
                case 3:
                    System.out.print("B");
                    if(style.equals("Classical")){
                        noteName = "b5";
                    } else {
                        noteName = "a-5";
                    }
                    break;
                case 4:
                    System.out.print("C");
                    noteName = "c-5";
                    break;
                case 5:
                    System.out.print("D");
                    noteName = "d-5";
                    break;
                case 6:
                    System.out.print("E");
                    if(style.equals("Classical")){
                        noteName = "e4";
                    } else {
                        noteName = "d-4";
                    }
                    break;
                case 7:
                    System.out.print("F#");
                    if(style.equals("Classical")){
                        noteName = "f-4";
                    } else {
                        noteName = "f4";
                    }
                    break;
            }
        } else if(key == 8){
            switch(note){
                case 1:
                    System.out.print("Ab");
                    noteName = "g-5";
                    break;
                case 2:
                    System.out.print("Bb");
                    noteName = "a-5";
                    break;
                case 3:
                    System.out.print("C");
                    if(style.equals("Classical")){
                        noteName = "c5";
                    } else {
                        noteName = "b5";
                    }
                    break;
                case 4:
                    System.out.print("Db");
                    noteName = "c-5";
                    break;
                case 5:
                    System.out.print("Eb");
                    noteName = "d-5";
                    break;
                case 6:
                    System.out.print("F");
                    if(style.equals("Classical")){
                        noteName = "f4";
                    } else {
                        noteName = "e4";
                    }
                    break;
                case 7:
                    System.out.print("G");
                    if(style.equals("Classical")){
                        noteName = "g4";
                    } else {
                        noteName = "f-4";
                    }
                    break;
            }
        }  else if(key == 9){
            switch(note){
                case 1:
                    System.out.print("A");
                    noteName = "a5";
                    break;
                case 2:
                    System.out.print("B");
                    noteName = "b5";
                    break;
                case 3:
                    System.out.print("C#");
                    if(style.equals("Classical")){
                        noteName = "c-5";
                    } else {
                        noteName = "c5";
                    }
                    break;
                case 4:
                    System.out.print("D");
                    noteName = "d5";
                    break;
                case 5:
                    System.out.print("E");
                    noteName = "e5";
                    break;
                case 6:
                    System.out.print("F#");
                    if(style.equals("Classical")){
                        noteName = "f-4";
                    } else {
                        noteName = "f4";
                    }
                    break;
                case 7:
                    System.out.print("G#");
                    if(style.equals("Classical")){
                        noteName = "g-4";
                    } else {
                        noteName = "g4";
                    }
                    break;
            }
        }  else if(key == 10){
            switch(note){
                case 1:
                    System.out.print("Bb");
                    noteName = "a-5";
                    break;
                case 2:
                    System.out.print("C");
                    noteName = "c5";
                    break;
                case 3:
                    System.out.print("D");
                    if(style.equals("Classical")){
                        noteName = "d5";
                    } else {
                        noteName = "c-5";
                    }
                    break;
                case 4:
                    System.out.print("Eb");
                    noteName = "d-5";
                    break;
                case 5:
                    System.out.print("F");
                    noteName = "f5";
                    break;
                case 6:
                    System.out.print("G");
                    if(style.equals("Classical")){
                        noteName = "g4";
                    } else {
                        noteName = "f-4";
                    }
                    break;
                case 7:
                    System.out.print("A");
                    if(style.equals("Classical")){
                        noteName = "a4";
                    } else {
                        noteName = "g-4";
                    }
                    break;
            }
        } else if(key == 11){
            switch(note){
                case 1:
                    System.out.print("B");
                    noteName = "b5";
                    break;
                case 2:
                    System.out.print("C#");
                    noteName = "c-5";
                    break;
                case 3:
                    System.out.print("D#");
                    if(style.equals("Classical")){
                        noteName = "d-5";
                    } else {
                        noteName = "d5";
                    }
                    break;
                case 4:
                    System.out.print("E");
                    noteName = "e5";
                    break;
                case 5:
                    System.out.print("F#");
                    noteName = "f-5";
                    break;
                case 6:
                    System.out.print("G#");
                    if(style.equals("Classical")){
                        noteName = "g-4";
                    } else {
                        noteName = "g4";
                    }
                    break;
                case 7:
                    System.out.print("F#");
                    if(style.equals("Classical")){
                        noteName = "f-4";
                    } else {
                        noteName = "f4";
                    }
                    break;
            }
        }

        return noteName;
    }
}
