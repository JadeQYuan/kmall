package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallBrand;
import plus.knowing.kmall.entity.MallBrandExample;

/**
 * MallBrandDAO继承基类
 */
@Mapper
@Repository
public interface MallBrandDAO extends MyBatisBaseDao<MallBrand, Long, MallBrandExample> {
}