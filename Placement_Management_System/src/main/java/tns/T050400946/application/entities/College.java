package tns.T050400946.application.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Colleges")
public class College {

    @Id
    private long college_id;
    
    private String collegeName;
    private String collegeLocation;

    @OneToMany(mappedBy = "college")
    @JsonIgnoreProperties({"college", "certificates"})
    private List<Student> students;

    @OneToMany(mappedBy = "college")
    @JsonIgnoreProperties("college")
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "college")
    @JsonIgnoreProperties("college")
    private List<Placement> placements;

    @OneToOne
    private User collegeAdmin; 


    public College() {
        super();
    }

    public College(long college_id, String collegeName, String collegeLocation) {
        super();
        this.college_id = college_id;
        this.collegeName = collegeName;
        this.collegeLocation = collegeLocation;
    }

    public long getCollege_id() {
        return college_id;
    }

    public void setCollege_id(long college_id) {
        this.college_id = college_id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeLocation() {
        return collegeLocation;
    }

    public void setCollegeLocation(String collegeLocation) {
        this.collegeLocation = collegeLocation;
    }

    public User getCollegeAdmin() {
        return collegeAdmin;
    }

    public void setCollegeAdmin(User collegeAdmin) {
        this.collegeAdmin = collegeAdmin;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    @Override
    public String toString() {
        return "College [college_id=" + college_id + ", collegeName=" + collegeName + ", collegeLocation=" + collegeLocation + "]";
    }
}
