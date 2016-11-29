package web;
import javax.persistence.*;

@Entity @Table(name="topic")
public class Topic {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	long user;
	String title;
	String detail;
	public String getTitle() { return title; }
	public String getDetail() { return detail; }
}
