import java.sql.*;

public class crud  {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/Tutorial";
        String uname = "postgres";
        String pass = "ayush123";

//        insert
//        String sql = "insert into student values (6, 'Pixar', 79)";

        //update
//        String sql = "update student set marks = 72 where sid=1";

        //delete
//        String sql = "delete from student where sid=6";

        //prepared statement
        String sql = "insert into student values (?,?,?)";

        int sid = 6;
        String sname = "Pixar";
        int marks = 84;

        try{
            Connection con = DriverManager.getConnection(url, uname, pass);
            System.out.println("Connection Established!");
//            Statement st = con.createStatement();
//            st.execute(sql);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sid);
            ps.setString(2, sname);
            ps.setInt(3, marks);

            ps.execute();

            System.out.println("Connection Closed!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
