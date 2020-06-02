package plus.knowing.kmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.knowing.kmall.dao.MallProductCategoryAttrDAO;
import plus.knowing.kmall.dao.MallProductCategoryDAO;
import plus.knowing.kmall.dao.MallProductCategorySpecDAO;
import plus.knowing.kmall.entity.MallProductCategory;
import plus.knowing.kmall.entity.MallProductCategoryAttr;
import plus.knowing.kmall.entity.MallProductCategoryAttrExample;
import plus.knowing.kmall.entity.MallProductCategorySpec;
import plus.knowing.kmall.entity.MallProductCategorySpecExample;
import plus.knowing.kmall.service.IProductCategoryService;
import plus.knowing.kmall.util.ConvertUtil;
import plus.knowing.kmall.vo.TreeNodeVO;
import plus.knowing.kmall.vo.mall.ProductCategoryAttrVO;
import plus.knowing.kmall.vo.mall.ProductCategorySpecVO;
import plus.knowing.kmall.vo.mall.ProductCategoryVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.time.LocalDateTime;
import java.util.List;

@Service
class ProductCategoryService implements IProductCategoryService {

    @Autowired
    private MallProductCategoryDAO mallProductCategoryDAO;

    @Autowired
    private MallProductCategoryAttrDAO mallProductCategoryAttrDAO;

    @Autowired
    private MallProductCategorySpecDAO mallProductCategorySpecDAO;

    @Override
    public TreeNodeVO<ProductCategoryVO> tree() {
        return null;
    }

    @Override
    public void create(ProductCategoryVO productCategoryVO, UserVO userVO) {
        MallProductCategory productCategory = productCategoryVO.convert2DB();
        productCategory.setCreateUserId(userVO.getId());
        productCategory.setCreateTime(LocalDateTime.now());
        mallProductCategoryDAO.insert(productCategory);
    }

    @Override
    public ProductCategoryVO get(Long id) {
        return new ProductCategoryVO(mallProductCategoryDAO.selectByPrimaryKey(id));
    }

    @Override
    public void update(Long id, ProductCategoryVO productCategoryVO) {

    }

    @Override
    public void delete(Long id) {
        mallProductCategoryDAO.deleteByPrimaryKey(id);
    }

    @Override
    public List<ProductCategoryAttrVO> listAttr(Long id) {
        MallProductCategoryAttrExample productCategoryAttrExample = new MallProductCategoryAttrExample();
        productCategoryAttrExample.createCriteria().andCategoryIdEqualTo(id);
        List<MallProductCategoryAttr> productCategoryAttrList = mallProductCategoryAttrDAO.selectByExample(productCategoryAttrExample);
        return ConvertUtil.convert(productCategoryAttrList, ProductCategoryAttrVO.class);
    }

    @Override
    public void createAttr(Long id, ProductCategoryAttrVO productCategoryAttrVO, UserVO userVO) {
        MallProductCategoryAttr productCategoryAttr = productCategoryAttrVO.convert2DB();
        productCategoryAttr.setCategoryId(id);
        mallProductCategoryAttrDAO.insert(productCategoryAttr);
    }

    @Override
    public void updateAttr(Long attrId, ProductCategoryAttrVO productCategoryAttrVO) {

    }

    @Override
    public void deleteAttr(Long attrId) {
        mallProductCategoryAttrDAO.deleteByPrimaryKey(attrId);
    }

    @Override
    public List<ProductCategorySpecVO> listSpec(Long id) {
        MallProductCategorySpecExample productCategorySpecExample = new MallProductCategorySpecExample();
        productCategorySpecExample.createCriteria().andCategoryIdEqualTo(id);
        List<MallProductCategorySpec> productCategorySpecList = mallProductCategorySpecDAO.selectByExample(productCategorySpecExample);
        return ConvertUtil.convert(productCategorySpecList, ProductCategorySpecVO.class);
    }

    @Override
    public void createSpec(Long id, ProductCategorySpecVO productCategorySpecVO, UserVO userVO) {
        MallProductCategorySpec productCategorySpec = productCategorySpecVO.convert2DB();
        productCategorySpec.setCategoryId(id);
        mallProductCategorySpecDAO.insert(productCategorySpec);
    }

    @Override
    public void updateSpec(Long specId, ProductCategorySpecVO productCategorySpecVO) {

    }

    @Override
    public void deleteSpec(Long specId) {
        mallProductCategorySpecDAO.deleteByPrimaryKey(specId);
    }
}
