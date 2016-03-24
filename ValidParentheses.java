public class Solution {
    /**
        it is more suitable to be parallelsim
    */
    public void expect(char r, char ex, Stack<Character> bs){
        if(r==ex){
            bs.pop();
        }else{
            bs.push(r);
        }
    }
    public boolean isValid(String s) {
        Stack<Character> bs = new Stack<Character>();
        int len = s.length();
        for(int i=0; i<s.length();i++){
            if(bs.isEmpty()){
                bs.push(s.charAt(i));
                continue;
            }
            char l=bs.peek(),r=s.charAt(i);
            switch(l){
                case '{':   expect(r,'}', bs);break;
                case '(':   expect(r,')', bs);break;
                case '[':   expect(r,']', bs);break;
                case '}':
                case ')':
                case ']':bs.push(r);break;
            }
        }
        return bs.isEmpty();
    }
}
