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
import plus.knowing.kmall.service.IGoodsService;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.mall.GoodsSpecVO;
import plus.knowing.kmall.vo.mall.GoodsVO;
import plus.knowing.kmall.vo.sys.UserVO;

import java.util.List;

@RestController
@RequestMapping(path = "/goodses")
public class GoodsController {

    @Autowired
    private IGoodsService iGoodsService;

    /**
     * 分页
     * @return
     */
    @GetMapping(path = "/paging")
    public PageVO<GoodsVO> paging(PageQueryVO queryVO) {
        return iGoodsService.paging(queryVO);
    }

    /**
     * 创建
     * @param goodsVO
     * @param userVO
     */
    @PostMapping(path = "")
    public void create(@RequestBody GoodsVO goodsVO, @RequestAttribute UserVO userVO) {
        iGoodsService.create(goodsVO, userVO);
    }

    /**
     * 获取信息
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public GoodsVO get(@PathVariable Long id) {
        return iGoodsService.get(id);
    }

    /**
     * 更新
     * @param id
     * @param goodsVO
     */
    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestBody GoodsVO goodsVO) {
        iGoodsService.update(id, goodsVO);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        iGoodsService.delete(id);
    }

    /**
     * 规格列表
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}/specs")
    public List<GoodsSpecVO> listSpec(@PathVariable Long id) {
        return iGoodsService.listSpec(id);
    }

    /**
     * 创建商品规格
     * @param id
     * @param goodsSpecVO
     */
    @PostMapping(path = "/{id}/specs")
    public void createSpec(Long id, @RequestBody GoodsSpecVO goodsSpecVO, UserVO userVO) {
        iGoodsService.createSpec(id, goodsSpecVO, userVO);
    }

    /**
     * 更新商品规格
     * @param specId
     * @param goodsSpecVO
     */
    @PostMapping(path = "/specs/{specId}")
    public void updateSpec(@PathVariable Long specId, @RequestBody GoodsSpecVO goodsSpecVO) {
        iGoodsService.updateSpec(specId, goodsSpecVO);
    }

    /**
     * 删除商品规格
     * @param specId
     */
    @DeleteMapping(path = "/{specId}")
    public void deleteSpec(@PathVariable Long specId) {
        iGoodsService.deleteSpec(specId);
    }

}
