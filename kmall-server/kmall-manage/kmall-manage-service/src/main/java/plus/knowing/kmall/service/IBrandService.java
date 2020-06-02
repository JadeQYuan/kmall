package plus.knowing.kmall.service;

import plus.knowing.kmall.vo.mall.BrandVO;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.sys.UserVO;

public interface IBrandService {

    /**
     * 分页
     * @param queryVO
     * @return
     */
    PageVO<BrandVO> paging(PageQueryVO queryVO);

    /**
     * 创建
     * @param brandVO
     * @param userVO
     */
    void create(BrandVO brandVO, UserVO userVO);

    /**
     * 获取信息
     * @param id
     * @return
     */
    BrandVO get(Long id);

    /**
     * 更新
     * @param id
     * @param brandVO
     */
    void update(Long id, BrandVO brandVO);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);
}
