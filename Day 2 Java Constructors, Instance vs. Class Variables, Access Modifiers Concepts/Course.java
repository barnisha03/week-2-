public class Course {
    private String courseName;
    private int duration; // in weeks
    private double fee;
    
    private static String instituteName = "Global Tech Institute"; // Class variable
    
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }
    
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
    
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 12, 1500);
        Course c2 = new Course("Data Science", 16, 2000);
        
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
        
        System.out.println("\nUpdating institute name...\n");
        Course.updateInstituteName("Advanced Learning Academy");
        
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}







