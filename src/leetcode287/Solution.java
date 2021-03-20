//class Solution {
//    public int findDuplicate(int[] nums){
//        if(nums.length == 0){
//            return  -1;
//        }
//        int left = 1;
//        int right = nums.length - 1;
//        while(left < right){
//            int count = 0;
//            int mid = (left + right) >>> 1;
//            for (int i : nums){
//                if (i <= mid){
//                    count++;
//                }
//            }
//            if(count <= mid){
//                left = mid + 1;
//            }else {
//                right = mid;
//            }
//        }
//        return left;
//    }
//}