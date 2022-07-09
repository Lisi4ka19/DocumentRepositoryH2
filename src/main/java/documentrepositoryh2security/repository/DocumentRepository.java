package documentrepositoryh2security.repository;

import documentrepositoryh2security.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {
    Page<Document> findAll(Pageable pageable);
}
