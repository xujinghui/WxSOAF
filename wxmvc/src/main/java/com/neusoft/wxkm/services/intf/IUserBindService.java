/**
 * 
 */
package com.neusoft.wxkm.services.intf;

/**
 * @author stevenxu
 * 
 */
public interface IUserBindService {
    
    /**
     * 当有用户关注本公众帐号，添加这个帐号的Alias名字，可以作为用户管理的用户ID；
     * @param userAlias
     * @param createTime
     * @return
     */
    public boolean addSubscriber(String userAlias, String createTime);
    /**
     * 判断微信用户是否已经绑定
     * 
     * @param userAlias
     *            微信用户帐号别名
     * @return
     */
    boolean isBinded(String userAlias);

	String bind(String userAlias, String name, String employeeId);

}
