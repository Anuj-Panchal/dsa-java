package algorithm;

import java.io.PrintWriter;
import java.util.Scanner;

public class SparseTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PrintWriter p = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();

        int n = scan.nextInt();
        int power = (int)(Math.log(n)/ Math.log(2));
        int[] a = new int[n];
        int[][] table = new int[n][power+1];

        for(int i=0;i<n;i++) {
            a[i] = scan.nextInt();
            table[i][0] = a[i];
        }

        for(int j = 1;j<=power;j++) {
            for(int i = 0;i + (1 << j) - 1 < n;i++) {
                table[i][j] = Math.min(table[i][j-1],table[i + (1 << (j-1))][j-1]);
            }
        }

        int m = scan.nextInt();
        while(m-- > 0) {
            int l = scan.nextInt();
            int r = scan.nextInt();

            sb.append(solve(l,r, table)).append('\n');
        }
        p.print(sb);
        p.close();
    }
    static int solve(int l, int r, int[][] table) {
        int len = r - l + 1;
        int pow = (int)(Math.log(len)/ Math.log(2));

        return Math.min(table[l][pow], table[r - (1 << (pow)) + 1][pow]);
    }
}
