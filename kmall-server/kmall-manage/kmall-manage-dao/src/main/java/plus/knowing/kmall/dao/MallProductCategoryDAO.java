package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallProductCategory;
import plus.knowing.kmall.entity.MallProductCategoryExample;

/**
 * MallProductCategoryDAO继承基类
 */
@Mapper
@Repository
public interface MallProductCategoryDAO extends MyBatisBaseDao<MallProductCategory, Long, MallProductCategoryExample> {
}