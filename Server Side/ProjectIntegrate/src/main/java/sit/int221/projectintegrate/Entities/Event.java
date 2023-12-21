package sit.int221.projectintegrate.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId", nullable = false)
    private Integer id;

    @Column(name = "bookingName", nullable = false, length = 100)
    private String bookingName;

    @Email(message = "Email should be a valid email format.")
    @NotNull(message = "Email should not be null or empty.")
    @Column(name = "bookingEmail", nullable = false, length = 100)
    private String bookingEmail;

    @Column(name = "category", nullable = false, length = 100)
    private String category;

    @Future(message = "Dates must not be present and past.")
    @NotNull(message = "Date time is not null or empty.")
    @Column(name = "startTime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "eventNotes", length = 500)
    private String eventNotes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "eventCategoryId")
    private EventCategory eventCategory;

}