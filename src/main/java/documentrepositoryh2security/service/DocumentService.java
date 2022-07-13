package documentrepositoryh2security.service;

import documentrepositoryh2security.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DocumentService {


    public Page<Document> getAllDocument(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByDateAsc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByDateDesc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByIdAsc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByIdDesc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByNameAsc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByNameDesc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByUserAsc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByUserDesc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderAnnotationAsc(Pageable pageable);

    public Page<Document> getAllDocumentByOrderByAnnotationDesc(Pageable pageable);

    public void saveDocument(Document document);

    public Document getDocument(int id);

    public void deleteDocument(int id);

}
