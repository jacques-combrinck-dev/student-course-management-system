import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CourseService {


    public void addCourse(Course course) {
        String sql = "INSERT INTO courses (course_name) VALUES(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getCourseName());

            stmt.executeUpdate();
            System.out.println("Course added to Database");

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        String sql = "SELECT * FROM courses";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {
                String courseName = rs.getString("course_name");

                Course course = new Course(courseName);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;

    }
    public Course findCourseByName(String name) {
        String sql = "SELECT course_name FROM courses WHERE course_name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String courseName = rs.getString("course_name");

                return new Course(courseName);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

}
