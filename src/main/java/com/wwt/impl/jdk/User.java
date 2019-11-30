package com.wwt.impl.jdk;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wwt
 * @ClassName User.java
 * @Description TODO
 * @createTime 2019-11-30 10:44
 */
@Data
public class User implements Serializable {

    private Long id;
    private Integer age;
    private String userName;

}
