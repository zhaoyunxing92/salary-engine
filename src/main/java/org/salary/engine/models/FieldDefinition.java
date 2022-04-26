package org.salary.engine.models;

import com.googlecode.aviator.AviatorEvaluator;
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
     * 小数位数
     */
    private int digits = 2;

    /**
     * 参数验证
     */
    public Object analysis(Map<String, Object> env) {
        return AviatorEvaluator.getInstance().execute(expression, env);
    }
}
