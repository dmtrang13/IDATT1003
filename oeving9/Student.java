package oeving9;

public class Student {
    private String name;
    private int taskCount;

    public Student(String name) {
        this.name = name;
        this.taskCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void incrementTask(int increment) {
        taskCount += increment;
    }

    public String toString() {
        return "Name: " + name
                + "\nTask Count: " + taskCount + "\n";
                
    }

}
