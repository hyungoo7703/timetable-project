package project.timetable.indiv.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project.timetable.indiv.dto.ScheduleFormDto;
import project.timetable.indiv.dto.ScheduleListDto;
import project.timetable.indiv.dto.ScheduleViewDto;
import project.timetable.indiv.model.ScheduleModel;
import project.timetable.indiv.repository.ScheduleRepository;
import project.timetable.indiv.service.ScheduleService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    @GetMapping("/list")
    public String getAllSchedules(Model model) {
        List<ScheduleListDto> scheduleListDtos = scheduleService.getAllSchedules();
        model.addAttribute("schedules", scheduleListDtos);
        return "schedule/list";
    }

    @GetMapping("/view")
    public String getSchedule(@RequestParam("id") Long id, Model model) {
        try {
            ScheduleViewDto scheduleViewDto = scheduleService.getSchedule(id);
            model.addAttribute("schedule", scheduleViewDto);
        }catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "일정을 찾을 수 없습니다.", e);
        }
        return "schedule/view";
    }

    @GetMapping("/form")
    public String hrefScheduleForm(Model model) {
        model.addAttribute("scheduleFormDto", new ScheduleFormDto());
        return "schedule/form";
    }

    @PostMapping("/form")
    public String addSchedule(@ModelAttribute("scheduleFormDto") ScheduleFormDto scheduleFormDto) {
        ScheduleModel scheduleModel = scheduleFormDto.toModel();
        scheduleRepository.save(scheduleModel.toEntity());
        return "redirect:/schedule/list";
    }

}
