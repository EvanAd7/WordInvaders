import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordReader {

    //instance variables
    private String[] wordList;
    private String wordTyped;
    private String currentWord;

    //constructor
    public WordReader(int letters) {
        if (letters == 4) {
            wordList = readFourLetterWords();
        } else if (letters == 5) {
            wordList = readFiveLetterWords();
        } else if (letters == 6) {
            wordList = readSixLetterWords();
        }
        wordTyped = "";
        newWord();
    }

    //add typed letter to the word typed
    public void addLetter(String letter) {
        wordTyped += letter;
    }

    //user typed "backspace" method
    public void backspace() {
        if (wordTyped.length() > 0) {
            wordTyped = wordTyped.substring(0, wordTyped.length() - 1);
        }
    }

    //generate a new word to type
    public void newWord() {
        currentWord = wordList[(int) (Math.random() * wordList.length)];
    }

    //file reader to compile four-letter words into an array
    public String[] readFourLetterWords() {
        String temp = "";
        Scanner inFile = null;
        ArrayList<String> words = new ArrayList<>();

        try {
            inFile = new Scanner(new File("src\\ImagesAndText\\fourLetter.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (inFile.hasNext()) {
            temp = inFile.next();
            words.add(temp);
        }

        inFile.close();
        return words.toArray(new String[0]);
    }

    //file reader to compile five-letter words into an array
    public String[] readFiveLetterWords() {
        String temp = "";
        Scanner inFile = null;
        ArrayList<String> words = new ArrayList<>();

        try {
            inFile = new Scanner(new File("src\\ImagesAndText\\fiveLetter.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (inFile.hasNext()) {
            temp = inFile.next();
            words.add(temp);
        }

        inFile.close();
        return words.toArray(new String[0]);
    }

    //file reader to compile six-letter words into an array
    public String[] readSixLetterWords() {
        String temp = "";
        Scanner inFile = null;
        ArrayList<String> words = new ArrayList<>();

        try {
            inFile = new Scanner(new File("src\\ImagesAndText\\sixLetter.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (inFile.hasNext()) {
            temp = inFile.next();
            words.add(temp);
        }

        inFile.close();
        return words.toArray(new String[0]);
    }

    //getters
    public String getWordTyped() {
        return wordTyped;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    //setters
    public void setWordTyped(String wordTyped) {
        this.wordTyped = wordTyped;
    }
}
