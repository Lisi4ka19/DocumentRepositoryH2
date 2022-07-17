package documentrepositoryh2security.repository;

import documentrepositoryh2security.dto.DocumentWithAccessDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentWithAccessRepository extends PagingAndSortingRepository<DocumentWithAccessDto, Long> {

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING,\n" +
            "DOCUMENTS_ACCESS.WRITING,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId " +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.id",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByIdAsc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.id Desc",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByIdDesc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.DATE",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByDateAsc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.DATE Desc",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByDateDesc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.NAME",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByNameAsc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.NAME Desc",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByNameDesc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.USER_ID",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByUserAsc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.USER_ID Desc",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByUserDesc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS.ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.ANNOTATION",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByAnnotationAsc(Pageable pageable, @Param("paramUserId") Long userId);

    @Query(value = "SELECT \n" +
            "DOCUMENTS.id,\n" +
            "DOCUMENTS. ANNOTATION, \n" +
            "DOCUMENTS.DATE,\n" +
            "DOCUMENTS.FILE_NAME ,\n" +
            "DOCUMENTS.NAME,\n" +
            "DOCUMENTS.USER_ID,\n" +
            "DOCUMENTS_ACCESS.READING,   \n" +
            "DOCUMENTS_ACCESS.VIEWING ,\n" +
            "DOCUMENTS_ACCESS.WRITING ,\n" +
            "DOCUMENTS_ACCESS.DELETING, \n" +
            "DOCUMENTS_ACCESS.SETTING \n" +
            "\n" +
            "FROM DOCUMENTS \n" +
            "INNER Join DOCUMENTS_ACCESS \n" +
            "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
            "\n" +
            "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
            "and DOCUMENTS_ACCESS.READING " +
            "\n" +
            "Order by DOCUMENTS.ANNOTATION Desc",
            countQuery ="select count(*) FROM DOCUMENTS \n" +
                    "INNER Join DOCUMENTS_ACCESS \n" +
                    "on DOCUMENTS.id = DOCUMENTS_ACCESS.DOCUMENT_ID \n" +
                    "\n" +
                    "where DOCUMENTS_ACCESS.USER_ID =:paramUserId \n" +
                    "and DOCUMENTS_ACCESS.READING"
            , nativeQuery = true)
    Page<DocumentWithAccessDto> findAllByOrderByAnnotationDesc(Pageable pageable, @Param("paramUserId") Long userId);

}
