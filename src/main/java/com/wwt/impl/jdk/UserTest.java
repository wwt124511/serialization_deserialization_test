package com.wwt.impl.jdk;

/**
 * @author wwt
 * @ClassName UserTest.java
 * @Description TODO
 * @createTime 2019-11-30 10:44
 */
public class UserTest {

    public static void main(String[] args) {
        //1. 序列化
        byte[] serializer = serializer();
        //2. 反序列化
        deserialize(serializer);
    }



    /**
     * @Description 序列化
     * @param
     * @return : void
    */
    private static byte[] serializer() {
        User uu = new User();
        uu.setId(12l);
        uu.setAge(13);
        uu.setUserName("小王");
        JavaImpl jj = new JavaImpl();
        byte[] tt = jj.serialize(uu);
        System.out.println(tt);
        return tt;
    }

    /***
     * @Description 反序列化
     * @param serializer
     * @return : void
    */
    private static void deserialize(byte[] serializer) {
        JavaImpl jj = new JavaImpl();
        User uu = jj.deserialize(serializer, User.class);
        System.out.println(uu.toString());
    }


}
