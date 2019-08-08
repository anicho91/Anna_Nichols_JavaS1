package com.company;

public class App {

    public static int subtract(int a, int b) {
        int subSum = a-b;
        return subSum;
    }

    public static int subtractOrZero(int a, int b){
        int subZsum = a-b;
        if (subZsum<0){
            return 0;
        }else{
            return subZsum;
        }
    }

    public static int max(int a, int b, int c){

        int otherResult = 0;
        if (a>b && a>c){
            return a;
        } else if (b>a && b>c){
            return b;
        } else if (c>a && c>b) {
            return c;
        }
        return otherResult;
    }

    public static int min(int a, int b, int c){

        int otherResult = 0;
        if (a<b && a<c){
            return a;
        } else if (b<a && b<c){
            return b;
        } else if (c<a && c<b) {
            return c;
        }
        return otherResult;
    }

    public static boolean isLarger(int a, int b){

        if (a > b){
            return true;
        }else {
            return false;
        }
    }
}
