package org.chen.arch;

import org.junit.Test;

public class ArrayTest {


    /**
     * 合并两个有序链表
     */
    @Test
    public void mergeOrderedArray() {

        int[] arr1 = {1, 5, 9, 13, 22, 35};
        int[] arr2 = {4, 5, 6, 10, 21};
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i];
                i++;
            } else {
                arr3[k++] = arr2[j];
                j++;
            }
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
        for (int m = 0; m < arr3.length; m++) {
            System.out.println(arr3[m]);
        }
    }


    /**
     * 数组中第二大值，时间复杂度O(n)
     */
    @Test
    public void secondMaxValue() {
        int[] arr = {1, 6, 2, 9, 3, 2, 5};
        int max = 0;
        int secMax = 0;
        for (int i = 0; i < arr.length; i++) {
            secMax = arr[i] > secMax ? arr[i] : secMax;
            if (max < secMax) {
                int tmp = max;
                max = secMax;
                secMax = tmp;
            }
        }
        System.out.println("最大值为：" + max);
        System.out.println("第二大值为：" + secMax);
    }


    /**
     * 仓库参观，无意中发现第1个货架格子编码为1，第2-3个分别为1,2，第4-6个格子分别是1，2，3，
     * 第7-10个格子编号分别是1,2,3,4，每个格子编号都是0-9中的一个整数，且相邻格子的编号连在一起有如下规律
     * 1|12|123|1234|...|123456789101112131415|...|123456789101112131415……n
     * 这个仓库存放的商品品类非常丰富，共有1千万多个货架格子。沐哲很好奇，他想快速知道第k个格子编号是多少？
     */
    @Test
    public void storageNumber() {
        int k = 336;
        int[] arr = new int[20000000];
        int n = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (int j = 1; j <= i + 1; j++) {
                if (j > 9) {
                    char[] str = String.valueOf(Integer.valueOf(j)).toCharArray();
                    for (char aStr : str) {
                        arr[n++] = Integer.parseInt(String.valueOf(aStr));
                    }
                } else {
                    arr[n++] = j;
                }
            }
            if (n >= k) {
                System.out.println(arr[k - 1]);
                break;
            }

        }
    }

}
