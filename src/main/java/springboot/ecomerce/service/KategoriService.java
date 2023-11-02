package springboot.ecomerce.service;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.ecomerce.entity.Kategori;
import springboot.ecomerce.exception.ResourceNotFoundException;
import springboot.ecomerce.repository.KategoriRepository;

import java.util.List;
import java.util.UUID;

@Service
public class KategoriService {

    @Autowired
    private KategoriRepository kategoriRepository;

    public Kategori findById(String id){
        return kategoriRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Kategori dengan id " + id + " Tidak Ditemukan"));
    }

    public List<Kategori> findAll(){
        return kategoriRepository.findAll();
    }

    public Kategori create(Kategori kategori){
        kategori.setId(UUID.randomUUID().toString());
        return kategoriRepository.save(kategori);
    }

    public Kategori edit(Kategori kategori){
        return kategoriRepository.save(kategori);
    }

    public void deleteById(String id){
        kategoriRepository.deleteById(id);
    }
}
