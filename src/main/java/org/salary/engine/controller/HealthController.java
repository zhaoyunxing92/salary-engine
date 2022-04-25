package org.salary.engine.controller;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 16:14:24
 */
@Slf4j
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthController {

    @GET
    public Map<String, String> health() {
        Map<String, String> data = new HashMap<>(2);
        data.put("msg", "ok");
        try {
            InetAddress ia = InetAddress.getLocalHost();
            data.put("host", ia.getHostName());
            return data;
        } catch (UnknownHostException ex) {
            log.error("health err", ex);
            return data;
        }
    }
}
