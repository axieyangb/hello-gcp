package hellogcp.controller;

import hellogcp.domain.Person;
import hellogcp.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HomeController {

  @Autowired private PersonRepository personRepo;
  private Logger logger = LoggerFactory.getLogger(HomeController.class);

  @RequestMapping("/hello")
  public String hello(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "age", required = false) Optional<Integer> age) {
    this.personRepo.save(new Person(name, age.isPresent() ? age.get() : 0));
    String welcomeWord = String.format("Hello %s with age: %d years old", name, age.isPresent() ? age.get() : 0);
    this.logger.info(welcomeWord);
    return welcomeWord;
  }
  @RequestMapping("/morning")
  public String goodMorning(){
    return "Good Afternoon";
  }
}
