package documentrepositoryh2security.repository;

import documentrepositoryh2security.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {

//    Page<Document> findAll(Pageable pageable);

//    Page<Document> findAllByOrderByDateAsc(Pageable pageable);
//
//    Page<Document> findAllByOrderByDateDesc(Pageable pageable);

//    @Query(value = "SELECT \n" +
//            "DOCUMENTS.id,\n" +
//            "DOCUMENTS. ANNOTATION, \n" +
//            "DOCUMENTS.DATE,\n" +
//            "DOCUMENTS.FILE_NAME ,\n" +
//            "DOCUMENTS.NAME,\n" +
//            "DOCUMENTS.USER_ID,\n" +
//            "DOCUMENTS_ACCESS.READING,   \n" +
//            "DOCUMENTS_ACCESS.VIEWING ,\n" +
//            "DOCUMENTS_ACCESS.WRITING ,\n" +
//            "DOCUMENTS_ACCESS.DELETING \n" +
//            "\n" +
//            "\n" +
//            "FROM DOCUMENTS \n" +
//            "INNER Join DOCUMENTS_ACCESS \n" +
//            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
//            "\n" +
//            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId " +
//            "and DOCUMENTS_ACCESS.READING " +
//            "\n" +
//            "Order by DOCUMENTS.id"
//            , nativeQuery = true)
//    Page<Document> findAllByOrderByIdAsc(Pageable pageable, @Param("paramUserId") Long userId);
//
//    @Query(value = "SELECT \n" +
//            "DOCUMENTS.id,\n" +
//            "DOCUMENTS. ANNOTATION, \n" +
//            "DOCUMENTS.DATE,\n" +
//            "DOCUMENTS.FILE_NAME ,\n" +
//            "DOCUMENTS.NAME,\n" +
//            "DOCUMENTS.USER_ID,\n" +
//            "DOCUMENTS_ACCESS.READING,   \n" +
//            "DOCUMENTS_ACCESS.VIEWING ,\n" +
//            "DOCUMENTS_ACCESS.WRITING ,\n" +
//            "DOCUMENTS_ACCESS.DELETING \n" +
//            "\n" +
//            "\n" +
//            "FROM DOCUMENTS \n" +
//            "INNER Join DOCUMENTS_ACCESS \n" +
//            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
//            "\n" +
//            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
//            "and DOCUMENTS_ACCESS.READING " +
//            "\n" +
//            "Order by DOCUMENTS.id Desc"
//            , nativeQuery = true)
//    Page<Document> findAllByOrderByIdDesc(Pageable pageable, @Param("paramUserId") Long userId);

    Page<Document> findAllByOrderByNameAsc(Pageable pageable);

    Page<Document> findAllByOrderByNameDesc(Pageable pageable);

    Page<Document> findAllByOrderByUserAsc(Pageable pageable);

    Page<Document> findAllByOrderByUserDesc(Pageable pageable);

    Page<Document> findAllByOrderByAnnotationAsc(Pageable pageable);

    Page<Document> findAllByOrderByAnnotationDesc(Pageable pageable);

}
