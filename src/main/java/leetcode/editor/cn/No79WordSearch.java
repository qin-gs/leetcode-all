// 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例 1：
//
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"SEE"
// 输出：true
//
//
// 示例 3：
//
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCB"
// 输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
// Related Topics 数组 回溯 矩阵 👍 1404 👎 0


package leetcode.editor.cn;

public class No79WordSearch {
    public static void main(String[] args) {
        Solution solution = new No79WordSearch().new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean b = solution.exist(board, "ABCB");
        System.out.println(b);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] isVisited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (exist(board, word, 0, i, j, isVisited)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean exist(char[][] board, String word, int index, int i, int j, boolean[][] isVisited) {
            if (index >= word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return false;
            }
            if (isVisited[i][j] || board[i][j] != word.charAt(index)) {
                return false;
            }
            isVisited[i][j] = true;
            boolean exist = exist(board, word, index + 1, i + 1, j, isVisited)
                    || exist(board, word, index + 1, i - 1, j, isVisited)
                    || exist(board, word, index + 1, i, j + 1, isVisited)
                    || exist(board, word, index + 1, i, j - 1, isVisited);
            if (exist) {
                return true;
            }

            isVisited[i][j] = false;
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
