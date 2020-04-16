package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallProductCategorySpec;
import plus.knowing.kmall.entity.MallProductCategorySpecExample;

/**
 * MallProductCategorySpecDAO继承基类
 */
@Mapper
@Repository
public interface MallProductCategorySpecDAO extends MyBatisBaseDao<MallProductCategorySpec, Long, MallProductCategorySpecExample> {
}