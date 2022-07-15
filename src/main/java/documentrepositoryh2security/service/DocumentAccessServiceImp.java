package documentrepositoryh2security.service;

import documentrepositoryh2security.model.Document;
import documentrepositoryh2security.model.DocumentsAccess;
import documentrepositoryh2security.model.User;
import documentrepositoryh2security.repository.DocumentsAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DocumentAccessServiceImp implements DocumentAccessService{

    @Autowired
    private DocumentsAccessRepository documentsAccessRepository;


    @Transactional
    @Override
    public void createFullAccess(Document document, User user) {
        DocumentsAccess documentsAccess = new DocumentsAccess(document, user, true, true, true, true);

        documentsAccessRepository.save(documentsAccess);

    }


    @Transactional
    @Override
    public void deleteAllByDocument(Document document) {
        documentsAccessRepository.deleteAllByDocument(document);
    }
}
