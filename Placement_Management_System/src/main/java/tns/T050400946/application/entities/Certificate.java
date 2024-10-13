package tns.T050400946.application.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Certificates")
public class Certificate {

    @Id
    private long certificate_id;

    private int year;
    
    @ManyToOne
    @JsonIgnoreProperties({"certificates", "students", "placements", "collegeAdmin"})
    private College college;

    @ManyToOne
    @JsonIgnoreProperties({"certificates", "college"})
    private Student student;


    public Certificate() {
        super();
    }

    public Certificate(long certificate_id, int year, College college, Student student) {
        super();
        this.certificate_id = certificate_id;
        this.year = year;
        this.college = college;
        this.student = student;
    }

    public long getCertificate_id() {
        return certificate_id;
    }

    public void setCertificate_id(long certificate_id) {
        this.certificate_id = certificate_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Certificate [certificate_id=" + certificate_id + ", year=" + year + "]";
    }
}
