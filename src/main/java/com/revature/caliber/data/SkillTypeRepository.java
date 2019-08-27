package com.revature.caliber.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SkillType;
/**
 * Spring Data repo
 */
@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Integer> {
  SkillType findSkillTypeByType(String type);
}
