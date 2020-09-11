package com.yffd.jecap.common.base.web.resolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.yffd.jecap.common.base.exception.BaseException;
import com.yffd.jecap.common.base.result.RtnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        RtnResult result = null;
        if (ex instanceof BaseException) {
            BaseException exception = (BaseException) ex;
            result = RtnResult.FAIL(String.format("[代号:BE00]%s"), exception.getMsg());
            log.error("[代号:BE00]系统错误", ex);
        } else if (ex instanceof Throwable) {
            result = RtnResult.FAIL("[代号:UN00]系统错误");
            log.error("[代号:UN00]系统错误", ex);
        }

        /* 使用FastJson提供的FastJsonJsonView视图返回JSON */
        ModelAndView mav = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        view.setAttributesMap(result.toMap());
        mav.setView(view);
        return mav;
    }

    private void returnJosn(HttpServletResponse response, RtnResult result) {
        /*	使用response返回	*/
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(JSON.toJSONString(result));
            writer.flush();
        } catch (IOException e) {
            log.error("响应客户端错误:", e);
        }
    }
}
