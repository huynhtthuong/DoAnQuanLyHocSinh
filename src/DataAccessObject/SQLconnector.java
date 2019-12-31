/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

/**
 *
 * @author mr932
 */
public class SQLconnector {
    // Properties
    String Host = "localhost";
    String User = "root";
    String Password = "huynhthuong";
    String Database = "truonghoc_1312";
    
    Connection connect = null;
    Statement statement = null;
    ResultSet result = null;
    
    // Constructors
    public SQLconnector(){}
    public SQLconnector(String Host, String User, String Password, String Database){
        this.Host = Host;
        this.User = User;
        this.Password = Password;
        this.Database = Database;
    }
    
    protected void driverTest() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(java.lang.ClassNotFoundException e){
            throw new Exception("MySQL JDBC Driver not found");
        }
    }
    
    protected Connection getConnect() throws Exception{
        if(this.connect == null){
            driverTest();
                String url = "jdbc:mysql://" + this.Host + ":3307/" + this.Database;
            try{
                this.connect = DriverManager.getConnection(url, this.User, this.Password);
            }catch(java.sql.SQLException e){
                throw new Exception("Không thể kết nối đến database");
            }
            }
        return this.connect;
    }
    
    protected Statement getStatement() throws Exception{
        if(this.statement == null ? true :this.statement.isClosed()){
            this.statement = this.getConnect().createStatement();
        }
        return this.statement;
    }
    
    public ResultSet executeQuery(String Query) throws Exception{
        try{
            this.result = this.getStatement().executeQuery(Query);
        }catch(Exception e){
        throw new Exception("Error" + e.getMessage() + "-" + Query);
        }
        return this.result;
    }
    
    public int executeUpdate(String Query) throws Exception{
        int res = Integer.MIN_VALUE;
        try{
            res = this.getStatement().executeUpdate(Query);
        }catch(Exception e){
            throw new Exception("Error : " + e.getMessage()+ "-" + Query );
        }finally{
            this.Close();
        }
        return res;
    }
    
    public void Close() throws Exception{
        if(this.result != null && !this.result.isClosed()){
            this.result.close();
            this.result = null;
        }
        if(this.statement != null && ! this.statement.isClosed()){
            this.statement.close();
            this.statement = null;
        }
        if(this.connect != null && ! this.connect.isClosed()){
            this.connect.close();
            this.connect = null;
        }}
}

