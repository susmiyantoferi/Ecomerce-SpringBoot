package springboot.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springboot.ecomerce.entity.Produk;
import springboot.ecomerce.exception.BadRequestException;
import springboot.ecomerce.exception.ResourceNotFoundException;
import springboot.ecomerce.repository.KategoriRepository;
import springboot.ecomerce.repository.ProdukRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ProdukService {

    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private ProdukRepository produkRepository;

    public Produk findById(String id){
        return produkRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Produk Dengan Id " + id + " Tidak DItemukan"));
    }

    public List<Produk> findAll(){
        return produkRepository.findAll();
    }

    public Produk create(Produk produk){

        if (!StringUtils.hasText(produk.getNama())){
            throw new BadRequestException("Nama Tidak Boleh Kossong");
        }

        if (produk.getKategori() == null){
            throw new BadRequestException("Kategori Tidak Boleh Kosong");
        }

        if (!StringUtils.hasText(produk.getKategori().getId())){
            throw new BadRequestException("Kategori Id TIdak Boleh Kosong");
        }

        kategoriRepository.findById(produk.getKategori().getId())
                .orElseThrow(()-> new BadRequestException("Kategori Id " + produk.getKategori().getId() + " Tidak Ada"));

        produk.setId(UUID.randomUUID().toString());
        return produkRepository.save(produk);
    }

    public Produk edit(Produk produk){

        if (!StringUtils.hasText(produk.getId())){
            throw new BadRequestException(" Produk Id Harus DIisi");
        }

        if (!StringUtils.hasText(produk.getNama())){
            throw new BadRequestException("Nama Tidak Boleh Kossong");
        }

        if (produk.getHarga() == null){
            throw new BadRequestException("Harga Produk Harus Diisi");
        }

        if (produk.getStok() == null){
            throw new BadRequestException("Stok Produk Harus Diisi");
        }

        if (produk.getKategori() == null){
            throw new BadRequestException("Kategori Tidak Boleh Kosong");
        }

        if (!StringUtils.hasText(produk.getKategori().getId())){
            throw new BadRequestException("Kategori Id TIdak Boleh Kosong");
        }

        kategoriRepository.findById(produk.getKategori().getId())
                .orElseThrow(()-> new BadRequestException("Kategori Id " + produk.getKategori().getId() + " Tidak Ada"));

        return produkRepository.save(produk);
    }

    public void deleteById(String id){
        produkRepository.deleteById(id);
    }
}
