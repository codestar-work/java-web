package web;
import javax.persistence.*;

@Entity @Table(name="topic")
public class Topic {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	long user;
	String title;
	String detail;
	String photo;
	public long   getId()     { return id;     }
	public String getTitle()  { return title;  }
	public String getDetail() { return detail; }
	public String getPhoto()  { return photo;  }
}
