class Solution {
    public int minimumPartition(String s, int k) {
        // Length of the string 's'.
		int n = s.length();

		// Store the current number formed.
		long cur = 0;

		// 'ans' stores the final answer.
		int ans = 0;

		// Iterate over the string.
		for (int i = 0; i < n; ++i) {
			// If we can include this digit in the
			// current number
			if (cur * 10
					+ Character.getNumericValue(s.charAt(i))
				<= k) {

				// Include this digit in
				// the current number.
				cur = cur * 10
					+ Character.getNumericValue(
						s.charAt(i));
			}
			else {

				// If 'cur' is '0',
				// it's impossible to partition
				if (cur == 0 || cur > k) {

					// Return the integer '-1'
					return -1;
				}
				else {

					// Increment the answer 'ans'
					ans++;

					// Set cur to the current digit
					cur = Character.getNumericValue(
						s.charAt(i));
				}
			}
		}

		// If cur > 0, means the last number is cur
		if (cur > 0 && cur <= k) {

			// Increment the 'ans'
			ans++;
		}

		// Return the number of partitions
		return ans;
    }
}