package accelone.exercise.rhombus.test;

import accelone.exercise.rhombus.Rhombus;
import accelone.exercise.rhombus.printer.BasicPrinterImpl;
import accelone.exercise.rhombus.printer.Printer;
import accelone.exercise.rhombus.printer.outputs.ConsoleOutput;
import accelone.exercise.rhombus.printer.outputs.Output;

public class PrintRhombus {

	public static void main(String[] args) {
		Rhombus rhombus;
		int rhombusHeart = 64; // default to have the 64 in the middle of the rhombus.
		try {

			if (args.length > 0) {
				rhombusHeart = Integer.valueOf(args[0]);
			}

			rhombus = new Rhombus(rhombusHeart);
			printToConsole(rhombus);
		} catch (NumberFormatException ex) {
			System.err.println("Argument" + args[0] + " must be an integer.");
		} catch (IllegalArgumentException ex) {
			System.err.println(ex.getMessage());
		}

	}

	public static void printToConsole(final Rhombus rhombus) {
		Printer onlyPrinter = new BasicPrinterImpl();

		Output consoleOutput = new ConsoleOutput();

		onlyPrinter.prettyPrintConverter(rhombus, consoleOutput);
	}

}
