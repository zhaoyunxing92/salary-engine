package org.salary.engine.function;

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 16:57:12
 */
public class IfFunctionTest {

    @Test
    void call() {
        // 注册自定义函数
        AviatorEvaluator.addFunction(new IF());
        AviatorEvaluator.addFunction(new SUM());
        long num = (Long) AviatorEvaluator.getInstance().execute("IF(SUM(IF(1==1,4,7),2)<5,4,3)");
        Assert.assertTrue(num == 3);
    }
}