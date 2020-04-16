package plus.knowing.kmall.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 
 * 产品类目
 */
@Data
public class MallProductCategory implements Serializable {
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父级类目
     */
    private Long parentId;

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