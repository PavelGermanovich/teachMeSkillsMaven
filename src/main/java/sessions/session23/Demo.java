package sessions.session23;

public class Demo {
    public static void main(String[] args) {
        int[][] matrixA;
        matrixA = new int[2][3];

        matrixA[0][0] = 1;
        matrixA[0][1] = 2;
        matrixA[0][2] = 3;
        matrixA[1][0] = 4;
        matrixA[1][1] = 5;
        matrixA[1][2] = 6;

        printArray(matrixA);

        int[][] matrixB = {
                {1, 32, 32},
                {3, 32, 11},
                {44, 11, 1311}
        };
        printArray(matrixB);

        int[][] matrx = new int[2][];
        matrx[0] = new int[11];
        matrx[1] = new int[2];
        printArray(matrx);
        System.out.println();

        //Triangle matrix task
        String[][] triangleMatrix = new String[7][];
        triangleMatrix[0] = new String[1];
        triangleMatrix[1] = new String[2];
        triangleMatrix[2] = new String[3];
        triangleMatrix[3] = new String[4];
        triangleMatrix[4] = new String[5];
        triangleMatrix[5] = new String[6];
        triangleMatrix[6] = new String[7];

        for (int i = 0; i < triangleMatrix.length; i++) {
            for (int j = 0; j < triangleMatrix[i].length; j++) {
                triangleMatrix[i][j] = Integer.parseInt("" + i + j) % 2 == 0 ? "+" : "-";
            }
        }

        printArray(triangleMatrix);
    }

    private static void printArray(int[][] matrixA) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(String[][] matrixA) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }
    }
}
