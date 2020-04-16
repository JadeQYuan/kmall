package plus.knowing.kmall.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 产品类目规格
 */
@Data
public class MallProductCategorySpec implements Serializable {
    private Long id;

    /**
     * 类目
     */
    private Long categoryId;

    /**
     * 名称
     */
    private String name;

    private static final long serialVersionUID = 1L;
}