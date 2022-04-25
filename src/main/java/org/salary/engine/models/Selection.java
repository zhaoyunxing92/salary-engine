package org.salary.engine.models;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 18:57:34
 */
@Getter
@Setter
@RegisterForReflection
public class Selection {

    /**
     * 选项中文描述
     */
    private String label;

    /**
     * 选项编码
     */
    private String value;
}
