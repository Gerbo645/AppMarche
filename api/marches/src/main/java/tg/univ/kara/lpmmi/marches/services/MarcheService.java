package tg.univ.kara.lpmmi.marches.services;

import tg.univ.kara.lpmmi.marches.models.Marche;

import java.util.List;
import java.util.Optional;

public interface MarcheService {
    List<Marche> getMarche();
    Optional<Marche> getMarchebyId(Long id);
    void DeleteMarche(Long id);
    void updateMarche(Marche marche);
    void addMarche(Marche marche);
}
