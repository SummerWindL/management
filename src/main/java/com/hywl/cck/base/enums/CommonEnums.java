package com.hywl.cck.base.enums;

/**
 * 
 * cck枚举
 * 
 * ClassName: CommonEnums
 * @Description: TODO
 * @author yzw
 * @date 2017年10月31日
 */
public enum CommonEnums {
	// 1表示用户，2表示订单，3表示系统通知,4表示直播,5表示游戏,6表示聊天

    REGISTER_ACCOUNT_EXIST("该手机号码已注册，不能重新注册", 100),
	PASSWORD_MISMATCH("两次输入密码不一致",101),
	NOT_EXIST_ACCOUNT("该账号不存在,请先注册!",102),
    ACCOUNT_OR_PWD_ERROR("用户名或者密码错误,请重新输入!",103),
    ACCOUNT_ERROR("用户名信息错误,请重新输入!",109),
    NEED_TO_MOBILE_NUMBER("需要填写手机号码", 104),
	LOGIN_DUE("登录已过期", 105),
    ACCOUNT_ENABLE("该账户已被禁用", 106),
    ACCOUNT_ID_REPETITION("账号id有重复",107),
    ACCOUNT_ID_CAN_NOT_MOD("账号id暂不能修改",108),


    PAY_PWD_ERROR("支付密码错误",200),
    ORDER_ERROR("订单错误", 201),
    PAY_PWD_INIT("请设置支付密码",202),
    GLOD_BALANCE_DEFICIENCY("金币余额不足",203),

	IS_NOT_DIRECT_SEEDING("您暂不是主播",400),
	SEEDING_INFO_CHECK("您的直播信息审核中",401),
	SEEDING_NOT_ALLOW_ATT("该直播间暂不允许关注", 402),
	ALREADY_ATT_SEEDING("您已关注该直播间", 403),
    NOT_ATT_SEEDING("您暂未关注该直播间", 404),
	SEEDING_DISABLED("该直播间已被禁用",405),
	SIGN_CREATE_ERROR("签名生成错误",406),

	GAME_IS_SAFEGUARD("该游戏正在维护中",500),
    STRENGTH_VALUE_DEFICIENCY("体力值不足", 501),
	STRENGTH_VALUE_INVALID("该体力暂时不能购买",502),
    STRENGTH_VALUE_NEED_USE("请消耗部分体力再购买",503),
	GAME_INTEGRAL_DEFICIBNCY("游戏总积分不足",504),

	PARAMETER_ERROR("参数错误",300),
	ENTER_MOBILENUMBER("参数错误",313),
	ENTER_PASSWORD("请输入密码",311),
	ENTER_CODES("请输入验证码",312),
	NETWORK_FAULT("网络繁忙,请重试!",314),
	SUCCESS("成功",301),
	SYSTEM_ERROR("系统错误",302),
	MOBILE_ERROR("请输入正确的手机号码", 303),
	SELECT_IMAGES("请选择上传图片",304),
	CODE_ERROR("验证码错误", 305),
	IMAGES_FORMAT_ERROR("图片格式不正确",306),
    PWD_LENGTH_NOT_ENOUGH("密码长度不够",307),
	SIGN_ERROR("签名错误",308),
	CODE_PAST_DUE("验证码已过期",309),
    DEFEATED("操作失败",310),

	USER_BELONG_BLACK("该用户属于黑名单用户，暂不能加好友",600),
    USER_BELONG_FRIENDS("该用户已属于您的好友", 601),
    CAN_NOT_ADD_ONESELF("不能添加自己为好友", 602),
    CAN_NOT_ADD_USER("暂不能添加该用户为好友", 603),
    USER_NOT_BELONG("该用户暂不属于您的好友", 604),

	NOT_AVAILABLE_DATA("暂无数据",304),
	USER_NOT("该用户暂不存在", 605),
	
	MERCHANT_NAME_ERROR("商家名称不能为空",700),
	LINKMAN_ERROR("请输入联系人名称",701),
	IDCARD_ERROR("请输入身份证号码",702),
	MERCHANT_TYPE("请选择商家的状态",703),
	BRANK_EXIT("该品牌已存在,请不要重复添加",704),
	BRANK_ISONPRODUCT("该品牌已上架商品,请不要删除",705),
	CATEGORY_ISEXIT("该类别已存在,请不要重复增加",706),
	SECOND_CATEGORY_ISEXIT("该类别已有二级分类,不能删除",707),
	PRODUCT_BY_CATEGORY("该类别已有上架商品,不能删除",708),
	CATEGORY_ISNUMBERONE("该类别已是第一条,不能上移",709),
	CATEGORY_ISEND("该类别已是最后一条,不能下移",710);
	
	
	
	private String label;
	private int value;

	private CommonEnums(String label, int value) {

		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return this.label;
	}

	public Integer getValue() {
		return this.value;
	}
}
