package vn.edu.fpt.deviceserv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import vn.edu.fpt.deviceserv.service.ScheduleTaskService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@Service
@RequiredArgsConstructor
public class ScheduleTaskServiceImpl implements ScheduleTaskService {

    private final TaskScheduler taskScheduler;
    private final Map<String, ScheduledFuture<?>> jobsMap = new HashMap<>();

    @Override
    public void addTask(String id, Runnable task, Trigger trigger) {
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(task, trigger);
        jobsMap.put(id, scheduledTask);
    }

    @Override
    public void removeTask(String id) {
        ScheduledFuture<?> scheduledTask = jobsMap.get(id);
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
            jobsMap.put(id, null);
        }
    }

    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {
        System.out.println("schedule");
        addTask("abc", () -> System.out.println("run" + System.currentTimeMillis()), new CronTrigger("*/1 * * * * *"));
    }
}
