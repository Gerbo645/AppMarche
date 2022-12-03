package tg.univ.kara.lpmmi.marches.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tg.univ.kara.lpmmi.marches.models.Marche;
import tg.univ.kara.lpmmi.marches.repositories.MarcheRepository;
import tg.univ.kara.lpmmi.marches.services.MarcheServiceImpl;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class MarcheController {
    @Autowired
    private MarcheServiceImpl marcheServiceImpl;
    @GetMapping("/marches")
    public List<Marche> marches(){
        List<Marche> marches = marcheServiceImpl.getMarche();
        return marches;
    }
    //
    @RequestMapping(path="/marches/get/{id}")
    public Optional<Marche> getMarcheById(@PathVariable("id") Long id){
        Optional<Marche> marche = marcheServiceImpl.getMarchebyId(id);
        return marche;
    }
    //
    @DeleteMapping("/marches/delete/{id}")
    public void deleteMarche(@PathVariable("id") Long id){
        marcheServiceImpl.DeleteMarche(id);
    }
    //
    @PutMapping(path="/marches/edit/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateMarche(@PathVariable("id") Long id,@RequestBody Marche marche)
    {
        Optional<Marche> array = marcheServiceImpl.getMarchebyId(id);
        if(array.isPresent()){
            Marche marcheupdatable = array.get();
            marcheupdatable.setNom(marche.getNom());
            marcheupdatable.setEmplacement(marche.getEmplacement());
            marcheupdatable.setHeure_ouverture(marche.getHeure_ouverture());
            marcheupdatable.setHeure_fermeture(marche.getHeure_fermeture());
            marcheupdatable.setNbre_hangars(marche.getNbre_hangars());
            marcheupdatable.setCategorie_produit(marche.getCategorie_produit());
            marcheServiceImpl.updateMarche(marcheupdatable);
        }
        return true;
    }
    //
    @PostMapping("/marches/add")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean storeNewMarche(@RequestBody Marche marche)
    {
        marcheServiceImpl.addMarche(marche);
        return true;
    }

}
