package accelone.exercise.rhombus.printer.outputs;

public class StringOutput implements Output {

	public StringBuilder stringBuilder = new StringBuilder();

	@Override
	public void add(String value) {
		stringBuilder.append(value);
	}

	@Override
	public String toString() {
		return stringBuilder.toString();
	}

}
