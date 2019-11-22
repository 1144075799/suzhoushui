package com.suzhoushui.enums;

public enum StatusCode {
    Success(1, "数据获取成功"),
    LikeSuccess(203,"添加喜欢成功"),
    DeleteSuccess(204,"删除喜欢成功"),
    LoginSuccess(301,"登陆成功"),
    RegisterSuccess(202,"注册成功"),
    CommentSuccess(204,"评论成功"),
    UploadSuccess(205,"上传图片成功"),

    Fail(0, "数据获取失败"),
    ParamFail(50, "参数错误"),
    LikeFail(60, "添加喜欢错误"),
    DeleteLikeFail(80, "删除喜欢失败"),
    CommentFail(70, "评论失败"),
    UploadFail(90,"上传图片失败"),
    VerifyFail(0, "验证失败"),
    ResignFail(0, "重签失败,可能是因为您太长久未登录"),
    DeleteFail(0,"删除错误"),
    ExistFail(101,"此条记录已经存在于数据库"),
    NoExistFail(0,"此条记录不存在"),
    INSERTERROR(510,"插入数据库错误"),

    AddFail(0,"参数错误"),

    UserNoLogin(20001,"用户未登录"),
    UserLongTimeNoLogin(20002,"用户长时间未登录"),



    UserNameNoExit(30001,"用户名不存在"),
    UserNameIsExit(30002,"用户名已存在"),
    UserAddressNoExit(30001,"用户名收货地址不存在"),
    UserNameError(0,"用户名错误"),

    UserNameLengthError(0,"用户名长度不在规定范围内"),

    UserPasswordError(30101,"用户密码错误"),
    PasswordLengthError(0,"密码长度不在规定范围内"),

    UserUpdateInfoSuccess(30201,"用户修改信息成功"),

    SHOES_NOT_EXIST(40001,"鞋子不存在"),
    SHOES_STOCK_ERROR(40002,"鞋子库存错误"),
    UserUpdateInfoError(40003,"用户修改信息失败"),


    ORDER_NOT_EXIST(50001,"订单不存在"),
    ORDER_STATUS_ERROR(50010,"订单状态不正确"),
    ORDER_UPDATE_FAIL(50011,"订单更新失败"),
    ORDER_DETAIL_EMPTY(50012,"订单详情为空"),
    ORDER_OWNER_ERROR(50100,"该订单不属于该用户"),

    CAR_OWNER_ERROR(60100,"购物车不属于该用户"),
    CAR_SHOES_NUM_NOT_ZERO(60200,"鞋子数量不能为0"),
    CAR_SHOES_NUM_NOT_DAEWOO_STOCK(60300,"鞋子数量不能大于库存"),

    USER_HAS_COLLECTION(70001,"用户已经收藏该鞋子"),
    ;
    final private Integer Code;
    final private String msg;

    StatusCode(Integer Code, String msg) {
        this.Code = Code;
        this.msg = msg;
    }

    public Integer getCode() {
        return Code;
    }

    public String getMsg() {
        return msg;
    }
}
