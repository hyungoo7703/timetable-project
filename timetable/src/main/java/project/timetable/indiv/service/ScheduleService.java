package project.timetable.indiv.service;

import project.timetable.indiv.model.ScheduleModel;

import java.util.List;

public interface ScheduleService {
    
    /* 전체 스케쥴 가져오기 */
    public List<ScheduleModel> getAllSchedules();

    /* 스케쥴 가져오기 */
    public ScheduleModel getSchedule(Long id);
}
