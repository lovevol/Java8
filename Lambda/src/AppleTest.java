import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lh
 * on 2017/7/8.
 */
public class AppleTest {
    private static List<Apple> inventory = new ArrayList<>();
    public static void init(){
        String[] colors = {"red","blue","green"};
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++){
            inventory.add(new Apple(random.nextInt(300),colors[random.nextInt(colors.length)]));
        }
    }
    public static void main(String[] args){
        init();
        List<Apple> list = filterApples(inventory,(Apple a)->"red".equals(a.getColor()));
        System.out.print(list);
    }
    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
