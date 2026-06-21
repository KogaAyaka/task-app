package com.example.task_app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskDto {

    private Integer taskId;

    private String title;

    private String description;

    private String status;

    private String createdBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean deleted;

}
