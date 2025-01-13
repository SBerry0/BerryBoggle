// Boggle.java by Sohum Berry
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boggle {
    public static char[][] board;
    public static boolean[][] visited;
    public static Trie dictionary;

    public static String[] findWords(char[][] inBoard, String[] inDictionary) {
        // Initialize the global variables
        board = inBoard.clone();
        visited = new boolean[board.length][board[0].length];
        ArrayList<String> goodWords = new ArrayList<String>();

        // Fill dictionary trie
        dictionary = new Trie();
        for (String s : inDictionary) {
            dictionary.insert(s);
        }

        // Append the entirety of the received arrayList from dfs to the main arrayList
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                goodWords.addAll(dfs(i, j, "", new ArrayList<String>()));
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        System.out.println(Arrays.toString(sol));
        return sol;
    }

    public static ArrayList<String> dfs(int row, int col, String word, ArrayList<String> outWords) {
        // If out of bounds, return the current arrayList of found words
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) { return outWords; }
        // If square is already visited, return the current arrayList of found words
        if (visited[row][col]) { return outWords; }
        // If the current word is no longer in the dictionary, return the current arrayList of found words
        if (!dictionary.isValidPrefix(word)) { return outWords; }

        // If a dictionary word is found, remove the word from the dictionary to stop repeats
        if (dictionary.lookup(word)) {
            dictionary.removeWord(word);
            // Then add the word to the arrayList of found words which will recurse up into the output
            outWords.add(word); }

        // Mark the square as visited before recursing N, E, S, W.
        visited[row][col] = true;
        // Append the entire outputted array to the current arrayList
        outWords.addAll(dfs(row+1, col, word+board[row][col], new ArrayList<String>()));
        outWords.addAll(dfs(row, col+1, word+board[row][col], new ArrayList<String>()));
        outWords.addAll(dfs(row-1, col, word+board[row][col], new ArrayList<String>()));
        outWords.addAll(dfs(row, col-1, word+board[row][col], new ArrayList<String>()));
        // Reset the visited square to false
        visited[row][col] = false;

        return outWords;
    }
}
