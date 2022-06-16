package com.yacoding.xt.common.login;

/**
 * @Author yaCoding
 * @create 2022-04-19 下午 3:44
 */

public class UserThreadLocal {//设置一个内存泄露的处理仓库

    private static final ThreadLocal<Long> LOCAL = new ThreadLocal<>();

    public static void put(Long userId) {
        LOCAL.set(userId);
    }

    public static Long get() {
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }

}
