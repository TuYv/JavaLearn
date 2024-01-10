package com.max.game;

import cn.hutool.core.util.RandomUtil;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int[] initRandom = {0,2,4};

    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        int[][] arr = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        doRandom(arr);
        System.out.println("请输入asdw来上下移动");
        print(arr);
        Scanner sco = new Scanner(System.in);
        while(true) {
            if(isEnd(arr)) {
                System.out.println("game over");
                break;
            }
            String next = sco.next();
            switch (next) {
                case "w":
                    up(arr);
                    break;
                case "s":
                    down(arr);
                    break;
                case "a":
                    left(arr);
                    break;
                case "d":
                    right(arr);
                    break;
                default:
                    break;
            }
            doRandom(arr);
            System.out.println("请输入asdw来上下移动");
            print(arr);
        }
    }

    public static void up(int[][] arr) {

    }

    public static void down(int[][] arr) {

    }

    public static void left(int[][] arr) {

    }

    public static void right(int[][] arr) {
        rightCombine(arr[0]);
        rightCombine(arr[1]);
        rightCombine(arr[2]);
        rightCombine(arr[3]);
    }

    public static void combine(int[] from, int[] to) {

    }
    public static void combine(int[] array, boolean isLeft) {
        if (isLeft) {
            leftCombine(array);
        } else {
            rightCombine(array);
        }
    }

    public static void leftCombine(int[] array) {

    }

    public static void rightCombine(int[] array) {
        //先堆叠 0202 -> 0022
        int point = 0;
        while(point < 4) {
            if (array[point] != 0 && point + 1 < 4) {
                if (array[point + 1] == 0) {
                    array[point + 1] = array[point];
                    int temp = point;
                    while(temp > 0) {
                        array[temp] = array[temp - 1];
                        temp--;
                    }
                    array[temp] = 0;
                }
            }
            point++;
        }
        //再合并 0022 -> 0004
        point = 3;
        while(point >= 0) {
            if (point > 0 && array[point] == array[point - 1] && array[point] != 0) {
                array[point] += array[point - 1];
                array[point - 1] = 0;
            }
            point--;
        }
        //再堆叠 0404 -> 0044
        point = 0;
        while(point < 4) {
            if (array[point] != 0 && point + 1 < 4) {
                if (array[point + 1] == 0) {
                    array[point + 1] = array[point];
                    int temp = point;
                    while(temp > 0) {
                        array[temp] = array[temp - 1];
                        temp--;
                    }
                    array[temp] = 0;
                }
            }
            point++;
        }

    }

    public static void doRandom(int[][] arr) {
        int times = 0;
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt == 0) {
                    int random = RandomUtil.randomInt(0, 2);
                    ints[j] = initRandom[random];
                    times += initRandom[random];
                    if (times >= 6) {
                        return;
                    }
                }
            }
        }
    }

    public static boolean isEnd(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}