# LAPIN - Rating 1159

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Lapindromes

 *Lapindrome*  is defined as a string which when split in the middle, gives two halves having the same characters and same frequency of each character. If there are odd number of characters in the string, we ignore the middle character and check for lapindrome. For example  ***gaga**  *is a lapindrome, since the two halves  ***ga***  and  ***ga**  *have the same characters with same frequency. Also,  ***abccab***,  ***rotor**  *and  ***xyzxy***  are a few examples of lapindromes. Note that  ***abbaab** * is NOT a lapindrome. The two halves contain the same characters but their frequencies do not match.
Your task is simple. Given a string, you need to tell if it is a lapindrome.

### Input:
First line of input contains a single integer  **T**, the number of test cases.
Each test is a single line containing a string  **S**  composed of only lowercase English alphabet.

### Output:
For each test case, output on a separate line: "YES" if the string is a lapindrome and "NO" if it is not.

### Constraints:
- 1 ≤ T ≤ 100
- 2 ≤ |S| ≤ 1000, where |S| denotes the length of S
### Sample 1:
Input
Output

```
6
gaga
abcde
rotor
xyzxy
abbaab
ababc
```

```
YES
NO
YES
YES
NO
NO
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-08T04:41:39.126Z  

```java
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
```

---

[View on CodeChef](https://www.codechef.com/problems/LAPIN)