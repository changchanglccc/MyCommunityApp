package ca.lccc.myCommunityApp.exceptions;

public class WechatAuthOperationException extends RuntimeException {
    private static final long serialVersionUID = -4290016045533442745L;

    public WechatAuthOperationException(String msg) {
        super(msg);
    }
}
