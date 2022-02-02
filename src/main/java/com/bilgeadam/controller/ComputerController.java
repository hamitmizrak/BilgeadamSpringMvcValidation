package com.bilgeadam.controller;

import com.bilgeadam.entity.ComputerEntity;
import com.bilgeadam.repository.impl.ComputerMyRepositoryImpl;
import com.bilgeadam.repository.IComputerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@Log4j2
public class ComputerController {

    //cdi =Inject
    @Autowired
    IComputerRepository IComputerRepository;

    @Autowired
    ComputerMyRepositoryImpl computerMyRepository;

    //////save //////
    //localhost:8080/computer/save
    @GetMapping("computer/save")
    @ResponseBody
    public String getComputerSave() {
        ComputerEntity computerEntity=null;
        for(int i=1; i<=10; i++){
             computerEntity = ComputerEntity.builder().computerId(0L).computerName("GL75").computerPrice(i*100).computerTrade("msi").build();
            IComputerRepository.save(computerEntity);
        }

        return "Ekleme Başarılı " + computerEntity.getComputerId();
    }

    //////requestParam////////
    //localhost:8080/computer/saverequestparam?name=GL73&trade=msi
    @GetMapping("computer/saverequestparam")
    @ResponseBody
    public String getComputerSaveRequestParam(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "trade") String trade
    ) {
        ComputerEntity computerEntity = ComputerEntity.builder().computerId(0L).computerName(name).computerTrade(trade).build();
        IComputerRepository.save(computerEntity);
        return "Ekleme Başarılı " + computerEntity.getComputerId();
    }

    /////FIND////////
    //localhost:8080/computer/find/1
    @GetMapping("computer/find/{id}")
    @ResponseBody
    public String getComputerFind(@PathVariable(name = "id") Long idim) {
        //java 8 null pointer exception kurtarmak için
        Optional<ComputerEntity> optional = IComputerRepository.findById(idim);
        //kayıt varsa
        if (optional.isPresent()) {
            ComputerEntity computerEntity1 = optional.get();
            return "Bulma Başarılı " + computerEntity1.getComputerId() + " " + computerEntity1.getComputerName() + " " + computerEntity1.getComputerTrade() + " " + computerEntity1.getDate();
        } else {
            return "Aradığınız bulunamadı" + idim;
        }
    }


    /////REMOVE////////
    //localhost:8080/computer/remove/1
    @GetMapping("computer/remove/{id}")
    @ResponseBody
    public String getComputerRemove(@PathVariable(name = "id") Long idim) {
        //java 8 null pointer exception kurtarmak için
        Optional<ComputerEntity> optional = IComputerRepository.findById(idim);
        //kayıt varsa
        if (optional.isPresent()) {
            ComputerEntity computerEntity1 = optional.get();
            IComputerRepository.deleteById(idim);
            return "silme Başarılı " + computerEntity1.getComputerId() + " " + computerEntity1.getComputerName() + " " + computerEntity1.getComputerTrade() + " " + computerEntity1.getDate();
        } else {
            return "silinemedi " + idim;
        }
    }


    /////UPDATE////////
    //Guncelleme ve kaydetmede save kullan
    //localhost:8080/computer/update/2?computer_name=Asus452&computer_trade=asus
    @GetMapping("computer/update/{id}")
    @ResponseBody
    public String getComputerUpdate(
            @PathVariable(name = "id") Long idim,
            @RequestParam(name = "computer_name") String name,
            @RequestParam(name = "computer_trade") String trade

    ) {

        Optional<ComputerEntity> optional = IComputerRepository.findById(idim);
        if (optional.isPresent()) {
            ComputerEntity computerEntity1 = optional.get();
            computerEntity1.setComputerName(name);
            computerEntity1.setComputerTrade(trade);
            IComputerRepository.save(computerEntity1);
            return "Güncelleme Başarılı ";
        } else {
            return "Güncelleme Başarısız" + idim;
        }
    }


    /////SELECT////////
    //localhost:8080/computer/select/findAll
    @GetMapping("computer/select/findAll")
    @ResponseBody
    public String getComputerSelectAll() {
        //iterable: birden fazla collection olan objedir.
        Iterable<ComputerEntity> iterableList = IComputerRepository.findAll();
        for (ComputerEntity temp : iterableList) {
            log.info(temp);
        }
        return "" + iterableList + "\n";
    }

    /////SELECT////////
    //localhost:8080/computer/select/specific/GL73
    @GetMapping("computer/select/specific/{computer_name}")
    @ResponseBody
    public String getComputerSelectSpesific(
            @PathVariable(name = "computer_name") String computerNamem
    ) {
        //iterable: birden fazla collection olan objedir.
        Iterable<ComputerEntity> iterableList = IComputerRepository.findComputerEntitiesByComputerName(computerNamem);
        for (ComputerEntity temp : iterableList) {
            log.info(temp);
        }
        return "" + iterableList + "\n";
    }

    /////////////////////////////////////////////////////////////////////////////////


    //////save //////
    //localhost:8090/computer/save
    @GetMapping("computer/save2")
    @ResponseBody
    public String getMyComputerSave() {
        ComputerEntity computerEntity=null;
        for(int i=1; i<=10; i++){
            computerEntity = ComputerEntity.builder().computerId(0L).computerName("GL75").computerPrice(i*100).computerTrade("msi").build();
            IComputerRepository.save(computerEntity);
        }

        return "Ekleme Başarılı " + computerEntity.getComputerId();
    }

    //localhost:8090/computer/minPrice/300
    @GetMapping("computer/minPrice/{price}")
    @ResponseBody
    public String getMyComputerPriceMin(@PathVariable(name = "price") double priceMin) {
        Iterable<ComputerEntity> iterableList = computerMyRepository.findComputerPriceMin(priceMin);
        for (ComputerEntity temp : iterableList) {
            log.info(temp);
        }
        return "" + iterableList + "\n";
    }


}
