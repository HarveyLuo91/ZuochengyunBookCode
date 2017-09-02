package SouHu.jerry;

import java.util.Arrays;

/**
 * Created by jerry on 2017/8/29.
 */
public class SlotTest {
    /**
     * 主要验证重复利用Slot对于垃圾回收的帮助
     ×（1）运行参数：-verbose:gc -XX:+PrintGCDetails
     * （2）64M的对象大于了目前年轻代的空间，根据大对象直接进入老年代的原则，在观察结果的时候需要关注ParOldGen
     * */

    public static int M = 1024 << 10;

    public static void main(String[] args) {
        new SlotTest().test6();
    }

    /**
     * replace 在执行gc操作的时候还没有超过它的作用域，也就是堆中还有实例和它直接关联所以不会被回收掉
     *
     * [GC [PSYoungGen: 614K->352K(17856K)] 66150K->65888K(124224K),
     * 0.0024710 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [Full GC
     * (System) [PSYoungGen: 352K->0K(17856K)] [ParOldGen:
     * 65536K->65759K(106368K)] 65888K->65759K(124224K) [PSPermGen:
     * 2403K->2401K(21248K)], 0.0102720 secs] [Times: user=0.02 sys=0.00,
     * real=0.01 secs]
     */
    public void test1() {
        // 64M
        byte[] replace = new byte[M << 6];
        System.gc();
    }

    /**
     * 在执行gc时，虽然replace已经过期，但是由于它的Slot中仍然存有相关的局部变量信息，所以gc 还是不可以 对64M的内存进行回收
     *
     * [GC [PSYoungGen: 614K->288K(17856K)] 66150K->65824K(124224K),
     * 0.0019600 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] [Full GC
     * (System) [PSYoungGen: 288K->0K(17856K)] [ParOldGen:
     * 65536K->65758K(106368K)] 65824K->65758K(124224K) [PSPermGen:
     * 2403K->2401K(21248K)], 0.0139210 secs] [Times: user=0.02 sys=0.00,
     * real=0.01 secs]
     */
    public void test2() {
//        byte t;
        {
            byte[] replace = new byte[M << 6];
        }
        System.gc();
    }

    /**
     * 在执行gc之前，由于a复用了replace 的Slot，所以此时可以认为replace在堆中的实例没有相关的引用，因此在gc的时候会将它回收
     * [GC [PSYoungGen: 614K->368K(17856K)] 66150K->65904K(124224K),
     * 0.0019430 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [Full GC
     * (System) [PSYoungGen: 368K->0K(17856K)] [ParOldGen:
     * 65536K->223K(106368K)] 65904K->223K(124224K) [PSPermGen:
     * 2403K->2401K(21248K)], 0.0107030 secs] [Times: user=0.01 sys=0.01,
     * real=0.01 secs]
     */
    public void test3() {
//        byte t;
        {
            byte[] replace = new byte[M << 6];
//            t = replace[0];
        }
        int a = 0;
        System.gc();
//        System.out.println(t);
    }

    public void test4(){
        byte t;
        {
            byte[] replace = new byte[M << 6];
            t = replace[0];
        }
        int a = 1;
        System.gc();
    }


    public void test5(){
        byte[] t = new byte[M<<5];
        {
            byte[] replace = new byte[M << 6];
            for (int i = 0; i < M << 5; i++) {
                t[i] = replace[i];
            }
        }
        System.gc();
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 3339K->528K(38400K)] 101643K->98840K(192000K), 0.0036643 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (System.gc()) [PSYoungGen: 528K->0K(38400K)] [ParOldGen: 98312K->33196K(153600K)] 98840K->33196K(192000K), [Metaspace: 3310K->3310K(1056768K)], 0.0091341 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     Heap
     PSYoungGen      total 38400K, used 333K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
     eden space 33280K, 1% used [0x0000000795580000,0x00000007955d34a8,0x0000000797600000)
     from space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
     to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
     ParOldGen       total 153600K, used 33196K [0x0000000740000000, 0x0000000749600000, 0x0000000795580000)
     object space 153600K, 21% used [0x0000000740000000,0x000000074206b340,0x0000000749600000)
     Metaspace       used 3317K, capacity 4500K, committed 4864K, reserved 1056768K
     class space    used 370K, capacity 388K, committed 512K, reserved 1048576K
     */

    public void test6(){
        byte[] t = new byte[M<<5];
        {
            byte[] replace = new byte[M << 6];
            for (int i = 0; i < M << 5; i++) {
                t[i] = replace[i];
            }
        }
        int a = 0;
        System.gc();
    }

}
