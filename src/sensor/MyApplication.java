package demo.sensor;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MyApplication extends Application {
	//private static BatteryValue batteryValue;
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();
/*
	public static BatteryValue getBatteryValue() {
		if(batteryValue == null) {
			batteryValue = new BatteryValue();
		}
		return batteryValue;
	}*/

	public MyApplication() {
		singletons.add(new MyResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
