package springboot.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springboot.ecomerce.entity.Pengguna;
import springboot.ecomerce.exception.BadRequestException;
import springboot.ecomerce.exception.ResourceNotFoundException;
import springboot.ecomerce.repository.PenggunaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PenggunaService {

    @Autowired
    private PenggunaRepository penggunaRepository;

    public Pengguna findById(String id){
        return penggunaRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Pengguna dengan id " + id + " Tidak Ditemukan"));
    }

    public List<Pengguna> findAll(){

        return penggunaRepository.findAll();
    }

    public Pengguna create(Pengguna pengguna ){
//        pengguna.setId(UUID.randomUUID().toString());

        if (!StringUtils.hasText(pengguna.getId())){
            throw new BadRequestException("Username Harus Diisi");
        }

        if (penggunaRepository.existsById(pengguna.getId())){
            throw new BadRequestException("Username " + pengguna.getId() + " SUdah Terdaftar");
        }

        if (!StringUtils.hasText(pengguna.getEmail())){
            throw new BadRequestException("Email Harus DIisi");
        }

        if (penggunaRepository.existsByEmail(pengguna.getEmail())){
            throw new BadRequestException("email " + pengguna.getEmail() + " Sudah Terdaftar");
        }

        pengguna.setIsAktif(true);
        return penggunaRepository.save(pengguna);
    }

    public Pengguna edit(Pengguna pengguna){

        if (!StringUtils.hasText(pengguna.getId())){
            throw new BadRequestException("Username Harus Diisi");
        }

        if (!StringUtils.hasText(pengguna.getEmail())){
            throw new BadRequestException("Email Harus DIisi");
        }

        if (!StringUtils.hasText(pengguna.getNama())){
            throw new BadRequestException("Nama Harus DIisi");
        }

        if (!StringUtils.hasText(pengguna.getPassword())){
            throw new BadRequestException("Password Harus DIisi");
        }

        if (!StringUtils.hasText(pengguna.getRole())){
            throw new BadRequestException("Pengguna Role Harus DIisi");
        }

        pengguna.setIsAktif(true);

        return penggunaRepository.save(pengguna);
    }

    public void deleteById(String id){
        penggunaRepository.deleteById(id);
    }
}
