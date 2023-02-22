public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Given source code
    /**
    boolean search( String word ) {
        TrieNode node = root;

        for( int i = 0; i < word.length(); i++ ) {
            int index = word.charAt(i) - 'a';

            if( node.children[index] == null ) {
                return false;
            }
            node = node.children[index];
        }

        return node.isWord;
    }
     **/

    /**
    void insert( String word) {

        TrieNode node = root;

        for( int i = 0; i < word.length(); i++ ) {
            int index = word.charAt(i) - 'a';

            if( node.children[index] == null ) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isWord = true;




    }
     **/

    void insert( String word ) {
        insertHelper(root, word);

    }

    void insertHelper(TrieNode node, String word) {

        if (word.length() <= 0) {
            node.isWord = true;
            return;
        }

        int index = word.charAt(0) - 'a';

        if( node.children[index] == null ) {
            node.children[index] = new TrieNode();
        }

        insertHelper(node.children[index], word.substring(1));

    }

    boolean search(String word) {
        return searchHelper(root, word);
    }

    boolean searchHelper(TrieNode node, String word) {

        if (word.length() <= 0) {
            return node.isWord;
        }

        int index = word.charAt(0) - 'a';

        if(node.children[index] == null) {
            return false;
        }

        return searchHelper(node.children[index], word.substring(1));

    }

    void delete(String word) {
        deleteHelper(root, word);
    }

    void deleteHelper(TrieNode node, String word) {

        // if we are at th end of the word
        if (word.length() <= 0) {
            node.isWord = false;
            return;
        }

        int index = word.charAt(0) - 'a';

        deleteHelper(node.children[index], word.substring(1));

        // if the node below is not the end of a word AND does not have any children meaning it's a false leaf
        if (!node.children[index].isWord && node.children[index].isEmpty()) {
            node.children[index] = null;
            return;
        }
    }



    public static void main( String [] args) {
        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("catch");
        trie.insert("aqua");
        trie.insert("a");
        trie.insert("part");
        trie.insert("party");
        trie.insert("par");

        System.out.println(trie.search("cat"));
        System.out.println(trie.search("ca"));

        System.out.println(trie.search("aqua"));
        trie.delete("aqua");
        System.out.println(trie.search("aqua"));
        trie.insert("ant");
        System.out.println(trie.search("ant"));

    }





}
