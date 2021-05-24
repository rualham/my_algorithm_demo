package com.ham.my_algorithm;

//import com.android.sharedemo.ASMTest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class InjectTest {
    //    @Test
//    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
//    }
    public static int a;

    @ASMTest
    public static void main(String[] args) throws InterruptedException {
//        long l = System.currentTimeMillis();
        Thread.sleep(1000);
//        long e = System.currentTimeMillis();
//        System.out.println("execute= " + (e - l));
    }
}