package co.ga.bookstore;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {

    @RestResource(path = "byTitle")
    List<Book> findByTitleIgnoreCaseContaining(@Param("q") String q);

    @RestResource(path = "byId")
    @ApiOperation("find all books that contain id")
    List<Book> findBooksById(@Param("i") Long i);

    @ApiOperation(value = "find book by id", notes = "This method will return a book with the matching id")
    @RestResource(path = "byId")
    @Override
    Optional<Book> findById(Long id);

}

