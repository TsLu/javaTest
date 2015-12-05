package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 关于统计一个字符串集合中，求出现次数最多的字符串
 * Created by Luts on 2015/12/5.
 */
public class test {
    public static void main(String args[]){
        long rand_startTime = System.currentTimeMillis();
        String str[] = new String[1490000];
        for (int i = 0; i < str.length; i++){
            str[i] = randomString(2);
        }
        long rand_endTime = System.currentTimeMillis();
        System.out.println("生成随机数组耗时：" + (rand_endTime - rand_startTime));

        long bilt_startTime = System.currentTimeMillis();
        Map<String, Integer> map = builMap(str);
        long built_endTime = System.currentTimeMillis();
        System.out.println("生成随机字符串耗时：" + (built_endTime - built_endTime));

        long count_stsrtTime = System.currentTimeMillis();
        System.out.println("出现次数最多的是" + getMaxStr(map));
        long count_endTime = System.currentTimeMillis();
        System.out.println("统计耗时： " + (count_endTime - count_stsrtTime));
    }

    //建立哈希映射
    public static Map<String, Integer> builMap(String[] strArr){
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str:strArr){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }else {
                map.put(str, 0);
            }
        }
        return map;
    }

    public static String getMaxStr(Map<String, Integer> map){
        int max = 0;
        String reslut = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > max){
                reslut = entry.getKey();
                if (reslut != null)
                    max = entry.getValue();
            }
        }
        return "键：" + reslut + "值：" + map.get(reslut);
    }

    public static final String randomString(int length){
        Random randGen = null;
        char[] numbersAndLetters = null;
        if (length < 1)
            return null;
        if (randGen == null){
            randGen = new Random();
            numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"+"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

        }

        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++){
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
    }
}
