public class A4Exercises {
	
	/*
	 * Purpose: determine if the stack of plates has been
	 *          stacked correctly (ie. there is never a plate
	 *          on top of a smaller plate)
	 * Parameters: Stack<Plate> s - a stack of plates
	 * Returns: boolean - true if the plates are stacked correctly
	 *                    false otherwise
	 * Post-condition: the contents of s are not modified
	 */
	public static boolean stackedCorrectly(Stack<Plate> s) {
		Stack<Plate> temp = new A4Stack<Plate>();
		while (!s.isEmpty()) {
			temp.push(s.top());
			s.pop();
		}
		while (!temp.isEmpty()) {
			Plate tmp1 = temp.pop();
			s.push(tmp1);
			if (!temp.isEmpty()) {
					Plate tmp2 = temp.top();
				if (tmp1.getDiameter() < tmp2.getDiameter())
					return false;
			}
		}
		return true; // so it compiles
	}

	/*
	 * Purpose: insert p into the correct location in the
	 *          stack such that there are no smaller plates 
	 *          below p and no larger plates above p
	 * Parameters: Stack<Plate> s - a stack of plates
	 *             Plate p - the plate to insert into s
	 * Returns: void - nothing
	 * Pre-condition: plates in s have been stacked correctly
	 */
	public static void insertPlate(Stack<Plate> s, Plate p) {
		Stack<Plate> temp = new A4Stack<Plate>();
		if (s.isEmpty()) {
			s.push(p);
			return;
		}
		else {
			while (!s.isEmpty()) {
				Plate tmp = s.top();
				temp.push(tmp);
				if (p.getDiameter() > tmp.getDiameter()) {
					temp.push(p);
					break;
				}
				s.pop();
			}
			while (!temp.isEmpty()) {
				Plate tmp = temp.pop();
				s.push(tmp);
			}
		}
	}
}