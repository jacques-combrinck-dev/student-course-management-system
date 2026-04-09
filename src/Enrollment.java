public class Enrollment {

    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
    public Student getStudent() {

        return this.student;
    }
    public Course getCourse() {

        return this.course;
    }
    @Override
    public String toString() {
        return student.getName() + " is enrolled in " + course.getCourseName();
    }




}
