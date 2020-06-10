package com.zzh.Kotlin实战;

import java.io.File;

/**
 * @author zhangzhihao
 * @date 2020/6/6 9:28
 */
public class Files {
    public static void main(String[] args) {
        String s = "s.mp4";
        String replaceFirst = s.substring(s.indexOf(".") + 1);
        System.out.println(replaceFirst);

        s = "/home/intellitourism/projects/intellitourism/static/upload/2020/6/4/fkdlsjflsd.mp4";
        replaceFirst = s.substring(s.indexOf("upload"));
        System.out.println(replaceFirst);

        File file = new File("com.zzh.Kotlin实战");
        System.out.println(file);


    }

}
