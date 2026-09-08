public class Solution {
    public static void main(String[] args) throws 
    IOException {
        BufferedReader bufferedReader = new BufferedReader
        (new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter
        (new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.
        readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.
        readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.compareTriplets(a, 
        b);

        bufferedWriter.write(
            result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}