package plus.knowing.kmall.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 购物车
 */
@Data
public class MallCar implements Serializable {
    private Long id;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 商品
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 商品状态
     */
    private String status;

    private static final long serialVersionUID = 1L;
}