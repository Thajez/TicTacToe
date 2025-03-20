import java.util.Scanner;

public class Main {
    static private boolean game = true;
    static private int sum = 0;
    static private boolean turn = true;
    static private final char[] arr = {'1','2','3','4','5','6','7','8','9'};
    static private final Scanner scanner = new Scanner(System.in);

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
            checkWinner();
        }
        scanner.close();
    }

    public static void choose(boolean who) {
        boolean trying = true;
        int choice = 0;
        while(trying){
            choice = scanner.nextInt();
            if(choice > 9 || choice < 1){
                System.out.println("Error: Choose between 1-9");
            }
            else if(arr[choice - 1] == 'O' || arr[choice - 1] == 'X') {
                System.out.println("Error: Choose a free tile!");
            }
            else trying = false;
        }

        if(who){
            arr[choice - 1] = 'O';
        }
        else{
            arr[choice - 1] = 'X';
        }
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

        }
    }

    //O = 79
    //X = 88
    //0 1 2
    //3 4 5
    //6 7 8
    public static void checkWinner(){
        if(arr[0]+arr[1]+arr[2] == 237 || arr[3]+arr[4]+arr[5] == 237 || arr[6]+arr[7]+arr[8] == 237
        || arr[0]+arr[3]+arr[6] == 237 || arr[1]+arr[4]+arr[7] == 237 || arr[2]+arr[5]+arr[8] == 237
        || arr[0]+arr[4]+arr[8] == 237 || arr[6]+arr[4]+arr[2] == 237) {
            printBoard();
            System.out.println("O wins!");
            game = false;
        }
        else if(arr[0]+arr[1]+arr[2] == 264 || arr[3]+arr[4]+arr[5] == 264 || arr[6]+arr[7]+arr[8] == 264
                || arr[0]+arr[3]+arr[6] == 264 || arr[1]+arr[4]+arr[7] == 264 || arr[2]+arr[5]+arr[8] == 264
                || arr[0]+arr[4]+arr[8] == 264 || arr[6]+arr[4]+arr[2] == 264) {
            printBoard();
            System.out.println("X wins!");
            game = false;
        }
        else if (sum == 9) {
            printBoard();
            System.out.println("Tie!");
            game = false;
        }
    }
}
