package plus.knowing.kmall.vo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonView(value = TreeNodeVO.TreeView.class)
@Getter
@Setter
public class TreeNodeVO<T> {

    private Enum<?> type;

    private T data;

    private Boolean valid;

    private List<TreeNodeVO<?>> children;

    public TreeNodeVO(Enum<?> type, T data) {
        this.type = type;
        this.data = data;
    }

    public void addChild(TreeNodeVO<?> child) {
        if (Objects.isNull(this.children)) {
            this.children = new ArrayList<>();
        }
        this.children.add(child);
    }

    public void addChildren(List<TreeNodeVO<?>> children) {
        if (Objects.isNull(this.children)) {
            this.children = new ArrayList<>();
        }
        this.children.addAll(children);
    }

    public interface TreeView extends BasicView {
    }
}
