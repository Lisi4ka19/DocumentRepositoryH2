package documentrepositoryh2security.repository;

import documentrepositoryh2security.model.Document;
import documentrepositoryh2security.model.DocumentsAccess;
import documentrepositoryh2security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsAccessRepository extends JpaRepository<DocumentsAccess, Long> {
//
//    List<DocumentsAccess> getAll();
//
//    List<DocumentsAccess> getAllByUser(User user);
//
//    List<DocumentsAccess> getAllByDocument(User user);

    void deleteAllByDocument(Document document);
}
