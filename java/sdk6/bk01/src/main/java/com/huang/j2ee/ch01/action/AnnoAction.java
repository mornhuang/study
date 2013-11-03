package com.huang.j2ee.ch01.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.*;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-20 下午6:40
 * Descriptions    :
 */
@ParentPackage("default")
@Namespace("/")
@Results({
    @Result(name = "success", type = "dispatcher", location = "/jsp/anno.jsp", params = {})
})
/*
@ExceptionMappings({
    @ExceptionMapping(exception = "", result = ""),
    @ExceptionMapping(exception = "", result = "", params = {})
})
*/
/*
@InterceptorRefs({
    @InterceptorRef(value = "", params = {}),
    @InterceptorRef(value = "")
})
*/
public class AnnoAction {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

/*
    @Actions({
        @Action(value = "Anno", params = {"username", "huang", "password", "abc"}),
        @Action(value = "Anno2")
    })
*/
    @Action(value = "Anno", params = {"username", "huang", "password", "abc"})
    public String doAcTest() throws Exception {
        ActionContext.getContext().put("password", password);
        return "success";
    }
}
