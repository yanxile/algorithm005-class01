class Solution {
    public int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; ++i) {
            if (nums[i] == num) ++ count;
        } 
        return count;
    }
    
    public int majorityElement(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElement(nums, lo, mid);
        int right = majorityElement(nums, mid + 1, hi);
        if (left == right) return left;
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }
    
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }
}