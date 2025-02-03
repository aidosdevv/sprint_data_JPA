package kz.bitlab.dataJPA.controller;

import kz.bitlab.dataJPA.model.Manufacturer;
import kz.bitlab.dataJPA.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerRepository manufacturerRepository;


    @GetMapping("/addmanufacturer")
    public String addManufacturerPage() {
        return "add-manufacturer";
    }

    @PostMapping("/addmanufacturer")
    public String addManufacturer(@RequestParam("manufacturer_name") String manufacturer_name,
                                  @RequestParam("manufacturer_code") String code) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(manufacturer_name);
        manufacturer.setCode(code);
        if(manufacturer!=null) {
            manufacturerRepository.save(manufacturer);
            return "redirect:/foods";
        }else{
            return "redirect:/addmanufacturer?error";
        }
    }
}
