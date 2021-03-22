package com.management.utils;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {

	private static final DateTimeFormatter YMDHMS_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	private static final DateTimeFormatter Y_M_D_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private static final DateTimeFormatter Y_M_D_H_M_S_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	/**
	 * date转日期字符串（yyyyMMddHHmmss）
	 * @param date 转换日期
	 * @return
	 */
	public static String dateToStr(Date date) {
		if (null == date) {
			date = new Date();
		}
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		return instant.atZone(zoneId).toLocalDateTime().format(YMDHMS_FORMATTER);
	}

	/**
	 * date天数加减计算转字符串（yyyy-MM-dd）
	 * @param date 计算日期
	 * @param days 加减天数
	 * @return
	 */
	public static String dateMinusDaysToStr(Date date, int days) {
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDate localDate = instant.atZone(zoneId).toLocalDate();
		return localDate.minusDays(days).format(Y_M_D_FORMATTER);
	}

	/**
	 * 日期字符串（yyyy-MM-dd HH:mm:ss）转date
	 * @param dateStr 日期字符串
	 * @return date
	 */
	public static Date dateStrToDate(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") String dateStr) {
		LocalDateTime localDateTime = LocalDateTime.parse(dateStr, Y_M_D_H_M_S_FORMATTER);
		ZoneId zoneId = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zoneId).toInstant();
		return Date.from(instant);
	}
}
