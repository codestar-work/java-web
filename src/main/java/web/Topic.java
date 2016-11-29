package web;
import javax.persistence.*;

@Entity @Table(name="topic")
class Topic {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	long user;
	String title;
	String detail;
}
