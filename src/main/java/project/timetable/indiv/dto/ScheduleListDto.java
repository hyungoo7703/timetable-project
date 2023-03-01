package project.timetable.indiv.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.timetable.indiv.model.ScheduleModel;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleListDto {

    private Long id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static ScheduleListDto fromModel(ScheduleModel model) {
        ScheduleListDto listDto = new ScheduleListDto();
        listDto.setId(model.getId());
        listDto.setTitle(model.getTitle());
        listDto.setStartTime(model.getStartTime());
        listDto.setEndTime(model.getEndTime());
        return listDto;
    }
}
