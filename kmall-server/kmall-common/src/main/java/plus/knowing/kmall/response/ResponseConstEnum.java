package plus.knowing.kmall.response;

import lombok.Getter;

@Getter
public enum ResponseConstEnum {

    SUCCESS(1, "成功"),
    FAILED(0, "失败"),
    ERROR(-1, "未知错误"),
    ;

    ResponseConstEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;
}
