
package action;

import java.util.List;
import registration.AccountDAO;
import registration.AccountDTO;

public class SearchAction {
    private String searchValue;
    private final String SUCCESS = "success";
    private List<AccountDTO> listAccount;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<AccountDTO> getListAccount() {
        return listAccount;
    }

   
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        AccountDAO dao = new AccountDAO();
        dao.searchUsername(searchValue);
      listAccount=dao.getListAccount();
       return SUCCESS;
    }
    
}
