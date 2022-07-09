package documentrepositoryh2security.service;

import documentrepositoryh2security.repository.DocumentRepository;
import documentrepositoryh2security.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentServiceImp implements DocumentService{

   @Autowired
    DocumentRepository documentRepository;

    @Override
    public Page<Document> getAllDocument(Pageable pageable) {
        return documentRepository.findAll(pageable);
    }

    @Override
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    @Override
    public Document getDocument(int id) {

        Document document = null;
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if(optionalDocument.isPresent()) document = optionalDocument.get();

        return document;
    }

    @Override
    public void deleteDocument(int id) {
        documentRepository.deleteById(id);
    }
}
