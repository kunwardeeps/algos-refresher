import java.util.HashMap;
import java.util.Map;

public class Trie {
    public class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>(); 
        public boolean isWord = false;
    }
    
    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return node.isWord;   
        if (chs[k] != '.') {
            return node.children.containsKey(chs[k]) && match(chs, k + 1, node.children.get(chs[k]));
        } else {
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                if (match(chs, k + 1, entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.addWord("word");
        t.addWord("hello");
        System.out.println(t.search("wo..") == true);
        System.out.println(t.search("word") == true);
        System.out.println(t.search("hello") == true);
        System.out.println(t.search("abc") == false);
    }
}
