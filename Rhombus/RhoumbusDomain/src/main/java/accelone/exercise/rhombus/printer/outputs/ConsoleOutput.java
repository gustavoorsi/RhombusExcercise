package accelone.exercise.rhombus.printer.outputs;

import java.io.PrintStream;

public class ConsoleOutput implements Output {

	private PrintStream console = System.out;

	@Override
	public void add(String value) {
		console.print(value);
	}

}
