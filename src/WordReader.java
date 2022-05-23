import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordReader {


    //instance variables
    private String[] wordList = readFiveLetter();
    private String[] wordList1 = readFourLetter();
    private String[] wordList2 = readSixLetter();
    private String wordTyped;
    private String currentWord;

    public String[] readFiveLetter() {
        String temp= "";
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("src\\ImagesAndText\\fiveLetterWords.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> words = new ArrayList<>();
        while (inFile.hasNext()) {
            temp = inFile.next();
            words.add(temp);
        }
        inFile.close();
        return words.toArray(new String[0]);
    }

    public String[] readFourLetter() {
        String temp= "";
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("src\\ImagesAndText\\fourLetter.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> words = new ArrayList<>();
        while (inFile.hasNext()) {
            temp = inFile.next();
            words.add(temp);
        }
        inFile.close();
        return words.toArray(new String[0]);
    }

    public String[] readSixLetter() {
        String temp= "";
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("src\\ImagesAndText\\sixLetter.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> words = new ArrayList<>();
        while (inFile.hasNext()) {
            temp = inFile.next();
            words.add(temp);
        }
        inFile.close();
        return words.toArray(new String[0]);
    }

    //constructor
    public WordReader() {
        wordTyped = "";
        newWord();
    }

    //add typed letter to the word typed
    public void addLetter(String letter) {
        wordTyped += letter;
    }

    //user typed "backspace" method
    public void backspace() {
        wordTyped = wordTyped.substring(0, wordTyped.length() - 1);
    }

    //generate a new word to type
    public void newWord() {
        currentWord = wordList[(int) (Math.random() * wordList.length)];
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
