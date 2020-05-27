package plus.knowing.kmall.exception;

import lombok.Getter;

@Getter
public class BizException extends BaseException {

    BizException(IExceptionInstance exceptionInstance) {
        super(exceptionInstance);
    }

    BizException(IExceptionInstance exceptionInstance, String errMessage) {
        super(exceptionInstance, errMessage);
    }

    BizException(IExceptionInstance exceptionInstance, Throwable cause) {
        super(exceptionInstance, cause);
    }
}
