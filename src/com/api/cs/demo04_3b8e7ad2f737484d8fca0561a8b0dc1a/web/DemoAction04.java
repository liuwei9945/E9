package com.api.cs.demo04_3b8e7ad2f737484d8fca0561a8b0dc1a.web;

import com.alibaba.fastjson.JSONObject;
import com.api.cs.demo04_3b8e7ad2f737484d8fca0561a8b0dc1a.service.DemoService04;
import com.api.cs.demo04_3b8e7ad2f737484d8fca0561a8b0dc1a.service.Impl.DemoServiceImpl04;
import com.engine.common.util.ParamUtil;
import com.engine.common.util.ServiceUtil;
import weaver.hrm.HrmUserVarify;
import weaver.hrm.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author      :wyl
 * @Date        :2019/4/19  11:46
 * @Version 1.0 :
 * @Description :
 **/
@Path("/cs/demo04_3b8e7ad2f737484d8fca0561a8b0dc1a")
public class DemoAction04 {

    private DemoService04 getService(User user) {
        return (DemoServiceImpl04) ServiceUtil.getService(DemoServiceImpl04.class, user);
    }

    /**
     * 获取表单的demo
     * @param request
     * @param response
     * @return
     */
    @GET
    @Path("/weatableDemo")
    @Produces({MediaType.TEXT_PLAIN})
    public String weatableDemo(@Context HttpServletRequest request, @Context HttpServletResponse response){
        Map<String, Object> apidatas = new HashMap<String, Object>();
        try {
            //获取当前用户
            User user = HrmUserVarify.getUser(request, response);
            apidatas.putAll(getService(user).weatableDemo(ParamUtil.request2Map(request)));
            apidatas.put("api_status", true);
        } catch (Exception e) {
            e.printStackTrace();
            apidatas.put("api_status", false);
            apidatas.put("api_errormsg", "catch exception : " + e.getMessage());
        }
        return JSONObject.toJSONString(apidatas);
    }

    /**
     * 获取高级搜索条件(含tab页)
     * @param request
     * @param response
     * @return
     */
    @GET
    @Path("/weatableConditonDemo")
    @Produces({MediaType.TEXT_PLAIN})
    public String weatableConditonDemo(@Context HttpServletRequest request, @Context HttpServletResponse response){
        Map<String, Object> apidatas = new HashMap<String, Object>();
        try {
            //获取当前用户
            User user = HrmUserVarify.getUser(request, response);
            apidatas.putAll(getService(user).weatableConditonDemo(ParamUtil.request2Map(request)));
            apidatas.put("api_status", true);
        } catch (Exception e) {
            e.printStackTrace();
            apidatas.put("api_status", false);
            apidatas.put("api_errormsg", "catch exception : " + e.getMessage());
        }
        return JSONObject.toJSONString(apidatas);
    }
}
