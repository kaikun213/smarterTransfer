package common.app.model.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import common.app.model.AbstractTimestampEntity;
import common.app.model.Location;
import common.app.model.merchant.Theme;

@Entity
@Table(name="USER")
public class User extends AbstractTimestampEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId", unique=true, nullable=false)
	private long userId;
	@Column(name="keshId", length=200, nullable=false, unique=true)
	private String keshId;
	@Column(name="password", length=45, nullable=false)
	private String password;
	@Column(name="name", length=45, nullable=false)
	private String name;
	@OneToOne
	@JoinColumn(name="themeId")
	private Theme theme;
	@Column(name="deviceId", length=45, nullable=false)
	private String deviceId;
	@Embedded
	private Location location;
	@Column(name="isDeleted", nullable = false)
	private boolean isDeleted;
	
	public User(){
	}
	
	public User(String keshId){
		this.keshId = keshId;
	}
	
	public long getUserId(){
		return userId;
	}
	public String getKeshId() {
		return keshId;
	}
	public void setKeshId(String keshId) {
		this.keshId = keshId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setLocation(double lon, double lat){
		this.location = new Location(lon,lat);
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public void setIsDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}
	public boolean getIsDeleted(){
		return isDeleted;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
	
	


}
