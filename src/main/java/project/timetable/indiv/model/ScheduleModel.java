package project.timetable.indiv.model;

import lombok.*;
import project.timetable.indiv.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ScheduleModel {
    private Long id;
    private final String title;
    private final String description;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Schedule toEntity() {
        Schedule entity = new Schedule(title, description, startTime, endTime);
        return entity;
    }

    public static ScheduleModel fromEntity(Schedule entity) {
        return new ScheduleModel(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getStartTime(), entity.getEndTime());
    }
}
