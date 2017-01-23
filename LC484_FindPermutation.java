
public class LC484_FindPermutation {
	public int[] findPermutation(String s) {
        if(s == null || s.length() == 0) return null;
        int len = s.length();
        int[] res = new int[len + 1];
        for(int i = 1; i <= len + 1; ++i){  // sort the default array in ascending order
            res[i - 1] = i;		// in this way, the result can be smallest in terms of lexicographic order
        }

        int tmp = 0, left = 0, index = 0, right = 0;

        while(index < len){
            if(s.charAt(index) == 'D'){
                left = index;
                ++index;
                while(index < len && s.charAt(index) == 'D') ++index; // record the consecutive 'D' in String
                right = (index == len)? index : index;
                while(left < right){    //reverse the subarray in the range of consecutive 'D'
                    tmp = res[left];
                    res[left] = res[right];
                    res[right] = tmp;
                    ++left;
                    --right;
                }
            }else{ // if character is 'I' move forward
                ++index;
            }
        }
        return res;
    }
}