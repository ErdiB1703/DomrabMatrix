import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк первой матрицы: ");
        int rows1 = scanner.nextInt();

        System.out.print("Введите количество столбцов первой матрицы: ");
        int columns1 = scanner.nextInt();

        int[][] matrix1 = new int[rows1][columns1];

        System.out.println("Введите элементы первой матрицы:");

        // Ввод элементов первой матрицы
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Введите количество строк второй матрицы: ");
        int rows2 = scanner.nextInt();

        System.out.print("Введите количество столбцов второй матрицы: ");
        int columns2 = scanner.nextInt();

        int[][] matrix2 = new int[rows2][columns2];

        System.out.println("Введите элементы второй матрицы:");

        // Ввод элементов второй матрицы
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        if (columns1 != rows2) {
            System.out.println("Невозможно выполнить умножение матриц: количество столбцов первой матрицы должно быть равно количеству строк второй матрицы.");
        } else {
            int[][] sum = addMatrices(matrix1, matrix2);
            int[][] difference = subtractMatrices(matrix1, matrix2);
            int[][] product = multiplyMatrices(matrix1, matrix2);

            System.out.println("Сложение матриц:");
            printMatrix(sum);

            System.out.println("Вычитание матриц:");
            printMatrix(difference);

            System.out.println("Умножение матриц:");
            printMatrix(product);
        }

        System.out.println("Транспонированная матрица 1:");
        int[][] transposedMatrix1 = transposeMatrix(matrix1);
        printMatrix(transposedMatrix1);

        System.out.println("Транспонированная матрица 2:");
        int[][] transposedMatrix2 = transposeMatrix(matrix2);
        printMatrix(transposedMatrix2);
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        if (rows1 != rows2 || columns1 != columns2) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размерности для сложения.");
        }

        int[][] result = new int[rows1][columns1];

        for (int i =

             0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        if (rows1 != rows2 || columns1 != columns2) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размерности для вычитания.");
        }

        int[][] result = new int[rows1][columns1];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        if (columns1 != rows2) { throw new IllegalArgumentException("Матрицы несовместимы для умножения.");
        }

        int[][] result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] transposedMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
