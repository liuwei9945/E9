package com.api.cs.demo02_22c545406a174abfaea9deabcc930fa2.web;

import com.alibaba.fastjson.JSONObject;
import com.engine.common.util.ParamUtil;
import com.engine.common.util.ServiceUtil;
import com.api.cs.demo02_22c545406a174abfaea9deabcc930fa2.service.DemoService02;
import com.api.cs.demo02_22c545406a174abfaea9deabcc930fa2.service.Impl.DemoServiceImpl02;
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
@Path("/cs/demo02_22c545406a174abfaea9deabcc930fa2")
public class DemoAction02 {

    private DemoService02 getService(User user) {
        return (DemoServiceImpl02) ServiceUtil.getService(DemoServiceImpl02.class, user);
    }

    /**
     * 获取表单的demo
     * @param request
     * @param response
     * @return
     */
    @GET
    @Path("/getFormDemo")
    @Produces({MediaType.TEXT_PLAIN})
    public String getFormDemo(@Context HttpServletRequest request, @Context HttpServletResponse response){
        Map<String, Object> apidatas = new HashMap<String, Object>();
        try {
            //获取当前用户
            User user = HrmUserVarify.getUser(request, response);
            apidatas.putAll(getService(user).getFormDemo(ParamUtil.request2Map(request)));
            apidatas.put("api_status", true);
        } catch (Exception e) {
            e.printStackTrace();
            apidatas.put("api_status", false);
            apidatas.put("api_errormsg", "catch exception : " + e.getMessage());
        }
        return JSONObject.toJSONString(apidatas);
    }
}
