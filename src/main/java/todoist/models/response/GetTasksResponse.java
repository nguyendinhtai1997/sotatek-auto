package todoist.models.response;

import lombok.Data;

import java.util.List;

@Data
public class GetTasksResponse {
    private Long id;
    private Long assigner;
    private Long project_id;
    private Integer section_id;
    private Integer order;
    private String content;
    private String description;
    private Boolean completed;
    private List<Object> label_ids;
    private Integer priority;
    private Integer comment_count;
    private Long creator;
    private String created;
    private Object due;
    private String url;
}