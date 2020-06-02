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
import plus.knowing.kmall.service.IBrandService;
import plus.knowing.kmall.vo.mall.BrandVO;
import plus.knowing.kmall.vo.PageQueryVO;
import plus.knowing.kmall.vo.PageVO;
import plus.knowing.kmall.vo.sys.UserVO;

@RestController
@RequestMapping(path = "/brands")
public class BrandController {

    @Autowired
    private IBrandService iBrandService;

    @GetMapping(path = "/paging")
    public PageVO<BrandVO> paging(PageQueryVO queryVO) {
        return iBrandService.paging(queryVO);
    }

    /**
     * 创建
     * @param brandVO
     * @param userVO
     */
    @PostMapping(path = "")
    public void create(@RequestBody BrandVO brandVO, @RequestAttribute UserVO userVO) {
        iBrandService.create(brandVO, userVO);
    }

    /**
     * 获取信息
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public BrandVO get(@PathVariable Long id) {
        return iBrandService.get(id);
    }

    /**
     * 更新
     * @param id
     * @param brandVO
     */
    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestAttribute BrandVO brandVO) {
        iBrandService.update(id, brandVO);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        iBrandService.delete(id);
    }
}
