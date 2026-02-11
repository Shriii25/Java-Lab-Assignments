//import java.util.Scanner;
import java.util.Arrays;
public class Arr {
    public static void main(String[] args){
        /*// Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        scanner.close();

        //Creating and initializing an array
        int[] arr = new int[5];
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;  
        arr[3]=40;
        arr[4]=50;

        for(int i=0;i<5;i++){
            System.out.println(arr[i]);
        }

        *///In One line
        int[] arr={20,10,50,30,40};
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        /*String[] arr={"Apple","Banana","Grapes","Orange","Pineapple"};
        for(String f: arr){
            if(f.toLowerCase().startsWith("a")||f.toLowerCase().startsWith("e")||f.toLowerCase().startsWith("i")||f.toLowerCase().startsWith("o")||f.toLowerCase().startsWith("u")){
                System.out.println(f);
            }else{
                System.out.println("Not a Vowel");
            }
        }*/

        int[] arr1 = new int[5];
        System.arraycopy(arr, 0, arr1, 0, 5);

        for(int i: arr1){
            System.out.println(i);
        }

        boolean e1=Arrays.equals(arr, arr1);
        System.out.println(e1);

        Arrays.sort(arr);

        boolean e2=Arrays.equals(arr, arr1);
        System.out.println(e2);
    }
}
