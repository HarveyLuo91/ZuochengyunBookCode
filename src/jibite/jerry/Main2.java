package jibite.jerry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jerry on 2017/8/27.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), col = sc.nextInt();
        int[][] G = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                G[i][j] = sc.nextInt();
            }
        }
        node[][] dp = new node[row][col];
        if (G[0][0]>=0){
            dp[0][0] = new node(G[0][0], 1);
        }else {
            dp[0][0] = new node(G[0][0], G[0][0]);
        }
        for (int i = 1; i < row; i++) {
            if (G[i][0]>=0){
                dp[i][0] = new node(dp[i-1][0].x+G[i][0], dp[i-1][0].y);
            }else {
                dp[i][0] = new node(dp[i-1][0].x+G[i][0], dp[i-1][0].y-G[i][0]);
            }
        }
        for (int i = 1; i < col; i++) {
            if (G[0][i]>=0){
                dp[0][i] = new node(dp[0][i-1].x+G[0][i], dp[0][i-1].y);
            }else {
                dp[0][i] = new node(dp[0][i-1].x+G[0][i], dp[0][i-1].y-G[0][i]);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                node l = dp[i - 1][j];
                node t = dp[i][j - 1];
                node tmp = l.y > t.y ? t : l;

                node cur = new node();
                cur.x = tmp.x + G[i][j];

                if (G[i][j] >= 0) {
                    cur.y = tmp.y;
                }else {
                    cur.y = tmp.y-G[i][j];
                }
                dp[i][j] = cur;
            }
        }
        System.out.println(dp[row-1][col-1].y);
    }
}

class node{
    int x,y;

    public node() {
    }

    public node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
