package fi.haagahelia.course.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Theme;
import fi.haagahelia.course.domain.ThemeRepository;
import fi.haagahelia.course.domain.Word;
import fi.haagahelia.course.domain.WordRepository;

@Controller
public class WordController {
	@Autowired
	private ThemeRepository themeRepository; 

	@Autowired
	private WordRepository wordRepository; 
	
	// Show all students
    @RequestMapping(value={"/", "/wordlist"})
    public String wordList(Model model) {	
        model.addAttribute("words", wordRepository.findAll());
        List<Word> words = (List<Word>) wordRepository.findAll();
        System.out.println("JUKKA    ");
        System.out.println(words);
        model.addAttribute("themes", themeRepository.findAll()); 
        List<Theme> themes = (List<Theme>) themeRepository.findAll();
        System.out.println("JUKKA    ");
        System.out.println(themes);
        return "studentlist";
    }
  
 
 }
