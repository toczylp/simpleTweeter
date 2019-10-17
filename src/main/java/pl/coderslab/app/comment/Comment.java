package pl.coderslab.app.comment;

import pl.coderslab.app.tweet.Tweet;
import pl.coderslab.app.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Tweet tweet;
    private LocalDateTime created;
    @NotBlank
    private String text;

    public Comment() {
    }

    public Comment(User user, Tweet tweet, LocalDateTime created, String text) {
        this.user = user;
        this.tweet = tweet;
        this.created = created;
        this.text = text;
    }

    @PrePersist
    public void prePresist() {
        created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", tweet=" + tweet +
                ", created=" + created +
                ", text='" + text + '\'' +
                '}';
    }
}
