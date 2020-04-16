package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallProduct;
import plus.knowing.kmall.entity.MallProductExample;

/**
 * MallProductDAO继承基类
 */
@Mapper
@Repository
public interface MallProductDAO extends MyBatisBaseDao<MallProduct, Long, MallProductExample> {
}