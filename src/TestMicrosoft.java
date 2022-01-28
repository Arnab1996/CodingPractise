import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Question 1. Minimum Modifications
 * <p>
 * Array of N integers arranged in non-decreasing sequence. You can perform two operations
 * a) remove an element
 * b) add an element
 * Return the minimum operations required such that each element X, appears exactly X times in the array
 * <p>
 * Example
 * <p>
 * Input = [1, 1, 3, 4, 4, 4]
 * Output:  3
 * Explanation:
 * 1. You can remove the 3, array becomes 1, 1, 4, 4, 4
 * 2. You can remove 1, array becomes 1, 4, 4, 4
 * 3. You can add 4, array becomes 1, 4, 4, 4, 4
 * Thus 1 appears 1 time, and 4 appears 4 times, in 3 operations.
 * Question 2: Robot Room Cleaner
 * There is a cleaning robot which is cleaning a rectangular grid of size Nx M, represented by array R consisting of N strings. Rows are numbered from 0 to N-1 (from top to bottom) and columns are numbered from 0 to M-1 (from left to right).
 * <p>
 * The robot starts cleaning in the top-left corner, facing rightwards. It moves in a straight line for as long as it can, i.e. while there is an unoccupied grid square ahead of it. When it cannot move forward, it rotates 90 degrees clockwise and tries to move forward again until it encounters another obstacle, and so on. Dots in the array (".") represent empty squares and 'x's represent occupied squares (ones the robot cannot move through). Each square that the robot occupied at least once is considered clean. The robot moves indefinitely.
 * <p>
 * Write a function:
 * <p>
 * int solution (vector &R);
 * <p>
 * that, given an array R consisting of N strings, each of length M, representing the grid, returns the number of clean squares.
 * <p>
 * Examples:
 * <p>
 * Given A = [...X..","..XX","..X..."], your function should return 6.
 * image
 * I was able to solve the first problem completely while second I couldn't. Have been leetcoding for 2 months now, (without prior CS background), so this was a good opportunity to test my progress. Overall I am happy that I was able to think of some solutions thus getting a positive reinforcement for the future grind. Till now I haven't touched greedy, DP and Graph Algorithms, and barely skimmed the surface of DFS based problems. I suppose I should get better once I solve those topics thoroughly.
 */
public class TestMicrosoft {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String[] R = new String[]{
                "...X..", "..XX", "..X..."
        };

        for (int i = 0; i < R.length; i++) {
            for (int j = 0; j < R[i].length(); j++) {
                System.out.println(R[i].charAt(j));

            }
        }
        System.out.println();

        sc.close();
    }

}
