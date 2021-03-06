package com.sef.proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class MyClassLoader extends ClassLoader{

    private File baseDir;

    public MyClassLoader() {
        String basePath = MyClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;

        if(baseDir != null){

            File classFile = new File(baseDir, name.replaceAll("\\.", "/") + ".class");

            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while((len = in.read(buff)) != -1){
                        out.write(buff,0, len);
                    }

                    return defineClass(className, out.toByteArray(), 0, out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        in.close();
                        out.close();;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    classFile.delete();
                }

            }
        }
        return null;
    }
}
