package plus.knowing.kmall.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 商品（sku）
 */
@Data
public class MallGoods implements Serializable {
    private Long id;

    /**
     * 产品
     */
    private Long productId;

    /**
     * 价格
     */
    private Float price;

    /**
     * 库存
     */
    private Integer stoke;

    private static final long serialVersionUID = 1L;
}