import java.util.HashMap;

public class RomanToInteger {

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内
     *
     * 使用map映射roman 和 int
     * 解析roman串，从末位向前逐一映射成int然后相加，有三种特殊情况时进行减法操作，最终得到结果
     * 特殊情况分析，从题目描述可以看出特殊情况时前后两数之和分别是 6/11，60/110，600/1100， 可抽象为 (i1+i2)%6 == 0 || (i1+i2)%11 == 0
     */

    private HashMap<Character,Integer> romanMap = new HashMap<Character, Integer>();
    {
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
    }
    public int romantoInt(String s){
        int length = s.length()-1;
        int result = this.romanMap.get(s.charAt(length));
        for(int i=length;i>0;i--){
            result = sumTwoRoman(s.charAt(i),s.charAt(i-1),result);
        }
        return result;
    }

    private int sumTwoRoman(Character r1,Character r2,int res){
        int i1 = this.romanMap.get(r1);
        int i2 = this.romanMap.get(r2);
        int i3 = i1+i2;
        if(i2<i1&&(i3%6==0||i3%11==0)){
            res = res-i2;
        }else{
            res = res+i2;
        }
        return res;
    }
    public static void main(String[] args) {
        String test = "IV";
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romantoInt(test));
    }
}
