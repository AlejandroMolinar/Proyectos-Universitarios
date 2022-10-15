package DiseñoSIstema;

import java.util.ArrayList;


public class UserAdd {
	
	private String User;
	private String Password;
	private String LastName;
	private String FirstName;
	private String Identification;
	private String Phone;
	private String Email;
	private String Career;
	private String Semester;
	
	public  UserAdd(String user, String password, String lastName, String firstName, String identification, String phone, String email, String career, String semester) {
		User = user;
		Password = password;
		LastName = lastName;
		FirstName = firstName;
		Identification = identification;
		Phone = phone;
		Email = email;
		Career = career;
		Semester = semester;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getIdentification() {
		return Identification;
	}

	public void setIdentification(String identification) {
		Identification = identification;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCareer() {
		return Career;
	}

	public void setCareer(String career) {
		Career = career;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public String toString() {
		return "UserAdd [User=" + User + ", Password=" + Password + ", LastName=" + LastName + ", FirstName="
				+ FirstName + ", Identification=" + Identification + ", Phone=" + Phone + ", Email=" + Email
				+ ", Career=" + Career + ", Semester=" + Semester + "]";
	}

	
}

class ArrayUsers{
	ArrayList<UserAdd> arrayUser= new ArrayList<UserAdd>();
	
	public ArrayUsers() {		
		
		arrayUser.add(new UserAdd("DaniMedina", "3221", "Medina", "Daniela", "16742712", "04245490207", "daniMedina@gmail.com", "Ingeniería Sistema" ,"2"));
		arrayUser.add(new UserAdd("BarbaraP", "1212", "Pimentel", "Barbara", "21745322", "04121465214", "BarbaraP@gmail.com", "Ingeniería Sistema" ,"6"));
		arrayUser.add(new UserAdd("AlexM12", "6566", "Marquez", "Alexander", "27834452", "04129543207", "alejanderMarquez@gmail.com", "Ingeniería Mecánica" ,"3"));
		arrayUser.add(new UserAdd("PeralezP", "7863", "Peralez", "Pedro", "21679842", "04149533106", "PeralesPedro@gmail.com", "Ingeniería Civil" ,"5"));
		arrayUser.add(new UserAdd("MartaMM", "0990", "Moreno", "Marta", "12632599", "04263259001", "MartaMRE@gmail.com", "Contaduría Pública" ,"8"));
		arrayUser.add(new UserAdd("GabyMTA", "1076", "Torres", "Gabriela", "22432566", "04143279045", "GabrielaAMT@gmail.com", "Ingeniería Electrónica" ,"9"));
		arrayUser.add(new UserAdd("CarlosDiaz", "7878", "Diaz", "Carlos", "12546658", "04164320011", "CarlosDiazTovar@gmail.com", "Derecho" ,"6"));
		arrayUser.add(new UserAdd("MelannySal", "1235", "Salazar", "Melanny", "17546001", "04143214830", "MelannySalazar11@gmail.com", "Enfermería" ,"8"));
		
		
		
	}
	
	public void AddArray(String user, String password, String lastName, String firstName, String identification, String phone, String email, String career, String semester) {
		arrayUser.add(new UserAdd(user, password, lastName, firstName, identification, phone, email, career, semester));
	}
}
















