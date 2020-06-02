package plus.knowing.kmall.vo.sys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import plus.knowing.kmall.entity.SysUser;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserVO {

    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private String role;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public UserVO fromDB(SysUser user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    public SysUser convert2DB() {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
