package plus.knowing.kmall.vo.mall;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.MallGoodsSpec;

@Getter
@Setter
public class GoodsSpecVO {

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

    public GoodsSpecVO(MallGoodsSpec goodsSpec) {
        BeanUtils.copyProperties(goodsSpec, this);
    }

    public MallGoodsSpec convert2DB() {
        MallGoodsSpec goodsSpec = new MallGoodsSpec();
        BeanUtils.copyProperties(this, goodsSpec);
        return goodsSpec;
    }
}
