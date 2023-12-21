package sit.int221.projectintegrate.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import sit.int221.projectintegrate.Entities.EventCategory;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Getter
@Setter
public class SimpleEventDTO {
    private Integer id;
    private String bookingName;

    @Email(message = "Email should be a valid email format.")
    @NotNull(message = "Email should not be null or empty.")
    private String bookingEmail;
    private String category;

    @Future(message = "Dates must not be present and past.")
    @NotNull(message = "Date time is not null or empty.")
    private LocalDateTime startTime;
    private Integer duration;
    private String eventNotes;
    private EventCategory eventCategory;


}
