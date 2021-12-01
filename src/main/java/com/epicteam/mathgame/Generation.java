package com.epicteam.mathgame;

import java.security.SecureRandom;
import java.text.DecimalFormat;

/**
 * A class for generating game examples for the user
 * @version 1.0.0
 * @author Savenia
 */
public class Generation {
    int level;
    int difficult;
    int[] arrayLevels;
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
    private static final DecimalFormat df = new DecimalFormat("###.##");

    /**
     * Class constructor
     * @param level selected level
     * @param difficult selected difficult
     * @param arrayLevels Game progress
     */
    public Generation(int level, int difficult, int[] arrayLevels){
        this.difficult = difficult;
        this.level = level;
        this.arrayLevels = arrayLevels;
        generator();
    }

    /**
     * Generation type of question
     */
    protected void generator(){
        int numberOfExample;
        if( level != 0) {
            numberOfExample = genNumOfExample0();
        }
        else{
            numberOfExample = genNumOfExample1();
        }
        switch (numberOfExample) {
            case 1 -> easyEquationsEasy();
            case 2 -> fraction();
            case 3 -> quadEquationsEasy();
            case 4 -> systemOfEquations();
            case 5 -> trigonEquations();
            case 6 -> logEquationsEasy();
            case 7 -> hardEquationsEasy();
            case 8 -> hardEquationsHard();
            case 9 -> quadEquationsHard();
            case 10 -> cubicEquations();
            case 11 -> logEquationHard();
            default -> {
                question1 = "В разработке";
                answer0[0] = "0";
            }
        }
    }

    /**
     * Type of question if level is not 0
     * @return type of question
     */
    private int genNumOfExample0(){
        int numberOfExample = 1;
        if(difficult == 1) {
            if (6 < level) {
                numberOfExample = ran.nextInt(2) + 5;
            }
            else if (3 < level) {
                numberOfExample = ran.nextInt(2) + 3;
            }
            else if (0 < level) {
                numberOfExample = ran.nextInt(2) + 1;
            }
        }
        else {
            if (6 < level) {
                numberOfExample = ran.nextInt(1) + 11;
            }
            else if (3 < level) {
                numberOfExample = ran.nextInt(2)+ 9;
            }
            else if (0 < level) {
                numberOfExample = ran.nextInt(2) + 7;
            }
        }
        return numberOfExample;
    }

    /**
     * Type of question if level is 0
     * @return type of question
     */
    private int genNumOfExample1(){
        int numberOfExample = 1;
        if(difficult == 1) {
            if (arrayLevels[7] > 0) {
                numberOfExample = ran.nextInt(6) + 1;
            }
            else if (arrayLevels[4] > 0) {
                numberOfExample = ran.nextInt(4) + 1;
            }
            else if (arrayLevels[1] > 0) {
                numberOfExample = ran.nextInt(2) + 1;
            }
        }
        else {
            if (arrayLevels[7] > 1) {
                numberOfExample = ran.nextInt(5) + 7;
            }
            else if (arrayLevels[4] > 1) {
                numberOfExample = ran.nextInt(4)+ 7;
            }
            else if (arrayLevels[1] > 1) {
                numberOfExample = ran.nextInt(2) + 7;
            }
        }
        return numberOfExample;
    }

    /**
     * Generating a +- sign for a number
     * @param number
     * @return number with sing
     */
    protected int znak(int number){
        int znak = ran.nextInt(2) + 1;
        if(znak == 2){
            number = number * (-1);
        }
        return number;
    }

    /**
     * Generating a simple equation
     */
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

    /**
     * Generates a system of simple equations
     */
    protected void systemOfEquations(){
        int a = ran.nextInt(20) - 10;
        while(a == 0) {
            a = ran.nextInt(20) - 10;
        }
        int x = ran.nextInt(20) - 10;
        int b = ran.nextInt(20) - 10;
        while(b == 0) {
            b = ran.nextInt(20) - 10;
        }
        int y = ran.nextInt(20) - 10;

        if(a != 1) {
            question1 = a + "x";
        }
        else{
            question1 = "x";
        }
        if(Math.abs(b) != 1) {
            if (b < 0) {
                question1 = question1 + " - " + -b;
            } else {
                question1 = question1 + " - " + b;

            }
        }
        question1 = question1 + "y";
        question1 = question1 + " = " + (a*x + b*y);

        a = ran.nextInt(20) - 10;
        while(a == 0) {
            a = ran.nextInt(20) - 10;
        }
        b = ran.nextInt(20) - 10;
        while(b == 0) {
            b = ran.nextInt(20) - 10;
        }

        if(a != 1) {
            question3 = a + "x";
        }
        else{
            question3 = "x";
        }
        if(Math.abs(b) != 1) {
            if (b < 0) {
                question3 = question3 + " - " + -b;
            } else {
                question3 = question3 + " - " + b;

            }
        }
        question3 = question3 + "y";
        question3 = question3 + " = " + (a*x + b*y);
        layoutQuestion3 = 115;

        question2 ="{";
        question2Font = 64;
        layoutQuestion2 = 96;
        layoutQuestion2Y = 222;

        answer0[0] = x + "," + y;
        answer0[1] = y + "," + x;
    }

    /**
     * Generating an example with fractions
     */
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
            x1 = x1 + x2;
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

    /**
     * Generating simple equations with non-integer roots
     */
    protected void hardEquationsEasy(){
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

    /**
     * Generating simple equations with large roots
     */
    protected void hardEquationsHard(){
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

    /**
     * Generating simple quadratic equations
     */
    protected void quadEquationsEasy(){
        int a = ran.nextInt(20) - 10;
        while(a == 0) {
            a = ran.nextInt(20) - 10;
        }
        int x1 = ran.nextInt(20) - 10;
        int x2 = ran.nextInt(20) - 10;

        if(Math.abs(a) == 1){
            question1 = "x";
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
            question1 = question1 + " - " + -a*x1*x2;
        }
        else{
            if(a*x1*x2 != 0 ) {
                question1 = question1 + " + " + a * x1 * x2;
            }
        }
        question1 = question1 + " = 0";

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

    /**
     * Generating quadratic equations with non-integer roots
     */
    protected void quadEquationsHard(){
        double a = ran.nextInt(200)/10d - 10;
        while(a == 0) {
            a = ran.nextInt(200)/10d - 10;
        }
        double x1 = ran.nextInt(200)/10d - 10;
        double x2 = ran.nextInt(200)/10d - 10;

        if(Math.abs(a) == 1){
            question1 = "   x";
        }
        else{
            question1 = df.format(a) + "x";
        }
        if(-(x1+x2)*a < 0){
            question1 = question1 + " - " + df.format((x1+x2)*a) + "x";
        }
        else{
            if(-(x1+x2)*a != 0) {
                question1 = question1 + " + " + df.format(-(x1 + x2) * a) + "x";
            }
        }
        if(a*x1*x2 < 0){
            question1 = question1 + " - " + df.format(-a*x1*x2) + " = 0";
        }
        else{
            if(a*x1*x2 != 0 ) {
                question1 = question1 + " + " + df.format(a * x1 * x2) + " = 0";
            }
        }


        if(a < 0){
            layoutQuestion2 = 147;
            if(a == -10){
                layoutQuestion2 = layoutQuestion2 + 11;
            }
        }
        double fractionalPart = a % 1;
        if(fractionalPart != 0){
            layoutQuestion2 = layoutQuestion2 + 11;
        }
        question2 = "2";
        answer0[0] = df.format(x1) + ";" + df.format(x2);
        answer0[1] = df.format(x2) + ";" + df.format(x1);
    }

    /**
     * Generating cubic equations
     */
    protected void cubicEquations(){
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

    /**
     * Generating trigonometric equations
     */
    protected void trigonEquations(){
        DecimalFormat df1 = new DecimalFormat("#.##");
        double[][] trigonNums = {{0.0,30.0,90.0,150.0},{90.0,60.0,0.0, 120.0},{0.0,45.0,135.0},{90.0,45.0,135.0}};
        String[] trigonNames = {"sin", "cos", "tg", "ctg"};
        int ranTrigonName = (ran.nextInt(4));
        int ranTrigonNum;
        if(ranTrigonName < 2){
            ranTrigonNum = (ran.nextInt(4));
        }
        else{
            ranTrigonNum = (ran.nextInt(3));
        }
        int more = ran.nextInt(5) + 1;
        String sin = "sin";
        String cos = "cos";
        String tg = "tg";
        String ctg = "ctg";
        double rad = Math.toRadians(trigonNums[ranTrigonName][ranTrigonNum] + more * 180.0);
        double value = 0;


        if(trigonNames[ranTrigonName].equals(sin)){
            value = value + Math.sin(rad);
        }
        else if(trigonNames[ranTrigonName].equals(cos)){
            value = value + Math.cos(rad);
        }
        else if(trigonNames[ranTrigonName].equals(tg)){
            value = value + Math.tan(rad);
        }
        else if(trigonNames[ranTrigonName].equals(ctg)){
            value = value + 1.0 / Math.tan(rad);
        }

        value = Math.round(value * 100.0) / 100.0;

        question1 = "        " + trigonNames[ranTrigonName] + "(" + (trigonNums[ranTrigonName][ranTrigonNum] + more * 180.0) + "°" + ")";

        answer0[0] = String.format("%s",df1.format(value));
    }

    DecimalFormat df2 = new DecimalFormat("#####");
    /**
     * Generating logarithmic equations
     */
    protected void logEquationsEasy(){
        int a = ran.nextInt(10) + 1;
        while (a == 1){
            a = ran.nextInt(10);
        }
        int x = ran.nextInt(5);
        double b = Math.exp(x*Math.log(a));
        b = Math.round(b);

        question1 = "    log" + a + "(x) = " + df2.format(b);

        answer0[0] = String.format("%s",x);
    }

    protected  void logEquationHard(){
        int a1 = ran.nextInt(5) + 1;
        while (a1 == 1){
            a1 = ran.nextInt(5) + 1;
        }
        int x11 = ran.nextInt(6);
        int x22 = ran.nextInt(6);
        if(a1 > 3){
            x11 = ran.nextInt(3);
            x22 = ran.nextInt(3);
        }
        double x1 = Math.exp(x11*Math.log(a1));
        double x2 = Math.exp(x22*Math.log(a1));
        x1 = Math.round(x1);
        x2 = Math.round(x2);
        int a = ran.nextInt(11) - 5;
        while(a == 0) {
            a = ran.nextInt(11) - 5;
        }

        String str = "(log" + a1 + "(x))";
        if(Math.abs(a) == 1){
            question1 = str;
            layoutQuestion1 = 50;
        }
        else{
            question1 = df2.format(a) + str;
        }
        if(-(x1+x2)*a < 0){
            question1 = question1 + " - " + df2.format((x1+x2)*a) + str;
        }
        else{
            if(-(x1+x2)*a != 0) {
                question1 = question1 + " + " + df2.format(-(x1 + x2) * a) + str;
            }
        }
        if(a*x1*x2 < 0){
            question1 = question1 + " - " + df2.format(-a*x1*x2);
        }
        else{
            if(a*x1*x2 != 0 ) {
                question1 = question1 + " + " + df2.format(a * x1 * x2);
            }
        }
        question1 = question1 + " = 0";

        layoutQuestion1 = 35;

        question2 = "2";
        layoutQuestion2 = 128;
        if (Math.abs(a) <= 1.001){
            layoutQuestion2 = layoutQuestion2 - 18;
        }
        answer0[0] = x11 + "," + x22;
        answer0[1] = x22 + "," + x11;
    }

}
