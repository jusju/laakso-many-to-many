package fi.haagahelia.course.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String name;
    
	@ManyToMany(mappedBy = "wordHasThemes", fetch = FetchType.EAGER)
    private Set<Word> words;

	public Theme() {
		super();
	}
	
	public Theme(String name) {
		super();
		this.name = name;
	}

	

	public Set<Word> getWords() {
		return words;
	}



	public void setWords(Set<Word> words) {
		this.words = words;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
    
   
	
    
    
}
