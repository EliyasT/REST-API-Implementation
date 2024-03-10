package demo.sensor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Instant;

@XmlRootElement(name = "battery")
public class SensorValue {
	@XmlElement
	@XmlJavaTypeAdapter(MyInstantAdapter.class)
	public Instant time;
	public int value;
	public String capacity;

	public SensorValue() {
		time = Instant.now();
		 this.value = 100;
				/*MyApplication.getBatteryValue().getValue();
		if (value > 0) {
			MyApplication.getBatteryValue().setValue(value - (1 + (int) (Math.random() * 5)));
		} else {
			value = 0;
		}*/
		capacity = "43.2Wh";
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SensorValue{" +
				"time=" + time +
				", value=" + value +
				", capacity" + capacity +
				'}';
	}
}
