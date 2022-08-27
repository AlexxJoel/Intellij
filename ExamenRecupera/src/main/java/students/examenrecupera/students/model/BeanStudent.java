package students.examenrecupera.students.model;

public class BeanStudent {
    private int id_students;
    private String name;
    private int qual1;
    private int qual2;
    private int qual3;
    private int qual4;
    private int qual5;
    private int average;
    private int status;


    public BeanStudent() {
    }

    public BeanStudent(int id_students, String name, int qual1, int qual2, int qual3, int qual4, int qual5, int average, int status) {

        this.id_students = id_students;
        this.name = name;
        this.qual1 = qual1;
        this.qual2 = qual2;
        this.qual3 = qual3;
        this.qual4 = qual4;
        this.qual5 = qual5;
        this.average = average;
        this.status = status;
    }


    public BeanStudent(String name, int qual1, int qual2, int qual3, int qual4, int qual5,int average) {
        this.name = name;
        this.qual1 = qual1;
        this.qual2 = qual2;
        this.qual3 = qual3;
        this.qual4 = qual4;
        this.qual5 = qual5;
        this.average = average;

    }

    public BeanStudent(int id_students, String name, int qual1, int qual2, int qual3, int qual4, int qual5, int average) {
        this.id_students = id_students;
        this.name = name;
        this.qual1 = qual1;
        this.qual2 = qual2;
        this.qual3 = qual3;
        this.qual4 = qual4;
        this.qual5 = qual5;
        this.average = average;
    }

    public int getId_students() {
        return id_students;
    }

    public void setId_students(int id_students) {
        this.id_students = id_students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQual1() {
        return qual1;
    }

    public void setQual1(int qual1) {
        this.qual1 = qual1;
    }

    public int getQual2() {
        return qual2;
    }

    public void setQual2(int qual2) {
        this.qual2 = qual2;
    }

    public int getQual3() {
        return qual3;
    }

    public void setQual3(int qual3) {
        this.qual3 = qual3;
    }

    public int getQual4() {
        return qual4;
    }

    public void setQual4(int qual4) {
        this.qual4 = qual4;
    }

    public int getQual5() {
        return qual5;
    }

    public void setQual5(int qual5) {
        this.qual5 = qual5;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BeanStudent{" +
                "id_students=" + id_students +
                ", name='" + name + '\'' +
                ", qual1=" + qual1 +
                ", qual2=" + qual2 +
                ", qual3=" + qual3 +
                ", qual4=" + qual4 +
                ", qual5=" + qual5 +
                ", average=" + average +
                ", status=" + status +
                '}';
    }
}
