package project.timetable.indiv.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.timetable.indiv.dto.ScheduleListDto;
import project.timetable.indiv.dto.ScheduleViewDto;
import project.timetable.indiv.entity.Schedule;
import project.timetable.indiv.model.ScheduleModel;
import project.timetable.indiv.repository.ScheduleRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleListDto> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleModel> scheduleModels = schedules.stream()
                .map(ScheduleModel::fromEntity)
                .collect(Collectors.toList());
        return scheduleModels.stream()
                .map(ScheduleListDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleViewDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        ScheduleModel scheduleModel = ScheduleModel.fromEntity(schedule);
        return ScheduleViewDto.fromModel(scheduleModel);
    }
}
