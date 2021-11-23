package com.epicteam.mathgame;

import java.security.SecureRandom;
import java.text.DecimalFormat;

public class Generation {
    int level;
    int difficult;
    int layoutQuestion2 = 140;
    int layoutQuestion1 = 115;
    int layoutQuestion3 = 150;
    int question2Font = 12;
    int layoutQuestion2Y = 266;
    String question1;
    String question2;
    String question3;
    protected String[] answer0 = new String[]{null,null,null,null,null,null};


    private static final SecureRandom ran = new SecureRandom();

    public Generation(int level, int difficult){
        this.difficult = difficult;
        this.level = level;
        generator(level,difficult);
    }

    protected void generator(int level, int difficult){
        int numberOfExample = 1;
        if(difficult == 1) {
            if (0 < level) {
                numberOfExample = ran.nextInt(2) + 1;
            }
            if (3 < level) {
                numberOfExample = ran.nextInt(2) + 5;
            }
            if (6 < level) {
                numberOfExample = ran.nextInt(2) + 9;
            }
        }
        else {
            if (0 < level) {
                numberOfExample = ran.nextInt(2) + 3;
            }
            if (3 < level) {
                numberOfExample = ran.nextInt(2)+ 7;
            }
            if (6 < level) {
                numberOfExample = ran.nextInt(2) + 11;
            }
        }
        switch (numberOfExample) {
            case 1 -> easyEquationsEasy();
            case 2 -> fraction();
            case 3 -> hardEquationsEasy();
            case 4 -> hardEquationsEasy1();
            case 5 -> quadEquationsEasy();
            case 6 -> cubicEquationsEasy();
            case 7 -> qubeEquationsHard();
            default -> {
                question1 = "В разработке";
                answer0[0] = "0";
            }
        }
    }
    protected void cubicEquationsEasy(){

    }

    protected void qubeEquationsHard(){
        int a = ran.nextInt(20) - 10;
        while(a == 0) {
            a = ran.nextInt(20) - 10;
        }
        int x1 = ran.nextInt(20) - 10;
        int x2 = ran.nextInt(20) - 10;
        int x3 = ran.nextInt(20) - 10;

        if(Math.abs(a) == 1){
            question1 = "   x";
        }
        else{
            question1 = a + "x";
        }
        int d = -a*(x1+x2+x3);
        if(d < 0){
            question1 = question1 + " - " + (x1+x2+x3)*a + "x";
        }
        if(d > 0) {
            question1 = question1 + " + " + -(x1+x2+x3)*a + "x";
        }

        int b = x1*x2 + x1*x3 + x2*x3;
        if(a*b < 0){
            question1 = question1 + " - " + -a*b + "x";
        }
        if(a*b > 0) {
            question1 = question1 + " + " + a*b + "x";
        }
        int c = -a * x1 * x2 * x3;
        if(c < 0){
            question1 = question1 + " - " + -c;
        }
        if(c > 0 ) {
            question1 = question1 + " + " + c;
        }

        question1 = question1 + " = 0";

        if(a < 0){
            layoutQuestion2 = 147;
            if(a == -10){
                layoutQuestion2 = layoutQuestion2 + 11;
            }
        }

        question2 = "3         ";
        if(a < 0){
            question2 = question2 + "  ";
        }
        if(Math.abs(d) > 10){
            question2 = question2 + "     ";
        }
        if(Math.abs(d) > 100){
            question2 = question2 + "    ";
        }
        question2 = question2 + "2";
        answer0[0] = x1 + "," + x2 + "," + x3;
        answer0[1] = x1 + "," + x3 + "," + x2;
        answer0[2] = x2 + "," + x1 + "," + x3;
        answer0[3] = x2 + "," + x3 + "," + x1;
        answer0[4] = x3 + "," + x1 + "," + x2;
        answer0[5] = x3 + "," + x2 + "," + x1;
    }

    protected void quadEquationsEasy(){
        int a = ran.nextInt(20) - 10;
        while(a == 0) {
            a = ran.nextInt(20) - 10;
        }
        int x1 = ran.nextInt(20) - 10;
        int x2 = ran.nextInt(20) - 10;

        if(Math.abs(a) == 1){
            question1 = "   x";
        }
        else{
            question1 = a + "x";
        }
        if(-(x1+x2)*a < 0){
            question1 = question1 + " - " + (x1+x2)*a + "x";
        }
        else{
            if(-(x1+x2)*a != 0) {
                question1 = question1 + " + " + -(x1 + x2) * a + "x";
            }
        }
        if(a*x1*x2 < 0){
            question1 = question1 + " - " + -a*x1*x2 + " = 0";
        }
        else{
            if(a*x1*x2 != 0 ) {
                question1 = question1 + " + " + a * x1 * x2 + " = 0";
            }
        }

        if(a < 0){
            layoutQuestion2 = 147;
            if(a == -10){
                layoutQuestion2 = layoutQuestion2 + 11;
            }
        }
        question2 = "2";
        answer0[0] = x1 + "," + x2;
        answer0[1] = x2 + "," + x1;
    }

    protected void hardEquationsEasy(){
        DecimalFormat df = new DecimalFormat("###.##");
        double a = ran.nextInt(200)/10d - 10;
        while(a == 0) {
            a = ran.nextInt(200)/10d - 10;
        }
        double b = ran.nextInt(200)/10d - 10;
        while(b == 0) {
            b = ran.nextInt(200)/10d - 10;
        }
        double x = ran.nextInt(20)/10d - 10;

        question1 = df.format(a) + "x";
        if(b < 0){
            question1 = question1 + " - " + df.format(-b);
        }
        else{
            question1 = question1 + " + " + df.format(b);
        }
        question1 = question1 + " = " + df.format(a*x + b);

        long iPart = (long) x;
        if (Math.abs(x - iPart) > 0.001) {
            answer0[0] = String.format("%.1f", x);
        }
        else{
            answer0[1] = String.format("%.0f",x);
        }
        layoutQuestion1 = 145;
    }

    protected void easyEquationsEasy(){
        int a = ran.nextInt(20) - 10;
        while(a == 0) {
            a = ran.nextInt(20) - 10;
        }
        int b = ran.nextInt(20) - 10;
        while(b == 0) {
            b = ran.nextInt(20) - 10;
        }
        int x = ran.nextInt(20) - 10;

        question1 = a +"x";
        if(b < 0){
            question1 = question1 + " - " + -b;
        }
        else{
            question1 = question1 + " + " + b;
        }
        question1 = question1 + " = " + (a*x + b);
        answer0[0] = String.format("%s",x);
        layoutQuestion1 = 145;
    }

    protected void hardEquationsEasy1(){
        int a = znak(ran.nextInt(80) + 21);
        int b = znak(ran.nextInt(80) + 21);
        int x = znak(ran.nextInt(80) + 21);

        question1 = a +"x";
        if(b < 0){
            question1 = question1 + " - " + -b;
        }
        else{
            question1 = question1 + " + " + b;
        }
        question1 = question1 + " = " + (a*x + b);
        answer0[0] = String.format("%s",x);
        layoutQuestion1 = 145;
    }

    protected int znak(int number){
        int znak = ran.nextInt(2) + 1;
        if(znak == 2){
            number = number * (-1);
        }
        return number;
    }

    protected void fraction(){
        int b = ran.nextInt(10);
        while (b <= 1){
            b = ran.nextInt(10);
        }
        int c = ran.nextInt(4);
        while (c == 0){
            c = ran.nextInt(4);
        }
        int d = ran.nextInt(b*c);
        while (d == 0){
            d = ran.nextInt(10);
        }
        int c1 = ran.nextInt(4);
        while (c1 == 0 || c1 == c){
            c1 = ran.nextInt(4);
        }
        int a = ran.nextInt(c*b);
        while (a == 0 || a > b){
            a = ran.nextInt(10);
        }
        layoutQuestion1 = 150;
        layoutQuestion2 = 155;
        layoutQuestion3 = 150;
        question2Font = 20;
        layoutQuestion2Y = layoutQuestion2Y - 7;
        question1 = " " + b*c + "       " + b*c1;
        question2 = "—  +  —  = ?";
        question3 = " " + a + "       " + d;
        int x1 = a*c1 + d*c;
        int x2 =b*c*c1;
        int x = x1 / x2;
        answer0[0] = "";
        if (x != 0) {
            answer0[0] = x + " ";
            x1 = x1 - x2;
        }
        if(x1 != 0) {
            for (int i = 2; i < x2; i++) {
                if (x1 % i == 0 && x2 % i == 0) {
                    x1 = x1 / i;
                    x2 = x2 / i;
                }
            }
            answer0[0] = answer0[0] + x1 + "/" + x2;
        }
    }
}
