import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];

        int fRow = -1;
        int fColl = -1;

        for (int i = 0; i < matrixSize; i++) {
            String[] input = scanner.nextLine().split("");
            for (int j = 0; j < matrixSize; j++) {
                if (input[j].equals("f")) {
                    fRow = i;
                    fColl = j;
                }
            }
            matrix[i] = input;
        }

        String command = scanner.nextLine();
        while (!matrix[fRow][fColl].equals("F") && countOfCommands > 0) {
        switch (command) {
            case "up":
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }
            command = scanner.nextLine();
        }

        if (matrix[fRow][fColl].equals("F")) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
