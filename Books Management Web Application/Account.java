package com.ICS2609JSPCRUDample;

public class Account {
	protected int id;
    protected String username;
    protected String password;
    protected String usertype;
    protected String status;
    //constructor for new account
    public Account() {
    }
    //constructor for deleting account
    public Account(int id) {
        this.id = id;
    }
    //constructor for inserting the new account or update account
    public Account(int id, String username, String password, String usertype, String status) {
        this(username, password, usertype, status);
        this.id = id;
    }
    //constructor for reading
    public Account(String username, String password, String usertype, String status) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.status = status;
    }
    //setter and getter of each column
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
