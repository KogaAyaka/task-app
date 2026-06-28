package com.example.task_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.task_app.dto.TaskDto;
import com.example.task_app.form.TaskForm;
import com.example.task_app.mapper.TaskMapper;

@Service
public class TaskService {

    @Autowired
    TaskMapper taskMapper;

    /**
     * タスク一覧画面を表示するメソッド
     */
    public List<TaskDto> getTaskList() {

        return taskMapper.findAll();

    }

    /**
     * 新規登録処理するメソッド
     * 
     * @param taskDto
     */
    public void createTaskList(TaskDto taskDto) {

        taskMapper.createTask(taskDto);
    }

    /**
     * 編集画面に表示するタスク内容を表示する
     * 
     * @param taskId タスクID
     * @return タスクIDに対応するタスク情報
     */
    public TaskDto getTask(Integer taskId) {
        return taskMapper.findByTaskId(taskId);
    }

    /**
     * 編集処理をおこなう
     * 
     * @param taskForm
     * @return
     */
    public int updateTask(TaskForm taskForm) {
        return taskMapper.updateByTaskId(taskForm);
    }

    /**
     * 削除処理をおこなう
     * 
     * @param taskId
     * @return
     */
    public int deletedTask(Integer taskId) {
        return taskMapper.deletedByTaskId(taskId);
    }
    
    public List<TaskDto> search(String keyword, String status){
        return taskMapper.search(keyword,status);
    }

}
