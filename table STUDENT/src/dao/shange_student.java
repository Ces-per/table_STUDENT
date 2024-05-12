package dao;

//import edu javacourse, studentorder, domain. Stre
import entity.student;
import java.sql.*;
import java.util.LinkedList; import java.util. List;
public class shange_student {


    private Connection getConnection() throws  SQLException{
        Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "1");
        return con;
    }

    public List<student> findStreets(String pattern) throws Exception {
        List<student> result = new LinkedList<>();
        try { Connection con = getConnection();

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT *\n" +
                "\tFROM public.\"ученики\";");
            while (rs.next()){
                student st = new student();
                st.setId(rs.getLong(1));
                st.setage(rs.getLong(2));
                st.setKlass(rs.getLong(3));
                st.setFamiliya(rs.getString(4));
                st.setName_(rs.getString(5));
                st.setOtchestvo(rs.getString(6));
                 result.add(st);
            }
        //int i = rs.getInt("max")+1;
        }
        catch (Exception e){}
            return result;
    } // Вывод

    public ResultSet selctstudent(){
        try{
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, age, klass, \"Familiya\", \"Name_\", \"Otchestvo\"\n" +
                    "\tFROM public.\"ученики\"\n" +
                    "\twhere delet= true;");
            return rs;
        }
        catch (Exception e){}
        return null;
    }

    public int createstudent(student student) {
        try {////блок кода, в котором может произойти исключение
            String sql = "INSERT INTO public.\"ученики\"(\n" +
                    "\tid, age, klass, \"Familiya\", \"Name_\", \"Otchestvo\", delet)\n" +
                    "\tVALUES (?, ?, ?, ?, ?, ?, true);";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setLong(1, student.getId());
            statement.setLong(2, student.getAge());
            statement.setLong(3, student.getKlass());
            statement.setString(4, student.getFamiliya());
            statement.setString(5, student.getName_());
            statement.setString(6, student.getOtchestvo());
            int i = statement.executeUpdate();
            System.out.println("Добавлено строк " + i);
        }
        catch (Exception e){}
        return 0;
    } // Добавление

    public int updateStudent(student student) {
        try
        {Connection con = getConnection();
        Statement stmt = con.createStatement();

            String sqlUpdate="UPDATE public.\"ученики\"\n" +
                    "\tSET id=?, age=?, klass=?, \"Familiya\"=?, \"Name_\"=?, \"Otchestvo\"=?\n" +
                    "\tWHERE id=?;";
            PreparedStatement statement = getConnection().prepareStatement(sqlUpdate);
            statement.setLong(1, student.getId());
            statement.setLong(2, student.getAge());
            statement.setLong(3, student.getKlass());
            statement.setString(4, student.getFamiliya());
            statement.setString(5, student.getName_());
            statement.setString(6, student.getOtchestvo());
            statement.setLong(7, student.getWhere());
            int i =  statement.executeUpdate();
            System.out.println("Обновлено строк " + i);

        } catch (Exception e){}
        return 0;
    }

        public int deletStudent(student student) {
            try
            {Connection con = getConnection();
                Statement stmt = con.createStatement();

                String sqlUpdate="UPDATE public.\"ученики\"\n" +
                        "\tSET delet=false\n" +
                        "\tWHERE id=?;";
                PreparedStatement statement = getConnection().prepareStatement(sqlUpdate);
                statement.setLong(1, student.getWhere());
                int i =  statement.executeUpdate();
                System.out.println("удолено строк строк " + i);

            } catch (Exception e){}
            return 0;
        }

}