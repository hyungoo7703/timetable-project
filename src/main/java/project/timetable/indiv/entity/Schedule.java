package project.timetable.indiv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "TIMETABLE_SCHEDULE")
@Getter
@RequiredArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String title;
    @Lob
    private final String description;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    protected Schedule() {
        this.title = null;
        this.description = null;
        this.startTime = null;
        this.endTime = null;
    }

}
