package tg.univ.kara.lpmmi.marches.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.univ.kara.lpmmi.marches.models.Marche;
import tg.univ.kara.lpmmi.marches.repositories.MarcheRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarcheServiceImpl implements MarcheService {
    @Autowired
    private MarcheRepository marcheRepository;
    @Override
    public List<Marche> getMarche() {
        return marcheRepository.findAll();
    }

    public Optional<Marche> getMarchebyId(Long id) {
        return marcheRepository.findById(id);
    }

    @Override
    public void DeleteMarche(Long id) {
        marcheRepository.deleteById(id);
    }

    @Override
    public void updateMarche(Marche marche) {
        marcheRepository.save(marche);
    }

    @Override
    public void addMarche(Marche marche) {
        marcheRepository.save(marche);
    }
}
