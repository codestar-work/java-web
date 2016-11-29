package web;
import javax.persistence.*;

@Entity @Table(name="topic")
class Topic {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String title;
	String detail;
}
