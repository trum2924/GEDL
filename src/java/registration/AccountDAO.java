package registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DButils;

public class AccountDAO {

    private List<AccountDTO> listAccount;

    public List<AccountDTO> getListAccount() {
        return listAccount;
    }

    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DButils.makeConnection();
            if (con != null) {
                String query = "select * from tbl_User where userid = ? and password = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public void searchUsername(String searchValue) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DButils.makeConnection();
            if (con != null) {
                String query = "select * from tbl_User where userid like ?";
                stm = con.prepareStatement(query);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString(1);
                    String password = rs.getString(2);
                    AccountDTO dto = new AccountDTO(username, password);
                    if (listAccount == null) {
                        listAccount = new ArrayList<AccountDTO>();
                    }
                    listAccount.add(dto);

                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean deleteRecord(String pk) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DButils.makeConnection();
            if (con != null) {
                String query = "delete from tbl_User where userid = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, pk);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
