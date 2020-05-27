package plus.knowing.kmall.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final Integer errCode;

    private final String errMessage;

    BaseException(IExceptionInstance exceptionInstance) {
        super(exceptionInstance.getErrMessage());
        this.errCode = exceptionInstance.getErrCode();
        this.errMessage = exceptionInstance.getErrMessage();
    }

    BaseException(IExceptionInstance exceptionInstance, String errMessage) {
        super(exceptionInstance.getErrMessage());
        this.errCode = exceptionInstance.getErrCode();
        this.errMessage = errMessage;
    }

    BaseException(IExceptionInstance exceptionInstance, Throwable cause) {
        super(exceptionInstance.getErrMessage(), cause);
        this.errCode = exceptionInstance.getErrCode();
        this.errMessage = exceptionInstance.getErrMessage();
    }
}
