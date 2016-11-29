package web;
import javax.persistence.*;

@Entity @Table(name="member")
public class Member {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	public String email;
	public String password;
	public String name;
}
