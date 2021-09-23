package apap.tutorial.cineplux.service;
import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;

public interface BioskopService {
    //Method untuk menambah Bioskop
    void addBioskop(BioskopModel bioskop);

    //Method untuk mengupdate Bioskop
    void updateBioskop(BioskopModel bioskop);

    //Method untuk mendapatkan daftar bioskop yang telah tersimpan
    List<BioskopModel> getBioskopList();

    //method untuk mendapatkan data sebuah bioskop berdasarkan no bioskop
    BioskopModel getBioskopByNoBioskop(Long noBioskop);

    //Method untuk hapus Bioskop
    void deleteBioskop(BioskopModel bioskop);

}
