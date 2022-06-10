import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lottery {
    final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        printInstructions();

        int[] randomArray = new int[7];
        int[] playersArray = new int[7];


       /* for (int i = 0; i < playersArray.length; i++) {
            System.out.println("Input " + (i+1) + " number: ");
            playersArray[i] = Integer.parseInt(bufferedReader.readLine());
        }
        */ for (int i = 0; i < playersArray.length; i++) {
            playersArray[i] = Integer.parseInt(bufferedReader.readLine());
        }

        sortArray(playersArray);

        System.out.println("Your numbers are: " + Arrays.toString(playersArray));

        try {
            printEscalating();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return;
        }

        fill(randomArray);

        sortArray(randomArray);

        System.out.println("Lottery numbers are: " + Arrays.toString(randomArray));

        int finalAction = compareArrays(playersArray,randomArray);

        if (finalAction < 7){
            saySupportMessage();
        }
        if (finalAction == 7){
            sayCongratsMessage();
        }
    }

    public static void printInstructions() {
        System.out.println("You have a chance to win our Grand Prize - $1 000 000.");
        System.out.println("Just guess 7 numbers. That's it!");
        System.out.println("Isn't that impressive?");
        System.out.println("Just type 7 numbers below (from 0 to 9): ");
    }

    public static void sortArray(int[] array){
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++){
                if(array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void printEscalating() throws InterruptedException {
        System.out.println("Just 5 seconds, and the winner will be determined...");
        for (int i = 5; i > 0; i-- ) {
            System.out.println("------------------- " + i + " -------------------");
            Thread.sleep(1000);
        }
    }

    public static void fill(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*10);
        }
    }

    public static int compareArrays(int[] array, int[] anotherArray) {
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
                if (array[i] == anotherArray[i]) {
                    temp++;
                    System.out.println("You matched the " + (i+1) + "th element");
                }
            }

        System.out.println("Number of matches: " + temp);
        return temp;
        }

        public static void saySupportMessage(){
        System.out.println("Don't be sad. You will definitely be lucky next time!");
        }
        public static void sayCongratsMessage(){
        System.out.println("Wow! Congrats! It's unbelievable!");
        System.out.println("You guessed all 7 numbers and you get $1 000 000!");
    }
}