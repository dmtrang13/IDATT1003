package oeving9;
import java.util.ArrayList;


public class TaskOverview{
    private ArrayList<Student> students;
    private int studentCount;

    public TaskOverview() {
        this.students = new ArrayList<Student>();
        this.studentCount = 0;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void addStudent(Student student) {
        students.add(student);
        studentCount++;
    }

    public void incrementStudent(Student student, int taskIncrement) {
       student.incrementTask(taskIncrement); 
    }

    public int getStudentTaskCount(Student student) {
        return student.getTaskCount();
    }

    public String toString() {
        String string = "";
        for (Student student : students){
            string += student + "\n";
        }
        return string;
    }

}
