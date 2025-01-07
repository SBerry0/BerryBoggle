// TrieNode.java by Sohum Berry from SpellCheck
public class TrieNode {
    int NUM_CHARACTERS = 256;
    private char letter;
    private TrieNode[] children;
    private boolean isWordEnd;

    public TrieNode(char c, boolean isWordEnd) {
        letter = c;
        children = new TrieNode[NUM_CHARACTERS];
        this.isWordEnd = isWordEnd;
    }

    // Setters
    public void addChild(TrieNode c) {
        children[c.getLetter()] = c;
    }
    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }

    // Getters
    public boolean isWordEnd() {
        return isWordEnd;
    }

    public char getLetter() {
        return letter;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public String toString() {
        return ""+letter;
    }
}
