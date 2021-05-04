package fi.haagahelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WordRepository  extends CrudRepository<Word, Long> {

    Word findByOriginal(String original);

}
