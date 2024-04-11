/**
 * 
 * @author COOVER_ALEX <ALEXCOOVER@LIVE COM>
 */
class MathematicsRec {
	/**
	 * The method returns a value which: - Increases each of even decimal digits of
	 * n by one - Decreases each of odd decimal digits of n by one
	 * 
	 * @param theDecimalNumber the input decimal number (n)
	 * @return the new decimal number after digit adjustments
	 */
	public static long eduodd(long n) {
		if (n == 0)
			return 1;
		else {
			return eduoddCalc(n);
		}

	}
	public static long eduoddCalc(long n) {
		if (n == 0)
			return 0;
		int sign = (n < 0) ? -1 : 1;
		if ((n % 10) % 2 == 0) {
			return eduoddCalc(n / 10) * 10 + (n % 10) + 1 * sign;
		} else {
			return eduoddCalc(n / 10) * 10 + (n % 10) - 1 * sign;
		}	
	}

	/**
	 * The method accepts non-negative integer and returns a value as described
	 * below
	 * 
	 * @param theDecimalNumber is a non-negative decimal number (n)
	 * @return the value in following way: - return 1 when n = 0 - return sum of
	 *         fibby(floor(n/4)) and fibby(floor(3n/4)) when n > 0
	 */
	public static int fibby(int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			n = -n;
		return fibby((n / 4)) + fibby((3 * n / 4));

	}

	/**
	 * The method prints all consecutive values of n and its fibby value
	 * 
	 * @param theLowerBound the lower bound (start)
	 * @param theUpperBound the upper bound (end)
	 */
	public static void stg(int n, int m) {
		System.out.println(n + " " + fibby(n));
		stgHelper(n + 1, m);
	}

	private static void stgHelper(int n, int m) {
		if (n > m)
			return;
		if (fibby(n) != fibby(n - 1)) {
			System.out.println(n + " " + fibby(n));
		}
		stgHelper(n + 1, m);
	}

	/**
	 * The method returns the median that split the array into 3 parts
	 * 
	 * @param theList the list of integers (a)
	 * @return the median
	 */
	public static double median3(int[] n) {
		thirdSorter(n);
		return medianGetter(n);
	}

	private static double medianGetter(int[] n) {
		int third = n.length / 3;
		int remainder = n.length % 3;

		if (n.length == 1) {
			return n[0];
		}
		if (n.length == 2) {
			return (n[0] + n[1]) / 2.0;
		}
		if (n.length == 3) {
			third = 3;
		}

		if (n.length % 3 == 2) {
			third++;
			remainder = 1;
		}
		if (n.length % 3 == 1) {
			remainder = -1;
		}
		double first = medianCalc(n, 0, third - 1);
		
		if (n.length < 4) return first;

		double middle = medianCalc(n, third, 2 * third - 1 - remainder);
		
		double last = medianCalc(n, 2 * third - remainder, n.length);
		return finalMedian(first, middle, last);
	}

	private static double medianCalc(int[] n, int pos, int length) {
		if (pos == length) {
			int val1 = n[pos];
			double val2 = val1;
			return val2;
		}
		if (length == n.length) {
			if (n.length == 4) {
				int val1 = n[3];
				double val2 = val1;
				return val2;
			}
			if (((length) - pos) % 2 != 0) {
				int oddFixer = 0;
				if (pos % 2 != 0 && length > 8) {
					oddFixer = 1;
				}
				int middle = length - (pos / 2) + oddFixer;
				int val1 = n[middle];
				double val2 = val1;
				return val2;
			}
			if (((length) - pos) % 2 == 0) {
				int left = ((length - 1) / 2) + (pos / 2);
				int right = left + 1;
				double avg = (n[left] + n[right]) / 2.0;
				return avg;
			}
		}
		if (((length + 1) - pos) % 2 != 0) {
			int oddFixer = 0;
			if (pos % 2 != 0 && length % 2 != 0) {
				oddFixer = 1;
			}
			int middle = (length / 2) + (pos / 2) + oddFixer;
			int val1 = n[middle];
			double val2 = val1;
			return val2;
		}
		if (((length + 1) - pos) % 2 == 0) {
			int diff = length - pos;
			int left = pos + (diff / 2);
			int right = left + 1;
			double avg = (n[left] + n[right]) / 2.0;
			return avg;
		} else
			return 0;

	}

	public static double finalMedian(double a, double b, double c) {
		if ((a >= b && a <= c) || (a >= c && a <= b))
			return a;
		else if ((b >= a && b <= c) || (b >= c && b <= a))
			return b;
		else
			return c;
	}

	private static void thirdSorter(int[] n) {
		int third = n.length / 3;
		int remainder = n.length % 3;
		if (n.length % 3 == 2) {
			third++;
			remainder = 1;
		}
		if (n.length % 3 == 1) {
			remainder = -1;
		}
		if (n.length == 3) {
			third = 3;
		}
		if (isSorted(n, 0, third - 1) != true) {
			sort(n, 0, third - 1);
			thirdSorter(n);
		}
		if (n.length < 4) return;
		
		if (isSorted(n, third, 2 * third - 1 - remainder) != true) {
			sort(n, third, 2 * third - 1 - remainder);
			thirdSorter(n);
		}
		
		if (isSorted(n, 2 * third - remainder, n.length) != true) {
			sort(n, 2 * third - remainder, n.length);
			thirdSorter(n);
		}

	}

	private static void sort(int[] n, int start, int end) {
		if (start == end || start == n.length - 1) {
			return;
		} else {
			if (n[start] > n[start + 1]) {
				int temp = n[start];
				n[start] = n[start + 1];
				n[start + 1] = temp;
			}
			sort(n, start + 1, end);
		}

	}

	private static boolean isSorted(int[] n, int pos, int length) {
		if (pos == length || pos == n.length - 1)
			return true;
		if (n[pos] < n[pos + 1]) {
			return isSorted(n, pos + 1, length);
		} else
			return false;
	}
}
