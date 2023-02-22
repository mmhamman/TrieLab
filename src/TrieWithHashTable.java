import java.util.HashMap;

public class TrieWithHashTable {
    TrieNodeWHashTable root;

    public TrieWithHashTable() {
        root = new TrieNodeWHashTable();
    }

    /**
    boolean search( String word ) {
        TrieNodeWHashTable node = root;

        for( int i = 0; i < word.length(); i++ ) {
            if( node.children.get(word.charAt(i)) == null ) {
                return false;
            }
            node = node.children.get(word.charAt(i));
        }

        return node.isWord;
    }

    void insert( String word) {
        TrieNodeWHashTable node = root;

        for( int i = 0; i < word.length(); i++ ) {
            if( node.children.get(word.charAt(i)) == null ) {

                node.children.put(word.charAt(i), new TrieNodeWHashTable());

            }

            node = node.children.get(word.charAt(i));
        }

        node.isWord = true;
    }
**/

    void insert( String word ) {
        insertHelper(root, word);

    }

    void insertHelper(TrieNodeWHashTable node, String word) {

        if (word.length() <= 0) {
            node.isWord = true;
            return;
        }

        if( node.children.get(word.charAt(0)) == null ) {
            node.children.put(word.charAt(0), new TrieNodeWHashTable());
        }

        insertHelper(node.children.get(word.charAt(0)), word.substring(1));

    }

    boolean search(String word) {
        return searchHelper(root, word);
    }

    boolean searchHelper(TrieNodeWHashTable node, String word) {

        if (word.length() <= 0) {
            return node.isWord;
        }

        if(node.children.get(word.charAt(0)) == null) {
            return false;
        }

        return searchHelper(node.children.get(word.charAt(0)), word.substring(1));

    }


    public static void main( String [] args) {
        TrieWithHashTable trie = new TrieWithHashTable();

        trie.insert("cat");
        trie.insert("catch");
        trie.insert("aqua");
        trie.insert("a");
        trie.insert("part");
        trie.insert("party");
        trie.insert("par");

        System.out.println(trie.search("cat"));
        System.out.println(trie.search("ca"));

    }





}