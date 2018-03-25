package com.kaishengit;

import com.kaishengit.entity.Movie;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.STRING;

/**
 * @author 小野
 * Created by Administrator on 2018/3/24.
 */
public class ExlsxInput {
    /**
     * 传如一个Excel的输入流
     * @param inputStream
     * @return 返回一个list集合，集合中封装了Excel表中的每一条数据
     */
    public static  List<Map<Integer, List<Object>>>  fileInputExcel(FileInputStream inputStream){
        List<Map<Integer, List<Object>>> integerListMap = null;
        try {
           integerListMap = ExlsxInput.getFileInputXSSF(inputStream);

        }catch (OfficeXmlFileException exception){
           integerListMap =  ExlsxInput.getFileInputHSSF(inputStream);
        }
        return  integerListMap;
    }


    /**
     * 传入有个Excel的输入流封装为一个对象
     * @param o
     * @param inputStream
     * @return 返回一个集合对象
     */
    public static List<Movie> getListObject(Movie o,FileInputStream inputStream){
       List<Map<Integer,List<Object>>> mapList =  fileInputExcel(inputStream);
       List<Movie> movies = new ArrayList<>();
       for (int j = 0;j<mapList.size();j++){
           for (Map.Entry<Integer,List<Object>> entry : mapList.get(j).entrySet()){
                      List<Object> li =  entry.getValue();
                      Movie movie = new Movie();
                      for (int i = 0; i<li.size();i++){
                          if (i==0){

                              movie.setName((String) li.get(i));
                          }
                          if (i == 1){

                              movie.setPassword((String) li.get(1));
                          }
                          if (i ==2){

                              try {
                                  movie.setNumber(Integer.parseInt((String) li.get(i)));
                              }catch (NumberFormatException e){
                                  movie.setNumber(null);
                              }
                          }
                          }
                          movies.add(movie);
                      }
           }
        return movies;
    }


    /**
     * 2003Excel版本使用
     * @param inputStream
     * @return 返回封装的数据集合
     */
 private static  List<Map<Integer,List<Object>>> getFileInputHSSF(InputStream inputStream){

     List<Map<Integer,List<Object>>> mapList = new ArrayList<>();
     Map<Integer,List<Object> > listMap = null;
     try {
         POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);
//         获得Excel工作
         HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
//         获得表的页脚数量
         int sheetNum = workbook.getActiveSheetIndex();
//        遍历页脚数目
        for (int s = 0 ; s <= sheetNum;s++){
//            每一个页脚封装为一个Map集合
            listMap = new HashMap<>();
//            获得第几个页脚对象,就是一个页面
            HSSFSheet sheet = workbook.getSheetAt(s);
//            获得一个页面的总行数
            int trlength =  sheet.getLastRowNum();
//           根据行的长度遍历
            for (int i = 0; i<=trlength;i++){
//                每一行数据封装为一个List集合
                List<Object> stringList = new ArrayList<>();
//           获得其中一行
                HSSFRow hssfRow =  sheet.getRow(i);
//           获得一行中有多少列
                int tdlength =  hssfRow.getLastCellNum();

//                System.out.println(trlength+"行----"+"第"+i+"行"+"----几"+tdlength+"列");
//               遍历一行中每一个单元格的数据
                for (int j = 0;j<tdlength;j++){
//               获得一个单元格
                    HSSFCell hssfCell =  hssfRow.getCell(j);
//               获得单元格样式
                    if (hssfCell!= null){
                        CellStyle cellStyle = hssfCell.getCellStyle();
                    }
                    if (hssfCell != null){
//                  设置数据类型
                        hssfCell.setCellType(STRING);
                    }
//                    System.out.print(hssfCell.getStringCellValue()+"\t\t");
                    stringList.add(hssfCell.getStringCellValue());
                }
//                System.out.println();
                listMap.put(i,stringList);
            }
//            把每一个页脚封装为一个List的map集合
            mapList.add(listMap);
        }
     } catch (IOException e) {
         e.printStackTrace();
     }
     return mapList;
 }
    /**
     * 2007Excel版本使用
     * @param inputStream
     */
 private static  List<Map<Integer,List<Object>>> getFileInputXSSF(InputStream inputStream){
     List<Map<Integer,List<Object>>> mapList = new ArrayList<>();
     Map<Integer,List<Object> > listMap = null;
     try {
//         获得Excel工作表对象
         Workbook workbook = WorkbookFactory.create(inputStream);
//         获取有多少个页脚页
         int sheetNum = workbook.getActiveSheetIndex();
//         遍历页脚页，获取一个页面对象
         for (int i = 0; i<=sheetNum;i++){
//             每一个页脚封装为一个Map集合
              listMap = new HashMap<>();
//             获得一个页脚页
             Sheet sheet = workbook.getSheetAt(i);
//             获得一页的总行数
             int trLength = sheet.getLastRowNum();
//             遍历每一行
             for (int j = 0; j<=trLength;j++){
//                 每一行数据封装为一个List集合
                 List<Object> stringList = new ArrayList<>();
//                 获得一行数据
                 Row row = sheet.getRow(j);
//                 获得一行中有多少列
                 int tdLength = row.getLastCellNum();
//                 遍历一行中的列数
                 for (int s = 0;s<tdLength;s++){
//                  得到一一行中的一个单元格
                     Cell cell = row.getCell(s);
                     if (cell!= null){
                         CellStyle cellStyle = cell.getCellStyle();
                     }
                     if (cell != null){
                         cell.setCellType(CellType.STRING);
                     }
                     stringList.add(cell.toString());
//                     System.out.print(cell.toString()+"\t\t");
                 }
                 listMap.put(j,stringList);
//                 System.out.println();
             }
 //            把每一个页脚封装为一个List的map集合
             mapList.add(listMap);
         }
     } catch (IOException e) {
         System.out.println(e.getMessage());
     } catch (InvalidFormatException e) {
         System.out.println(e.getMessage());
     }
    return mapList;
 }
}