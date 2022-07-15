package documentrepositoryh2security.service;

import documentrepositoryh2security.dto.DocumentWithAccessDto;
import documentrepositoryh2security.repository.DocumentWithAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentWithAccessServiceImp implements DocumentWithAccessService{

   @Autowired
   private DocumentWithAccessRepository documentWithAccessRepository;


    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByIdAsc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByIdAsc(pageable, UserId);
    }

    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByIdDesc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByIdDesc(pageable, UserId);
    }


    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByDateAsc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByDateAsc(pageable, UserId);
    }

    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByDateDesc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByDateDesc(pageable, UserId);
    }


    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByNameAsc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByNameAsc(pageable, UserId);
    }

    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByNameDesc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByNameDesc(pageable, UserId);
    }

    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByUserAsc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByUserAsc(pageable, UserId);
    }

    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByUserDesc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByUserDesc(pageable, UserId);
    }

    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderAnnotationAsc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByAnnotationAsc(pageable, UserId);
    }

    @Override
    public Page<DocumentWithAccessDto> getAllDocumentByOrderByAnnotationDesc(Pageable pageable, Long UserId) {
        return documentWithAccessRepository.findAllByOrderByAnnotationDesc(pageable, UserId);
    }

}
