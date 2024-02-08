package com.archive.log.service;

import com.archive.log.model.LogEntry;
import com.archive.log.util.Enum.LogLevels;
import org.springframework.stereotype.Service;

@Service
public class LogService {


    public LogEntry info(String message, Object context) {

        return LogEntry.builder()
                .timestamp(java.time.LocalDateTime.now())
                .level(LogLevels.INFO)
                .message(message)
                .className(context.getClass().getName())
                .methodName(Thread.currentThread().getStackTrace()[2].getMethodName())
                .threadName(Thread.currentThread().getName())
                .build();
    }


    public static void main(String[] args) {
        LogService logService = new LogService();
        System.out.println(logService.info("Hello ", logService).toString());
    }


    public LogEntry erorr(String directorySelected, LogService logService) {
        return LogEntry.builder()
                .timestamp(java.time.LocalDateTime.now())
                .level(LogLevels.ERROR)
                .message(directorySelected)
                .className(logService.getClass().getName())
                .methodName(Thread.currentThread().getStackTrace()[2].getMethodName())
                .threadName(Thread.currentThread().getName())
                .build();
    }
}
