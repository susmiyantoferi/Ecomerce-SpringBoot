package springboot.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springboot.ecomerce.entity.Pengguna;
import springboot.ecomerce.service.PenggunaService;

import java.util.List;

@RestController
@RequestMapping(value ="/api", produces = MediaType.APPLICATION_JSON_VALUE)

public class PenggunaController {

    @Autowired
    private PenggunaService penggunaService;

    @GetMapping("/penggunas")
    public List<Pengguna> findAll(){
        return penggunaService.findAll();
    }

    @GetMapping("/penggunas/{id}")
    public Pengguna findById(@PathVariable("id") String id){
        return penggunaService.findById(id);
    }

    @PostMapping(value = "/addpenggunas")
    public Pengguna create(@RequestBody Pengguna pengguna){
        return penggunaService.create(pengguna);
    }

    @PutMapping("/editpenggunas")
    public Pengguna edit(@RequestBody Pengguna pengguna){
        return penggunaService.edit(pengguna);
    }

    @DeleteMapping("/deletepenggunas/{id}")
    public void deleteById(@PathVariable("id") String id){
        penggunaService.deleteById(id);
    }
}
