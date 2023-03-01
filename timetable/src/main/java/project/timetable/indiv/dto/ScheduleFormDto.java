package project.timetable.indiv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.timetable.indiv.model.ScheduleModel;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleFormDto {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ScheduleModel toModel() {
        return new ScheduleModel(title, description, startTime, endTime);
    }
}
