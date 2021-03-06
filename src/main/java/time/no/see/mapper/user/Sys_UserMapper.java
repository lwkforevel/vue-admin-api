package time.no.see.mapper.user;

import time.no.see.model.beans.user.Sys_User;

public interface Sys_UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Jul 13 14:51:05 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Jul 13 14:51:05 CST 2019
     */
    int insert(Sys_User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Jul 13 14:51:05 CST 2019
     */
    int insertSelective(Sys_User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Jul 13 14:51:05 CST 2019
     */
    Sys_User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Jul 13 14:51:05 CST 2019
     */
    int updateByPrimaryKeySelective(Sys_User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Jul 13 14:51:05 CST 2019
     */
    int updateByPrimaryKey(Sys_User record);


	Sys_User getSys_UserByUsername(String username);

	Long selectRoleIdByUsername(String username);

	Sys_User selectRoleByUsername(String username);


}