package pl.coderslab.app.tweet;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;



@Repository
@Transactional
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByUserIdOrderByCreatedDesc(Long id);


    @Query("select t from Tweet t order by t.created desc")
    List<Tweet> findAllOrderDesc();
}
