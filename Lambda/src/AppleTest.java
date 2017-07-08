import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by lh
 * on 2017/7/8.
 */
public class AppleTest {
    private static List<Apple> inventory = new ArrayList<>();
    private static List<Integer> integers = new ArrayList<>();
    public static void init() {
        String[] colors = {"red", "blue", "green"};
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            inventory.add(new Apple(random.nextInt(300), colors[random.nextInt(colors.length)]));
            integers.add(random.nextInt(200));
        }
    }

    public static void main(String[] args) {
        init();
        //使用lambda表达式达到筛选的效果
        List<Apple> apples = filter(inventory, (Apple a) -> "red".equals(a.getColor()) && a.getWeight() > 100);
        System.out.println(apples);
        List<Integer> ints = filter(integers,(Integer i)->i>100);
        System.out.println(ints);
        inventory.sort(new Comparator<Apple>() {//匿名内部类
            @Override
            public int compare(Apple o1, Apple o2) {
                return ((Integer)o1.getWeight()).compareTo(((Integer)o2.getWeight()));
            }
        });
        System.out.println(inventory);
        inventory.sort(Comparator.comparing(o -> ((Integer) o.getWeight())));//lambda表达式
        inventory.sort(Comparator.comparing(Apple::getWeight));//方法引用
        System.out.println(inventory);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
