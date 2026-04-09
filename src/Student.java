public class Student {
    private String name;
    private int studentNumber;

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }
    public String getName() {
        return this.name;
    }
    public int getStudentNumber() {
        return this.studentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "Student{name='" + name + "', studentNumber=" + studentNumber + "}";
    }
}

