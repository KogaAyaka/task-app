package com.example.task_app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.task_app.dto.TaskDto;
import com.example.task_app.form.TaskForm;

@Mapper
public interface TaskMapper {

    /**
     * 登録一覧を表示する
     * 
     * @return
     */
//     @Select("""
//             SELECT
//             task_id,
//             title,
//             description,
//             status,
//             created_by,
//             created_at,
//             updated_at,
//             deleted
//             FROM task
//             WHERE deleted = false
//             ORDER BY task_id ASC
//             """)
     List<TaskDto> findAll();

    /**
     * タスクを追加する処理
     * @param taskDto
     */
//     @Insert("""
//                 INSERT INTO task (
//                     title,
//                     description,
//                     status,
//                     created_by,
//                     created_at,
//                     updated_at,
//                     deleted
//                 )
//                 VALUES (
//                     #{title},
//                     #{description},
//                     #{status},
//                     #{createdBy},
//                     NOW(),
//                     NOW(),
//                     false
//                 )
//             """)
    void createTask(TaskDto taskDto);

    /**
     * 編集ボタン押した後のリストを表示する
     * @param taskId
     * @return
     */
//     @Select("""
//             SELECT
//             task_id,
//             title,
//             description,
//             status,
//             created_by,
//             created_at,
//             updated_at,
//             deleted
//             FROM task
//             WHERE task_id = #{taskId}
//             """)
    TaskDto findByTaskId(Integer taskId);

    /**
     * 更新処理
     * @param taskForm
     * @return
     */
//     @Update("""
//             UPDATE task
//             SET title = #{title},
//             description=#{description},
//             status=#{status},
//             updated_at=Now()
//             WHERE task_id=#{taskId}
//             """)
    int updateByTaskId(TaskForm taskForm);

    /**
     * 削除処理
     * @param taskId
     * @return
     */
//     @Update("""
//             UPDATE task
//             SET deleted = true          
//             WHERE task_id=#{taskId}
//             """)
    int deletedByTaskId(Integer taskId);

    /**
     * 検索結果を表示する
     * @return 検索結果一覧
     */
//     @Select("""
//             SELECT
//             task_id,
//             title,
//             description,
//             status,
//             created_by,
//             created_at,
//             updated_at,
//             deleted
//             FROM task
//             WHERE deleted = false
//             AND title LIKE '%' || #{keyword} || '%'
//             AND status = #{status}
//             ORDER BY task_id ASC
//             """)
    List<TaskDto> searchList(String keyword,String status);

    /**
     * 検索結果を表示する(状態関連)
     * @return 検索結果一覧
     */
//     @Select("""
//             SELECT
//             task_id,
//             title,
//             description,
//             status,
//             created_by,
//             created_at,
//             updated_at,
//             deleted
//             FROM task
//             WHERE deleted = false
//             AND status = #{status}
//             ORDER BY task_id ASC
//             """)
    List<TaskDto> searchStatusList(String status);


     /**
     * 検索結果を表示する
     * @return 検索結果一覧
     */
//     @Select("""
//             SELECT
//             task_id,
//             title,
//             description,
//             status,
//             created_by,
//             created_at,
//             updated_at,
//             deleted
//             FROM task
//             WHERE deleted = false
//             AND title LIKE '%' || #{keyword} || '%'
//             ORDER BY task_id ASC
//             """)
    List<TaskDto> searchKeywordList(String keyword);

}
