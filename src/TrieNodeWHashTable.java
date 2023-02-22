import java.util.HashMap;

public class TrieNodeWHashTable {
    boolean isWord;
    HashMap<Character, TrieNodeWHashTable> children;

    public TrieNodeWHashTable() {
        isWord = false;
        children = new HashMap<>();
    }
}