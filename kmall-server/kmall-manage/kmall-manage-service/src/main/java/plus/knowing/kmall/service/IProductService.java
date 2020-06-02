package plus.knowing.kmall.service;

import plus.knowing.kmall.vo.mall.ProductAttrVO;
import plus.knowing.kmall.vo.mall.ProductVO;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.util.List;

public interface IProductService {

    /**
     * 分页
     * @return
     */
    PageVO<ProductVO> paging(PageQueryVO queryVO);

    /**
     * 创建
     * @param productVO
     * @param userVO
     */
    void create(ProductVO productVO, UserVO userVO);

    /**
     * 获取信息
     * @param id
     * @return
     */
    ProductVO get(Long id);

    /**
     * 更新
     * @param id
     * @param productVO
     */
    void update(Long id, ProductVO productVO);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 属性列表
     * @param id
     * @return
     */
    List<ProductAttrVO> listAttr(Long id);

    /**
     * 创建产品属性
     * @param id
     * @param productAttrVO
     */
    void createAttr(Long id, ProductAttrVO productAttrVO, UserVO userVO);

    /**
     * 更新产品属性
     * @param attrId
     * @param productAttrVO
     */
    void updateAttr(Long attrId, ProductAttrVO productAttrVO);

    /**
     * 删除产品属性
     * @param attrId
     */
    void deleteAttr(Long attrId);
}
