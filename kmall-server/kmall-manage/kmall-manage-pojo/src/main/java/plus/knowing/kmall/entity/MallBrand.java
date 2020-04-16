package plus.knowing.kmall.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 
 * 品牌
 */
@Data
public class MallBrand implements Serializable {
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * logo url
     */
    private String logo;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 状态
     */
    private String status;

    private static final long serialVersionUID = 1L;
}