package org.demo.result;

/**
 * 返回结果枚举类
 */
public enum ResultCode {

    // 状态枚举
    SUCCESS(200, "成功", true),

    ERROR(404, "失败", false);

    // 响应码
    private Integer code;

    // 响应消息
    private String message;

    // 响应是否成功
    private Boolean success;

    // 默认就是私有的 private 修饰符，所以这里不写了
    ResultCode(int code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    // 提供给外部获取的方法
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }

}
