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
        while (!matrix[fRow][fColl].equals("F") || countOfCommands == 0) {
        switch (command) {
            case "up":
                countOfCommands -=1;
                matrix[fRow][fColl] = "-";
                if (fRow - 1 < 0) {
                    fRow = matrixSize -1;
                } else {
                    fRow -=1;
                }

                if (matrix[fRow][fColl].equals("T")) {
                    fRow += 1;
                } else if (matrix[fRow][fColl].equals("B")){
                    if (fRow - 1 < 0) {
                        fRow = matrixSize -1;
                    } else {
                        fRow -=1;
                    }
                }

                break;
            case "down":
                countOfCommands -=1;
                matrix[fRow][fColl] = "-";
                if (fRow + 1 > matrixSize - 1) {
                    fRow = 0;
                } else {
                    fRow += 1;
                }

                if (matrix[fRow][fColl].equals("T")) {
                    fRow -= 1;
                } else if (matrix[fRow][fColl].equals("B")){
                    if (fRow + 1 > matrixSize - 1) {
                        fRow = 0;
                    } else {
                        fRow += 1;
                    }
                }
                break;
            case "left":
                countOfCommands -=1;
                matrix[fRow][fColl] = "-";
                if (fColl - 1 < 0) {
                    fColl = matrixSize - 1;
                } else {
                    fColl -= 1;
                }

                if (matrix[fRow][fColl].equals("T")) {
                    fColl += 1;
                } else if (matrix[fRow][fColl].equals("B")){
                    if (fColl - 1 < 0) {
                        fColl = matrixSize - 1;
                    } else {
                        fColl -= 1;
                    }
                }

                break;
            case "right":
                countOfCommands -=1;
                matrix[fRow][fColl] = "-";
                if (fColl + 1 > matrixSize -1) {
                    fColl = 0;
                } else {
                    fColl += 1;
                }

                if (matrix[fRow][fColl].equals("T")) {
                    fColl -= 1;
                } else if (matrix[fRow][fColl].equals("B")){
                    if (fColl + 1 > matrixSize -1) {
                        fColl = 0;
                    } else {
                        fColl += 1;
                    }
                }
                break;
        }
            if (matrix[fRow][fColl].equals("F") ||countOfCommands ==0) {
                break;
            }
            command = scanner.nextLine();
        }

        matrix[fRow][fColl] = "f";

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
