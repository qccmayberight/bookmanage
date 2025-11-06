package com.test.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class InputUtil {
    private static final Scanner scanner =new Scanner(System.in);

    public static int nextInt(String prompt) {
        while (true) {
            try{
                System.out.print(prompt);
                return scanner.nextInt();
            }catch (InputMismatchException e){
                sendErrorAndWait("您输入的不是一个数字,请重新输入!");
            }finally{
                scanner.nextLine();
            }
        }
    }


    public static String nextLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }


    public static String nextLine(String prompt, String... Values) {
        List<String> list= Arrays.asList(Values);
        while(true){
            System.out.print(prompt);
            String input = scanner.nextLine();
            if(list.contains(input)){
                return input;
            }
            sendErrorAndWait("输入错误,并非按需求输入,请重新输入!");
        }
    }

    public static void sendErrorAndWait(String prompt) {
        System.err.println(prompt+"(需等待一段时间重新输入)" );
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
