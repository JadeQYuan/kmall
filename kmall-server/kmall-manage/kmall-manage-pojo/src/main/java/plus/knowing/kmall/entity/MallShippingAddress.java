package plus.knowing.kmall.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 收货地址
 */
@Data
public class MallShippingAddress implements Serializable {
    private Long id;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 收件人姓名
     */
    private String recipientName;

    /**
     * 收件人手机
     */
    private String recipientMobile;

    /**
     * 收件人地址
     */
    private String recipientAddress;

    /**
     * 是否默认
     */
    private Boolean isDefault;

    private static final long serialVersionUID = 1L;
}