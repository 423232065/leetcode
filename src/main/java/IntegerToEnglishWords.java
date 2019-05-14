import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntegerToEnglishWords {
    /**
     * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: "One Hundred Twenty Three"
     * 示例 2:
     *
     * 输入: 12345
     * 输出: "Twelve Thousand Three Hundred Forty Five"
     * 示例 3:
     *
     * 输入: 1234567
     * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     * 示例 4:
     * 输入: 1234567891
     * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
     */
    private HashMap<Integer,String> wordsMap = new HashMap<Integer, String>();
    {
        this.wordsMap.put(1,"One ");
        this.wordsMap.put(2,"Two ");
        this.wordsMap.put(3,"Three ");
        this.wordsMap.put(4,"Four ");
        this.wordsMap.put(5,"Five ");
        this.wordsMap.put(6,"Six ");
        this.wordsMap.put(7,"Seven ");
        this.wordsMap.put(8,"Eight ");
        this.wordsMap.put(9,"Nine ");
        this.wordsMap.put(10,"Ten ");
        this.wordsMap.put(11,"Eleven ");
        this.wordsMap.put(12,"Twelve ");
        this.wordsMap.put(13,"Thirteen ");
        this.wordsMap.put(14,"Fourteen ");
        this.wordsMap.put(15,"Fifteen ");
        this.wordsMap.put(16,"Sixteen ");
        this.wordsMap.put(17,"Seventeen ");
        this.wordsMap.put(18,"Eighteen ");
        this.wordsMap.put(19,"Nineteen ");
        this.wordsMap.put(20,"Twenty ");
        this.wordsMap.put(30,"Thirty ");
        this.wordsMap.put(40,"Forty ");
        this.wordsMap.put(50,"Fifty ");
        this.wordsMap.put(60,"Sixty ");
        this.wordsMap.put(70,"Seventy ");
        this.wordsMap.put(80,"Eighty ");
        this.wordsMap.put(90,"Ninety ");
        this.wordsMap.put(100,"Hundred ");
        this.wordsMap.put(1000,"Thousand ");
        this.wordsMap.put(1000000,"Million ");
        this.wordsMap.put(1000000000,"Billion ");
    }
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String result = "";
        int i = num;
        int n = 1;
        int u = 0;//个位
        int t = 0;//十位
        int h = 0;//百位
        while(i>0){
            u = i%10;
            t = (i-u)%100/10;
            h = (i-u-t)%1000/100;
            String tmp = getCurWord(u,t,h);
            result = tmp+(n>1&&tmp.length()>0?this.wordsMap.get(n):"")+result;
            n = n*1000;
            i = num/n;
        }
        return result.trim();
    }

    private String getCurWord(int u,int t,int h){
        System.out.println("个位 ： "+u);
        System.out.println("十位 ： "+t);
        System.out.println("百位 ： "+h);
        String tenD = t>1?(this.wordsMap.get(t*10)+(u>0?this.wordsMap.get(u):"")):((this.wordsMap.get(t*10+u))== null?"":this.wordsMap.get(t*10+u));
        return (h>0?this.wordsMap.get(h)+this.wordsMap.get(100):"")+tenD;
    }

    public static void main(String[] args) {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        System.out.println(integerToEnglishWords.numberToWords(1000000));
    }
}
