package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

public interface PenjagaService {
    //Method untuk menambah Penjaga
    void addPenjaga(PenjagaModel penjaga);

    //Method untuk update Penjaga
    void updatePenjaga(PenjagaModel penjaga);

    //method untuk mendapatkan data sebuah penjaga berdasarkan no penjaga
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);

    //Method untuk hapus penjaga
    void deletePenjaga(PenjagaModel penjaga);

    int deletePenjagaa(PenjagaModel penjaga);
}
