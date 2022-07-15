package documentrepositoryh2security.model;

import javax.persistence.*;

@Entity
@Table
public class DocumentsAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private Document document;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name="viewing")
    private boolean viewing;

    @Column(name="reading")
    private boolean reading;

    @Column(name="writing")
    private boolean writing;

    @Column(name="deleting")
    private boolean deleting;

    public DocumentsAccess() {
    }

    public DocumentsAccess(Document document, User user, boolean viewing, boolean reading, boolean writing, boolean deleting) {
        this.document = document;
        this.user = user;
        this.viewing = viewing;
        this.reading = reading;
        this.writing = writing;
        this.deleting = deleting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
