
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DButils implements Serializable{
   
    public static Connection makeConnection() throws NamingException, SQLException{
        Context context = new InitialContext();
        Context tomcatCtx = (Context)context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatCtx.lookup("GEDL");
        Connection con = ds.getConnection();
        return con;
    }
    
}
