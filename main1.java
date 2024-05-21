import java.util.*;
public class main1 { 
    static int numStudents;
    static int counter;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of students to store from the user
        System.out.println("Enter the number of students to manage: ");
        numStudents = scanner.nextInt();

        // Create an array to store Student objects
        Student[] students = new Student[numStudents];
        course[] courses=new course[numStudents];
        Teacher teacher=new Teacher();
        // Do While Loop For Menu
        int choice;
        do {
            System.out.println("\n-------------------------------------\n");
            System.out.println("\n      Student Management System    ");
            System.out.println("\n-------------------------------------\n");
            System.out.println("||  1. Add Student              ||");
            System.out.println("||  2. View Students            ||");
            System.out.println("||  3. Update Student           ||");
            System.out.println("||  4. Delete Student           ||");
            System.out.println("||  5. Enroll Student in Course ||"); 
            System.out.println("||  6. Assign Grade             ||"); 
            System.out.println("||  7. View Student Grades      ||"); 
            System.out.println("||  8. Manage Teachers          ||"); 
            System.out.println("||  9. Exit                     ||");
            System.out.println("\n-------------------------------------\n");
            System.out.print("Enter your choice:=> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(students,courses);

                    if (numStudents>=counter)
                        counter++;   

                    break;
                case 2:
                    viewStudents(students,courses);  
                    break;
                case 3:
                    updateStudent(students); 
                    break;
                case 4:
                    deleteStudent(students); 
                    break;
                case 5:
                    enrollStudent(students,courses);
                    break;
                case 6:
                    setGrade(students);
                    break;
                case 7:
                    viewGrades(students);
                    break;
                case 8:
                    teacher.teach();
                case 9:
                    System.out.println("Exiting Student Management System");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 9);

        System.out.println("Thanks for using Student Management System");
    }

    public static void addStudent(Student[] students,course[] courses) {
        Scanner scanner = new Scanner(System.in);

        // Find the first empty slot in the students array
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Student list is full!");
            return;
        }

        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student ID: ");
        int id = scanner.nextInt();

        // Create a new Student object and assign it to the empty slot
        students[index] = new Student(name, id);
        courses[index]=new course("");
        System.out.println("Student added successfully!");
    }
    public static void viewStudents(Student[] students,course[] courses) 
    {
        //if()
        //{
         //   System.out.println("Add Students to View ");
          //  return;
        //}
        boolean flag=false;
        boolean t= false; 
        for (course course1 : courses) {
            if (course1 != null) {
                flag=true;
            }
        }
        for (int i=0;i<counter;i++) 
        {
            if(students[i].getId()!=-1 || students[i].getName()!=null)
            {
            System.out.println(" \n ======================================== \n");
            System.out.println("  Id Of Student :"+ students[i].getId());

            System.out.println("  Name Of Student :"+students[i].getName());
            if(flag==true && courses[i].getCourse()!="")
                System.out.println("  Course Of Student :"+courses[i].getCourse());

            System.out.println(" \n ======================================== \n ");
            t=true;
            }
        }
        
        if(t==false)
        {
            System.out.println("\n\n\n Students Not Added ....!!!!! \n\n\n\n\n");
        }
    
    }
    public static void updateStudent(Student[] students) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student ID to update: ");
        int id = scanner.nextInt();
        int cnt=0;
        String newName="";
        for (int i=0;i<counter;i++) 
        {
            if (students[i].getId() == id ) 
            {
                System.out.println("Update student name : ");
                newName = scanner.next();
                students[i].setName(newName);
                System.out.println("Done : ");
                cnt++;
                break;
            }
        }
        if(cnt==0)
        {   
            System.out.println("\n======================================== \n");
            System.out.println("            Student Not Found   ");
            System.out.println("\n======================================== \n");
        }
        //String newName = scanner.nextLine();
    }
    //Delete student
    public static void deleteStudent(Student[] students) 
    {
        Scanner scanner = new Scanner(System.in);

    
        if (students[0].getName()==null) 
        {
            System.out.println("No students found!");
            return;
        }
    
        System.out.print("Enter student ID to delete:=> ");
        int id = scanner.nextInt();
    
        //int studentIndex = -1;
        for (int i=0;i<counter;i++) 
        {
            if (students[i].getId() == id ) 
            {
                System.out.println("\n============================================================= \n");
                System.out.println("Student Name : "+  (students[i].getName()) + "  Student Id :" +  (students[i].getId() ));
                System.out.println("\n============================================================= \n");
                System.out.println("Do you want to delete this student? if YES Enter 1 or If NO Enter 0 ");
                int n=scanner.nextInt();
                
                if(n==1)
                {
                    counter=counter-1;
                    students[i].setId();
                    students[i].setName();
                    System.out.println("Student deleted successfully!");

                }
                else{
                    System.out.println("No changes made.....");
                }
            
                break;
            }
        }
    }
    public static void enrollStudent(Student[] students ,course[] courses) 
    {
        Scanner scanner = new Scanner(System.in);

    
        if (students[0].getName()==null) 
        {
            System.out.println("No students found!");
            return;
        }
    
        System.out.print("Enter student ID to You want Enroll the Course=> ");
        int id = scanner.nextInt();
    
        //int studentIndex = -1;
        for (int i=0;i<counter;i++) 
        {
            if (students[i].getId() == id ) 
            {
                System.out.println("\n============================================================= \n");
                System.out.println("    Select Course");
                System.out.println("      1. BCA ");
                System.out.println("      2. BBA ");
                System.out.println("      3. MCA ");
                System.out.println("      4. MBA ");
                System.out.println("\n============================================================= \n");
                int n=scanner.nextInt();
                switch (n) {
                    case 1:
                        courses[i].setCourse("BCA");
                        break;
                    case 2:
                        courses[i].setCourse("BBA");
                        break;
                    case 3:
                        courses[i].setCourse("MCA");
                        break;
                    case 4:
                        courses[i].setCourse("MBA");
                        break; 
                    default:
                    System.out.println("!!!!!!!!!!!!!!!!!!! INVALID INPUT NO COURSE ADDED TO STUDENT  !!!!!!!!!!!!!");
                
            }
            
                break;
            }
        }
    }
    public static void setGrade(Student[] students)
    {
        if (students[0].getName()==null) 
        {
            System.out.println("No students found!");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student ID to add Grades : ");
        int id = scanner.nextInt();
        int grade=0;
        
        for (int i=0;i<counter;i++) 
        {
            if (students[i].getId() == id ) 
            {
                System.out.println("Enter Grades from 1 to 100 Only: ");
                System.out.println("Update student Grades : ");
                grade = scanner.nextInt();
                if(grade<=100 && grade>=1)
                {
                    students[i].setGrade(grade);
                    System.out.println("Grades Updated");    
                }
                else
                    System.out.println("Grades Were Not Updated ");

                    
                break;
            }
        }

    } 
    public static void viewGrades(Student[] students)
    {
        //boolean flag=false;
        boolean t= false; 
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to View Grades :=> ");
        int id = scanner.nextInt();

        for (int i=0;i<counter;i++) 
        {
            if (students[i].getId() == id && students[i].getId()!=0 ) 
            {
            System.out.println(" \n ======================================== \n");
            System.out.println("  Id Of Student : "+ students[i].getId());

            System.out.println("  Name Of Student : "+students[i].getName());
                System.out.println("  Course Of Student : "+students[i].getGrade());
            

            System.out.println(" \n ======================================== \n ");
            t=true;
            return;
            }
        }
        
        if(t==false)
        {
            System.out.println("\n\n\n Students Not Added ....!!!!! \n\n\n\n\n");
        }
    
    }

}

//constructore of student class
class Student {
    private String name;
    private int id;
    private float grades;
    // Constructor to initialize student object
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        grades=0;
    }
    public void setGrade(float grades)
    {
        this.grades=grades;
    }
    public float getGrade()
    {
        return grades;
    }
    public int getId()
    {
        return id;             
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setName()
    {
        this.name=null;
    }
    public void setId()
    {
        this.id=-1;
    }
}
class course {
    private String course;
    public course(String course)
    {
        this.course=course;
    }
    public String getCourse()
    {
        return course;             
    }
    public void setCourse(String course)
    {
        this.course=course;             
    }
}
class Teacher{
    
    static int numTeacher;
    static int counter=0;
    public void teach(){
    Scanner scanner = new Scanner(System.in);
    
    // Get the number of teacher to store from the user
    System.out.print("Enter the number of Teacher to manage: ");
    numTeacher = scanner.nextInt();
    T[] t=new T[numTeacher];
    int choice;
        do {
            System.out.println("\n-------------------------------------\n");
            System.out.println("\n      Teacher     ");
            System.out.println("\n-------------------------------------\n");
            System.out.println("||  1. Add Teacher              ||");
            System.out.println("||  2. View Students            ||");
            System.out.println("||  0. Exit                     ||");
            System.out.println("\n-------------------------------------\n");
            System.out.print("Enter your choice:=> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTeacher(t);
                    break;
                case 2:
                    viewTeacher(t); 
                    if(counter<numTeacher)
                    {
                        counter++;
                    }
                    break;
                case 0:
                    System.out.println("Teacher Modified");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

   
    }
    public static void addTeacher(T[] t) {
        Scanner scanner = new Scanner(System.in);

        
        int index = -1;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Teacherr list is full!");
            return;
        }

        System.out.println("Enter Teacher name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Teacher Mobile Number : ");
        String phno = scanner.next();
        System.out.println("Enter Teacher ID : ");
        int id = scanner.nextInt();
        
        // Create a new Student object and assign it to the empty slot
        t[index] = new T(name, id,phno);
        
        System.out.println("Teaceher added successfully!");
    }
    public static void viewTeacher(T[] t) 
    {
        
        boolean flag=false;
        boolean cnt= false; 
        for (T t1 : t) {
            if (t1 != null) {
                flag=true;
            }
        }
        for (int i=0;i<counter;i++) 
        {
            if(t[i].getId()!=-1 || t[i].getName()!=null)
            {
            System.out.println(" \n ======================================== \n");
            System.out.println("  Id Of Teacher :"+ t[i].getId());

            System.out.println("  Name Of Teacher :"+t[i].getName());
            System.out.println("  Phone Number Of Teacher :"+t[i].getPhno());
            System.out.println(" \n ======================================== \n ");
            cnt=true;
            }
        }
        
        if(cnt==false)
        {
            System.out.println("\n\n\n Teacher  Not Added ....!!!!! \n\n\n\n\n");
        }
    
    }

}
class T{
    private String name;
    private int id;
    private String phno;
    // Constructor to initialize teacher object
    public T(String name, int id,String phno) {
        this.name = name;
        this.id = id;
        this.phno=phno;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getPhno()
    {
        return phno;
    }

}