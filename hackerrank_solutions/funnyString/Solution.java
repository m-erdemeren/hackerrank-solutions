package funnyString;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int j = 1;
        while(Math.abs(s.charAt(j)-s.charAt(j-1)) == 
             Math.abs(rev.charAt(j)-rev.charAt(j-1)) && j<s.length()){
                j++;
                }
        return (j == s.length() ? "Funny" : "Not Funny");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            System.out.println(result);
        }

        scanner.close();
    }
}

