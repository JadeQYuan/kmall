package plus.knowing.kmall.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 
 * 产品（spu）
 */
@Data
public class MallProduct implements Serializable {
    private Long id;

    /**
     * 品牌
     */
    private Long brandId;

    /**
     * 类目
     */
    private Long categoryId;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 图片
     */
    private String images;

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

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}