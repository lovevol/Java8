import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by lh
 * on 2017/7/8.
 */
public class LambdaTest {
    public static void main(String[] args){
        Thread thread1 = new Thread(()->System.out.println("Hello word form thread1"),"thread1");
        Thread thread2 = new Thread(()->System.out.println("Hello word form thread2"),"thread2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world from main");
        Runnable r1 = ()->System.out.println("hello world from r1");
        Runnable r2 = new Runnable() {//函数式接口
            @Override
            public void run() {
                System.out.println("hello world from r2");
            }
        };
        process(r1);
        process(r2);
        process(()->System.out.println("hello world from r3"));
        //方法引用测试
        List<String> stringList = Arrays.asList("a","C","b","D");
        stringList.sort(String::compareToIgnoreCase);
        System.out.println(stringList);
        stringList = Arrays.asList("a","C","b","D");
        stringList.sort((s1,s2)->s1.compareToIgnoreCase(s2));
        System.out.println(stringList);

        Function<Integer,Integer> g = x->x+1;
        Function<Integer,Integer> h = x->x*2;
        Function<Integer,Integer> f = g.compose(h);
        int result = f.apply(8);
        System.out.println(result);



    }
    public static void process(Runnable runnable){//测试
        runnable.run();
    }
}
