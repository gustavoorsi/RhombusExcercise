package accelone.exercise.rhombus.printer;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import accelone.exercise.rhombus.Rhombus;
import accelone.exercise.rhombus.printer.outputs.Output;

/**
 * 
 * @author Gustavo Orsi
 *
 */
@Service(value = "betterPrinter")
public class BetterPrinterImpl implements Printer {

	private static final String BLANK_SPACE = " ";
	private static final String NEW_LINE = "\n";

	/**
	 * This method will iterate the rhombus matrix and delegate the print action to the output object, it will also add the extra blank
	 * spaces needed to do a pretty print.
	 */
	@Override
	public void prettyPrintConverter(Rhombus rhombus, Output output) {

		// the amount of digits the heart of the rhombus has (which is the longest in the entire list of numbers). This way we calculate the
		// extra spaces each cell needs based on the longest cell. Example: if the longest number is 128 then all cells should have 3
		// character holders.
		int heartLength = (int) Math.log10(rhombus.getHeart()) + 1;

		// get the total columns this rhombus has. We need them to figure out how many empty spaces we need to add to make the rhombus
		// shape.
		int totalColumns = rhombus.getRhombusMatrix().size();

		// iterate the rhombus
		for (int i = 0; i < totalColumns; i++) {
			List<Integer> row = rhombus.getRhombusMatrix().get(i);

			// calculate the number of 'empty spaces' we need to add (at the beginning and end of the row).
			int addSpaces = (totalColumns - row.size()) / 2;

			// add 'n' zeros at the beginning and end of the row (this zeros will be replaced by blank spaces)
			addBefore(row, addSpaces);
			addAfter(row, addSpaces);

			// iterate the row and replace zeros with empty spaces.
			for (int j = 0; j < totalColumns - 1; j++) {
				Integer number = rhombus.getRhombusMatrix().get(i).get(j);
				String format = "%0" + heartLength + "d";
				String numberToString = String.format(format, number).replace("0", BLANK_SPACE);

				output.add(numberToString);
				output.add(BLANK_SPACE);
			}
			output.add(NEW_LINE);
		}

	}

	/**
	 * Add a 0 (zero) at the beginning of the list n times, where n = amount.
	 * 
	 * @param list
	 * @param amount
	 *            the number of zeros that should be added at the beginning.
	 */
	private void addBefore(List<Integer> list, int amount) {

		for (int i = 0; i < amount; i++) {
			((LinkedList<Integer>) list).addFirst(0);
		}
	}

	/**
	 * Add a 0 (zero) at the end of the list n times, where n = amount.
	 * 
	 * @param list
	 * @param amount
	 *            the number of zeros that should be added at the end.
	 */
	private void addAfter(List<Integer> list, int amount) {

		for (int i = 0; i < amount; i++) {
			((LinkedList<Integer>) list).addLast(0);
		}
	}

}
