package documentrepositoryh2security.service;

import documentrepositoryh2security.dto.DocumentWithAccessDto;
import documentrepositoryh2security.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DocumentWithAccessService {


    public Page<DocumentWithAccessDto> getAllDocumentByOrderByIdAsc(Pageable pageable, Long UserId);

    public Page<DocumentWithAccessDto> getAllDocumentByOrderByIdDesc(Pageable pageable, Long UserId);


    public Page<DocumentWithAccessDto> getAllDocumentByOrderByDateAsc(Pageable pageable, Long UserId);

    public Page<DocumentWithAccessDto> getAllDocumentByOrderByDateDesc(Pageable pageable, Long UserId);

    public Page<DocumentWithAccessDto> getAllDocumentByOrderByNameAsc(Pageable pageable, Long UserId);

    public Page<DocumentWithAccessDto> getAllDocumentByOrderByNameDesc(Pageable pageable, Long UserId);

    public Page<DocumentWithAccessDto> getAllDocumentByOrderByUserAsc(Pageable pageable, Long UserId);

    public Page<DocumentWithAccessDto> getAllDocumentByOrderByUserDesc(Pageable pageable, Long UserId);

    public Page<DocumentWithAccessDto> getAllDocumentByOrderAnnotationAsc(Pageable pageable, Long UserId);

    public Page<DocumentWithAccessDto> getAllDocumentByOrderByAnnotationDesc(Pageable pageable, Long UserId);

}
