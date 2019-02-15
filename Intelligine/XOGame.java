import java.util.*;

public class XOGame {

  public char[][] init (char[][] matrix, int row_amount, int col_amount, int size) {
    for (int i = 0; i < row_amount; i++) {
      for (int s = 0; s < col_amount; s++) {
        matrix[i][s] = ' ';
      }
    }
    return matrix;
  }


  public static char[][] drawBoard(char[][] matrix, char[][] tempMatrix, int rowChoice, int colChoice, char player)
        {

            if(rowChoice == 0 && colChoice == 0 && matrix[0][0] == ' ')
                {
                    matrix[0][0] = player;
                    return matrix;
                }
            else if(matrix[rowChoice][colChoice] == ' ')
                {
                    matrix[rowChoice][colChoice] = player;
                    return matrix;
                }
            else
                {
                    System.out.println("Cannot enter here. Already full.");
                    tempMatrix[0][0] = '0';
                    return tempMatrix;
                }
        }

    public static void sop(char[][] matrix)
        {
            System.out.println("\n   col \t\t0.\t1.\t2.");
            System.out.println("\nRow 0.\t\t" + matrix[0][0] + "\t" + matrix[0][1] + "\t" + matrix[0][2]);
            System.out.println("\n    1.\t\t" + matrix[1][0] + "\t" + matrix[1][1] + "\t" + matrix[1][2]);
            System.out.println("\n    2.\t\t" + matrix[2][0] + "\t" + matrix[2][1] + "\t" + matrix[2][2]);
        }

    public static void main(String[] args)
        {
            XOGame XO = new XOGame();
            Scanner xoIn = new Scanner(System.in);
            Scanner numIn = new Scanner(System.in);
            final int SIZE = 3;
            final int ROW = 3;
            final int COL = 3;
            final int AREA = ROW * COL;
            int rowChoice;
            int colChoice;
            boolean gameEndStatus;
            char player;
            char xoMatrix[][] = new char[ROW][COL];
            char tempMatrix[][] = new char[ROW][COL];

            // initialising matrices
            xoMatrix = XO.init(xoMatrix, ROW, COL, SIZE);
            tempMatrix = XO.init(tempMatrix, ROW, COL, SIZE);

            gameEndStatus = false;
            for(int i = 0; i < AREA && !gameEndStatus; i++)
                {
                    System.out.print("X or O?\t");
                    player = xoIn.next().charAt(0);
                    System.out.print("Row?\t");
                    rowChoice = numIn.nextInt();
                    System.out.print("Column?\t");
                    colChoice = numIn.nextInt();

                    tempMatrix = drawBoard(xoMatrix, tempMatrix,rowChoice, colChoice, player);

                    if(tempMatrix[0][0] == '0')
                        {
                            i--;
                        }
                    else
                        {
                            xoMatrix = tempMatrix.clone();
                        }

                    // output 3x3 matrix
                    XO.sop(xoMatrix);

                          // if matrix is full, end game
                      if(i >= AREA)
                        {
                          gameEndStatus = true;
                        }
                    //THIS IS THE INITIALISATION AFTER EACH MOVE
                    //tempMatrix = XO.init(tempMatrix, ROW, COL, SIZE);
                }// for

            System.out.print("\n\nEnd of game\n\n");
            xoIn.close();
            numIn.close();
        }
}
