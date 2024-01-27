public class A5Exercises {

	// PART 1

	/*
	 * Purpose: get a count of the number of elements in the array
	 *          with a value that is a multiple of x
	 * Parameters: int[] arr
	 * Returns: int - the number multiples of x
	 * Pre-condition: x > 0
	 * Post-condition - the array contents are unchanged
	 */
	public static int countMultiples(int[] arr, int x) {
		return countMultiplesHelper(arr, x, 0); // so it compiles 
	}

	public static int countMultiplesHelper(int[] a, int x, int pos) {
		int cnt = 0;
		if (pos >= a.length) {
			return cnt;
		} else {
			if (a[pos] % x == 0) {
				cnt++;
			}
			return cnt + countMultiplesHelper(a, x, pos + 1);
		}
	}
		
	/*
	 * Purpose: double all values in the given array
	 * Parameters: int[] array - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] array) {
		doubleAllHelper(array, 0);
	}

	public static void doubleAllHelper(int[] a, int pos) {
		if (pos >= a.length) {
			return;
		} else {
			a[pos] *= 2;
			doubleAllHelper(a, pos + 1);
		}
	}
	
	/*
	 * Purpose: get the minimum value found in the array
	 * Parameters: int[] array - the array to search
	 * Returns: int - minimum value found in the array
	 *                or -1 if the array is empty
	 * Post-condition - the array contents are unchanged
	 */
	public static int getMinimum(int[] array) {
		if (array.length == 0) {
			return -1;
		} else {
			return getMinimumHelper(array, 0, array[0]); // so it compiles
		}
	}
	
	public static int getMinimumHelper(int[] a, int pos, int mn) {
		if (pos >= a.length) {
			return mn;
		} else {
			mn = Math.min(a[pos], mn);
			return getMinimumHelper(a, pos + 1, mn);
		}
	}
	



	// PART II

	/*
	 * Purpose: get the total number of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of books
	 * Post-condition: s is not modified
	 */
	public static int totalBooks(Stack<Book> s) {
		Stack<Book> c = new A5Stack<Book>();
		totalBooksHelper(s, c);
		return totalBooksHelper(c, s);
		 // so it compiles
	}

	public static int totalBooksHelper(Stack<Book> s1, Stack<Book> s2) {
		int cnt = 0;
		if (s1.isEmpty()) {
			return cnt;
		} else {
			cnt ++;
			s2.push(s1.top());
			s1.pop();
			cnt = cnt + totalBooksHelper(s1, s2);
			return cnt;
		}
	}

	/*
	 * Purpose: get the total number of pages of all 
	 *          books in the stack
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of pages
	 * Post-condition: s is not modified
	 */
	public static int totalPages(Stack<Book> s) {
		Stack<Book> c = new A5Stack<Book>();
		totalPagesHelper(s, c);
		return totalPagesHelper(c, s);
		 // so it compiles
	}

	public static int totalPagesHelper(Stack<Book> s1, Stack<Book> s2) {
		int cnt = 0;
		if (s1.isEmpty()) {
			return cnt;
		} else {
			cnt += s1.top().getPages();
			s2.push(s1.top());
			s1.pop();
			cnt = cnt + totalPagesHelper(s1, s2);
			return cnt;
		}
	}
	
	/*
	 * Purpose: get the average number of pages of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: double - the average number of pages
	 *                   0.0 if there are no books in s
	 * Post-condition: s is not modified
	 */
	public static double averagePages(Stack<Book> s) {
		// You don't need to change this, if you have
		// completed the previous two exercises
		// correctly, it should pass all the tests
		if (s.isEmpty()) {
			return 0.0;
		} else {
			double sum = totalPages(s);
			int count = totalBooks(s);
			return sum/count;
		}
	}

	/*
	 * Purpose: determine whether toFind is contained in s
	 * Parameters: Stack<Book> s - the stack of books
	 *             Book toFind - the book to search for
	 * Returns: boolean - true if s contains toFind, false otherwise
	 * Post-condition: s is not modified
	 */
	public static boolean containsBook(Stack<Book> s, Book toFind) {
		Stack<Book> c = new A5Stack<Book>();
		containsBookHelper(s, c, toFind);
		return (containsBookHelper(c, s, toFind) > 0); // so it compiles
	}

	public static int containsBookHelper(Stack<Book> s1, Stack<Book> s2, Book toFind) {
		int cnt = 0;
		if (s1.isEmpty()) {
			return cnt;
		} else {
			if (s1.top().equals(toFind)) {
				cnt++;
			}
			s2.push(s1.top());
			s1.pop();
			cnt = cnt + containsBookHelper(s1, s2, toFind);
			return cnt;
		}
	}

	/*
	 * Purpose: determine the books in s are stacked correctly
	 *          (ie. there is never a book stacked on top of 
	 *               another book with fewer pages)
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: boolean - true if books in s are stacked correctly
	 * Post-condition: s is not modified
	 */
	public static boolean stackedCorrectly(Stack<Book> s) {
		Stack<Book> c = new A5Stack<Book>();
		stackedCorrectlyHelper(s, c);
		return (stackedCorrectlyHelper(c, s) == 0);
		// so it compiles
	}

	public static int stackedCorrectlyHelper(Stack<Book> s1, Stack<Book> s2) {
		int cnt = 0;
		if (s1.isEmpty()) {
			return cnt;
		} else {
			Book b1 = s1.top();
			s2.push(s1.top());
			s1.pop();
			if (!s1.isEmpty()) {
				Book b2 = s1.top();
				s2.push(s1.top());
				s1.pop();
				if (b1.getPages() <= b2.getPages()) {
					cnt ++;
				}
				cnt = cnt + stackedCorrectlyHelper(s1, s2);
			}
			return cnt;
		}
	}
}