package cn.gamers.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BackUpDB {
    public static void backup() throws IOException{  
    	String path = "C:\\MysqlBU\\school.sql";
        Runtime runtime = Runtime.getRuntime();  
        //-u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字  
        Process process = runtime.exec("mysqldump -u root -p123456 school");  
        InputStream inputStream = process.getInputStream();//得到输入流，写成.sql文件  
        InputStreamReader reader = new InputStreamReader(inputStream);  
        BufferedReader br = new BufferedReader(reader);  
        String s = null;  
        StringBuffer sb = new StringBuffer();  
        while((s = br.readLine()) != null){  
            sb.append(s+"\r\n");  
        }  
        s = sb.toString();  
        System.out.println(s);  
        File file = new File(path);  
        file.getParentFile().mkdirs();  
        FileOutputStream fileOutputStream = new FileOutputStream(file);  
        fileOutputStream.write(s.getBytes());  
        fileOutputStream.close();  
        br.close();  
        reader.close();  
        inputStream.close();  
    }  
}
