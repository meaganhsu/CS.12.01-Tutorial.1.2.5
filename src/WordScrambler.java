public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {
        scrambledWords = mixedWords(wordArr);
    }
    public String[] getScrambledWords() {
        return scrambledWords;
    }
    public void setScrambledWords(String[] scrambledWords) {
        this.scrambledWords = scrambledWords;
    }
    private String recombine(String word1, String word2) {
        return word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);
    }
    private String[] mixedWords(String[] words) {
        String[] out = new String[words.length];

        if (words.length % 2 == 1) throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(" ")) throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
        }

        for (int i = 0; i < out.length; i++) {
            if (i % 2 == 0) out[i] = recombine(words[i], words[i+1]);
            else out[i] = recombine(words[i], words[i-1]);
        }

        return out;
    }
}
