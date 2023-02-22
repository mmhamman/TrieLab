import java.util.HashMap;

public class TrieNode {
    TrieNode [] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

    boolean isEmpty() {
        for(TrieNode node : children) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

}
