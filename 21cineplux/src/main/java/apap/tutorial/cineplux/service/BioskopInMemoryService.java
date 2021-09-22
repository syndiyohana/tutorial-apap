package apap.tutorial.cineplux.service;
import org.springframework.stereotype.Service;

import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;
import java.util.ArrayList;

@Service

public class BioskopInMemoryService implements BioskopService{

    private List<BioskopModel> listBioskop;

    //Constructor
    public BioskopInMemoryService(){
        listBioskop = new ArrayList<BioskopModel>();
    }

    @Override
    public void addBioskop(BioskopModel bioskop){
        listBioskop.add(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return listBioskop;
    }

    @Override
    public BioskopModel getBioskopByIdBioskop(String idBioskop) {
        for (BioskopModel a : listBioskop){
            if (a.getIdBioskop().equals(idBioskop)){
                return a;
            }
        }
        return null;
    }

    @Override
    public void setJumlahStudioByIdBioskop(String idBioskop, int jumlahStudio) {
        for (BioskopModel a : listBioskop){
            if (a.getIdBioskop().equals(idBioskop)){
                a.setJumlahStudio(jumlahStudio);
            }
        }
    }

    @Override
    public void deleteBioskop(BioskopModel bioskop){
        listBioskop.remove(bioskop);

    }

}
