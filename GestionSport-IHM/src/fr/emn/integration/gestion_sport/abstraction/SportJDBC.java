package fr.emn.integration.gestion_sport.abstraction;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SportJDBC extends Sport {
	private Connection connexion = BDSport.getConnexion();
	
	@Override
	public boolean importResultatsFile(File file)
			throws ParserConfigurationException, SAXException, IOException,
			ImportException, Exception {
		// TODO
		
		return false;
	}

	@Override
	public void validateResultats(String discipline, String competition) {
		// TODO 

	}

	@Override
	public Vector<String> getAllAthletesAndResultatsAsStrings(
			String discipline, String competition) {
		// TODO 
		return new Vector<String>();
	}

	@Override
	public void saveResultat(Resultat n, String discipline, String competition,
			String athlete, boolean creation) throws Exception {
		// TODO 

	}

	@Override
	public void saveAthlete(Athlete n, Vector<String> disciplines,
			boolean creation) throws Exception {
		// TODO 

	}

	@Override
	public void saveCompetition(Competition e, boolean creation)
			throws Exception {
		// TODO 

	}

	@Override
	public void saveDiscipline(Discipline m, boolean creation) throws Exception {
		// TODO 

	}

	@Override
	public void deleteResultat(String discipline, String competition,
			String athlete) throws Exception {
		// TODO 

	}

	@Override
	public void deleteCompetition(String discipline, String nom)
			throws Exception {
		// TODO 

	}

	@Override
	public void deleteAthlete(String email) throws Exception {
		// TODO 

	}

	@Override
	public void deleteDiscipline(String m) throws Exception {
		// TODO 

	}

	@Override
	public Resultat findResultat(String discipline, String competition,
			String athlete) {
		// TODO 
		return null;
	}

	@Override
	public Competition findCompetition(String discipline, String nom) {
		// TODO 
		return null;
	}

	@Override
	public Vector<Athlete> findAllAthletes() {
		// TODO 
		return new Vector<Athlete>();
	}

	@Override
	public Vector<Discipline> findAllDisciplines() {
		// TODO 
		return new Vector<Discipline>();
	}

	@Override
	public Discipline findDiscipline(String nom) {
		// TODO
		try {
			System.out.println("selection d'une discipline...");
			String myQuery = "SELECT * FROM discipline WHERE (nom=?)";
			PreparedStatement s = connexion.prepareStatement(myQuery);
			s.setString(1,nom);
			ResultSet rs = s.executeQuery();
			String nom_discipline="";
			String responsable="";
			while (rs.next()){
				nom_discipline = rs.getString("nom");
				responsable = rs.getString("responsable");
			}
			Discipline discipline = new Discipline(nom_discipline, responsable);
			return discipline;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Vector<Discipline> findDisciplinesAthlete(Athlete athlete) {
		// TODO 
		return new Vector<Discipline>();
	}

	@Override
	public Vector<Athlete> findAthletesDiscipline(Discipline discipline) {
		// TODO 
		return new Vector<Athlete>();
	}

	@Override
	public Vector<Competition> findCompetitionsDiscipline(Discipline discipline) {
		// TODO 
		return new Vector<Competition>();
	}

	@Override
	public void close() {
		// TODO 

	}

}
