package documentrepositoryh2security.dto;

import documentrepositoryh2security.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Table(name = "DocumentWithAccessDto")
@Entity
public class DocumentWithAccessDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private int id;

    @Size(min=2, message = "Name - required field")
    @Column(name="name")
    private String name;

    @Column(name="date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Size(min=2, message = "Annotation - required field")
    @Column(name="annotation")
    private String annotation;

    @Column(name="fileName")
    private String fileName;

    //    @Transient
    private boolean viewing;

    //    @Transient
    private boolean reading;

    //    @Transient
    private boolean writing;

    //    @Transient
    private boolean deleting;


    public DocumentWithAccessDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isViewing() {
        return viewing;
    }

    public void setViewing(boolean viewing) {
        this.viewing = viewing;
    }

    public boolean isReading() {
        return reading;
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }

    public boolean isWriting() {
        return writing;
    }

    public void setWriting(boolean writing) {
        this.writing = writing;
    }

    public boolean isDeleting() {
        return deleting;
    }

    public void setDeleting(boolean deleting) {
        this.deleting = deleting;
    }
}
