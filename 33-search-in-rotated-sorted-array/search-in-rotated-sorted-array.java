class Solution {
    public int search(int[] nums, int target) {
        int minIndex= findMin(nums,target);
        if(target>= nums[minIndex]&& target<=nums[nums.length-1]){
            return Search(nums,target,minIndex,nums.length-1);
        }
        else{
            return Search(nums,target,0,minIndex-1);
        }
    }

    public int findMin(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int Search(int nums[],int target, int low,int high){
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}