package documentrepositoryh2security.service;

import documentrepositoryh2security.model.Document;
import documentrepositoryh2security.model.DocumentsAccess;
import documentrepositoryh2security.model.User;

import java.util.List;

public interface DocumentAccessService {

    void createFullAccess(Document document, User user);

    void deleteAllByDocument(Document document);

    void save(DocumentsAccess documentAccess);

    DocumentsAccess getDocumentsAccessById(int id);

    List<DocumentsAccess> getAllByDocument(Document document);

    List<DocumentsAccess> getAllUsersAccessByDocument(Document document);
}
