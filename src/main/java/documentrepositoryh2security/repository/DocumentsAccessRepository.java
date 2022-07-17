package documentrepositoryh2security.repository;

import documentrepositoryh2security.model.Document;
import documentrepositoryh2security.model.DocumentsAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsAccessRepository extends JpaRepository<DocumentsAccess, Long> {

    void deleteAllByDocument(Document document);

    DocumentsAccess getDocumentsAccessById(int id);

    List<DocumentsAccess> getAllByDocument(Document document);

}
