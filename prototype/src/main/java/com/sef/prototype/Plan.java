package com.sef.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangyongjie on 2018/8/16.
 */
public class Plan implements Cloneable,Serializable{

    public String name;
    // 引用类型
    public List<String> executors = new ArrayList<String>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Plan)super.clone();
    }

    /* 深复制 */
    public Object deepClone() throws IOException, ClassNotFoundException {
        // 写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                ", executors=" + executors +
                '}';
    }
}
