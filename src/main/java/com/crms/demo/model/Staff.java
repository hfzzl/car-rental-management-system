package com.crms.demo.model;

public class Staff {
    private String username;
    private String password;
    private int userid;
    private String fullname;
    private String birthdate;
    private int phone_no;
    private String email;
    private String addressL1;
    private String addressL2;
    private String addressL3;
    private String postcode;
    private String city;
    private String state;

    // default constructor
    public Staff() {
    }

    // user constructor
    public Staff(String username, String password, int userid, String fullname, String birthdate, int phone_no, String email, String addressL1, String addressL2, String addressL3, String postcode, String city, String state) {
        this.username = username;
        this.password = password;
        this.userid=userid;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.phone_no = phone_no;
        this.email = email;
        this.addressL1 = addressL1;
        this.addressL2 = addressL2;
        this.addressL3 = addressL3;
        this.postcode = postcode;
        this.city = city;
        this.state = state;
    }

    // accessor and mutator methods
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserid(int userid){
		this.userid = userid;
	}
    public int getUserid() {
        return userid;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public int getPhone_no() {
        return phone_no;
    }
    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddressL1() {
        return addressL1;
    }
    public void setAddressL1(String addressL1) {
        this.addressL1 = addressL1;
    }
    public String getAddressL2() {
        return addressL2;
    }
    public void setAddressL2(String addressL2) {
        this.addressL2 = addressL2;
    }
    public String getAddressL3() {
        return addressL3;
    }
    public void setAddressL3(String addressL3) {
        this.addressL3 = addressL3;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}