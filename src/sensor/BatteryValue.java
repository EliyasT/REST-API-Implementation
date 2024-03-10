package demo.sensor;

public class BatteryValue {
    private int value ;
    public BatteryValue() {
       this.value = 100;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
