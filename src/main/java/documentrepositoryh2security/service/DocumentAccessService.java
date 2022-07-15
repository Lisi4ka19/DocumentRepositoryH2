package documentrepositoryh2security.service;

import documentrepositoryh2security.model.Document;
import documentrepositoryh2security.model.User;

public interface DocumentAccessService {

    void createFullAccess(Document document, User user);

    void deleteAllByDocument(Document document);
}
