class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // The transposed matrix will have swapped dimensions: n rows and m columns.
        int[][] transposed = new int[n][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Swap the row and column indices
                transposed[j][i] = matrix[i][j];
            }
        }
        
        return transposed;
    }
}