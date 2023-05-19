package Models;
import java.lang.String;
public class Student {
    private String email;
    private String name;
    private boolean Gender;
    private String SchoolName;
    private boolean in;
    public Student() {
    }

    public Student(String email, String name, boolean gender, String schoolName, boolean in) {
        this.email = email;
        this.name = name;
        Gender = gender;
        SchoolName = schoolName;
        this.in = in;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public boolean isIn() {
        return in;
    }

    public void setIn(boolean in) {
        this.in = in;
    }

}
