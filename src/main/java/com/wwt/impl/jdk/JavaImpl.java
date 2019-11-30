package com.wwt.impl.jdk;

import com.wwt.ISerializer;

import java.io.*;

/**
 * @author wwt
 * @ClassName javaImpl.java
 * @Description java实现序列化、反序列化
 *                  Java默认的序列化、反序列化主要通过对象输出流（ObjectOutputStream）和
 *                  输入流（ObjectInputStream）来实现，其中被序列化的类必须哟实现
 *                  java.io.Serializable接口
 *
 *
 *              java对象序列化、反序列化优缺点：
 *                  优点：
 *                      1. java自带，无需额外引入第三方依赖
 *                      2. 与Java语言有天然的最好的易用性与亲和性
 *                  缺点：
 *                      1. 只支持Java语言，不支持跨语言
 *                      2. Java默认序列化性能欠佳，序列化后发生的码流过大，对于引用过深的对象序列化易发生内存OOM异常
 * @createTime 2019-11-30 10:18
 */
public class JavaImpl implements ISerializer {

    /**
     * @Description java序列化方法，返回字节数组
     * @param obj
     * @return : byte[]
    */
    @Override
    public <T> byte[] serialize(T obj) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != objectOutputStream){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return byteArrayOutputStream.toByteArray();
    }


    /**
     * @Description Java反序列化方法，返回对象
     * @param data
     * @param clazz
     * @return : T
    */
    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
