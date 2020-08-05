package nonDivisibleSubset;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int getMax(int[] arr){
        int max = arr[0];
        for(int t = 1; t < arr.length; t++){
            if(arr[t] > max) max = arr[t];
        }
        return max;
    }
    
    public static int getMaxIndex(int[] arr){
        int max = arr[0];
        int index = 0;
        for(int t = 1; t < arr.length; t++){
            if(arr[t] > max){
                max = arr[t];
                index = t;
            }
        }
        return index;
    }
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int size = s.size();
        int[] arr = new int[size];

        for(int i = 0; i < size-1; i++){
            for(int j = i+1; j < size; j++){
                if((s.get(i) + s.get(j)) % k != 0 ){
                    arr[i]++;
                    arr[j]++;
                }
            }
        }

        int[] occurrence = new int[getMax(arr) + 1];
        for(int i = 0; i < arr.length; i++){
            occurrence[arr[i]]++;
        }
        
        int target = getMaxIndex(occurrence);
        int count = 0;
        for(int t = 0; t < size; t++){
            if(arr[t] == target) count++;
        }
        return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        in.close();
        
        System.out.println(result);
    }
}

