package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallGoodsSpec;
import plus.knowing.kmall.entity.MallGoodsSpecExample;

/**
 * MallGoodsSpecDAO继承基类
 */
@Mapper
@Repository
public interface MallGoodsSpecDAO extends MyBatisBaseDao<MallGoodsSpec, Long, MallGoodsSpecExample> {
}