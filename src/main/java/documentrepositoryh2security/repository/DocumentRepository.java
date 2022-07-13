package documentrepositoryh2security.repository;

import documentrepositoryh2security.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {

    Page<Document> findAll(Pageable pageable);

    Page<Document> findAllByOrderByDateAsc(Pageable pageable);

    Page<Document> findAllByOrderByDateDesc(Pageable pageable);

    Page<Document> findAllByOrderByIdAsc(Pageable pageable);

    Page<Document> findAllByOrderByIdDesc(Pageable pageable);

    Page<Document> findAllByOrderByNameAsc(Pageable pageable);

    Page<Document> findAllByOrderByNameDesc(Pageable pageable);

    Page<Document> findAllByOrderByUserAsc(Pageable pageable);

    Page<Document> findAllByOrderByUserDesc(Pageable pageable);

    Page<Document> findAllByOrderByAnnotationAsc(Pageable pageable);

    Page<Document> findAllByOrderByAnnotationDesc(Pageable pageable);

}
