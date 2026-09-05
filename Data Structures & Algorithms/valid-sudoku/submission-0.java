class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();

        // rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }

        // columns
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }

        // squares
        for (int sq = 0; sq < 9; sq++) {
            for (int i = (sq / 3) * 3; i < (sq / 3) * 3 + 3; i++) {
                for (int j = (sq % 3) * 3; j < (sq % 3) * 3 + 3; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }

        return true;
    }
}

/*

Approach 1:
1. Check all rows
2. Check all columns
3. Check all squares
To check, put all numbers in a HashSet
If the number is already there -> invalid
Ignore empty spaces

*/
