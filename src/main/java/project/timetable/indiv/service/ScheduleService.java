package project.timetable.indiv.service;

import project.timetable.indiv.dto.ScheduleListDto;
import project.timetable.indiv.dto.ScheduleViewDto;

import java.util.List;

public interface ScheduleService {
    
    /* 전체 스케쥴 가져오기 */
    public List<ScheduleListDto> getAllSchedules();

    /* 스케쥴 가져오기 */
    public ScheduleViewDto getSchedule(Long id);
}
