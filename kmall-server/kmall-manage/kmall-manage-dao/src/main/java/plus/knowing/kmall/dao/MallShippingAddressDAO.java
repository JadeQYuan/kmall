package plus.knowing.kmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plus.knowing.kmall.entity.MallShippingAddress;
import plus.knowing.kmall.entity.MallShippingAddressExample;

/**
 * MallShippingAddressDAO继承基类
 */
@Mapper
@Repository
public interface MallShippingAddressDAO extends MyBatisBaseDao<MallShippingAddress, Long, MallShippingAddressExample> {
}