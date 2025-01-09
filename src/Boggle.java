import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boggle {
    public static char[][] board;
    public static boolean[][] visited;
    public static Trie dictionary;

    public static String[] findWords(char[][] inBoard, String[] inDictionary) {
        board = inBoard.clone();
        visited = new boolean[board.length][board[0].length];
        ArrayList<String> goodWords = new ArrayList<String>();

        dictionary = new Trie();
        for (String s : inDictionary) {
            dictionary.insert(s);
        }

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
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) { return outWords; }
        if (visited[row][col]) { return outWords; }
        if (!dictionary.isValidPrefix(word)) { return outWords; }

        if (dictionary.lookup(word)) {
            System.out.println(word);
            outWords.add(word); }

        visited[row][col] = true;
        outWords.addAll(dfs(row+1, col, word+board[row][col], new ArrayList<String>()));
        outWords.addAll(dfs(row, col+1, word+board[row][col], new ArrayList<String>()));
        outWords.addAll(dfs(row-1, col, word+board[row][col], new ArrayList<String>()));
        outWords.addAll(dfs(row, col-1, word+board[row][col], new ArrayList<String>()));

        visited[row][col] = false;

        return outWords;
    }
}
