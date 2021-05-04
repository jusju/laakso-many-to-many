package fi.haagahelia.course.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Word {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
    private String original;
    private String translation;
    
    
	@ManyToMany(fetch = FetchType.EAGER)
	//@ManyToMany
    @JoinTable(name = "word_themes",
            joinColumns = {
                    @JoinColumn(name = "word_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "theme_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Theme> wordHasThemes = new HashSet<Theme>(0);

	public Word() {
		super();
	}
	
	public Word(String original, String translation) {
		super();
		this.original = original;
		this.translation = translation;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}




	public String getOriginal() {
		return original;
	}


	public void setOriginal(String original) {
		this.original = original;
	}


	public String getTranslation() {
		return translation;
	}


	public void setTranslation(String translation) {
		this.translation = translation;
	}


	public Set<Theme> getWordHasThemes() {
		return wordHasThemes;
	}


	public void setWordHasThemes(Set<Theme> wordHasThemes) {
		this.wordHasThemes = wordHasThemes;
	}
   
    
    
}
