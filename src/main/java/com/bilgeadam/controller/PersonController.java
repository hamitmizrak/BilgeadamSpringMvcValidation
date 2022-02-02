package com.bilgeadam.controller;
import com.bilgeadam.entity.PersonEntity;
import com.bilgeadam.repository.IPersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class PersonController {

    //cdi =Inject
    @Autowired
    IPersonRepository personRepository;

    /////paging
    //localhost:8090/person/page
    @GetMapping("person/page")
    @ResponseBody
    public String getPersonPaging() {
        //2.sayfada 20 tane olsun
       Pageable pageable= PageRequest.of(0,20);
        //slice: page'e göre daha performanlı slice: sadece gereken sayfa alınır page hepsini alır isteneni gösterir
        Page<PersonEntity> iterableListPerson = personRepository.findAll(pageable);
        for (PersonEntity temp : iterableListPerson) {
            log.info(temp);
        }
        return "" + iterableListPerson + "\n";
    }


    /////paging pathVariable
    //localhost:8090/person/page/1
    @GetMapping("person/page/{page}")
    @ResponseBody
    public String getPersonPagingPath(@PathVariable(name = "page") int paging ) {
        //2.sayfada 20 tane olsun
        Pageable pageable= PageRequest.of(paging,20);
        //slice: page'e göre daha performanlı slice: sadece gereken sayfa alınır page hepsini alır isteneni gösterir
        Page<PersonEntity> iterableListPerson = personRepository.findAll(pageable);
        for (PersonEntity temp : iterableListPerson) {
            log.info(temp);
        }
        return "" + iterableListPerson + "\n";
    }


    //unutma sıralamayı her zaman string'e gre yapar
    /////sorting: küçükten büyüğe
    //localhost:8090/person/sorting/ascending
    @GetMapping("person/sorting/ascending")
    @ResponseBody
    public String getPersonSortingAscending() {
        Sort sort=  Sort.by("date");
        Iterable<PersonEntity> iterableListPerson = personRepository.findAll(sort);
        for (PersonEntity temp : iterableListPerson) {
            log.info(temp);
        }
        return "" + iterableListPerson + "\n";
    }



    //unutma sıralamayı her zaman string'e gre yapar
    /// sorting edilmiş bir sayfada paging yapalım
    //localhost:8090/person/sortingvepaging
    @GetMapping("person/sortingvepaging")
    @ResponseBody
    public String getPersonSortingPaging() {
        //2.sayfada 5 tane olsun
        Pageable pageable= PageRequest.of(0,5,Sort.by("date").descending());
        //slice: page'e göre daha performanlı slice: sadece gereken sayfa alınır page hepsini alır isteneni gösterir
        Page<PersonEntity> iterableListPerson = personRepository.findAll(pageable);
        for (PersonEntity temp : iterableListPerson) {
            log.info(temp);
        }
        return "" + iterableListPerson + "\n";
    }



    //////save //////
    //localhost:8090/person/save
    @GetMapping("person/save")
    @ResponseBody
    public String getMyComputerSave() {
        PersonEntity personEntity=null;
        int count=0;
        for(int i=10; i>0; i--){
            personEntity = PersonEntity.builder().personelId(0L).personName("personel adı "+i).personSurname("soyadı "+i).personPrice(i*100).build();
            personRepository.save(personEntity);
            count++;
        }
        return "Personel Ekleme Başarılı " + count+" kayıt";
    }


}
