package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallProductCategoryAttr;
import plus.knowing.kmall.entity.MallProductCategoryAttrExample;

/**
 * MallProductCategoryAttrDAO继承基类
 */
@Mapper
@Repository
public interface MallProductCategoryAttrDAO extends MyBatisBaseDao<MallProductCategoryAttr, Long, MallProductCategoryAttrExample> {
}