// Assignment #: 8
//         Name: Aaron Kampmeier
//    StudentID: 1217750807
//      Lecture: T&Th 10:30
//  Description: Compares clubs using their presidents.

import java.util.Comparator;

public class CurrentPresidentComparator implements Comparator<Club> {
	/**
	 * Compares its two arguments for order.  Returns a negative integer,
	 * zero, or a positive integer as the first argument is less than, equal
	 * to, or greater than the second.<p>
	 * <p>
	 * In the foregoing description, the notation
	 * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
	 * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
	 * <tt>0</tt>, or <tt>1</tt> according to whether the value of
	 * <i>expression</i> is negative, zero or positive.<p>
	 * <p>
	 * The implementor must ensure that <tt>sgn(compare(x, y)) ==
	 * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
	 * implies that <tt>compare(x, y)</tt> must throw an exception if and only
	 * if <tt>compare(y, x)</tt> throws an exception.)<p>
	 * <p>
	 * The implementor must also ensure that the relation is transitive:
	 * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
	 * <tt>compare(x, z)&gt;0</tt>.<p>
	 * <p>
	 * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
	 * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
	 * <tt>z</tt>.<p>
	 * <p>
	 * It is generally the case, but <i>not</i> strictly required that
	 * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
	 * any comparator that violates this condition should clearly indicate
	 * this fact.  The recommended language is "Note: this comparator
	 * imposes orderings that are inconsistent with equals."
	 *
	 * @param o1 the first object to be compared.
	 * @param o2 the second object to be compared.
	 * @return a negative integer, zero, or a positive integer as the
	 * first argument is less than, equal to, or greater than the
	 * second.
	 * @throws NullPointerException if an argument is null and this
	 *                              comparator does not permit null arguments
	 * @throws ClassCastException   if the arguments' types prevent them from
	 *                              being compared by this comparator.
	 */
	@Override
	public int compare(Club o1, Club o2) {
		if (o1.getCurrentPresident().getLastName().equals(o2.getCurrentPresident().getLastName())) {
			//Compare the first names
			return o1.getCurrentPresident().getFirstName().compareTo(o2.getCurrentPresident().getFirstName());
		} else {
			//Compare the last names
			return o1.getCurrentPresident().getLastName().compareTo(o2.getCurrentPresident().getLastName());
		}
	}
}
