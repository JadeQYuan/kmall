package plus.knowing.kmall.exception;

import lombok.Getter;

@Getter
public class SysException extends BaseException {

    SysException(IExceptionInstance exceptionInstance) {
        super(exceptionInstance);
    }

    SysException(IExceptionInstance exceptionInstance, String errMessage) {
        super(exceptionInstance, errMessage);
    }

    SysException(IExceptionInstance exceptionInstance, Throwable cause) {
        super(exceptionInstance, cause);
    }
}
