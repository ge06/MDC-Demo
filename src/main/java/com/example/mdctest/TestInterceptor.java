package com.example.mdctest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.UUID;

@Component
public class TestInterceptor implements HandlerInterceptor {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        MDC.put("request-id", UUID.randomUUID().toString());
        MDC.put("random-int-key", String.valueOf(new Random().nextInt(1000)));
        MDC.put("random-string-key", "A" + new Random().nextInt(90));

        logger.info("test");
    }
}
