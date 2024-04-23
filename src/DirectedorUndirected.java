import java.util.Scanner;

public class DirectedorUndirected {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n x n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if (isDirectedGraph(matrix, n)) {
            System.out.println("The given matrix represents a directed graph.");
        } else {
            System.out.println("The given matrix does not represent a directed graph.");
        }

        scanner.close();
    }

    public static boolean isDirectedGraph(int[][] matrix, int n) {
        // Checking if the matrix is square
        for (int[] row : matrix) {
            if (row.length != n) {
                return false;
            }
        }

        // Checking if the matrix is symmetric along the main diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        // Checking if the diagonal elements are all zero
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] != 0) {
                return false;
            }
        }

        return true;
    }
}
