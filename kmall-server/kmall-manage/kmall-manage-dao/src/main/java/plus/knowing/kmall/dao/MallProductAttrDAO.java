package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallProductAttr;
import plus.knowing.kmall.entity.MallProductAttrExample;

/**
 * MallProductAttrDAO继承基类
 */
@Mapper
@Repository
public interface MallProductAttrDAO extends MyBatisBaseDao<MallProductAttr, Long, MallProductAttrExample> {
}