package time.no.see.model.beans;

public class User {

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.organization_id
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    private Long organizationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.username
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.password
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.salt
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.role_ids
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    private String roleIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.locked
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    private Boolean locked;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.organization_id
     *
     * @return the value of sys_user.organization_id
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.organization_id
     *
     * @param organizationId the value for sys_user.organization_id
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.username
     *
     * @return the value of sys_user.username
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.username
     *
     * @param username the value for sys_user.username
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.password
     *
     * @return the value of sys_user.password
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.password
     *
     * @param password the value for sys_user.password
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.salt
     *
     * @return the value of sys_user.salt
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.salt
     *
     * @param salt the value for sys_user.salt
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.role_ids
     *
     * @return the value of sys_user.role_ids
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.role_ids
     *
     * @param roleIds the value for sys_user.role_ids
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.locked
     *
     * @return the value of sys_user.locked
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.locked
     *
     * @param locked the value for sys_user.locked
     *
     * @mbggenerated Tue Jun 25 10:14:28 CST 2019
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
	
	
	public String getCredentialsSalt() {
		String credentialsSalt = this.username+this.salt;
		return credentialsSalt;
	}
}
