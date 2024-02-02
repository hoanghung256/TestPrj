package dao;

import java.sql.*;
/**
 *
 * @author hoang hung
 * Impelement Singleton Pattern
 */

public class JDBCUtil {
    private static JDBCUtil instance;
    private static Connection connection;
    private String url = "jdbc:sqlserver://localhost:1433;database=StaffManageApplication;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private String username = "sa";
    private String password = "2562004";
    
    private JDBCUtil() {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
    
    public static JDBCUtil getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new JDBCUtil();
        }
        
        return instance;
    }
    
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws SQLException {
        Connection conn = JDBCUtil.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "  SELECT * FROM [StaffManageApplication].[dbo].[Staff]";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }
}
