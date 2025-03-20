import java.util.Scanner;

public class Main {
    static private boolean game = true;
    static private int sum = 0;
    static private boolean turn = true;
    static private final char[] arr = {'1','2','3','4','5','6','7','8','9'};
    static private final Scanner scanner = new Scanner(System.in);
    static private int[] chosen = new int[9];
    static private int index = 0;

    public static void main(String[] args) {
        while(game){
            printBoard();
            if(turn){
                System.out.println("O Turn");
                choose( true);
                turn = false;
            }
            else{
                System.out.println("X Turn");
                choose( false);
                turn = true;
            }
            scanner.nextLine();
            sum++;
            if(sum == 9){
                game = false;
                printBoard();
            }
        }
        scanner.close();
    }

    public static void choose(boolean who) {
        boolean trying = true;
        int choice = 0;
        while (trying) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                for (int i : chosen) {
                    if (i == choice && i != 0) {
                        System.out.println("Wrong Input: This spot is not empty");
                    }
                    else if (choice < 1 || choice > 9) {
                        System.out.println("Wrong Input: Please choose between spots 1-9");
                        throw new ArrayIndexOutOfBoundsException("Wrong Input: Please choose between spots 1-9");
                    }
                }
                trying = false;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        if (who) {
            arr[choice - 1] = 'O';
        } else arr[choice - 1] = 'X';
        chosen[index++] = choice;
    }

    public static void printBoard(){
        for(int i = 1; i <= 5; i++){
            if(i == 1){
                System.out.println(arr[0] + "|" + arr[1] + "|" + arr[2]);
            }
            else if(i == 3){
                System.out.println(arr[3] + "|" + arr[4] + "|" + arr[5]);
            }
            else if(i == 5){
                System.out.println(arr[6] + "|" + arr[7] + "|" + arr[8]);
            }
            else System.out.println("_____");
        }
    }
}