

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Himanshu Bhardwaj on 07/07/18.
 * CodeForces: https://codeforces.com/problemset/problem/489/C
 *Algo: DP
 * /Users/himanshubhardwaj/Desktop/job_practice/practice/HelloToPractice/src/main/java/com/himanshu/practice/july7/GivenLengthAndSumOfDigits.java
 */
public class GivenLengthAndSumOfDigits {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String[][] DPMin = new String[m + 1][s + 1];


        for (int i = 0; i <= s; i++) {
            DPMin[0][i] = "-1";

            if (i < 10) {
                DPMin[1][i] = Integer.toString(i);
            } else {
                DPMin[1][i] = "-1";
            }
        }


        for (int i = 1; i < m; i++) {

            for (int j = 0; j <= s; j++) {
                if (j > (Math.pow(10d, i + 1) - 1)) {
                    DPMin[i + 1][j] = "-1";
                    continue;
                }

                //now from here, number is possible
                //we have to find DPMin[i + 1][j], DPMax[i + 1][j]

                for (int k = 0; k <= Math.min(9, s); k++) {

                    DPMin[i + 1][j] = (k == 0) ? (("0".equals(DPMin[i][j]) || "-1".equals(DPMin[i][j])) ? ("-1") : (DPMin[i][j] + "0"))
                            : getMin(DPMin[i + 1][j], (j > k) ? DPMin[i][j - k] + DPMin[1][k] : "-1");
//                    DPMax[i + 1][j] = (k == 0) ? (("0".equals(DPMax[i][j]) || "-1".equals(DPMax[i][j])) ? ("-1") : ( DPMax[i][j] + "0"))
//                            : getMin(DPMin[i + 1][j], (j > k) ? DPMin[i][j - k] + DPMin[1][k] : "-1");
                }
                //DPMax[i + 1][j] = multiplyWith10(DPMax[i][j]);
            }
        }

        System.out.print(DPMin[m][s] + " " + getMaxValue(m, s));


    }

    private static String getMaxValue(int numbers, int sum) {
        if (sum == 0) {
            if (numbers == 1) {
                return "0";
            } else return "-1";
        }


        String result = "";

        for (int i = 0; i < numbers; i++) {
            if (sum >= 9) {
                result = "9" + result;
                sum = sum - 9;
            } else {
                result = result + sum;
                sum = 0;
            }
        }
        return (sum == 0) ? result : "-1";
    }

    public static String getMax(String a, String b) {
        String result = null;
        if (a.equals("-1")) {
            result = (b.charAt(0) == '-') ? "-1" : b;
        } else if (b.equals("-1")) {
            result = a;
        } else if (a.charAt(0) == '-' || b.charAt(0) == '-') {
            result = "-1";
        } else if (a.length() > b.length()) {
            result = a;
        } else if (a.length() < b.length()) {
            result = b;
        } else {
            //now length of both strings are equal
            for (int i = 0; i < a.length() && (result == null); i++) {
                if (a.charAt(i) > b.charAt(i)) {
                    result = a;
                }
            }
        }

        return (result != null) ? result : a;
    }

    public static String getMin(String a, String b) {
        String result = null;
        if (a.equals("-1")) {
            result = (b.charAt(0) == '-') ? "-1" : b;
        } else if (b.equals("-1")) {
            result = a;
        } else if (a.charAt(0) == '-' || b.charAt(0) == '-') {
            result = "-1";
        } else if (a.length() > b.length()) {
            result = b;
        } else if (a.length() < b.length()) {
            result = a;
        } else {
            //now length of both strings are equal
            for (int i = 0; i < a.length() && (result == null); i++) {
                if (a.charAt(i) > b.charAt(i)) {
                    result = b;
                }
            }
        }

        return (result != null) ? result : a;
    }

    private static String multiplyWith10(String s) {
        if (s.equals("-1")) {
            return "-1";
        } else {
            return s + "0";
        }
    }

    private static String smallestNumberWithSameDigitandSumOneMore(String str, int newLength, int newSum) {
        if (str.equals("-1")) {
            if (newSum == 0) {
                return str;
            }
        }

        String returnString = "-1";
        for (int i = (str.length() - 1); i >= 0 && returnString.equals(-1); i--) {
            if ((str.charAt(i) - '0') < 9) {
                char ch = str.charAt(i);
                ch++;
                returnString = str.substring(0, i) + Character.toString(ch) + str.substring(i + 1, str.length());
            }
        }
        return returnString;
    }
}
