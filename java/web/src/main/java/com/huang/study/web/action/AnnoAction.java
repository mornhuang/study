package com.huang.study.web.action;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-20 下午6:40
 * Descriptions    :
 */
/*@ParentPackage("default")
@Action(name = "AnnoAction")
@Results({
    @Result(name = "preEdit", type = NullResult.class, value = "/jsp/component/mail/mailsetting.jsp", params = {})
})*/
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

    public String doAcTest() throws Exception {

        return "success";
    }
}
