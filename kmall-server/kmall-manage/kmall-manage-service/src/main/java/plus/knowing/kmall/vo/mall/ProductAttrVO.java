package plus.knowing.kmall.vo.mall;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.MallProductAttr;

@Getter
@Setter
public class ProductAttrVO {

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

    public ProductAttrVO(MallProductAttr productAttr) {
        BeanUtils.copyProperties(productAttr, this);
    }

    public MallProductAttr convert2DB() {
        MallProductAttr productAttr = new MallProductAttr();
        BeanUtils.copyProperties(this, productAttr);
        return productAttr;
    }
}
