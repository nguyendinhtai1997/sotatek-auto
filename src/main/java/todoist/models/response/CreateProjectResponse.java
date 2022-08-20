package todoist.models.response;

import lombok.Data;

@Data
public class CreateProjectResponse {
    private Long id;
    private Integer order;
    private Integer color;
    private String name;
    private Integer comment_count;
    private Boolean shared;
    private Boolean favorite;
    private Integer sync_id;
    private String url;
}