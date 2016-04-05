public class Solution {
    /**
    *
    * two dic, one for original words, count each string appearence, one for visited
    * traverse the string by step of word length, try all possible position by changing traverse start point
    * if the visited appearence times is less than the original one, add directly
    * else we move the window left and decrement the dropped word until the appearence times is equal to the original one
    * record the start point of the window as the answer, then move window left 
    */
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> dic = new HashMap<String, Integer>();
        int interval = words[0].length();
        
        for(int i=0;i<words.length;i++){
            Integer wc = dic.get(words[i]);
            if(wc!=null){
                dic.put(words[i], ++wc);
            }
            else
                dic.put(words[i], 1);
        }
        
        List<Integer> ans = new LinkedList<Integer>();
        int len = s.length(), dicS=dic.size();
        for(int i=0;i<interval;i++){
            int start = i, count=0;
            HashMap<String, Integer> tdic = new HashMap<String, Integer>();
            for(int j=i;j<=len-interval;j+=interval){
                String curW = s.substring(j, j+interval);
                Integer wc = dic.get(curW);
                if(wc!=null){//valid word add to the visited dic
                    Integer twc = tdic.get(curW);
                    if(twc==null){
                        tdic.put(curW, 1);
                        count++;
                    }else{
                        tdic.put(curW, ++twc);
                        count++;
                        if(twc>wc)
                            while(tdic.get(curW)>wc){
                                String tww = s.substring(start, start+interval);
                                tdic.put(tww, tdic.get(tww)-1);
                                start+=interval;
                                count--;
                            }
                    }
                }else{
                    tdic.clear();
                    count=0;
                    start=j+interval;
                }
                if(count==words.length){
                    ans.add(start);
                    String tww = s.substring(start, start+interval);
                    tdic.put(tww, tdic.get(tww)-1);
                    start+=interval;
                    count--;
                }
            }
        }
        return ans;
    }
}
