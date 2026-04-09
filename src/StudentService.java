
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentService {


    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, student_number) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getStudentNumber());

            stmt.executeUpdate();
            System.out.println("Student added to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int studentNumber = rs.getInt("student_number");

                Student student = new Student(name, studentNumber);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;


    }
    public Student getStudentViaNum(int num) {
        String sql = "SELECT * FROM students WHERE student_number = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, num);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int studentNumber = rs.getInt("student_number");

                return new Student(name, studentNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean removeStudentViaNumber(int number) {
        String sql = "DELETE FROM students WHERE student_number = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, number);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateStudentName(int num, String newName) {
        String sql = "UPDATE students SET name = ? WHERE student_number = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName); // first ?
            stmt.setInt(2, num);        // second ?

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



}
