package org.salary.engine.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 16:48:31
 */
public class IF extends AbstractFunction {
    @Override
    public String getName() {
        return "IF";
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject exp, AviatorObject v1, AviatorObject v2) {
        // double num1 = FunctionUtils.getNumberValue(v1, env).doubleValue();
        // double num2 = FunctionUtils.getNumberValue(v2, env).longValue();
        if (FunctionUtils.getBooleanValue(exp, env)) {
            return v1;
        }
        return v2;
    }
}
