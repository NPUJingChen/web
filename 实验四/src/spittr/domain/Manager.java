package spittr.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * manager类
 *
 * @author chenjing
 *
 */

public class Manager {

    private Long id;
    @NotNull
    @Size(min = 5,max = 16)
    private String userName;

    @NotNull
    @Size(min = 5,max = 25)
    private String password;

    @NotNull
    @Size(min = 2,max = 30)
    private String fullName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 6,max = 20)
    private String phoneNo;

    @NotNull
    private int isDelete;


    public Manager(){

    }
    /**
     * 构造函数
     *
     * @param userName     管理员用户名（登录名）
     *
     * @param password      密码
     *
     * @param fullName      管理员姓名
     *
     * @param email         邮箱
     *
     * @param phoneNo       电话号码
     *
     * @param isDelete      删除标记
     *
     */
    public Manager(String userName, String password, String fullName, String email, String phoneNo, int isDelete){
        this(null,userName,password,fullName,email,phoneNo,isDelete);
    }
    public Manager(Long id, String userName, String password, String fullName, String email, String phoneNo, int isDelete){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.isDelete = isDelete;
    }

    /**
     * 获取用户ID
     * @return
     */
    public Long getId(){
        return id;
    }

    /**
     * 设置用户ID
     * @param id
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * 获取用户名
     * @return
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置用户名
     * @param userName
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * 获取密码
     * @return
     */
    public String getPassword(){
        return password;
    }

    /**
     * 设置密码
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * 获取管理员名字
     * @return
     */
    public String getFullName(){
        return fullName;
    }

    /**
     * 设置管理员名字
     * @param fullName
     */
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    /**
     * 获取邮箱
     * @return
     */
    public String getEmail(){
        return email;
    }

    /**
     * 设置邮箱
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话号码
     * @return
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置电话号码
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 获取受否删除
     * @return
     */
    public int getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     * @param isDelete
     */
    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;

        return id.equals(manager.id);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
