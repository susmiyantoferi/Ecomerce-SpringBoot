package springboot.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springboot.ecomerce.entity.Kategori;
import springboot.ecomerce.service.KategoriService;

import java.util.List;

@RestController
@RequestMapping(value ="/api", produces = MediaType.APPLICATION_JSON_VALUE)

public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @GetMapping("/kategoris")
    public List<Kategori> findAll(){
        return kategoriService.findAll();
    }

    @GetMapping("/kategoris/{id}")
    public Kategori findById(@PathVariable("id") String id){
        return kategoriService.findById(id);
    }

    @PostMapping(value = "/addkategoris")
    public Kategori create(@RequestBody Kategori kategori){
        return kategoriService.create(kategori);
    }

    @PutMapping("/editkategoris")
    public Kategori edit(@RequestBody Kategori kategori){
        return kategoriService.edit(kategori);
    }

    @DeleteMapping("/deletekategoris/{id}")
    public void deleteById(@PathVariable("id") String id){
        kategoriService.deleteById(id);
    }
}
