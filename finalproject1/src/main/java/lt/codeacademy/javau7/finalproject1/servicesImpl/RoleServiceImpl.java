package lt.codeacademy.javau7.finalproject1.servicesImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lt.codeacademy.javau7.finalproject1.entities.Role;
import lt.codeacademy.javau7.finalproject1.services.RoleService;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	private EntityManager entityManager;

	public RoleServiceImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public Role findRoleByName(String theRoleName) {

		TypedQuery<Role> theQuery = entityManager.createQuery("from Role where name=:roleName", Role.class);
		theQuery.setParameter("roleName", theRoleName);
		
		Role theRole = null;
		
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	}
}
