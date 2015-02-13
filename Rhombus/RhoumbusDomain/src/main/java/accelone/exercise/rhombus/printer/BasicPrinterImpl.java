package accelone.exercise.rhombus.printer;

import java.util.List;

import org.springframework.stereotype.Service;

import accelone.exercise.rhombus.Rhombus;
import accelone.exercise.rhombus.printer.outputs.Output;

/**
 * 
 * @author Gustavo Orsi
 *
 */
@Service(value = "basicPrinter")
public class BasicPrinterImpl implements Printer {

	/**
	 * This method will iterate the rhombus matrix and delegate the print action to the output object, it will also add the extra blank
	 * spaces needed to do a pretty print.
	 */
	@Override
	public void prettyPrintConverter(Rhombus rhombus, Output output) {

		int heartLength = (int) Math.log10(rhombus.getHeart()) + 1;

		// get the total columns this rhombus has. We need them to figure out how many empty spaces we need to add to make the rhombus
		// shape.
		int totalColumns = rhombus.getRhombusMatrix().size();

		// iterate the matrix
		for (List<Integer> line : rhombus.getRhombusMatrix()) {

			// this row of the rhombus should add n empty spaces at the front and back. ( n = spaces )
			int spaces = (totalColumns - line.size()) / 2;

			// print the spaces at the front.
			for (int i = 0; i < spaces; i++) {
				for (int j = 0; j < heartLength; j++) {
					output.add(" ");
				}
			}

			// print the actual row with numbers.
			for (Integer number : line) {
				output.add(String.valueOf(number));
				output.add(" ");
			}

			// print the spaces at the end of the row.
			for (int i = 0; i < spaces; i++) {
				for (int j = 0; j < heartLength; j++) {
					output.add(" ");
				}
			}

			// print new line.
			output.add("\n");
		}

	}

}
