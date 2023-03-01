package project.timetable.indiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.timetable.indiv.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {}
