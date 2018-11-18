/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import registration.AccountDAO;

/**
 *
 * @author ASUS
 */
public class DeleteAction {

    private String pk;
    private String lastSearch;
    private final String SUCCESS = "success";
    private final String FAIL = "faild";

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getLastSearch() {
        return lastSearch;
    }

    public void setLastSearch(String lastSearch) {
        this.lastSearch = lastSearch;
    }

    public DeleteAction() {
    }

    public String execute() throws Exception {
        AccountDAO dao = new AccountDAO();
        String url = FAIL;
        if(dao.deleteRecord(pk)){
            url = SUCCESS;
        }
        return url;
    }

}
