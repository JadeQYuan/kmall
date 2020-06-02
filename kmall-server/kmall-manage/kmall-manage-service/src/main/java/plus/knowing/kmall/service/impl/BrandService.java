package plus.knowing.kmall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.knowing.kmall.dao.MallBrandDAO;
import plus.knowing.kmall.entity.MallBrand;
import plus.knowing.kmall.service.IBrandService;
import plus.knowing.kmall.vo.mall.BrandVO;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.time.LocalDateTime;

@Service
class BrandService implements IBrandService {

    @Autowired
    private MallBrandDAO mallBrandDAO;

    @Override
    public PageVO<BrandVO> paging(PageQueryVO queryVO) {
        PageHelper.startPage(queryVO);
        Page<MallBrand> page = (Page<MallBrand>) mallBrandDAO.selectByExample(null);
        return PageVO.convert(page, BrandVO.class);
    }

    @Override
    public void create(BrandVO brandVO, UserVO userVO) {
        MallBrand mallBrand = brandVO.convert2DB();
        mallBrand.setCreateUserId(userVO.getId());
        mallBrand.setCreateTime(LocalDateTime.now());
        mallBrandDAO.insert(mallBrand);
    }

    @Override
    public BrandVO get(Long id) {
        MallBrand mallBrand = mallBrandDAO.selectByPrimaryKey(id);
        return new BrandVO(mallBrand);
    }

    @Override
    public void update(Long id, BrandVO brandVO) {

    }

    @Override
    public void delete(Long id) {
        mallBrandDAO.deleteByPrimaryKey(id);
    }
}
