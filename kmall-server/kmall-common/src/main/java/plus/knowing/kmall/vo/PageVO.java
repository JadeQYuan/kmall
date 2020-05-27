package plus.knowing.kmall.vo;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import plus.knowing.kmall.util.ConvertUtil;

import java.io.Serializable;
import java.util.List;

@JsonView(value = PageVO.PageView.class)
@Getter
@Setter
@ToString
public class PageVO<T> implements Serializable {

    private int pageNum = 1;

    private int pageSize = 10;

    private long total;

    private List<T> list;

    public PageVO() {}

    public PageVO(int pageNum2, int pageSize2, long total2, List<T> result) {
        this.pageNum = pageNum2;
        this.pageSize = pageSize2;
        this.total = total2;
        this.list = result;
    }

    public static <E> PageVO<E> convert(Page<?> page, List<E> voList) {
        return new PageVO<>(page.getPageNum(), page.getPageSize(), page.getTotal(), voList);
    }

    public static <E> PageVO<E> convert(Page<E> page) {
        return new PageVO<>(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getResult());
    }

    public static <T, D> PageVO<D> convert(Page<T> page, Class<D> toClass) {
        List<D> list = ConvertUtil.convert(page.getResult(), toClass);
        return new PageVO<>(page.getPageNum(), page.getPageSize(), page.getTotal(), list);
    }

    public interface PageView extends BasicView {
    }
}
