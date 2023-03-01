package project.timetable.indiv.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.timetable.indiv.model.ScheduleModel;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleViewDto {

    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static ScheduleViewDto fromModel(ScheduleModel model) {
        ScheduleViewDto viewDto = new ScheduleViewDto();
        viewDto.setTitle(model.getTitle());
        viewDto.setDescription(model.getDescription());
        viewDto.setStartTime(model.getStartTime());
        viewDto.setEndTime(model.getEndTime());
        return viewDto;
    }
}
