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

		// the amount of digits the heart of the rhombus has (which is the longest in the entire list of numbers).
		int heartLength = (int) Math.log10(rhombus.getHeart()) + 1;

		// get the total columns this rhombus has. We need them to figure out how many empty spaces we need to add to make the rhombus
		// shape.
		int totalColumns = rhombus.getRhombusMatrix().size();

		for (int i = 0; i < totalColumns; i++) {
			List<Integer> row = rhombus.getRhombusMatrix().get(i);

			int addSpaces = (totalColumns - row.size()) / 2;

			addBefore(row, addSpaces);
			addAfter(row, addSpaces);
		}

		for (int i = 0; i < totalColumns; i++) {
			for (int j = 0; j < totalColumns-1; j++) {
				Integer number = rhombus.getRhombusMatrix().get(i).get(j);
				String format = "%0" + heartLength + "d";
				String numberToString = String.format(format, number).replace("0", " ");
				
				output.add( numberToString );
				output.add( BLANK_SPACE);
			}
			output.add( NEW_LINE );
			
		}


	}

	private void addBefore(List<Integer> list, int amount) {

		for (int i = 0; i < amount; i++) {
			((LinkedList<Integer>) list).addFirst(0);
		}
	}

	private void addAfter(List<Integer> list, int amount) {

		for (int i = 0; i < amount; i++) {
			((LinkedList<Integer>) list).addLast(0);
		}
	}

}
