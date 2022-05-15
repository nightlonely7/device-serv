package vn.edu.fpt.deviceserv.service;

import org.springframework.scheduling.Trigger;

public interface ScheduleTaskService {
    void addTask(String id, Runnable task, Trigger trigger);
    void removeTask(String id);
}
