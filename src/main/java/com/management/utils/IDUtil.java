package com.management.utils;

import java.util.UUID;

/**
 * id工具类
 * @auth caolf
 * @date 2020/9/30 16:26
 */
public class IDUtil {

	public static String genUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 返回8位随机数
	 * @return
	 */
	public static String getRandomEight() {
		return String.valueOf((int)((Math.random() * 9 + 1) * Math.pow(10, 7)));
	}
}
