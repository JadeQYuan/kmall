package plus.knowing.kmall.vo.mall;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.MallProductCategory;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductCategoryVO {

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父级类目
     */
    private Long parentId;

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

    public ProductCategoryVO(MallProductCategory category) {
        BeanUtils.copyProperties(category, this);
    }

    public MallProductCategory convert2DB() {
        MallProductCategory category = new MallProductCategory();
        BeanUtils.copyProperties(this, category);
        return category;
    }
}
