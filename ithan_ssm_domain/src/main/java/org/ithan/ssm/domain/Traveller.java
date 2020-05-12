package org.ithan.ssm.domain;

/**
 * @Author HanMengJie
 * @Date 2020/5/6 17:09
 **/
public class Traveller {
    private Integer id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr; //证件类型 0身份证 1护照 2 军官证
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr; //游客类型 0成人 1儿童


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if (credentialsType!=null){
            if (credentialsType==0){
                credentialsTypeStr="身份证";
            }else if(credentialsType==1){
                credentialsTypeStr="护照";
            }else if(credentialsType==2){
                credentialsTypeStr="军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if (travellerType!=null){
            if(travellerType==0){
                travellerTypeStr="成人";
            }else if (travellerType==1){
                travellerTypeStr="儿童";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }


}
