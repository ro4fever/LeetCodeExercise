class Solution {
    public static int getMaxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(getMaxSum(nums));
    }
}
