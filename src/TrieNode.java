import java.util.HashMap;

public class TrieNode {
    TrieNode [] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

}
