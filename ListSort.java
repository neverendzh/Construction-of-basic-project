package com.kaishengit.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author 小野
 * Created by Administrator on 2018/3/26.
 */
public class ListSort {

    public  static  void main(String [] args){
        List<Score> listSorts = new ArrayList<>();
        Score listSorts1 = new Score(34,66,67,40,89,104,88,87);
        Score listSorts2 = new Score(23,87,43,69,65,66,78,87);
        Score listSorts3 = new Score(54,64,124,50,65,55,23,30);
        Score listSorts4 = new Score(67,86,156,30,65,89,54,30);
        Score listSorts5 = new Score(78,46,67,70,65,134,71,80);
        Score listSorts6 = new Score(89,32,89,100,65,165,49,81);
        Score listSorts7 = new Score(90,89,18,45,65,144,88,85);
        Score listSorts8 = new Score(66,37,58,44,65,67,97,107);
        Score listSorts9 = new Score(65,53,39,66,65,89,90,108);
        Score listSorts10 = new Score(35,87,20,33,65,55,78,106);
        listSorts.add(listSorts1);
        listSorts.add(listSorts2);
        listSorts.add(listSorts3);
        listSorts.add(listSorts4);
        listSorts.add(listSorts5);
        listSorts.add(listSorts6);
        listSorts.add(listSorts7);
        listSorts.add(listSorts8);
        listSorts.add(listSorts9);
        listSorts.add(listSorts10);
        for (int i =0;i<listSorts.size();i++){
                Score score = listSorts.get(i);
                showAttr(score,"tt");
        }
    }


   public static void showAttr(Object o,String title){
        if(o==null){
            System.out.println("空值");
            return;
        }
        Field[] fields= o.getClass().getDeclaredFields();
//        System.out.println("————————————"+title+"————————————————");
        double[] doubles = new double[fields.length];
        Map<Object,double[] > map = new HashMap<>();
        for(int i=0;i<fields.length;i++){
//            System.out.println(fields.length+"长度");
            String fieldName=fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1);
            try {
                Method getMethod=o.getClass().getMethod("get"+fieldName, new Class[]{});
//                System.out.println("<-"+"get"+fieldName+"->"+"t{"+getMethod.invoke(o, new Object[]{})+"}");
                try {
                    double d = (double) getMethod.invoke(o, new Object[]{});
                    doubles[i] = d;
                }catch (ClassCastException e){
                    e.getMessage();
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0;i<doubles.length;i++){
            for (int j = 0;j<doubles.length-1-i;j++){
                double emp = 0.0;
                if (doubles[j]<doubles[j+1]){
                    emp = doubles[j];
                    doubles[j] = doubles[j+1];
                    doubles[j] = emp;
                }
            }
        }
         map.put(o,doubles);
       bijiao(map);

        }

   public static void bijiao(Map<Object,double []> objectMap){
       Map<Object,Double> map = new HashMap<>();
       double socreAll = 0.0;
       for (Map.Entry<Object,double []> entry : objectMap.entrySet()){
           double [] doubles = entry.getValue();
           Score score = (Score) entry.getKey();
           int j = 0;
           double[] doubles1 = new double[3];
           for (int i =0;i<doubles.length;i++){
               int d = doubles.length-3;
               if ( i >= d ){
                   doubles1[j] = doubles[d];
                   j++;
               }
           }
           for (int i1 = 0;i1<doubles1.length-1;i1++){
               socreAll = socreAll+ doubles1[i1];
           }
           map.put(score,socreAll);
       }

       scoreList(map);
   }

    /**
     * 返回排序后集合
     * @param scoreDoubleMap
     * @return
     */
   public static List<Score> scoreList(Map<Object,Double> scoreDoubleMap){
       Map<Integer,Score> scoreMap = new HashMap<>();
       Map<Integer,Double> doubleMap = new HashMap<>();
       List<Double> doubleList = new ArrayList<>();
       for (Map.Entry<Object, Double> entry : scoreDoubleMap.entrySet()){
          Score score = (Score) entry.getKey();
          double d = entry.getValue();
          scoreMap.put(1,score);
          doubleMap.put(1,d);
          doubleList.add(d);
       }

       double[] allScore = new double[]{doubleList.size()-1};
       for (int i = 0;i<doubleList.size();i++){
          allScore[i] = doubleList.get(i);
       }
       Arrays.sort(allScore);

       int [] ints = new int[]{allScore.length-1};
       int mapkey = 0;
         for (Map.Entry<Integer,Double> doubleMaps : doubleMap.entrySet()){
             for (double d : allScore){
                 if (doubleMaps.getValue() == d){
                     int keydoub  = doubleMaps.getKey();
                     ints[mapkey] = keydoub;
                     mapkey++;
                 }
             }
         }
       List<Score> scoreList = new ArrayList<>();
       for (Map.Entry<Integer, Score> entry : scoreMap.entrySet()) {

           for (int key : ints){
               if (entry.getKey() == key ){
                   scoreList.add(entry.getValue());
               }

           }
       }

       return scoreList;
   }
}
