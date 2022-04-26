package org.salary.engine.models;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 20:46:11
 */
@Setter
@Getter
@RegisterForReflection
public class User {

    private String userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 基本薪资
     */
    private String baseSalary;

    /**
     * 入职日期
     */
    private String hireDate;

    /**
     * 工龄
     */
    private Integer seniority;

    /**
     * 提成
     */
    private Integer commission;
}
