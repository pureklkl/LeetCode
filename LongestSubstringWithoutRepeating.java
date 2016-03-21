public class Solution {
    /**
    * basic idea: we keep a window to record the visited character, once we meet a duplicate character, we move the beginning of the window           
      to the place next to where this character first appears. To short the window size, we also need remove the characters               
      between the beginning and that place.O(n^2)
    * improve   : lazy remove. Just leave the recoded character fall out of the window, if it show again, we just refresh its place.
    */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), start=0,max=0;
        HashMap<Character, Integer> visited = new HashMap<Character, Integer>();
        for(int i=0; i<len; i++){
            Character ic = s.charAt(i);
            if(visited.containsKey(ic)&&visited.get(ic)>=start){
                start=visited.get(ic)+1;
            }
            visited.put(ic, i);
            max=Math.max(max, i-start+1);
        }
        return max;
    }
}
