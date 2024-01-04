package john.michael;
import java.util.*;
/*
For the given numbers K, N and M, begin iterating through the various seeds starting from K: (K, K+1, K+2...).
In each iteration, use that seed for a random generator and get N random Gaussian numbers using the
Random.nextGaussian() method. Output the seed for which all N Gaussian numbers are less than or equal to M.

The input contains numbers K, N, M in a single line.

Sample Input 1:
0 5 0

Sample Output 1:
38
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        double M = Double.parseDouble(input[2]);
        Random random = new Random(K);

        int validNumbers = 0;
        do {
            double generated = random.nextGaussian();
            if (generated <= M){
                validNumbers++;
            }else{
                validNumbers = 0;
                random.setSeed(++K);
            }
        }while(validNumbers != N);
        System.out.println(K);
    }
}
