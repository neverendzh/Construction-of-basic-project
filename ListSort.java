package com.kaishengit.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
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

            double [] doubles = new double[]{};
            for (int j =0;j<listSorts.size();j++){
                Score score = listSorts.get(i);
                showAttr(score,"tt");
            }

        }














    }


   public static void showAttr(Object o,String title){
        if(o==null){
            System.out.println("空值");
            return;
        }
        Field[] fields= o.getClass().getDeclaredFields();
        System.out.println("————————————"+title+"————————————————");
        double[] doubles = new double[fields.length];
        Map<Object,double[] > map = new HashMap<>();
        for(int i=0;i<fields.length;i++){
            System.out.println(fields.length+"长度");

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
        for ( int i = doubles.length-1;i>=0;i--){

            System.out.println(doubles[i]);
        }
//       System.out.println(doubles.length+"dubbo");
//       map.put(o,);
        }
}
