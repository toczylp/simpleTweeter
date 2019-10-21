package pl.coderslab.app.message;

import pl.coderslab.app.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 160)
    private String message;

    private boolean readFlag;

    private LocalDateTime created;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User recipient;

    public Message() {
    }

    public Message(@NotBlank @Size(max = 160) String message, boolean readFlag, LocalDateTime created, User sender, User receipient) {
        this.message = message;
        this.readFlag = readFlag;
        this.created = created;
        this.sender = sender;
        this.recipient = receipient;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReadFlag() {
        return readFlag;
    }

    public void setReadFlag(boolean readFlag) {
        this.readFlag = readFlag;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User receipient) {
        this.recipient = receipient;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", readFlag=" + readFlag +
                ", created=" + created +
                ", sender=" + sender +
                ", receipient=" + recipient +
                '}';
    }
}
