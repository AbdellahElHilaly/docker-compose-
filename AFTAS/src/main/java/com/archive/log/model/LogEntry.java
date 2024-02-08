package com.archive.log.model;

import com.archive.log.util.Enum.LogLevels;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LogEntry {

    private LocalDateTime timestamp;
    private LogLevels level ;
    private String message;
    private String threadName;
    private String stackTrace;
    private String exceptionType;
    private String exceptionMessage;
    private String exceptionStackTrace;
    private String className;
    private String methodName;


    public String[] toArrayHeader() {
        return new String[]{"Timestamp", "Level", "Message", "Thread Name", "Stack Trace", "Exception Type", "Exception Message", "Exception Stack Trace", "Class Name", "Method Name"};
    }

    public String[] toArrayValue() {
        return new String[]{timestamp.toString(), level.name(), message, threadName, stackTrace, exceptionType, exceptionMessage, exceptionStackTrace, className, methodName};
    }
}
