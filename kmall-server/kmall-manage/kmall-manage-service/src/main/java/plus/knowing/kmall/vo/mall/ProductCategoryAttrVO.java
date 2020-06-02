package plus.knowing.kmall.vo.mall;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.MallProductCategoryAttr;

@Getter
@Setter
public class ProductCategoryAttrVO {

    private Long id;

    /**
     * 类目
     */
    private Long categoryId;

    /**
     * 名称
     */
    private String name;

    public ProductCategoryAttrVO(MallProductCategoryAttr categoryAttr) {
        BeanUtils.copyProperties(categoryAttr, this);
    }

    public MallProductCategoryAttr convert2DB() {
        MallProductCategoryAttr productCategoryAttr = new MallProductCategoryAttr();
        BeanUtils.copyProperties(this, productCategoryAttr);
        return productCategoryAttr;
    }
}
