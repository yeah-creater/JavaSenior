package _07网络编程;

import java.net.InetAddress;


/**
 * @author Yeah
 * @date 2021/2/1 - 18:15
 * @intention:
 *
 *       网络编程概述
 *      * 网络通信要素概述
 *      *       通信要素1:IP和端口
 *      *       通信要素2网络协议
 *      * TCP网络编程
 *      * UDP网绛编程
 *      * URL编程
 */
public class ID00Definition {
    /**
     * 网络编程概述
     *
     * Java提供的网络类库,可以实现无痛的网络连接,联网的底层
     * 细节被隐藏在Java的本机安装系统里,由JVM进行控制。并
     * 且Java实现了一个跨平台的网络库,程序员面对的是一个统
     * 的网络编程环境。
     * 网络编程的日的:
     * 直接或间接地通过网络协议与其它计算机实现数据交换,进行通讯
     * 网络编程中有两个主要的问题:
     * 如何准确地定位网络上一台或多台主机;定位主机上的特定的应用
     * 找到主机后如何可靠高效地进行数据传输
     */

    /**
     * 网络通信要素概述
     * IP和端口号
     *      1.IP:唯一的标识 Internet上的计算机(通信实体)
     *      2.在aVa中使用 InetAddress类代表IP
     *      3.IP分类:IP4和IPV6;万维网和局域网
     *      4.tg:Www.baiducomwww.mi.comwwW.sinacomwww.jd.com
     *      www.vlp.com
     *      5.本地回路地址:127,.日.1对应着: Localhost
     *      6.如何实例化 netAddress:两个方法: getByName( String host)、, getLocaLHos
     *      两个常用方法: getHostName()/ getHostAddress()
     *      7.端口号:正在计算机上运行的进程
     *      要求:不同的进程有不同的端口号
     *      范围:被规定为一个16位的整数6~65535
     *      8.端口号与IP地址的组合得出一个网络套接字: Socket
     * 网络通信协议
     *
     */

    public static void main(String[] args)throws Exception {
        InetAddress i1 = InetAddress.getByName("www.baidu.com");
        System.out.println(i1.getHostName());

    }
}
