package org.salary.engine.models;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.salary.engine.enums.FieldType;

import java.text.ParseException;
import java.util.*;

import static org.salary.engine.enums.FieldType.SELECTION;

/**
 * 字段定义
 *
 * @author zhaoyunxing
 * @date 2022-04-25 17:38:18
 */
@Setter
@Getter
@RegisterForReflection
public class FieldDefinition {

    /**
     * 自定义主键id
     */
    private String fieldId;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段类型 {@link FieldType}
     */
    private String fieldType;

    /**
     * 是否必填：
     */
    private boolean required;

    /**
     * 填写说明
     */
    private String desc;

    /**
     * 表达式
     */
    private String expression;

    /**
     * 参数验证
     */
    public boolean validate(Object value) {
        FieldType type = FieldType.getInstance(fieldType);
        switch (type) {
            case NUMBER:
                String num = String.valueOf(value);
                if (!NumberUtils.isNumber(num)) {
                    return false;
                }
                break;
            case DATE:
                try {
                    String date = String.valueOf(value);
                    DateUtils.parseDate(date, "yyyy-MM-dd", "yyy-MM-dd HH:mm:ss");
                } catch (ParseException ex) {
                    return false;
                }
                break;
            case CHECKBOX:
            case SELECTION:

                List<String> strings;
                if (value instanceof String) {
                    strings = Collections.singletonList(value.toString());
                } else if (value instanceof Collection) {
                    strings = (ArrayList<String>) value;
                } else {
                    return false;
                }
                if (type.equals(SELECTION) && strings.size() > 1) {
                    return false;
                }
                break;
            case STRING:
                //字符串验证手机格式
                String str = String.valueOf(value);
                if (required && StringUtils.isBlank(str)) {
                    return false;
                }
                break;
        }
        return true;
    }
}
