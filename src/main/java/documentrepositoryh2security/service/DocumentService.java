package documentrepositoryh2security.service;

import documentrepositoryh2security.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DocumentService {

    public void saveDocument(Document document);

    public Document getDocument(int id);

    public void deleteDocument(int id);

}
