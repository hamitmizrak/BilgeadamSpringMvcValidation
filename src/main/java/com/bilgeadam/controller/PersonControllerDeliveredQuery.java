package com.bilgeadam.controller;
import com.bilgeadam.entity.PersonEntity;
import com.bilgeadam.repository.IDelivedQueryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class PersonControllerDeliveredQuery {

    //cdi =Inject
    @Autowired
    IDelivedQueryRepository iDelivedQueryRepository;

    /// personName sonu 10 ile biten
    //localhost:8090/persondelivered/10
    @GetMapping("persondelivered/{ends}")
    @ResponseBody
    public String getPersonDelivered(@PathVariable(name = "ends") String personNameEnd ) {
        Iterable<PersonEntity> iterableListPerson = iDelivedQueryRepository.findByPersonNameEndsWith(personNameEnd);
        for (PersonEntity temp : iterableListPerson) {
            log.info(temp);
        }
        return "" + iterableListPerson + "\n";
    }

    /// personName sonu 10 ile biten
    //localhost:8090/persondelivered/10
    @GetMapping("persondelivered/{start}")
    @ResponseBody
    public String getPersonDeliveredAll(@PathVariable(name = "start") String personNameStart ) {
        Iterable<PersonEntity> iterableListPerson = iDelivedQueryRepository.findByPersonNameStartingWith(personNameStart);
        for (PersonEntity temp : iterableListPerson) {
            log.info(temp);
        }
        return "" + iterableListPerson + "\n";
    }
}
