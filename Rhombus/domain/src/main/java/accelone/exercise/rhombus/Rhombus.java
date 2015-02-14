package accelone.exercise.rhombus;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// @formatter:off
/**
 *  
 * Represent a rhombus with numbers, where the heart of the rhombus is surrounded by a number which is half of the previous.
 * 
 * example:
 * 
 *                           1
 *                       1   2   1
 *                   1   2   4   2   1
 *               1   2   4   8   4   2   1
 *           1   2   4   8  16   8   4   2   1
 *       1   2   4   8  16  32  16   8   4   2   1
 *   1   2   4   8  16  32  64  32  16   8   4   2   1
 *   1   2   4   8  16  32  64  32  16   8   4   2   1
 *       1   2   4   8  16  32  16   8   4   2   1
 *           1   2   4   8  16   8   4   2   1
 *               1   2   4   8   4   2   1
 *                   1   2   4   2   1
 *                       1   2   1
 *                           1
 * 
 * 
 * 
 * 
 * @author Gustavo Orsi
 *
 */
// @formatter:on
public class Rhombus {

	/**************************************************************/
	/*********************** PROPERTIES ***************************/
	/**************************************************************/

	/**
	 * the number in the middle of the rhombus.
	 */
	private final int heart;

	/**
	 * The rhombus matrix.
	 */
	private List<List<Integer>> rhombusMatrix;

	/**************************************************************/
	/********************** CONSTRUCTOR ***************************/
	/**************************************************************/

	/**
	 * Creates a rhombus surrounded by numbers.
	 * 
	 * @param heart
	 *            the number in the center of the rhombus.
	 */
	public Rhombus(final int heart) {
		
		if( heart%2 != 0 ) throw new IllegalArgumentException( "Sorry, the heart of the rhombus must be an even number." );
		
		this.heart = heart;
		this.rhombusMatrix = new LinkedList<List<Integer>>();
		makeRhomubs();
	}

	/**************************************************************/
	/********************* LOGIC METHODS **************************/
	/**************************************************************/

	/**
	 * This method will populate the <code>rhombusMatrix</code> matrix.
	 */
	private void makeRhomubs() {

		int heart = this.heart;

		// this is the bottom half of the rhombus.
		List<List<Integer>> bottomHalfRhombus = new LinkedList<List<Integer>>();

		// add the first element. (1)
		this.rhombusMatrix.add(new LinkedList<Integer>(Arrays.asList(1)));

		// inside this loop we are going to create the half of the rhombus.
		while (heart % 2 == 0) {

			// lets get a half of a rhombus row.
			List<Integer> halfRhombusRow = divide(heart);
			// now that we have a half, lets mirror it.
			List<Integer> rhombusRows = (List<Integer>) mirrorList(halfRhombusRow, new LinkedList<Integer>(halfRhombusRow));

			// and finally merge both half.
			rhombusRows.addAll(halfRhombusRow);

			// add the entire row to the rhombus.
			bottomHalfRhombus.add(rhombusRows);

			heart = heart / 2;
		}

		// we have half of the rhombus so far, so lets mirror it.
		List<List<Integer>> upperHhalfRhombus = (List<List<Integer>>) mirrorList(bottomHalfRhombus, new LinkedList<List<Integer>>(bottomHalfRhombus));

		// duplicate the middle row of the rhombus and add it at the top of the bottom half.
		List<Integer> duplicateMiddleLine = bottomHalfRhombus.get(0);
		bottomHalfRhombus.add(0, duplicateMiddleLine);

		// add first half of the rhombus.
		this.rhombusMatrix.addAll(upperHhalfRhombus);

		// add the second half.
		this.rhombusMatrix.addAll(bottomHalfRhombus);

		// add the last element. (1)
		this.rhombusMatrix.add(new LinkedList<Integer>(Arrays.asList(1)));
	}

	/**
	 * Given the <code>source</code> list, creates a new one with the inverse order.
	 * 
	 * @param source
	 *            the source list.
	 * @param mirror
	 *            the <code>source</code> list with inverted order.
	 * @return a new list like <code>source</code> with inverted order.
	 */
	private List<?> mirrorList(List<?> source, List<?> mirror) {
		// remove the first one so we don't have 2 hearts in the same row. (Avoid this: 1,2,4,8,16,16,8,4,2,1 note the duplicate 16 in the
		// middle.)
		mirror.remove(0);
		// make use of collections utils.
		Collections.reverse(mirror);
		return mirror;
	}

	/**
	 * Creates and populate a List with a sequence of numbers from <code>head</code> till 1. The function applied is: n = n/2 - 1 ---->
	 * (which is the same as: n + 1 = n/2 .Next number is equal to current divided by 2.).
	 * 
	 * @param head
	 *            the base number. ie: 16. then the list will contain: 16,8,4,2,1
	 * @return a List with numbers where each number is the double of the next one.
	 */
	private List<Integer> divide(int head) {
		List<Integer> list = new LinkedList<Integer>();

		// add the first element.
		list.add(head);

		// divide till we reach 0.
		while (head % 2 == 0) {
			list.add(head = head / 2);
		}

		return list;
	}

	/**************************************************************/
	/******************** GETTERS/SETTERS *************************/
	/**************************************************************/

	public List<List<Integer>> getRhombusMatrix() {
		return rhombusMatrix;
	}

	public int getHeart() {
		return heart;
	}

}
