package com.wwt.impl.xml.xmlImpl;

import java.io.PipedReader;

/**
 * @author wwt
 * @ClassName XmlTest.java
 * @Description TODO
 * @createTime 2019-11-30 11:52
 */
public class XmlTest {

    private static final String xml = "<user><id>12</id><name>小孙</name></user>";

    public static void main(String[] args) {
        //1. 序列化
        byte[] bb = seri();

        //2. 反序列化
        dseri(bb);

    }


    /***
     * @Description xml序列化
     * @param
     * @return : void
    */
    private static byte[] seri() {
        XmlSerializer xs = new XmlSerializer();
        byte[] bb = xs.serialize(xml);
        System.out.println(bb);
        return bb;
    }

    /**
     * @Description 反序列化
     * @param bb
     * @return : void
     */
    private static void dseri(byte[] bb) {
        XmlSerializer xs = new XmlSerializer();
        String deserialize = xs.deserialize(bb, String.class);
        System.out.println(deserialize);
    }

}
