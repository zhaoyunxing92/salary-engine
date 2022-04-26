package org.salary.engine.req;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.salary.engine.models.FieldDefinition;
import org.salary.engine.models.User;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 20:52:56
 */
@Setter
@Getter
@RegisterForReflection
public class Calculate {
    /**
     * 字段定义
     */
    private List<FieldDefinition> defines;

    /**
     * 计算数据
     */
    private List<Map<String, Object>> users;
}
