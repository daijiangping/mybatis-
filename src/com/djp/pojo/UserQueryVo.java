package com.djp.pojo;

public class UserQueryVo {//Vo 视图层面的对象
	//在这里包装查询条件
	//用户查询条件
	private UserCustom userCustom;
	//可以再包装其他查询条件,订单,商品等

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	
}
