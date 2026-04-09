
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class EnrollmentService {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void enroll(Student student,Course course) {
        String sql = "INSERT INTO enrollments (student_id, course_id) " +
                "VALUES ((SELECT id FROM students WHERE student_number = ?), " +
                "(SELECT id FROM courses WHERE course_name = ?))";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, student.getStudentNumber());
            stmt.setString(2, course.getCourseName());

            stmt.executeUpdate();
            System.out.println("Enrollment successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<String> getEnrollments() {
        ArrayList<String> enrollments = new ArrayList<>();

        String sql = "SELECT s.name, c.course_name " +
                "FROM enrollments e " +
                "JOIN students s ON e.student_id = s.id " +
                "JOIN courses c ON e.course_id = c.id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {
                String studentName = rs.getString("name");
                String courseName = rs.getString("course_name");

                String line = studentName + " -> " + courseName;
                enrollments.add(line);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;

    }

}
