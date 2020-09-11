package com.yffd.jecap.common.base.web.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public abstract class BaseController {
    protected static final String _CSRF_RANDOM_TOKEN = "_Y_TOKEN";
    protected static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /** 默认分页-起始页码 */
    protected static final int DEF_PAGE_NUM = 1;
    /** 默认分页-每页条数 */
    protected static final int DEF_PAGE_SIZE = 20;

    @InitBinder
    public void intDate(WebDataBinder dataBinder) {
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }

    @Autowired(required = false)
    public HttpServletRequest request;

    @Autowired(required = false)
    public HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * 获取所有request请求参数key-value
     * @return
     */
    public Map<String, String> getRequestParams() {
        Map<String, String> params = new HashMap<String, String>();
        if(null != this.request){
            Set<String> paramsKey = this.request.getParameterMap().keySet();
            for(String key : paramsKey){
                params.put(key, this.request.getParameter(key));
            }
        }
        return params;
    }

    public <T> T getT() {
        Map<String, String> requestParams = this.getRequestParams();
        return (T) JSON.parseObject(JSON.toJSONString(requestParams));
    }

}
