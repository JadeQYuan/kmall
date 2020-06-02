package plus.knowing.kmall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.knowing.kmall.dao.MallGoodsDAO;
import plus.knowing.kmall.dao.MallGoodsSpecDAO;
import plus.knowing.kmall.entity.MallGoods;
import plus.knowing.kmall.entity.MallGoodsSpec;
import plus.knowing.kmall.entity.MallGoodsSpecExample;
import plus.knowing.kmall.service.IGoodsService;
import plus.knowing.kmall.util.ConvertUtil;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.mall.GoodsSpecVO;
import plus.knowing.kmall.vo.mall.GoodsVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.util.List;

@Service
class GoodsService implements IGoodsService {

    @Autowired
    private MallGoodsDAO mallGoodsDAO;

    @Autowired
    private MallGoodsSpecDAO mallGoodsSpecDAO;

    @Override
    public PageVO<GoodsVO> paging(PageQueryVO queryVO) {
        PageHelper.startPage(queryVO);
        Page<MallGoods> page = (Page<MallGoods>) mallGoodsDAO.selectByExample(null);
        return PageVO.convert(page, GoodsVO.class);
    }

    @Override
    public void create(GoodsVO goodsVO, UserVO userVO) {
        MallGoods mallGoods = goodsVO.convert2DB();
        mallGoodsDAO.insert(mallGoods);
    }

    @Override
    public GoodsVO get(Long id) {
        MallGoods mallGoods = mallGoodsDAO.selectByPrimaryKey(id);
        return new GoodsVO(mallGoods);
    }

    @Override
    public void update(Long id, GoodsVO goodsVO) {

    }

    @Override
    public void delete(Long id) {
        mallGoodsDAO.deleteByPrimaryKey(id);
    }

    @Override
    public List<GoodsSpecVO> listSpec(Long id) {
        MallGoodsSpecExample goodsSpecExample = new MallGoodsSpecExample();
        goodsSpecExample.createCriteria().andGoodsIdEqualTo(id);
        List<MallGoodsSpec> goodsSpecList = mallGoodsSpecDAO.selectByExample(goodsSpecExample);
        return ConvertUtil.convert(goodsSpecList, GoodsSpecVO.class);
    }

    @Override
    public void createSpec(Long id, GoodsSpecVO goodsSpecVO, UserVO userVO) {
        MallGoodsSpec goodsSpec = goodsSpecVO.convert2DB();
        goodsSpec.setGoodsId(id);
        mallGoodsSpecDAO.insert(goodsSpec);
    }

    @Override
    public void updateSpec(Long specId, GoodsSpecVO goodsSpecVO) {

    }

    @Override
    public void deleteSpec(Long specId) {
        mallGoodsSpecDAO.deleteByPrimaryKey(specId);
    }
}
