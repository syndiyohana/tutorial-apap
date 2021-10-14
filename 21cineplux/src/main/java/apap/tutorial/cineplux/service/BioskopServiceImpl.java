package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.FilmDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class BioskopServiceImpl implements BioskopService{

    @Autowired
    BioskopDB bioskopDB;
    @Autowired
    FilmDB filmDB;

    @Override
    public void addBioskop(BioskopModel bioskop){
        bioskopDB.save(bioskop);
    }

    @Override
    public void updateBioskop(BioskopModel bioskop){
        bioskopDB.save(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList(){
        return bioskopDB.findAll(Sort.by(Sort.Direction.ASC, "namaBioskop"));
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop){
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if (bioskop.isPresent()){
            return bioskop.get();
        }
        return null;
    }

    @Override
    public void deleteBioskop(BioskopModel bioskop){
        bioskopDB.delete(bioskop);
    }

    @Override
    public List<FilmModel> getFilmList() {
        return filmDB.findAll();
    }
}
