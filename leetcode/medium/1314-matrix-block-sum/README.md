# Matrix Block Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a `m x n` matrix `mat` and an integer `k`, return  *a matrix*  `answer`  *where each*  `answer[i][j]`  *is the sum of all elements*  `mat[r][c]`  *for* :

- i - k <= r <= i + k,
- j - k <= c <= j + k, and
- (r, c) is a valid position in the matrix.

 

 **Example 1:** 

```
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]

```

 **Example 2:** 

```
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]

```

 

 **Constraints:** 

- m == mat.length
- n == mat[i].length
- 1 <= m, n, k <= 100
- 1 <= mat[i][j] <= 100

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 60.42%)  
**Memory:** 46.7 MB (beats 40.97%)  
**Submitted:** 2026-09-08T04:31:06.863Z  

```java
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // dp[i][j] will store the sum of the submatrix from (0,0) to (i-1, j-1)
        // We use an extra row and column (1-based index padding) to handle out-of-bounds easily
        int[][] dp = new int[m + 1][n + 1];
        
        // 1. Build the 2D prefix sum matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] 
                         + dp[i - 1][j] 
                         + dp[i][j - 1] 
                         - dp[i - 1][j - 1];
            }
        }
        
        int[][] answer = new int[m][n];
        
        // 2. Calculate the block sum for each cell using the dp matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine the boundaries of the valid block
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // Shift boundaries to match the 1-based indexed dp array
                r1++; 
                c1++; 
                r2++; 
                c2++;
                
                // Inclusion-Exclusion Principle to get the sum of the submatrix (r1, c1) to (r2, c2)
                answer[i][j] = dp[r2][c2] 
                             - dp[r1 - 1][c2] 
                             - dp[r2][c1 - 1] 
                             + dp[r1 - 1][c1 - 1];
            }
        }
        
        return answer;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/matrix-block-sum/)