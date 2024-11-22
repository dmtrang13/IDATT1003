package oeving9;
//
public class Client {
    public static void main(String[] args) {
        TaskOverview taskOverview = new TaskOverview();
        Student newStudent = new Student("Didick");
        Student newStudent1 = new Student("Ibra");
        taskOverview.addStudent(newStudent);
        taskOverview.addStudent(newStudent1);
        taskOverview.incrementStudent(newStudent, 2);
        System.out.println("Number of students: " + taskOverview.getStudentCount());
        System.out.println(taskOverview); //toString()
        System.out.println(newStudent.getName() + " has completed " + taskOverview.getStudentTaskCount(newStudent) + " tasks");
    }
    
    

}
