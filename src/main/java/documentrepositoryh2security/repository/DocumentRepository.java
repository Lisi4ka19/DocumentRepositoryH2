package documentrepositoryh2security.repository;

import documentrepositoryh2security.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {

    Page<Document> findAllByOrderByNameAsc(Pageable pageable);

    Page<Document> findAllByOrderByNameDesc(Pageable pageable);

    Page<Document> findAllByOrderByUserAsc(Pageable pageable);

    Page<Document> findAllByOrderByUserDesc(Pageable pageable);

    Page<Document> findAllByOrderByAnnotationAsc(Pageable pageable);

    Page<Document> findAllByOrderByAnnotationDesc(Pageable pageable);

}
