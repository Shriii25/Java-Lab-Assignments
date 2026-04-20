import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class Student {
    int studentId;
    String name, branch;
    int marks1, marks2, marks3, marks4, marks5;
    double percentage;

    public Student(int studentId, String name, String branch,
                   int m1, int m2, int m3, int m4, int m5) {
        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        this.marks4 = m4;
        this.marks5 = m5;
        this.percentage = 0.0;
    }

    public void calculatePercentage() {
        this.percentage = (marks1 + marks2 + marks3 + marks4 + marks5) / 5.0;
    }

    public String toCSV() {
        return studentId + "," + name + "," + branch + "," +
               marks1 + "," + marks2 + "," + marks3 + "," +
               marks4 + "," + marks5 + "," + percentage;
    }
}

public class StudentCSVCRUD {

    static String fileName = "Students.csv";

    public static void addStudents() {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write("\n");
            Student s1 = new Student(104, "Amit", "AI-ML", 70, 75, 80, 0, 0);
            Student s2 = new Student(105, "Neha", "CSE", 65, 68, 72, 0, 0);
            Student s3 = new Student(106, "Riya", "IT", 88, 85, 90, 0, 0);

            fw.write(s1.toCSV() + "\n");
            fw.write(s2.toCSV() + "\n");
            fw.write(s3.toCSV() + "\n");

            System.out.println("\n--- Adding New Students ---");
        } catch (IOException e) {
            System.out.println("IOException while adding students: " + e.getMessage());
        }
    }

    public static void displayFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\n--- Displaying File ---");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException while reading file: " + e.getMessage());
        }
    }

    public static void updateStudents() {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Student s = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]),
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]),
                        Integer.parseInt(data[7])
                );

                if (s.marks4 == 0) s.marks4 = 80;
                if (s.marks5 == 0) s.marks5 = 85;

                s.calculatePercentage();
                list.add(s);
            }
        } catch (IOException e) {
            System.out.println("IOException during update read: " + e.getMessage());
        }

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");
            for (Student s : list) {
                fw.write(s.toCSV() + "\n");
            }
            System.out.println("\n--- Records Updated Successfully ---");
        } catch (IOException e) {
            System.out.println("IOException during update write: " + e.getMessage());
        }
    }

    public static void deleteStudent(int idToDelete) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(idToDelete + ",")) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("IOException during delete read: " + e.getMessage());
        }

        try (FileWriter fw = new FileWriter(fileName)) {
            for (String l : lines) {
                fw.write(l + "\n");
            }
            System.out.println("\n--- Student with ID " + idToDelete + " deleted ---");
        } catch (IOException e) {
            System.out.println("IOException during delete write: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (FileReader fr = new FileReader("WrongFile.csv")) {
        } catch (IOException e) {
            System.out.println("\n[Exception Demo] File not found: " + e.getMessage());
        }

        addStudents();
        displayFile();

        updateStudents();
        displayFile();

        deleteStudent(105);
        displayFile();
    }
}