package cn.gamers.test;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  
  
public class DateTest {  
  
    public static void main(String[] args) {  
        localDate();  
    }  
    /**  
     * 默认时间格式：Wed Jun 29 17:26:16 CST 2016  
     * 转换成【yyyy-MM-dd HH:mm:ss】这样的格式输出  
     */  
    public static void localDate(){  
        SimpleDateFormat newSF = new SimpleDateFormat("yyyy-MM-dd");  
        SimpleDateFormat oldSF = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.ENGLISH);  
        String dateResult = "";  
        String defDate = new Date().toString();//默认的时间格式  
//        try {  
            dateResult = newSF.format(new Date());  
//        } catch (ParseException e) {  
//            e.printStackTrace();  
//        }  
        //Wed Jun 29 17:26:16 CST 2016======2016-06-29 17:26:16  
        System.out.println(dateResult);  
    }  
    /**  
     * 字符串转换成日期格式  
     * String 类型是【2008-07-10 19:20:00】这样的格式转换  
     */  
    public static void getStringToDate(){  
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );  
        try {  
            Date date = sdf.parse( " 2008-07-10 19:20:00 " );  
            //Date : Thu Jul 10 19:20:00 CST 2008  
            System.out.println("Date : " + date);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
    }  
}  