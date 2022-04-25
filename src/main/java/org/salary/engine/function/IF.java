package org.salary.engine.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
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
        long num1 = FunctionUtils.getNumberValue(v1, env).longValue();
        long num2 = FunctionUtils.getNumberValue(v2, env).longValue();
        if (FunctionUtils.getBooleanValue(exp, env)) {
            return AviatorLong.valueOf(num1);
        }
        return AviatorLong.valueOf(num2);
    }
}
