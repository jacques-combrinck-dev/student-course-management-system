
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        DatabaseConnection.getConnection();

        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        EnrollmentService enrollmentService = new EnrollmentService();
        CourseService courseService = new CourseService();


        while(true) {
            System.out.println("Choose the number option you wish to pick: ");
            System.out.println("1. Add Student");
            System.out.println("2. View all Students");
            System.out.println("3. Search for Student Via StudentNumber");
            System.out.println("4. Remove Student");
            System.out.println("5. Update Student name");
            System.out.println("6. Add a Course");
            System.out.println("7. Find Course by name");
            System.out.println("8. View all Courses");
            System.out.println("9. Enroll in a Course");
            System.out.println("10. View all enrollments");
            System.out.println("11. Exit");

            int option = 0;

            while (true) {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid Input. Please try again:");
                    scanner.next();
                }
            }
            if (option == 1) {
                scanner.nextLine();

                System.out.println("Please enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Please enter your student number: ");
                int studNum = scanner.nextInt();

                Student student1 = new Student(name, studNum);


                studentService.addStudent(student1);

            } else if (option == 2) {
                for (Student s : studentService.getStudents()) {
                    System.out.println(s);
                }

            } else if (option == 3) {
                System.out.println("Please enter the student number:");
                int number = scanner.nextInt();
                Student studentViaNum = studentService.getStudentViaNum(number);
                if (studentViaNum == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.println(studentViaNum);
                }

            } else if (option == 4) {
                System.out.println("Please enter student number to remove student: ");
                int num = scanner.nextInt();
                boolean remove = studentService.removeStudentViaNumber(num);
                if( remove == true ) {
                    System.out.println("Student removed successfully.");
                } else {
                    System.out.println("Student not found.");
                }

            } else if (option == 5) {
                System.out.println("Please enter student number to update student name");
                int num = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter new student name");
                String newName = scanner.nextLine();
                boolean update = studentService.updateStudentName(num, newName);
                if(update == true) {
                    System.out.println("Student Updated successfully");
                } else {
                    System.out.println("Student not found");
                }



            } else if (option == 6) {
                System.out.println("Please enter Course name");
                scanner.nextLine();
                String courseName = scanner.nextLine();
                Course course = new Course(courseName);
                courseService.addCourse(course);


            } else if (option == 7) {
                System.out.println("Please enter Course you wish to search for");
                scanner.nextLine();
                String courseSearch = scanner.nextLine();
                Course c = courseService.findCourseByName(courseSearch);
                if(c == null) {
                    System.out.println("Course not found");
                } else {
                    System.out.println("Course found! "+ c.getCourseName());
                }


            } else if (option == 8) {
                for(Course s: courseService.getCourses()) {
                    System.out.println(s);
                }

            }  else if (option == 9) {
                scanner.nextLine();
                System.out.println("Please enter student number");
                int number = scanner.nextInt();
                scanner.nextLine();
                Student student = studentService.getStudentViaNum(number);

                System.out.println("Please enter Course name");
                String name = scanner.nextLine();
                Course course = courseService.findCourseByName(name);

                if (student == null || course == null) {
                    System.out.println("Doesn't exist in database");

                } else {
                    enrollmentService.enroll(student, course);
                }


            } else if (option == 10) {
                for (String e : enrollmentService.getEnrollments()) {
                    System.out.println(e);
                }

            } else if (option == 11) {
                System.out.println("Thanks for using us!");
                break;
            }

            //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
            // to see how IntelliJ IDEA suggests fixing it.
            //Student student1 = new Student("Jacques Combrinck", 25501);
            //Student student2 = new Student("Alex Naaido", 34556);

            //StudentService studentService = new StudentService();

            //studentService.addStudent(student1);
            //studentService.addStudent(student2);


            continue;
        }


        }
    }
