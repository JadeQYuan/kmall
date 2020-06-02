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
import plus.knowing.kmall.service.IProductService;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.mall.ProductAttrVO;
import plus.knowing.kmall.vo.mall.ProductVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    /**
     * 分页
     * @return
     */
    @GetMapping(path = "/paging")
    public PageVO<ProductVO> paging(PageQueryVO queryVO) {
        return iProductService.paging(queryVO);
    }

    /**
     * 创建
     * @param productVO
     * @param userVO
     */
    @PostMapping(path = "")
    public void create(@RequestBody ProductVO productVO, @RequestAttribute UserVO userVO) {
        iProductService.create(productVO, userVO);
    }

    /**
     * 获取信息
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public ProductVO get(@PathVariable Long id) {
        return iProductService.get(id);
    }

    /**
     * 更新
     * @param id
     * @param productVO
     */
    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductVO productVO) {
        iProductService.update(id, productVO);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        iProductService.delete(id);
    }

    /**
     * 属性列表
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}/attrs")
    public List<ProductAttrVO> listAttr(@PathVariable Long id) {
        return iProductService.listAttr(id);
    }

    /**
     * 创建产品属性
     * @param id
     * @param productAttrVO
     */
    @PostMapping(path = "/{id}/attrs")
    public void createAttr(@PathVariable Long id, @RequestBody ProductAttrVO productAttrVO, @RequestAttribute UserVO userVO) {
        iProductService.createAttr(id, productAttrVO, userVO);
    }

    /**
     * 更新产品属性
     * @param attrId
     * @param productAttrVO
     */
    @PutMapping(path = "/attrs/{attrId}")
    public void updateAttr(@PathVariable Long attrId, @RequestBody ProductAttrVO productAttrVO) {
        iProductService.updateAttr(attrId, productAttrVO);
    }

    /**
     * 删除产品属性
     * @param attrId
     */
    @DeleteMapping(path = "/{attrId}")
    public void deleteAttr(@PathVariable Long attrId) {
        iProductService.deleteAttr(attrId);
    }
}
