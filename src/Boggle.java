import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        Stack<Character> possibilities = new Stack<>();
        possibilities.add(board[0][0]);
        char currentChar;
        boolean[][] history = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

            }
        }

        Trie dictionaryTrie = new Trie();
        for (String s : dictionary) {
            dictionaryTrie.insert(s);
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void dfs(int row, int col, char[][] board, boolean[][] visited) {
        if (visited[row][col]) { return; }

    }
}
