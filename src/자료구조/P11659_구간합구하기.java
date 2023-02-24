package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringtokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringtokenizer.nextToken());
        int quizNo = Integer.parseInt(stringtokenizer.nextToken());

        long[] S = new long[suNo + 1];
        stringtokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 1; i <= suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringtokenizer.nextToken());
        }
        for(int q = 0; q < quizNo; q++){
            stringtokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringtokenizer.nextToken());
            int j = Integer.parseInt(stringtokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}
