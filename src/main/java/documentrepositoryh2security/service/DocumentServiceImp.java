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
    public Page<Document> getAllDocumentByOrderByDateAsc(Pageable pageable) {
        return documentRepository.findAllByOrderByDateAsc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderByDateDesc(Pageable pageable) {
        return documentRepository.findAllByOrderByDateDesc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderByIdAsc(Pageable pageable) {
        return documentRepository.findAllByOrderByIdAsc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderByIdDesc(Pageable pageable) {
        return documentRepository.findAllByOrderByIdDesc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderByNameAsc(Pageable pageable) {
        return documentRepository.findAllByOrderByNameAsc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderByNameDesc(Pageable pageable) {
        return documentRepository.findAllByOrderByNameDesc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderByUserAsc(Pageable pageable) {
        return documentRepository.findAllByOrderByUserAsc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderByUserDesc(Pageable pageable) {
        return documentRepository.findAllByOrderByUserDesc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderAnnotationAsc(Pageable pageable) {
        return documentRepository.findAllByOrderByAnnotationAsc(pageable);
    }

    @Override
    public Page<Document> getAllDocumentByOrderByAnnotationDesc(Pageable pageable) {
        return documentRepository.findAllByOrderByAnnotationDesc(pageable);
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
