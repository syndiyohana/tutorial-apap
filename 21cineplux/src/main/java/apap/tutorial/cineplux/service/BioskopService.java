package apap.tutorial.cineplux.service;
import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;

public interface BioskopService {
    //Method untuk menambah Bioskop
    void addBioskop(BioskopModel bioskop);

    //Method untuk mendapatkan daftar bioskop yang telah tersimpan
    List<BioskopModel> getBioskopList();

    //method untuk mendapatkan data sebuah bioskop berdasarkan id bioskop
    BioskopModel getBioskopByIdBioskop(String idBioskop);

    //method untuk mengupdate data jumlah studio berdasarkan id bioskop
    void setJumlahStudioByIdBioskop(String idBioskop, int jumlahStudio);

    //method untuk men-delete data bioskop berdasarkan id bioskop
    void deleteBioskop(BioskopModel bioskop);

}
