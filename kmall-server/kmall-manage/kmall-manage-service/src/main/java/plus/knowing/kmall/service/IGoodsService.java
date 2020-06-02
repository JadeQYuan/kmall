package plus.knowing.kmall.service;

import plus.knowing.kmall.vo.mall.GoodsSpecVO;
import plus.knowing.kmall.vo.mall.GoodsVO;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.util.List;

public interface IGoodsService {

    /**
     * 分页
     * @return
     */
    PageVO<GoodsVO> paging(PageQueryVO queryVO);

    /**
     * 创建
     * @param goodsVO
     * @param userVO
     */
    void create(GoodsVO goodsVO, UserVO userVO);

    /**
     * 获取信息
     * @param id
     * @return
     */
    GoodsVO get(Long id);

    /**
     * 更新
     * @param id
     * @param goodsVO
     */
    void update(Long id, GoodsVO goodsVO);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 规格列表
     * @param id
     * @return
     */
    List<GoodsSpecVO> listSpec(Long id);

    /**
     * 创建商品规格
     * @param id
     * @param goodsSpecVO
     */
    void createSpec(Long id, GoodsSpecVO goodsSpecVO, UserVO userVO);

    /**
     * 更新商品规格
     * @param specId
     * @param goodsSpecVO
     */
    void updateSpec(Long specId, GoodsSpecVO goodsSpecVO);

    /**
     * 删除商品规格
     * @param specId
     */
    void deleteSpec(Long specId);
}
