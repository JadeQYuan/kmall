package plus.knowing.kmall.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 产品属性
 */
@Data
public class MallProductAttr implements Serializable {
    private Long id;

    /**
     * 产品
     */
    private Long productId;

    /**
     * 类目属性
     */
    private Long categoryAttrId;

    /**
     * 属性值
     */
    private String value;

    private static final long serialVersionUID = 1L;
}