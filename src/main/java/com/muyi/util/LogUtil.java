package com.muyi.util;

import cn.hutool.json.JSONUtil;

/**
 * @Author: muyi
 * @Date: 2020/12/17 10:57
 */
public class LogUtil {
    public static  void  LogConsole(Object o){
        System.out.println(JSONUtil.toJsonStr(o));
    }

    public static void main(String[] args) {
        LogUtil.LogConsole(new char[]{'1','2'});
    }
}
