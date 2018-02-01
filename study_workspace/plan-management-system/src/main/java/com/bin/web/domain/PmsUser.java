package com.bin.web.domain;


import java.util.Arrays;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * PMS_USER
 * 
 * @author bianj
 * @version 1.0.0 2018-01-19
 */
@Entity
@Table(name = "PMS_USER")
public class PmsUser implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -5067416066766937014L;

    /** id */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    private String id;

    /** 用户名 */
    @Column(name = "USER_NAME", unique = true, nullable = false, length = 50)
    private String userName;

    /** 部门id */
    @Column(name = "DEPARTMENT_ID", nullable = true, length = 19)
    private Long departmentId;

    /** 邮件地址 */
    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email;

    /** 手机号码 */
    @Column(name = "PHONE", unique = true, nullable = true, length = 30)
    private String phone;

    /** 密码 */
    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    /** 排序 */
    @Column(name = "SORT", nullable = false, length = 19)
    private Long sort;

    /** 状态(1:正常用户) */
    @Column(name = "STATUS", nullable = false)
    private Byte[] status;

    /** 创建时间 */
    @Column(name = "CREATED", nullable = false)
    private Date created;

    /** 更新时间 */
    @Column(name = "UPDATED", nullable = true)
    private Date updated;

    /**
     * 获取id
     * 
     * @return id
     */
   

    /**
     * 设置id
     * 
     * @param id
     *          id
     */
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置用户名
     * 
     * @param userName
     *          用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取部门id
     * 
     * @return 部门id
     */
    public Long getDepartmentId() {
        return this.departmentId;
    }

    /**
     * 设置部门id
     * 
     * @param departmentId
     *          部门id
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取邮件地址
     * 
     * @return 邮件地址
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置邮件地址
     * 
     * @param email
     *          邮件地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号码
     * 
     * @return 手机号码
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * 设置手机号码
     * 
     * @param phone
     *          手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取密码
     * 
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置密码
     * 
     * @param password
     *          密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取排序
     * 
     * @return 排序
     */
    public Long getSort() {
        return this.sort;
    }

    /**
     * 设置排序
     * 
     * @param sort
     *          排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 获取状态(1:正常用户)
     * 
     * @return 状态(1
     */
    public Byte[] getStatus() {
        return this.status;
    }

    /**
     * 设置状态(1:正常用户)
     * 
     * @param status
     *          状态(1
     */
    public void setStatus(Byte[] status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Date getCreated() {
        return this.created;
    }

    /**
     * 设置创建时间
     * 
     * @param created
     *          创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取更新时间
     * 
     * @return 更新时间
     */
    public Date getUpdated() {
        return this.updated;
    }

    /**
     * 设置更新时间
     * 
     * @param updated
     *          更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

	@Override
	public String toString() {
		return "PmsUser [id=" + id + ", userName=" + userName + ", departmentId=" + departmentId + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", sort=" + sort + ", status="
				+ Arrays.toString(status) + ", created=" + created + ", updated=" + updated + "]";
	}
}