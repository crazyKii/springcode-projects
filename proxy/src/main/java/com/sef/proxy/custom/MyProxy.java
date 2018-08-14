package com.sef.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class MyProxy{

    private static String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader loader, Class<?>[] interfaces, MyInvocationHandler h){

        try {
            // 1、生成源码
            String proxySrc = generateSrc(interfaces[0]);

            // 2、将生成的源代码输出到磁盘，保存为.java文件
            String filePath = MyProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy4.java");
            FileWriter fw = new FileWriter(file);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            // 3、编译源代码，并且生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable =  manager.getJavaFileObjects(file);

            CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4、将class文件中的内容，动态加载到JVM中来

            // 5、返回被代理后的代理对象
            Class proxyClass = loader.findClass("$Proxy4");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            file.delete();

            return c.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
        package com.sef.proxy.custom;
        import java.lang.reflect.Method;
        public class $Proxy0 implements Subject{
            MyInvocationHandler h;
            public $Proxy0(GPInvocationHandler h){
                this.h = h;
            }

            public Subject rent(){
                try{
                    this.h.invoke(this,m,null);
                }catch(Throwable e){
                    e.printStackTrace();
                }
            }
        }
     */
    private static String generateSrc(Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package com.sef.proxy.custom;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy4 implements " + interfaces.getName() + "{" + ln);

        src.append("MyInvocationHandler h;" + ln);

        src.append("public $Proxy4(MyInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }

        src.append("}");

        return src.toString();
    }
}
