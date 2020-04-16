package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallCar;
import plus.knowing.kmall.entity.MallCarExample;

/**
 * MallCarDAO继承基类
 */
@Mapper
@Repository
public interface MallCarDAO extends MyBatisBaseDao<MallCar, Long, MallCarExample> {
}