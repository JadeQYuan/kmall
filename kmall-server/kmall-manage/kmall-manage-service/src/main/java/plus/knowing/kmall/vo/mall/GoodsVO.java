package plus.knowing.kmall.vo.mall;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.MallGoods;

@Getter
@Setter
public class GoodsVO {

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

    public GoodsVO(MallGoods goods) {
        BeanUtils.copyProperties(goods, this);
    }

    public MallGoods convert2DB() {
        MallGoods goods = new MallGoods();
        BeanUtils.copyProperties(this, goods);
        return goods;
    }
}
