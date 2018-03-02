package org.chen.arch;

import java.util.HashMap;

public class Test {

    public static int a1;
    public int a2 ;
    public static HashMap<String,Object> hm1;
    public HashMap<String,Object> hm2;

    public static void fA1(){
        int a3 = 0;
        if(a1==0){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        Test test = new Test();
        if(test.a2==0){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        if(0==a3){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        if(hm1==null){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        if(test.hm2==null){
            System.out.println("T");
        }else {
            System.out.println("F");
        }

    }

    public void fA2(){
        int a3 = 0;
        if(a1==0){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        if(a2==0){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        if(0==a3){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        if(hm1==null){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        if(hm2==null){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
    }

    public static void main(String[] args) {
        fA1();
        System.out.println("fa1 end---");
        Test test = new Test();
        test.fA2();
    }
}
