package com.example.task_app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.example.task_app.dto.TaskDto;
import com.example.task_app.form.TaskForm;

@Mapper
public interface TaskMapper {

    /**
     * 登録一覧を表示する
     * 
     * @return
     */
     List<TaskDto> findAll();

    /**
     * タスクを追加する処理
     * @param taskDto
     */
    void createTask(TaskDto taskDto);

    /**
     * 編集ボタン押した後のリストを表示する
     * @param taskId
     * @return
     */
    TaskDto findByTaskId(Integer taskId);

    /**
     * 更新処理
     * @param taskForm
     * @return
     */
    int updateByTaskId(TaskForm taskForm);

    /**
     * 削除処理
     * @param taskId
     * @return
     */
    int deletedByTaskId(Integer taskId);

    List<TaskDto> search(
        @Param("keyword") String keyword,
        @Param("status") String status
    );

}
