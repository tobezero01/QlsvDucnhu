package entity;

public class User {
	private int idUser;
    private String userName;
    private String password;

    public User() {
    }
 
	/**
	 * @param idUser
	 * @param userName
	 * @param password
	 */
	public User( String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
