package com.example.task_app.entity;
import java.time.LocalDateTime;

import lombok.Data;

//アノテーション後でつける
@Data
public class TaskEntity {
    
    private String taskId;

    private String title;

    private String description;

    private String status;

    private String createdBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean deleted;
}
