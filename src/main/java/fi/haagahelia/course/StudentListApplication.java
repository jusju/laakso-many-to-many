package fi.haagahelia.course;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.haagahelia.course.domain.Theme;
import fi.haagahelia.course.domain.ThemeRepository;
import fi.haagahelia.course.domain.Word;
import fi.haagahelia.course.domain.WordRepository;

@SpringBootApplication
public class StudentListApplication {
	private static final Logger log = LoggerFactory.getLogger(StudentListApplication.class);
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(StudentListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(WordRepository wordRepository, ThemeRepository themeRepository) {
		return (args) -> {
			
			themeRepository.save(new Theme("Animals"));
			themeRepository.save(new Theme("Furniture"));
			themeRepository.save(new Theme("Hobbies"));
			themeRepository.save(new Theme("Numbers"));
			themeRepository.save(new Theme("Forestry"));
			
			Word word1 = new Word("Koira", "Dog");
			Set<Theme> set1 = new HashSet<Theme>();
			set1.add(themeRepository.findByName("Animals").get(0));
			word1.setWordHasThemes(set1);
			wordRepository.save(word1);
			
		
			
			Word word2 = new Word("Kuusi", "Six");
			Set<Theme> set2 = new HashSet<Theme>();
			set2.add(themeRepository.findByName("Numbers").get(0));
			word2.setWordHasThemes(set2);
			wordRepository.save(word2);
			
			Word word3 = new Word("Kuusi", "Pine tree");
			Set<Theme> set3 = new HashSet<Theme>();
			set3.add(themeRepository.findByName("Forestry").get(0));
			word3.setWordHasThemes(set2);
			wordRepository.save(word3);			

			
			
			log.info("save a couple of words");
	

			for (Word word : wordRepository.findAll()) {
				log.info(word.toString());
			}

		};
	}
}
