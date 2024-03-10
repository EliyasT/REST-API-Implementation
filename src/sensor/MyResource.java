package demo.sensor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("battery")
public class MyResource {
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SensorValue getSensorValue() {
		SensorValue sensorValue = new SensorValue();
		sensorValue.setValue(100 - (1 + (int) (Math.random() * 5)));
		return new SensorValue();
	}

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String getSensorValueText() {
		SensorValue sensorValue = new SensorValue();
		return sensorValue.time + "," + sensorValue.value + "," +sensorValue.capacity;
	}
}
