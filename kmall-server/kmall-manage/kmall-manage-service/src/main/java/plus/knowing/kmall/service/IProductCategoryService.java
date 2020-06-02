package plus.knowing.kmall.service;

import plus.knowing.kmall.vo.mall.ProductCategoryAttrVO;
import plus.knowing.kmall.vo.mall.ProductCategorySpecVO;
import plus.knowing.kmall.vo.mall.ProductCategoryVO;
import plus.knowing.kmall.vo.TreeNodeVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.util.List;

public interface IProductCategoryService {

    /**
     * 树
     * @return
     */
    TreeNodeVO<ProductCategoryVO> tree();

    /**
     * 创建
     * @param productCategoryVO
     * @param userVO
     */
    void create(ProductCategoryVO productCategoryVO, UserVO userVO);

    /**
     * 获取信息
     * @param id
     * @return
     */
    ProductCategoryVO get(Long id);

    /**
     * 更新
     * @param id
     * @param productCategoryVO
     */
    void update(Long id, ProductCategoryVO productCategoryVO);

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
    List<ProductCategoryAttrVO> listAttr(Long id);

    /**
     * 创建产品类目属性
     * @param id
     * @param productCategoryAttrVO
     */
    void createAttr(Long id, ProductCategoryAttrVO productCategoryAttrVO, UserVO userVO);

    /**
     * 更新产品类目属性
     * @param attrId
     * @param productCategoryAttrVO
     */
    void updateAttr(Long attrId, ProductCategoryAttrVO productCategoryAttrVO);

    /**
     * 删除产品类目属性
     * @param attrId
     */
    void deleteAttr(Long attrId);

    /**
     * 规格列表
     * @param id
     * @return
     */
    List<ProductCategorySpecVO> listSpec(Long id);

    /**
     * 创建产品类目规格
     * @param id
     * @param productCategorySpecVO
     */
    void createSpec(Long id, ProductCategorySpecVO productCategorySpecVO, UserVO userVO);

    /**
     * 更新产品类目规格
     * @param specId
     * @param productCategorySpecVO
     */
    void updateSpec(Long specId, ProductCategorySpecVO productCategorySpecVO);

    /**
     * 删除产品类目规格
     * @param specId
     */
    void deleteSpec(Long specId);
}
