package plus.knowing.kmall.vo.mall;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.MallBrand;

import java.time.LocalDateTime;

@Getter
@Setter
public class BrandVO {

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * logo url
     */
    private String logo;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

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

    public BrandVO(MallBrand brand) {
        BeanUtils.copyProperties(brand, this);
    }

    public MallBrand convert2DB() {
        MallBrand mallBrand = new MallBrand();
        BeanUtils.copyProperties(this, mallBrand);
        return mallBrand;
    }
}
