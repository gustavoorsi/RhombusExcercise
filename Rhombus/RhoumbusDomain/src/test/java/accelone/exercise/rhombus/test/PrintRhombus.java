package accelone.exercise.rhombus.test;

import accelone.exercise.rhombus.Rhombus;
import accelone.exercise.rhombus.printer.BasicPrinterImpl;
import accelone.exercise.rhombus.printer.Printer;
import accelone.exercise.rhombus.printer.outputs.ConsoleOutput;
import accelone.exercise.rhombus.printer.outputs.Output;

public class PrintRhombus {

	public static void main(String[] args) {
		Rhombus rhombus;
		try {
			rhombus = new Rhombus(64);
			printToConsole(rhombus);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void printToConsole(final Rhombus rhombus) {
		Printer onlyPrinter = new BasicPrinterImpl();

		Output consoleOutput = new ConsoleOutput();

		onlyPrinter.prettyPrintConverter(rhombus, consoleOutput);
	}

}
