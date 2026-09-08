import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numRings = Math.min(m, n) / 2;

        for (int k = 0; k < numRings; k++) {
            List<Integer> ring = new ArrayList<>();
            int r1 = k, r2 = m - 1 - k;
            int c1 = k, c2 = n - 1 - k;

            // 1. Extract the current ring/layer
            for (int j = c1; j <= c2; j++) ring.add(matrix.get(r1).get(j));
            for (int i = r1 + 1; i <= r2; i++) ring.add(matrix.get(i).get(c2));
            for (int j = c2 - 1; j >= c1; j--) ring.add(matrix.get(r2).get(j));
            for (int i = r2 - 1; i >= r1 + 1; i--) ring.add(matrix.get(i).get(c1));

            // 2. Calculate effective rotations
            int rot = r % ring.size();
            int idx = rot;

            // 3. Put the rotated elements back
            for (int j = c1; j <= c2; j++) matrix.get(r1).set(j, ring.get(idx++ % ring.size()));
            for (int i = r1 + 1; i <= r2; i++) matrix.get(i).set(c2, ring.get(idx++ % ring.size()));
            for (int j = c2 - 1; j >= c1; j--) matrix.get(r2).set(j, ring.get(idx++ % ring.size()));
            for (int i = r2 - 1; i >= r1 + 1; i--) matrix.get(i).set(c1, ring.get(idx++ % ring.size()));
        }

        // 4. Print the final rotated matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }
            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);
        bufferedReader.close();
    }
}
