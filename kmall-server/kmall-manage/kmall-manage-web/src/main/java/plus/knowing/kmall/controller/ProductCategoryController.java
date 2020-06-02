package plus.knowing.kmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.knowing.kmall.service.IProductCategoryService;
import plus.knowing.kmall.vo.TreeNodeVO;
import plus.knowing.kmall.vo.mall.ProductCategoryAttrVO;
import plus.knowing.kmall.vo.mall.ProductCategorySpecVO;
import plus.knowing.kmall.vo.mall.ProductCategoryVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.util.List;

@RestController
@RequestMapping(path = "/productCategories")
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService iProductCategoryService;

    /**
     * 树
     * @return
     */
    @GetMapping(path = "/tree")
    public TreeNodeVO<ProductCategoryVO> tree() {
        return iProductCategoryService.tree();
    }

    /**
     * 创建
     * @param productCategoryVO
     * @param userVO
     */
    @PostMapping(path = "")
    public void create(@RequestBody ProductCategoryVO productCategoryVO, @RequestAttribute UserVO userVO) {
        iProductCategoryService.create(productCategoryVO, userVO);
    }

    /**
     * 获取信息
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public ProductCategoryVO get(@PathVariable Long id) {
        return iProductCategoryService.get(id);
    }

    /**
     * 更新
     * @param id
     * @param productCategoryVO
     */
    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestAttribute ProductCategoryVO productCategoryVO) {
        iProductCategoryService.update(id, productCategoryVO);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        iProductCategoryService.delete(id);
    }

    /**
     * 属性列表
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}/attrs")
    public List<ProductCategoryAttrVO> listAttr(@PathVariable Long id) {
        return iProductCategoryService.listAttr(id);
    }

    /**
     * 创建产品类目属性
     * @param id
     * @param productCategoryAttrVO
     */
    @PostMapping(path = "/{id}/attrs")
    public void createAttr(@PathVariable Long id, @RequestBody ProductCategoryAttrVO productCategoryAttrVO, @RequestAttribute UserVO userVO) {
        iProductCategoryService.createAttr(id, productCategoryAttrVO, userVO);
    }

    /**
     * 更新产品类目属性
     * @param attrId
     * @param productCategoryAttrVO
     */
    @PutMapping(path = "/attrs/{attrId}")
    public void updateAttr(@PathVariable Long attrId, @RequestBody ProductCategoryAttrVO productCategoryAttrVO) {
        iProductCategoryService.updateAttr(attrId, productCategoryAttrVO);
    }

    /**
     * 删除产品类目属性
     * @param attrId
     */
    @DeleteMapping(path = "/attrs/{attrId}")
    public void deleteAttr(@PathVariable Long attrId) {
        iProductCategoryService.deleteAttr(attrId);
    }

    /**
     * 规格列表
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}/specs")
    public List<ProductCategorySpecVO> listSpec(@PathVariable Long id) {
        return iProductCategoryService.listSpec(id);
    }

    /**
     * 创建产品类目规格
     * @param id
     * @param productCategorySpecVO
     */
    @PostMapping(path = "/{id}/specs")
    public void createSpec(@PathVariable Long id, @RequestBody ProductCategorySpecVO productCategorySpecVO, @RequestAttribute UserVO userVO) {
        iProductCategoryService.createSpec(id, productCategorySpecVO, userVO);
    }

    /**
     * 更新产品类目规格
     * @param specId
     * @param productCategorySpecVO
     */
    @PutMapping(path = "/specs/{specId}")
    public void updateSpec(@PathVariable Long specId, @RequestBody ProductCategorySpecVO productCategorySpecVO) {
        iProductCategoryService.updateSpec(specId, productCategorySpecVO);
    }

    /**
     * 删除产品类目规格
     * @param specId
     */
    @GetMapping(path = "/spec/{specId}")
    public void deleteSpec(@PathVariable Long specId) {
        iProductCategoryService.deleteSpec(specId);
    }

}
