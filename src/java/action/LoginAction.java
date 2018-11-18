/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import registration.AccountDAO;

/**
 *
 * @author ASUS
 */
public class LoginAction {

    private String username;
    private String password;
    private final String SUCCESS = "success";
    private final String FAIL = "faild";

    public LoginAction() {

    }

    public String execute() throws Exception {
        AccountDAO dao = new AccountDAO();
        String url = FAIL;
        if (dao.checkLogin(username, password)) {
            Map session = ActionContext.getContext().getSession();
            session.put("USER",username);
            url = SUCCESS;
        }
        return url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
