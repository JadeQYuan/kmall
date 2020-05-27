package plus.knowing.kmall.response;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import plus.knowing.kmall.vo.BasicView;

import java.io.Serializable;

@SuppressWarnings("serial")
@JsonView(value = BasicView.class)
@NoArgsConstructor
@Getter
@ToString
public class CommonResponse<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    /**
     * 构造一个没有数据的消息
     */
    private CommonResponse(ResponseConstEnum respConst) {
        this.code = respConst.getCode();
        this.message = respConst.getMsg();
    }

    /**
     * 构造成功返回数据对象
     */
    private CommonResponse(T data) {
        this.code = ResponseConstEnum.SUCCESS.getCode();
        this.message = ResponseConstEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public CommonResponse(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    /**
     * 返回通用成功对象
     */
    public static <T> CommonResponse<T> newSuccessResponse() {
        return new CommonResponse<>(ResponseConstEnum.SUCCESS);
    }

    /**
     * 成功返回数据对象
     */
    public static <T> CommonResponse<T> newSuccessResponse(T data) {
        return new CommonResponse<>(data);
    }

    /**
     * 返回失败对象
     */
    public static <T> CommonResponse<T> newFailedResponse(String message) {
        return new CommonResponse<>(ResponseConstEnum.FAILED.getCode(), message);
    }

    /**
     * 返回通用异常对象
     */
    public static <T> CommonResponse<T> newErrorResponse() {
        return new CommonResponse<>(ResponseConstEnum.ERROR);
    }

    public static <T> CommonResponse<T> newErrorResponse(int code, String msg) {
        return new CommonResponse<>(code, msg);
    }
}
