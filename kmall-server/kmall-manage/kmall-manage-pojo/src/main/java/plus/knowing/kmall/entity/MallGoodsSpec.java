package plus.knowing.kmall.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 商品规格
 */
@Data
public class MallGoodsSpec implements Serializable {
    private Long id;

    /**
     * 商品
     */
    private Long goodsId;

    /**
     * 类目规格
     */
    private Long categorySpecId;

    /**
     * 规格值
     */
    private String value;

    private static final long serialVersionUID = 1L;
}