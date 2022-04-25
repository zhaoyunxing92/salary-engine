package org.salary.engine.controller;

import lombok.extern.slf4j.Slf4j;
import org.salary.engine.req.Calculate;
import org.salary.engine.response.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 计算工资
 */
@Slf4j
@Path("/cal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculateController {

    /**
     * 计算
     *
     * @param req 请求
     * @return 计算结果
     */
    @POST
    public Response<String> calculate(Calculate req) {
        log.info("data={}", req.getUsers());
        return Response.getSuccess();
    }
}