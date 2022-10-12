import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            char[] a = scn.next().toCharArray();
            char[] b = scn.next().toCharArray();

            int xa = 0;
            int xb = 0;
            int sa = 0;
            int sb = 0;
            int la = 0;
            int lb = 0;
            int ma = 0;
            int mb = 0;

            for (char ch : a) {

                if (ch == 'X')
                    xa++;
                else if (ch == 'M')
                    ma++;
                else if (ch == 'L')
                    la++;
                else
                    sa++;
            }

            for (char ch : b) {

                if (ch == 'X')
                    xb++;
                else if (ch == 'M')
                    mb++;
                else if (ch == 'L')
                    lb++;
                else
                    sb++;
            }

            if (la > 0 && lb > 0) {
                if (xa == xb) {
                    System.out.println("=");
                } else if (xa > xb) {
                    System.out.println(">");
                } else {
                    System.out.println("<");
                }
            } else if (sa > 0 && sb > 0) {
                if (xa == xb) {
                    System.out.println("=");
                } else if (xa > xb) {
                    System.out.println("<");
                } else {
                    System.out.println(">");
                }
            } else if (ma > 0 && mb > 0) {
                if (xa == xb) {
                    System.out.println("=");
                } else if (xa > xb) {
                    System.out.println(">");
                } else {
                    System.out.println("<");
                }
            } else if (la > 0 && mb > 0) { // LM
                System.out.println(">");
            } else if (sa > 0 && lb > 0) { // S L
                System.out.println("<");
            } else if (la > 0 && sb > 0) { // LS
                System.out.println(">");
            } else if (ma > 0 && sb > 0) { // M S
                System.out.println(">");
            } else if (mb > 0 && sa > 0) { // S M
                System.out.println("<");
            }else if(ma >0 && lb >0){ // ML
                System.out.println("<");
            }
        }
    }
}

// L S ,  L M , S L , S M , m s , m l

// la sb lb sa ma sb mb sa