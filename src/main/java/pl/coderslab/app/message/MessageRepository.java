package pl.coderslab.app.message;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByRecipientIdOrderByCreatedDesc(Long Id);
    List<Message> findAllBySenderIdOrderByCreatedDesc(Long Id);
}
