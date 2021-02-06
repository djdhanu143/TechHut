package TechHut.javaResort.dao;

public class DAOFactoryClass {
public static RegistrationDAOInf getRegistrationDAOInfInstance() {
	return new RegistrationDAO();
}
}
