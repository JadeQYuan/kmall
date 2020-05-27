package plus.knowing.kmall.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQueryVO {

    private int pageNum = 1;

    private int pageSize = 10;

    private String orderBy = " ID DESC ";

    // 排序
    // ...

    public int getOffset() {
        return (pageNum - 1) * pageSize;
    }

}
