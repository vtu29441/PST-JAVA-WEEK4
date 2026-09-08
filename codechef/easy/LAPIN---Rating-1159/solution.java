import java.util.Scanner;
import java.util.Arrays;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                int len = s.length();
                
                // Split the string into two halves, ignoring the middle character if the length is odd
                String left = s.substring(0, len / 2);
                String right = s.substring((len + 1) / 2);
                
                // Convert to character arrays and sort them to compare frequencies
                char[] leftArr = left.toCharArray();
                char[] rightArr = right.toCharArray();
                
                Arrays.sort(leftArr);
                Arrays.sort(rightArr);
                
                // If sorted arrays are equal, it's a Lapindrome
                if (Arrays.equals(leftArr, rightArr)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}