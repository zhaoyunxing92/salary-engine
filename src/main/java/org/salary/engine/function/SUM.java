package org.salary.engine.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 17:27:19
 */
public class SUM extends AbstractFunction {

    @Override
    public String getName() {
        return "SUM";
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject v1, AviatorObject v2) {
        long num1 = FunctionUtils.getNumberValue(v1, env).longValue();
        long num2 = FunctionUtils.getNumberValue(v2, env).longValue();
        return AviatorLong.valueOf(num1 + num2);
    }
}
