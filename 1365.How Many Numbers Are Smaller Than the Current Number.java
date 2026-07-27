class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] count = new int[101]; // values are 0 to 100 per constraints

        // Count frequency of each value
        for (int num : nums) {
            count[num]++;
        }

        // Convert to prefix sum: count[i] becomes "how many numbers are < i"
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return result;
    }
}
