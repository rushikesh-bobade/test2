class Solution {
    public int[] twoSum(int[] nums, int target) {
        int mn=0;
        Map<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mn=target-nums[i];
            if(mpp.containsKey(mn)){
                return new int[] {mpp.get(mn),i};
            }
            mpp.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}