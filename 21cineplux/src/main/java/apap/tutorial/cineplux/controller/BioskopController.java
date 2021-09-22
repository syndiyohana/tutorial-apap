package apap.tutorial.cineplux.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.ArrayList;


@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
        //request parameter yang ingin digunakan
        @RequestParam(value = "idBioskop", required = true) String idBioskop,
        @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
        @RequestParam(value = "alamat", required = true) String alamat,
        @RequestParam(value = "noTelepon", required = true) String noTelepon,
        @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
        Model model
    ){
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambah objek BioskopModel ke dalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        //return view template yang digunakan
        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        //Return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null){
            return "error-page";
        }
        else {
            //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
            model.addAttribute("bioskop", bioskopModel);
            return "view-bioskop";
        }
    }

    @RequestMapping("/bioskop/view/id-bioskop/{idBioskop}")
    public String detailBioskopwithPathVariable(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null){
            return "error-page";
        }
        else {
            //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
            model.addAttribute("bioskop", bioskopModel);
            return "view-bioskop";
        }

    }

    @RequestMapping("/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateJumlahStudio(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            @PathVariable(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null){
            return "error-page";
        }
        else {
            //Update jumlah studio bioskop sesuai dengan idBioskop
            bioskopService.setJumlahStudioByIdBioskop(idBioskop, jumlahStudio);

        }

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);
        return "update-jumlah-studio";
    }

    @RequestMapping("/bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null){
            return "error-page";
        }
        else {
            //Delete bioskop sesuai dengan idBioskop
            bioskopService.deleteBioskop(bioskopModel);

        }

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);
        return "delete-bioskop";
    }

}
