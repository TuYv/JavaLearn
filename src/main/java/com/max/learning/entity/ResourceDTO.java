package com.max.learning.entity;

import lombok.Data;

/**
 * @author Rick
 * @date 2021-12-24 17:52
 */
@Data
public class ResourceDTO {
    private String id;
    private String parent_id;
    private String resource_type;
    private String resource_level;
    private String element_code;
    private String menu_name;
    private String url;
    private String system;
    private String description;
    private String create_time;
    private String update_time;
    private String deleted;
}
