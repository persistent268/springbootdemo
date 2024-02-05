package cn.devcorp.demo.utils;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Description: DateUtil
 *
 * @author wupanhua
 * @date 2019/8/6 15:28
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Slf4j
public class DateUtil {

    private static final ThreadLocal<Map<String, SimpleDateFormat>> safeFormat = new ThreadLocal<>();
    private final ThreadLocal<Calendar> safeCalendar = ThreadLocal.withInitial(Calendar::getInstance);
    private final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final ZoneId DEFAULT_ZONE = ZoneId.of("Asia/Shanghai");

    /**
     * Description:
     * <从ThreadLocal中获取一个SimpleDateFormat,线程安全的，一定要在执行一次safeFormat.remove()方法>
     *
     * @param dateStyle 1
     * @return java.text.SimpleDateFormat
     * @author wupanhua
     * @date 15:27 2019/8/8
     **/
    private static SimpleDateFormat getformatTools(DateStyle dateStyle) {
        try {
            String style = dateStyle.getStyle();
            Map<String, SimpleDateFormat> tool = safeFormat.get();

            if (tool == null) {
                tool = Maps.newHashMap();
            }

            SimpleDateFormat sdf = tool.get(style);
            if (sdf == null) {
                sdf = new SimpleDateFormat(style, Locale.getDefault());
                tool.put(style, sdf);
                safeFormat.set(tool);
            }

            return sdf;
        } catch (Exception ex) {
            log.error("getformatTools exception", ex);
            throw ex;
        } finally {
            safeFormat.remove();
        }
    }

    /**
     * Description:
     * <将日期格式化成指定的格式>
     *
     * @param date      1
     * @param dateStyle 2
     * @return java.lang.String
     * @author wupanhua
     * @date 15:28 2019/8/8
     **/
    public static String format(Date date, DateStyle dateStyle) {

        if (Objects.isNull(date)) {
            return null;
        }

        return getformatTools(dateStyle).format(date);
    }

    /**
     * Description:
     * <日期字符串格式化为Date类型>
     *
     * @param dateStr   1
     * @param dateStyle 2
     * @return java.util.Date
     * @author wupanhua
     * @date 15:28 2019/8/8
     **/
    public static Date parse(String dateStr, @NotNull DateStyle dateStyle) {

        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }

        Date date = null;
        try {
            date = getformatTools(dateStyle).parse(dateStr);
        } catch (ParseException e) {
            log.error("格式化日期失败 error", e);
        }
        return date;
    }

    /**
     * Description:
     * <获取指定日期的年份>
     *
     * @param date 1
     * @return int
     * @author wupanhua
     * @date 15:28 2019/8/8
     **/
    public int getYear(Date date) {

        try {
            if (null != date) {
                safeCalendar.get().setTime(date);
                return safeCalendar.get().get(Calendar.YEAR);
            }
        } finally {
            safeCalendar.remove();
        }
        return 0;
    }

    /**
     * Description:
     * <获取月份>
     *
     * @param date 1
     * @return int
     * @author wupanhua
     * @date 15:29 2019/8/8
     **/
    public int getMounth(Date date) {

        try {
            if (null != date) {
                safeCalendar.get().setTime(date);
                return safeCalendar.get().get(Calendar.MONTH) + 1;
            }
        } finally {
            safeCalendar.remove();
        }
        return 0;
    }

    /**
     * Description:
     * <获取两日期间的间隔天数，不包含周六日，相同日期算1天>
     *
     * @param start 1
     * @param end   2
     * @return java.lang.Integer
     * @author wenxiaopeng
     * @date 15:47 2021/05/06
     **/
    public static Integer getDayDuration(Date start, Date end) {
        Integer duration = null;
        // TODO 自定义节假日
        if (null != end && null != start) {
            duration = 1;
            Calendar startCalendar = DateUtils.toCalendar(start);
            Calendar endCalendar = DateUtils.toCalendar(end);
            while (startCalendar.compareTo(endCalendar) < 0) {
                int weekDay = startCalendar.get(Calendar.DAY_OF_WEEK);
                if (weekDay < Calendar.SATURDAY && weekDay > Calendar.SUNDAY) {
                    duration++;
                }
                startCalendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }

        return duration;
    }

    /**
     * Description:
     * <日期风格>
     *
     * @author wupanhua
     * @date 15:29 2019/8/8
     **/
    public enum DateStyle {
        /**
         * 年/月/日/时/分/秒
         */
        ALL("yyyy-MM-dd HH:mm:ss"),

        YMDHM("yyyy-MM-dd HH:mm"),
        /**
         * 年/月/日
         */
        YEAE_MONTH_DAY("yyyy-MM-dd"),
        /**
         * 时/分/秒
         */
        HH_DOT_MM_DOT_SS("HH:mm:ss"),
        /**
         * 新格式/年/月/日/时/分/秒
         */
        NEW_DATE("_yyyy_MM_dd_HH_mm_ss"),
        /**
         *
         */
        YYYYMMDDHH_mm("yyyyMMddHH_mm"),
        /**
         * 年/月/日
         */
        YEARMONTHDAY("yyyyMMdd"),

        /**
         * 年/月/日
         */
        YYYYMMDDHHMM("yyyyMMddHHmm"),

        /**
         * 年/月/日时分秒
         */
        yyyyMMddHHmmss("yyyyMMddHHmmss");

        private String style;

        DateStyle() {
        }

        DateStyle(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }

    /**
     * Description:
     * <计算时间差>
     *
     * @param starDate 1
     * @param endDate  2
     * @return java.lang.String
     * @author yangliu
     * @date 15:31 2019/8/8
     **/
    public static String getDatePoor(Date starDate, Date endDate) {

        long nd = 1000 * 24 * 60 * 60L;
        long nh = 1000 * 60 * 60L;
        long nm = 1000 * 60L;
        long ns = 1000L;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - starDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;

        return day + "天" + hour + "小时" + min + "分钟" + sec + "秒";
    }

    /**
     * Description:
     * <计算时间差>
     *
     * @param starDate 1
     * @param endDate  2
     * @return String 秒 s
     * @author WZC
     * @date 15:08 2022/4/15
     **/

    public static String getDateDiff(Date starDate, Date endDate) {
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - starDate.getTime();
        return Long.toString(diff / 1000);
    }

    /**
     * @param date 输入日期
     * @param iday 要增加或减少的天数
     * @描述 在输入日期上增加（+）或减去（-）天数
     */
    public static Date addDay(Date date, int iday) {
        Calendar cd = Calendar.getInstance();

        cd.setTime(date);

        cd.add(Calendar.DAY_OF_MONTH, iday);

        return cd.getTime();
    }

    /**
     * @param date
     * @return
     * @描述 —— 时间对象转换成字符串
     * @作者 yangyang
     * @创建日期 2012-7-13
     * @创建时间 下午12:24:19
     */
    public static String date2string(Date date, String formatStr) {
        String strDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        strDate = sdf.format(date);
        return strDate;
    }

    /**
     * 返回两时间相差的天数
     *
     * @param smdate
     * @param bdate
     * @return
     * @throws ParseException
     * @author yangyang
     */
    public static int daysBetween(Date smdate, Date bdate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * @param date    日期
     * @param seconds 秒数
     * @return
     * @描述 增加秒数
     * @autho yangyang
     */
    public static Date addSeconds(Date date, int seconds) {
        Calendar cd = Calendar.getInstance();

        cd.setTime(date);

        cd.add(Calendar.SECOND, seconds);

        return cd.getTime();
    }

    /**
     * Description:
     * <格式化日期对象>
     *
     * @param date 1
     * @return
     * @Author yangyang
     * @Date 2022/4/26
     **/
    public static Date date2date(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String str = sdf.format(date);
        try {
            date = sdf.parse(str);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    /**
     * 获取当前日期的指定格式的字符串
     *
     * @param format 指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:mm"
     * @return
     */
    public String getCurrentTime(String format) {
        if (format == null || format.trim().equals("")) {
            sdf1.applyPattern(DateStyle.ALL.getStyle());
        } else {
            sdf1.applyPattern(format);
        }
        return sdf1.format(new Date());
    }


    /**
     * Description:
     * <时间增加分钟>
     *
     * @param date 1
     * @param min  2
     * @return java.util.Date
     * @Author yangyang
     * @Date 11:04 2022/11/4
     **/
    public static Date addMin(Date date, int min) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.MINUTE, min);
        return cd.getTime();
    }

    /**
     * Description:
     * <时间增加小时>
     *
     * @param date 1
     * @param min  2
     * @return java.util.Date
     * @Author yangyang
     * @Date 11:03 2022/11/4
     **/
    public static Date addHour(Date date, int min) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.HOUR, min);
        return cd.getTime();
    }

    /**
     * Description:计算两个时间之间相差的分钟数
     * <>
     *
     * @Author yangyang
     * @Date 16:25 2022/5/21
     **/
    public static long timeDifference(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Expecting date parameter not to be null");
        }
        return Math.abs((date1.getTime() - date2.getTime()) / 1000 / 60);
    }


    /**
     * Description:计算两个时间之间相差的秒数
     * <>
     *
     * @Author yangyang
     * @Date 16:25 2022/5/30
     **/
    public static long timeDifferenceSecond(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Expecting date parameter not to be null");
        }
        return Math.abs((date1.getTime() - date2.getTime()) / 1000);
    }


    /**
     * Description:
     * <格式转换 秒 转换成 00:00:00 格式 >
     *
     * @param seconds 1
     * @return void
     * @Author yangyang
     * @Date 16:51 2022/6/10
     **/
    public static String dateFormatFromSeconds(Long seconds) {
        if (seconds == null || seconds < 0) {
            seconds = 32000L;
            return "00:00:00";
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        // 设置时区，跳过此步骤会默认设置为"GMT+08:00" 得到的结果会多出来8个小时
        format.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        return format.format(seconds * 1000);
    }


    /**
     * Description:
     * <获取日期所需要查询周的周一>
     *
     * @param n 1
     * @return java.util.Date
     * @Author yangyang
     * @Date 15:11 2022/10/28
     **/
    public static Date getMonDayToDate(int n) {
        Calendar cal = Calendar.getInstance();

        // N：0-表示本周，1-表示下周，-1-表示上周
        cal.add(Calendar.DATE, n * 7);
        // Calendar.MONDAY 表示获取周一的日期; Calendar.WEDNESDAY:表示周三的日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return cal.getTime();
    }

    /**
     * 时间差，以x小时x分x秒的格式
     *
     * @param date    日期A
     * @param another 日期B
     * @return java.lang.String
     * @author wenxiaopeng
     * @date 2023/2/7 10:54
     **/
    public static String diffAsHourMinutes(Date date, Date another) {
        if (null == date || null == another) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        long seconds = timeDifferenceSecond(date, another);
        // 24h 60min 60s
        if (seconds >= 3600) {
            sb.append(seconds / 3600).append("小时");
            seconds = seconds % 3600;
        }
        // 24h 60min 60s
        if (seconds >= 60) {
            sb.append(seconds / 60).append("分");
            seconds = seconds % 60;
        }
        if (seconds > 0 || sb.capacity() <= 0) {
            sb.append(seconds).append("秒");
        }

        return sb.toString();
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(DEFAULT_ZONE).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(DEFAULT_ZONE).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(DEFAULT_ZONE).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(DEFAULT_ZONE).toLocalDateTime();
    }


    public static final SafeSimpleDateFormat YYYY_MM_DD = new SafeSimpleDateFormat("yyyy-MM-dd");
    public static final SafeSimpleDateFormat YYYY_MM_DD_HH = new SafeSimpleDateFormat("yyyy-MM-dd HH");
    public static final SafeSimpleDateFormat YYYY_MM_DD_HH_MI = new SafeSimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SafeSimpleDateFormat YYYY_MM_DD_HH_MI_SS = new SafeSimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String date2Str(Date date) {
        return date2Str(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String date2Str(Date date, String pattern) {
        return null == date ? null : getDateFormat(pattern).format(date);
    }

    public static SafeSimpleDateFormat getDateFormat(String pattern) {
        return new SafeSimpleDateFormat(pattern);
    }

    public static Map<String, Long> getDateRage1(String startTimeStr, String endTimeStr, Map<String, Long> timeMap) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);
        while (startTime.isBefore(endTime) || startTime.equals(endTime)) {
            String key = startTime.format(DateTimeFormatter.ofPattern("dd-HH"));
            if (!timeMap.containsKey(key)) {
                timeMap.put(key, 0L);
            }
            startTime = startTime.plusHours(1);
        }
        return new TreeMap<>(timeMap);
    }

    public static Map<String, Long> getDateRage2(int type, String startTimeStr, String endTimeStr, Map<String, Long> timeMap) {
        LocalDate start = LocalDate.parse(startTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate end = LocalDate.parse(endTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate current = start;
        while (!current.isAfter(end)) {
            if (1 == type) {
                String key = current.getYear() + "-" + String.format("%02d", current.getMonthValue());
                if (!timeMap.containsKey(key)) {
                    timeMap.put(key, 0L);
                }
            } else {
                if (!timeMap.containsKey(current.toString())) {
                    timeMap.put(current.toString(), 0L);
                }
            }

            current = current.plusDays(1);
        }
        return new TreeMap<>(timeMap);
    }

 /*   public static void main(String[] args) {
        Map<String, Long> timeMap = Maps.newHashMap();
//        timeMap.put("22-14", 50L);
        timeMap.put("2024-01", 50L);
//        getDateRage1("2024-01-22 00:00", "2024-01-24 23:59", timeMap);
        getDateRage2(1, "2022-01-22", "2024-01-30", timeMap);
        System.out.println(timeMap);
    }
    */


}
