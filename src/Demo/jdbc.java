package Demo;

import java.sql.*;

public class jdbc  {
    public static void main(String[] args) {
        /*
            import package
            load and register
            create connection
            create statement
            execute statement
            process and results
            close
         */
        // loading (optional) (You can ignore it!)
        try{
            Class.forName("org.postgresql.Driver");
        }  catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost:5432/Tutorial";
        String uname = "postgres";
        String pass = "ayush123";

        String sql = "select * from student";

        try{
            Connection con = DriverManager.getConnection(url, uname, pass);
            System.out.println("Connection Established!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
//            rs.next();
//            String name = rs.getString("sname");
//            System.out.println("Name of student: " + name);

            while(rs.next()){
                System.out.print(rs.getInt(1) + " - ");
                System.out.print(rs.getString(2) + " : ");
                System.out.println(rs.getInt(3));
            }

            con.close();
            System.out.println("Connection Closed!");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
