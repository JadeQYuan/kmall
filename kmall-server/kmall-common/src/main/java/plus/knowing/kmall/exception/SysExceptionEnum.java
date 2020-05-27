package plus.knowing.kmall.exception;

import lombok.Getter;

@Getter
public enum SysExceptionEnum implements SysAssert {

    SYS_EXCEPTION(500, "系统异常"),
    ;

    SysExceptionEnum(Integer errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    private final Integer errCode;

    private final String errMessage;
}
