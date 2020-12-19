package com.muyi.ali.tianchi.oj.weekly.D20201205;

import java.util.HashMap;

/**
 * @author: muyi
 * @date: 2020-12-18 20:39
 *
 * 捡胡萝卜(https://tianchi.aliyun.com/oj/210874425247820050/215397455965131519)
 *
 * 描述
 * 给定一个n * m 的矩阵 carrot, carrot[i][j] 表示(i, j) 坐标上的胡萝卜数量。 从矩阵的中心点出发，每一次移动都朝着四个方向中胡萝卜数量最多的方向移动，保证移动方向唯一。 返回你可以得到的胡萝卜数量。
 *
 * 给定一个n * m 的矩阵 carrot, carrot[i][j] 表示(i, j) 坐标上的胡萝卜数量。 从矩阵的中心点出发，每一次移动都朝着四个方向中胡萝卜数量最多的方向移动，保证移动方向唯一。 返回你可以得到的胡萝卜数量。
 *
 * 示例
 * 示例 1:
 * 输入:
 * carrot =
 * [[5, 7, 6, 3],
 * [2,  4, 8, 12],
 * [3, 5, 10, 7],
 * [4, 16, 4, 17]]
 * 输出: 83
 * 解释：起点坐标是(1, 1), 移动路线是：4 -> 8 -> 12 -> 7 -> 17 -> 4 -> 16 -> 5 -> 10
 *
 * 示例 2:
 * 输入:
 * carrot =
 * [[5, 3, 7, 1, 7],
 *  [4, 6, 5, 2, 8],
 *  [2, 1, 1, 4, 6]]
 *  输出: 30
 *  解释：起始点是 (1, 2), 移动路线是： 5 -> 7 -> 3 -> 6 -> 4 -> 5
 *
 */
public class Q1_pick_up_the_carrot {


    public static int PickCarrots(int[][] carrot) {
        HashMap<String,Integer> hashMap = new HashMap<>();

        int all = 0;

        int x= (carrot[0].length-1)/2;
        int y= (carrot.length-1)/2;

        while(true){
            int n = carrot[y][x];
                hashMap.put(y+"_"+x,0);
            all+=n;

            int t = -1;

            int a = y;
            int b = x;

            //shang
            if(y-1>=0 && !hashMap.containsKey((y-1)+"_"+(x))){
                t = carrot[y-1][x];
                a= y-1;
                b = x;
            }

            //xia
            if(y+1<carrot.length && !hashMap.containsKey((y+1)+"_"+x) ){
                if(t<carrot[y+1][x]) {
                    t = carrot[y+1][x];
                    a = y+1;
                    b = x;
                }
            }

            //zuo
            if(x-1>=0 && !hashMap.containsKey(y+"_"+(x-1)) ){
                if(t<carrot[y][x-1]) {
                    t = carrot[y][x-1];
                    a = y;
                    b = x-1;
                }
            }

            //you
            if(x+1 < carrot[0].length && !hashMap.containsKey(y+"_"+(x+1)) ){
                if(t<carrot[y][x+1]) {
                    t = carrot[y][x+1];
                    a = y;
                    b = x+1;
                }
            }

            if(t <0){
                break;
            }

            y = a;
            x = b;
        }


        return all;
    }

    public static void main(String[] args) {
        int[][] carrot = new int[][]{
                {5, 3, 7, 1, 7},
                {4, 6, 5, 2, 8},
                {2, 1, 1, 4, 6}};
//        int[][] carrot = new int[][]{
//        {5, 7, 6, 3},
//        {2,  4, 8, 12},
//        {3, 5, 10, 7},
//        {4, 16, 4, 17}};

        System.out.println(PickCarrots(carrot));
    }
}

class node{
    public int val;
    public boolean isUse;
}