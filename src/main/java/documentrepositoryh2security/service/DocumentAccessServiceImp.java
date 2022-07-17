package documentrepositoryh2security.service;

import documentrepositoryh2security.model.Document;
import documentrepositoryh2security.model.DocumentsAccess;
import documentrepositoryh2security.model.User;
import documentrepositoryh2security.repository.DocumentsAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocumentAccessServiceImp implements DocumentAccessService{

    @Autowired
    private DocumentsAccessRepository documentsAccessRepository;

    @Autowired
    private UserService userService;



    @Transactional
    @Override
    public void createFullAccess(Document document, User user) {
        DocumentsAccess documentsAccess = new DocumentsAccess(document, user, true, true, true, true, true);

        documentsAccessRepository.save(documentsAccess);

    }


    @Transactional
    @Override
    public void deleteAllByDocument(Document document) {
        documentsAccessRepository.deleteAllByDocument(document);
    }

    @Override
    public void save(DocumentsAccess documentAccess) {
        documentsAccessRepository.save(documentAccess);
    }

    @Override
    public DocumentsAccess getDocumentsAccessById(int id) {
        return documentsAccessRepository.getDocumentsAccessById(id);
    }

    @Override
    public List<DocumentsAccess> getAllByDocument(Document document) {
        return documentsAccessRepository.getAllByDocument(document);
    }

    @Override
    public List<DocumentsAccess> getAllUsersAccessByDocument(Document document) {
        List<DocumentsAccess> accessList = getAllByDocument(document);

        List<User> userList = userService.getAllByEnable();
        for (User user: userList) {

            boolean isUse = false;

            for (DocumentsAccess documentAccess: accessList) {
                if(documentAccess.getUser().getId()==user.getId()){
                    isUse = true;
                }
            }

            if (!isUse){
                accessList.add(new DocumentsAccess(document, user,false,false, false, false, false));
            }
        }

        return accessList;
    }
}
