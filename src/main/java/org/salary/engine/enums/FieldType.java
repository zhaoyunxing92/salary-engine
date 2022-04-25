package org.salary.engine.enums;

import lombok.Getter;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 19:03:09
 */
public enum FieldType {
    /**
     * 文本
     */
    STRING("string", "文本"),

    /**
     * 数字
     */
    NUMBER("number", "数字"),

    /**
     * 日期
     */
    DATE("date", "日期"),

    /**
     * 多选选项
     */
    CHECKBOX("checkbox", "多选选项"),// CHECKBOX

    /**
     * 附件
     */
    FILE("file", "附件"),

    /**
     * 单选选项
     */
    SELECTION("selection", "单选选项"),
    ;

    @Getter
    private final String code;
    @Getter
    private final String desc;

    FieldType(String code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public static FieldType getInstance(String code) {
        FieldType[] values = FieldType.values();
        for (FieldType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return FieldType.STRING;
    }
}
