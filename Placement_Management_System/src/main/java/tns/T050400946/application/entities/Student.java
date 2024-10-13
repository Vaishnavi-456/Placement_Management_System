package tns.T050400946.application.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    private long id;

    private String name;
    
    @ManyToOne
    @JsonIgnoreProperties({"students", "certificates", "placements", "collegeAdmin"})
    private College college;
    
    private long rollNo;
    private String qualification;
    private String course;
    private int year;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Certificate> certificates;
    
    private long hallTicketNo;

    public Student() {
        super();
    }

    public Student(long id, String name, College college, long rollNo, String qualification, String course, int year, long hallTicketNo) {
        super();
        this.id = id;
        this.name = name;
        this.college = college;
        this.rollNo = rollNo;
        this.qualification = qualification;
        this.course = course;
        this.year = year;
        this.hallTicketNo = hallTicketNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public long getRollNo() {
        return rollNo;
    }

    public void setRollNo(long rollNo) {
        this.rollNo = rollNo;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public long getHallTicketNo() {
        return hallTicketNo;
    }

    public void setHallTicketNo(long hallTicketNo) {
        this.hallTicketNo = hallTicketNo;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", college=" + college + ", rollNo=" + rollNo + "]";
    }
}
