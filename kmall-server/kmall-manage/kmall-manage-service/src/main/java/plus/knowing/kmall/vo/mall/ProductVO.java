package plus.knowing.kmall.vo.mall;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.MallProduct;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductVO {

    private Long id;

    /**
     * 品牌
     */
    private Long brandId;

    /**
     * 类目
     */
    private Long categoryId;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 图片
     */
    private String images;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 描述
     */
    private String description;

    public ProductVO(MallProduct product) {
        BeanUtils.copyProperties(product, this);
    }

    public MallProduct convert2DB() {
        MallProduct product = new MallProduct();
        BeanUtils.copyProperties(this, product);
        return product;
    }
}
