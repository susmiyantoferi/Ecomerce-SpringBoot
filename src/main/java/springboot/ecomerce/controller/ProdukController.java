package springboot.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springboot.ecomerce.entity.Produk;
import springboot.ecomerce.service.ProdukService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)

public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping("/produks")
    public List<Produk> findAll(){
        return produkService.findAll();
    }

    @GetMapping("/produks/{id}")
    public Produk findById(@PathVariable("id") String id){
        return produkService.findById(id);
    }

    @PostMapping("/addproduks")
    public Produk create(@RequestBody Produk produk){
        return produkService.create(produk);
    }

    @PutMapping("/editproduks")
    public Produk edit(@RequestBody Produk produk){
        return produkService.edit(produk);
    }

    @DeleteMapping("/deleteproduks/{id}")
    public void deleteById(@PathVariable("id") String id){
        produkService.deleteById(id);
    }
}
