package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.SysUser;
import plus.knowing.kmall.entity.SysUserExample;

/**
 * SysUserDAO继承基类
 */
@Mapper
@Repository
public interface SysUserDAO extends MyBatisBaseDao<SysUser, Long, SysUserExample> {
}