package com.example.task_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.task_app.dto.TaskDto;
import com.example.task_app.form.TaskForm;
import com.example.task_app.service.TaskService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    /**
     * タスク一覧を表示させるメソッド
     * 
     * @return タスク一覧画面
     */
    @GetMapping("/task-list")
    public String showTaskList(@RequestParam(required = false) String keyword,
            @RequestParam(required = false) String status, Model model) {

        List<TaskDto> taskList;

        boolean noKeyword = keyword == null || keyword.isBlank();
        boolean noStatus = status == null || status.isBlank();

        if (noKeyword && noStatus) {
            taskList = taskService.getTaskList();
        } else if (noKeyword) {
            taskList = taskService.searchByStatus(status);

        } else if (noStatus) {
            taskList = taskService.searchByKeyword(keyword);

        } else {
            taskList = taskService.searchTask(keyword, status);
        }

        model.addAttribute("taskList", taskList);

        return "task-list";
    }

    /**
     * 質問登録を表示させるController
     * 
     * @return 登録画面
     */
    @GetMapping("/create-task")
    public String showCreateTask(Model model) {

        model.addAttribute("taskForm", new TaskForm());

        return "create-task";
    }

    /**
     * 登録を行うController
     * 
     * @param taskForm Form
     * @return 質問一覧画面
     */
    @PostMapping("/create-task")
    public String createTask(@Validated TaskForm taskForm, BindingResult result) {

        if (result.hasErrors()) {
            return "create-task";
        }

        TaskDto createTaskDto = new TaskDto();

        createTaskDto.setTitle(taskForm.getTitle());
        createTaskDto.setDescription(taskForm.getDescription());
        createTaskDto.setStatus(taskForm.getStatus());

        taskService.createTaskList(createTaskDto);

        return "redirect:/task-list";
    }

    /**
     * タスク更新画面を表示する
     * 
     * @param taskId タスクID
     * @param model  Model
     * @return タスク更新画面
     */
    @GetMapping("/update-task/{taskId}")
    public String showUpdateTask(@PathVariable Integer taskId, Model model) {

        TaskDto dto = taskService.getTask(taskId);
        TaskForm form = new TaskForm();
        form.setTaskId(dto.getTaskId());
        form.setTitle(dto.getTitle());
        form.setDescription(dto.getDescription());
        form.setStatus(dto.getStatus());
        model.addAttribute("taskForm", form);
        return "update-task";
    }

    /**
     * タスク内容を編集する
     * 
     * @param taskForm
     * @return
     */
    @PostMapping("/update-task/{taskId}")
    public String updateTaskList(TaskForm taskForm) {
        taskService.updateTask(taskForm);

        return "redirect:/task-list";
    }

    @PostMapping("/deleted-task/{taskId}")
    public String deletedTaskList(@PathVariable Integer taskId) {
        taskService.deletedTask(taskId);
        return "redirect:/task-list";
    }

}
