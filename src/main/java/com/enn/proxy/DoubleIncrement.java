package  com.enn.proxy;

public class DoubleIncrement implements Incrementable {
    private Double count = 0D;
    private Double delta = 0.0001D;

    public DoubleIncrement(Double delta){
        this.delta = delta;
    }

    @Override
    public void increment() {
        this.count = count + delta;
    }
}
