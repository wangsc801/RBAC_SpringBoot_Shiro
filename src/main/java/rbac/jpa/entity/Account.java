package rbac.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "varchar(64)")
	private String nickname;
	@Column(columnDefinition = "varchar(64)")
	private String username;
	private String email;
	@Column(columnDefinition = "varchar(11)")
	private String mobile;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date created;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date edited;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getEdited() {
		return edited;
	}

	public void setEdited(Date edited) {
		this.edited = edited;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", nickname=" + nickname + ", username=" + username + ", email=" + email
				+ ", mobile=" + mobile + ", password=" + password + ", birthday=" + birthday + ", created=" + created
				+ ", edited=" + edited + "]";
	}
}
