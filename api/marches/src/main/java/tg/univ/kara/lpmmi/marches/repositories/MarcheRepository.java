package tg.univ.kara.lpmmi.marches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.univ.kara.lpmmi.marches.models.Marche;

@Repository
public interface MarcheRepository extends JpaRepository<Marche,Long> {
}
