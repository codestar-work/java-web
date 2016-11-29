package web;
import javax.persistence.*;

@Entity @Table(name="member")
public class Member {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	public String email;
	public String password;
	public String name;
}
