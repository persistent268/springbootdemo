package cn.devcorp.demo.utils;


import cn.devcorp.demo.exception.BusinessException;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Description: 散列主键算法
 *
 * Twitter_Snowflake<br>
 * SnowFlake的结构如下(每部分用-分开):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
 * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
 * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
 * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
 * 加起来刚好64位，为一个Long型。<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
 * @author wupanhua
 * @date 2019/8/6 15:28
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public class SnowFlakeUtil {

    private static final Logger log = LoggerFactory.getLogger(SnowFlakeUtil.class);

    private SnowFlakeUtil() {
        // make constructor private
    }
    /**
     * 开始时间截 (2015-01-01)
     */
    private static final long TWEPOCH = 1420041600000L;

    /**
     *机器id所占的位数
     */
    private static final long WORKER_ID_BITS = 5L;

    /**
     *数据标识id所占的位数
     */
    private static final long DATACENTER_ID_BITS = 5L;

    /**
     *序列在id中占的位数
     */
    private static final long SEQUENCE_BITS = 12L;

    /**
     *机器ID向左移12位
     */
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;

    /**
     *数据标识id向左移17位(12+5)
     */
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    /**
     *时间截向左移22位(5+5+12)
     */
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    /**
     *生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
     */
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    /**
     *工作机器ID(0~31)
     */
    private static long workerId;

    /**
     *数据中心ID(0~31)
     */
    private static long datacenterId;

    static {
        try {
            workerId = Math.abs(getLocalHostLANAddress().getHostAddress().hashCode() % 31);
            datacenterId = Math.abs((getLocalHostLANAddress().getHostAddress().hashCode() + RandomUtils.nextInt()) % 31);
        } catch (Exception e) {
            log.error("unknown host error ", e);
        }
    }

    /**
     *毫秒内序列(0~4095)
     */
    private static long sequence = 100L;

    /**
     *上次生成ID的时间截
     */
    private static long lastTimestamp = -1L;

    /**
     * Description:
     * <获得下一个ID (该方法是线程安全的)>
     * @author wupanhua
     * @date 15:52 2019/8/8
     * @return java.lang.Long
     **/
    public static synchronized Long getID(){
        long timestamp = timeGen();

        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new BusinessException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }

        //上次生成ID的时间截
        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - TWEPOCH) << TIMESTAMP_LEFT_SHIFT)
                | (datacenterId << DATACENTER_ID_SHIFT)
                | (workerId << WORKER_ID_SHIFT)
                | sequence;
    }

    public static String idStr() {
        return String.valueOf(getID());
    }

    /**
     * Description:
     * <阻塞到下一个毫秒，直到获得新的时间戳>
     * @author wupanhua
     * @date 15:52 2019/8/8
     * @param lastTimestamp 1
     * @return long
     **/
    protected static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * Description:
     * <返回以毫秒为单位的当前时间>
     * @author wupanhua
     * @date 15:52 2019/8/8
     * @return long
     **/
    protected static long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * Description:
     * <获取真实的IP地址>
     * @author wupanhua
     * @date 10:40 2019-09-03
     * @return java.net.InetAddress
     */
    private static InetAddress getLocalHostLANAddress() throws Exception {
        InetAddress candidateAddress = null;
        // 遍历所有的网络接口
        for (Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements();) {
            NetworkInterface iface = ifaces.nextElement();
            // 在所有的接口下再遍历IP
            for (Enumeration<InetAddress> inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements();) {
                InetAddress inetAddr = inetAddrs.nextElement();
                // 排除loopback类型地址
                if (inetAddr.isSiteLocalAddress() && !inetAddr.isLoopbackAddress()) {
                    return inetAddr;
                }
                if (candidateAddress == null && !inetAddr.isSiteLocalAddress() && !inetAddr.isLoopbackAddress()) {
                    candidateAddress = inetAddr;
                }
            }
        }
        if (candidateAddress != null) {
            return candidateAddress;
        }
        // 如果没有发现 non-loopback地址.只能用最次选的方案
        InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
        if (jdkSuppliedAddress == null) {
            throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
        }
        return jdkSuppliedAddress;
    }

}
