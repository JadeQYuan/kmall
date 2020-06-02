package plus.knowing.kmall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.knowing.kmall.dao.MallProductAttrDAO;
import plus.knowing.kmall.dao.MallProductDAO;
import plus.knowing.kmall.entity.MallProduct;
import plus.knowing.kmall.entity.MallProductAttr;
import plus.knowing.kmall.entity.MallProductAttrExample;
import plus.knowing.kmall.service.IProductService;
import plus.knowing.kmall.util.ConvertUtil;
import plus.knowing.kmall.vo.mall.ProductAttrVO;
import plus.knowing.kmall.vo.mall.ProductVO;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.time.LocalDateTime;
import java.util.List;

@Service
class ProductService implements IProductService {

    @Autowired
    private MallProductDAO mallProductDAO;

    @Autowired
    private MallProductAttrDAO mallProductAttrDAO;

    @Override
    public PageVO<ProductVO> paging(PageQueryVO queryVO) {
        PageHelper.startPage(queryVO);
        Page<MallProduct> page = (Page<MallProduct>) mallProductDAO.selectByExample(null);
        return PageVO.convert(page, ProductVO.class);
    }

    @Override
    public void create(ProductVO productVO, UserVO userVO) {
        MallProduct product = productVO.convert2DB();
        product.setCreateUserId(userVO.getId());
        product.setCreateTime(LocalDateTime.now());
        mallProductDAO.insert(product);
    }

    @Override
    public ProductVO get(Long id) {
        return new ProductVO(mallProductDAO.selectByPrimaryKey(id));
    }

    @Override
    public void update(Long id, ProductVO productVO) {

    }

    @Override
    public void delete(Long id) {
        mallProductDAO.deleteByPrimaryKey(id);
    }

    @Override
    public List<ProductAttrVO> listAttr(Long id) {
        MallProductAttrExample productAttrExample = new MallProductAttrExample();
        productAttrExample.createCriteria().andProductIdEqualTo(id);
        List<MallProductAttr> productAttrList = mallProductAttrDAO.selectByExample(productAttrExample);
        return ConvertUtil.convert(productAttrList, ProductAttrVO.class);
    }

    @Override
    public void createAttr(Long id, ProductAttrVO productAttrVO, UserVO userVO) {
        MallProductAttr productAttr = productAttrVO.convert2DB();
        productAttr.setProductId(id);
        mallProductAttrDAO.insert(productAttr);
    }

    @Override
    public void updateAttr(Long attrId, ProductAttrVO productAttrVO) {

    }

    @Override
    public void deleteAttr(Long attrId) {
        mallProductAttrDAO.deleteByPrimaryKey(attrId);
    }
}
