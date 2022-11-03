package temp;

import org.testng.annotations.Test;
import utils.MyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyConnectionTest{

    @Test
    public void test01() throws SQLException {
        MyConnection myConnection = new MyConnection(
                "jdbc:mysql://142.93.110.12:3306/tempdb",
                "gsuser",
                "Gsuser!123456");

        ResultSet resultSet = myConnection.getResultSet("SELECT * FROM kartal;");

        while(resultSet.next()){
            System.out.println(resultSet.getString(1)+ "  -  "+resultSet.getString(2));
        }

        myConnection.tearDown();

    }


}
