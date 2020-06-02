package plus.knowing.kmall.vo.mall;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.MallProductCategorySpec;

@Getter
@Setter
public class ProductCategorySpecVO {

    private Long id;

    /**
     * 类目
     */
    private Long categoryId;

    /**
     * 名称
     */
    private String name;

    public ProductCategorySpecVO(MallProductCategorySpec categorySpec) {
        BeanUtils.copyProperties(categorySpec, this);
    }

    public MallProductCategorySpec convert2DB() {
        MallProductCategorySpec productCategorySpec = new MallProductCategorySpec();
        BeanUtils.copyProperties(this, productCategorySpec);
        return productCategorySpec;
    }
}

