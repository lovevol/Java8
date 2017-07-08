/**
 * Created by lh
 * on 2017/7/8.
 */
public class Apple{
    private int weight;
    private String color;
    public Apple(int w, String c){
        weight = w;
        color = c;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "weight:"+weight+" color:"+color+"\n";
    }
}
