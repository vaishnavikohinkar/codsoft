import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int availableSlots;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.availableSlots = capacity;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public boolean registerStudent() {
        if (availableSlots > 0) {
            availableSlots--;
            return true;
        }
        return false;
    }

    public void dropStudent() {
        if (availableSlots < capacity) {
            availableSlots++;
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\n" +
               "Title: " + title + "\n" +
               "Description: " + description + "\n" +
               "Available Slots: " + availableSlots + "/" + capacity + "\n" +
               "Schedule: " + schedule;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            System.out.println("Course registered: " + course.getTitle());
        } else {
            System.out.println("Course is full: " + course.getTitle());
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.dropStudent();
            registeredCourses.remove(course);
            System.out.println("Course dropped: " + course.getTitle());
        } else {
            System.out.println("Course not found: " + course.getTitle());
        }
    }
}

public class CourseRegistrationSystem  {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CSCI101", "Introduction to Programming", "Learn the basics of programming.", 50, "Mon/Wed 9:00 AM - 10:30 AM"));
        courses.add(new Course("MATH201", "Calculus I", "Study differential and integral calculus.", 40, "Tue/Thu 11:00 AM - 12:30 PM"));
        courses.add(new Course("PHYS301", "Physics Mechanics", "Explore classical mechanics.", 30, "Wed/Fri 2:00 PM - 3:30 PM"));

        List<Student> students = new ArrayList<>();
        students.add(new Student(1001, "John Doe"));
        students.add(new Student(1002, "Jane Smith"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
            case 1:
                	 System.out.println("\nAvailable Courses:");
                     for (Course course : courses) {
                         System.out.println(course);
                         System.out.println("-------------------------------");
                     }
                     break;
            case 2:
                     System.out.print("Enter student ID: ");
                     int studentID = scanner.nextInt();
                     Student student = findStudent(students, studentID);
                     if (student != null) {
                         System.out.println("\nAvailable Courses:");
                         for (int i = 0; i < courses.size(); i++) {
                             System.out.println(i + 1 + ". " + courses.get(i).getTitle());
                         }
                         System.out.print("Select a course (1-" + courses.size() + "): ");
                         int courseChoice = scanner.nextInt() - 1;
                         if (courseChoice >= 0 && courseChoice < courses.size()) {
                             student.registerCourse(courses.get(courseChoice));
                         } else {
                             System.out.println("Invalid course selection.");
                         }
                     } else {
                         System.out.println("Student not found.");
                     }
                     break;
            case 3:
                     System.out.print("Enter student ID: ");
                     int studentIDDrop = scanner.nextInt();
                     Student studentDrop = findStudent(students, studentIDDrop);
                     if (studentDrop != null) {
                         List<Course> studentCourses = studentDrop.getRegisteredCourses();
                         if (!studentCourses.isEmpty()) {
                             System.out.println("\nRegistered Courses:");
                             for (int i = 0; i < studentCourses.size(); i++) {
                                 System.out.println(i + 1 + ". " + studentCourses.get(i).getTitle());
                             }
                             System.out.print("Select a course to drop (1-" + studentCourses.size() + "): ");
                             int courseChoiceDrop = scanner.nextInt() - 1;
                             if (courseChoiceDrop >= 0 && courseChoiceDrop < studentCourses.size()) {
                                 studentDrop.dropCourse(studentCourses.get(courseChoiceDrop));
                             } else {
                                 System.out.println("Invalid course selection.");
                             }
                         } else {
                             System.out.println("No registered courses to drop.");
                         }
                     } else {
                         System.out.println("Student not found.");
                     }
                     break;
                 case 4:
                     System.out.println("Exiting the system.");
                     scanner.close();
                     return;
                 default:
                	 System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    static Student findStudent(List<Student> students, int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
                
    }
}




