import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");

        String setup;

        System.out.print("Insert a number: ");
        setup = scanner.toString();

        //String setup = "o x#xox#o x";
        // completar codigo para transformar el string setup en la matriz oxo

        char[][] oxo = {{'o',' ','x'},{'x','o','x'},{'o', ' ', 'o'}};
        //draw
        // modificar el FOR para funcionar con matrices de diferentes tamaños
        // (example: {{'o',' ','x', ,'x'},{'x','o','x','x'},{'o', ' ', 'o', 'o'}})
        // por ahora solo funciona para matrices 3x3, queremos que funcione para matrices 4x4, 2x2, 6x6 etc
        for (int i = 0; i < oxo.length; i ++) {
            System.out.println(oxo[i][0] + "|" + oxo[i][1] + "|" + oxo[i][2]);
            if(i + 1 < oxo.length) {
                System.out.println("-+-+-");
            }
        }
        // apply rules
        char winner = ' ';
        String winningMethod = "";

        for (int i = 0; i < oxo.length; i++) {
            if (oxo[i][0] == oxo[i][1] && oxo[i][1] == oxo[i][2]) {
                winner = oxo[i][0];
                winningMethod = "row " + i;

            }
            if (oxo[0][i] == oxo[1][i] && oxo[1][i] == oxo[2][i]) {
                winner = oxo[0][i];
                winningMethod = "column " + i;
            }
        }

        int j = 1;

        if ((oxo[j - 1][j -1] == oxo[j][j] && oxo[j][j] == oxo[j + 1][j + 1]) ||
                (oxo[j - 1][j + 1] == oxo[j][j] && oxo[j][j] == oxo[j + 1][j - 1]) ) {
            winner = oxo[j][j];
            winningMethod = "diagonal";
        }

        // print winner
        if (winner != ' ') {
            System.out.println("The winner is: " + winner);
            System.out.println("winning method: " + winningMethod);
        }
        else {
            System.out.println("It is a tie!!");
        }
    }
}