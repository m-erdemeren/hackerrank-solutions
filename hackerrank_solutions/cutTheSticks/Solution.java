package cutTheSticks;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int nonZeroMin(int[] arr){
        int min = 10000;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]!=0 && arr[i]<min) min = arr[i];
        }
        return min;
    }
    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int min = arr[0];
        int max = arr[0];
        int maxIndex = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min) 
                min =  arr[i];
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        int nonZeroMin;
        while(arr[maxIndex] > 0) {
            nonZeroMin = nonZeroMin(arr);
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > 0){
                    arr[i] -= nonZeroMin;
                    count++;
                } 
            }
            result.add(count);
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scanner.close();
    }
}
