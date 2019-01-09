package com.github.archerda.designpattern.proxy;

import javassist.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Javassist动态代理: 采用 字节码 技术创建;
 *
 * @author archerda
 */
public class JavassistByteCodeMain {

    public static void main(String[] args) throws Exception {

        /*
        创建类池
         */
        ClassPool classPool = ClassPool.getDefault();

        String className = TargetClass.class.getName();
        CtClass ctClass = classPool.makeClass(className + "JavassitProxy");

        /*
        添加接口,可选
         */
        ctClass.addInterface(classPool.get(TargetInterface.class.getName()));

        /*
        添加超类
         */
        // ctClass.setSuperclass(classPool.get(TargetClass.class.getName()));

        /*
         添加默认构造函数
         */
        // ctClass.addConstructor(new CtConstructor(new CtClass[]{}, ctClass));

        /*
        添加屬性
         */
        CtField enameField = new CtField(classPool.getCtClass(className), "targetClass", ctClass);
        enameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enameField);

        /*
        添加构造函数
         */
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        /*
        为构造函数设置函数体
         */
        ctConstructor.setBody("{\n" + "targetClass = new " + className + "();" + "\n}");
        /*
        把构造函数添加到新的类中
         */
        ctClass.addConstructor(ctConstructor);

        /*
        添加方法,里面进行动态代理logic
         */
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "sayHi", new CtClass[]{}, ctClass);
        /*
        为自定义方法设置修饰符
         */
        ctMethod.setModifiers(Modifier.PUBLIC);
        /*
        为自定义方法设置函数体
         */
        String buffer2 = "{\n" +
                "targetClass.sayHi();" +
                "\n}";
        ctMethod.setBody(buffer2);
        ctClass.addMethod(ctMethod);

        /*
        把生成的class文件写入文件
         */
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/Archerda/Desktop/java-example/com/sun/proxy/JavassitProxy.class"));
        fos.write(byteArr);
        fos.close();

        /*
        生成代理类对象实例
         */
        TargetInterface targetClass = (TargetInterface)ctClass.toClass().newInstance();

        /*
        代理类方法调用
         */
        targetClass.sayHi();
    }
}
