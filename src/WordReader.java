public class WordReader {

    //instance variables
    private String[] wordList = {"the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"};
    private String wordTyped;
    private String currentWord;

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
