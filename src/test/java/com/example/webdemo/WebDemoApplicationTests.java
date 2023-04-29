package com.example.webdemo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import net.dreamlu.mica.http.HttpLogger;
import net.dreamlu.mica.http.HttpRequest;
import net.dreamlu.mica.http.LogLevel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.*;

@SpringBootTest
class WebDemoApplicationTests {

    @Test
    void contextLoads() {
        ZipUtil.zip("D:\\Desktop\\demo","D:\\Desktop\\demo1\\ccc.zip");
    }

    @Test
    void contextLoa1ds() throws Exception {
//        ZipUtil.zip("C:\\Users\\xieshaonan\\Documents\\Downloads","D:\\Desktop\\demo\\ccc.zip");
            // 设置全局日志级别
            HttpRequest.setGlobalLog(HttpLogger.Console, LogLevel.HEADERS);
            // 1. 下载文件流，注意： mica-http CompletableFuture 异步不会自动关流，其他都会自动关闭
            InputStream inputStream = HttpRequest.get("https://cd.jwx.com.cn:4443/index.php?m=file&f=download&fileID=17587&zentaosid=da1c43256af841fa95cfdb1da6b91bfd")
                    .executeAsyncAndJoin()
                    .asStream();


                // 创建文件输出流
                FileOutputStream outputStream = new FileOutputStream("D:\\Desktop\\demo\\myfile.docx");

                // 定义缓冲区
                byte[] buffer = new byte[1024];
                int count;
                // 将文件数据写入文件中
                while ((count = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, count);
                }
                // 关闭流
                inputStream.close();
                outputStream.close();



        // DownAndReadFile("https://cd.jwx.com.cn:4443/index.php?m=file&f=download&fileID=17587&zentaosid=da1c43256af841fa95cfdb1da6b91bfd","D:\\Desktop\\demo\\aa.docx");
        System.err.println("ok");


    }

    /**
     * 远程下载文件
     * @param filePath 文件网络地址
     */
    public static void DownAndReadFile(String filePath,String dirPath) throws Exception {
        //检查指定目录,用户没有指定目录 抛出异常提示用户
        if(dirPath==null||dirPath.length()==0)throw new Exception("指定路径目录不能为空");

        //创建file文件对象
        File savePath = new File(dirPath);
        //判断文件目录是否存在，不存在即创建目录
        if (!savePath.exists()) {
            savePath.mkdir();
        }
        String[] urlname = filePath.split("/");
        int len = urlname.length-1;
        //获取文件名
        String uname = urlname[len];
        File file = new File(savePath+"//"+uname);
        //创建新文件
        if(file!=null && !file.exists()){
            file.createNewFile();
        }
        //输出流
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file));
        URL url = new URL(filePath);
        //获取链接
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
        uc.connect();
        //获取输入流，读取文件
        InputStreamReader in = new InputStreamReader(uc.getInputStream());
        char[] buffer = new char[4*1024];
        int length;
        //读取文件
        while((length=in.read(buffer))!= -1){
            //写出
            out.write(buffer, 0, length);
        }
        out.flush();
        in.close();
        out.close();
    }

    //https://cd.jwx.com.cn:4443/index.php?m=file&f=download&fileID=17587&zentaosid=da1c43256af841fa95cfdb1da6b91bfd

}
