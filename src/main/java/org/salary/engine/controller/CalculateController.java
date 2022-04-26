package org.salary.engine.controller;

import com.googlecode.aviator.AviatorEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.salary.engine.function.IF;
import org.salary.engine.function.SUM;
import org.salary.engine.models.FieldDefinition;
import org.salary.engine.req.Calculate;
import org.salary.engine.response.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 计算工资
 */
@Slf4j
@Path("/cal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculateController {

    public CalculateController() {
        AviatorEvaluator.addFunction(new IF());
        AviatorEvaluator.addFunction(new SUM());
    }

    /**
     * 计算
     *
     * @param req 请求
     * @return 计算结果
     */
    @POST
    public Response<List<Map<String, Object>>> calculate(Calculate req) {
        Map<String, FieldDefinition> fields = req.getDefines().stream()
                .collect(Collectors.toMap(FieldDefinition::getFieldId, s -> s, (k1, k2) -> k1));

        List<Map<String, Object>> collect = req.getUsers().stream().peek(user -> {

            user.forEach((key, value) -> {
                FieldDefinition df = fields.getOrDefault(key, null);
//                data.setValue(df.analysis(user));
                user.putIfAbsent(key, df.analysis(user));
            });
        }).collect(Collectors.toList());
        return Response.getSuccess(collect);
    }
}