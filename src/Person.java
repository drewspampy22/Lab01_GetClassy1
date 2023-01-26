import java.time.Year;

public class Person {

    private String FName;
    private String LName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String FName, String LName, String ID, String title, int YOB) {
        this.FName = FName;
        this.LName = LName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FName='" + FName + '\'' +
                ", LName='" + LName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    public String getFullName() {
        return FName + " " + LName;
    }
    public String getFormalName() {
        return title + " " + LName;
    }
    public int getAge(){
      return Integer.parseInt(Year.now().toString()) - YOB;
    }
    public int getAge(int year){
        return year- YOB;
    }
    public String toCSVRecordMethod()
    {
        return getFName() + ", " + getLName() + ", " + getID() + ", " + getTitle() + ", " + getAge();
    }
}


