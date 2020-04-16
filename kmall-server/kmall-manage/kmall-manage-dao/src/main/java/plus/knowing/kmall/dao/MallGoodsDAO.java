package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallGoods;
import plus.knowing.kmall.entity.MallGoodsExample;

/**
 * MallGoodsDAO继承基类
 */
@Mapper
@Repository
public interface MallGoodsDAO extends MyBatisBaseDao<MallGoods, Long, MallGoodsExample> {
}