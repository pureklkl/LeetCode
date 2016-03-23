public class Solution {
    /**
     * I - 1
     * V - 5
     * X - 10
     * L - 50
     * C - 100
     * D - 500
     * M - 1000
     * 
     * rule one: I for 1, II for 2, III for 3, VI for 6, VII for 7, VIII for 8;
     * rule two: larger number is placed left hand of the smaller, except the values in the rule three, e.g. LX for 60, CLX for 160;
     * rule three: smaller number is placed left hand of larger for IV - 4, IX - 9, XL - 40, XC - 90, CD - 400, CM - 900.
    */
    public String intToRoman(int num) {
        String[] thousands  = {"", "M", "MM", "MMM"};//0,1000,2000,3000
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//0,100,200,300,400,500,600,700,800,900
        String[] tens     = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unit     = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num/1000]+
               hundreds[(num%1000)/100]+
               tens[(num%100)/10]+
               unit[num%10];
    }
}
