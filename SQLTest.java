/*MySQL 연결 생성코드 테스트
* CREATED: 2023-12-11*/
import java.sql.*;
public class SQLTest {
    public static void main(String[]args){
        Connection con = null;

        String server       = "localhost";                                      //서버주소
        String url          = "jdbc:mysql://localhost:3306/nanumi_members";     //DBurl
        String user_name    = "root";                                           //접속자 id
        String password     = "dhoqkRnj1!";                                     //접속자 pw

        //JDBC 드라이버 로드
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        //접속
        try{
            //[B]#1
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            System.out.println("연결 완료!");
            //[E]#1


            //[B]#2
            Connection connection   = DriverManager.getConnection(url, user_name, password);
            Statement statement     = connection.createStatement();
            ResultSet resultSet     = statement.executeQuery("select * From player_info");

            resultSet.next();
            String name = resultSet.getString("name");
            System.out.println(name);

            resultSet.close();
            resultSet.close();
            resultSet.close();
            //[E]#2
        }catch(SQLException e){
            System.out.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }

        //접속 종료
        try{
            if(con != null)
                con.close();
        }catch(SQLException e){

        }
    }
}
