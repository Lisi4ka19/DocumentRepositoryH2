package documentrepositoryh2security.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="documents")
public class Document {

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

    public Document(int id, String name, Date date, User user, String annotation, String fileName) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.user = user;
        this.annotation = annotation;
        this.fileName = fileName;
    }

    public Document() {

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
}
