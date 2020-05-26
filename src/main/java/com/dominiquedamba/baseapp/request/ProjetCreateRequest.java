/**
 * 
 */
package com.dominiquedamba.baseapp.request;



import java.util.Date;

import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author dominique
 *
 */
@JsonDeserialize(as = ProjetCreateRequest.class)

public class ProjetCreateRequest {

	private String nom;
	private String description;
	private String convention;
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateDebut;
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateFin;
	private double budget;
	private String responsable;
	
	private String[] partenaires;
	private String[] soumissionaire;
	private String[] maitreDoeuvrage;
	private JSONObject[] caracteristiqueTechniques;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConvention() {
		return convention;
	}

	public void setConvention(String convention) {
		this.convention = convention;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String[] getPartenaires() {
		return partenaires;
	}

	public void setPartenaires(String[] partenaires) {
		this.partenaires = partenaires;
	}

	public String[] getSoumissionaire() {
		return soumissionaire;
	}

	public void setSoumissionaire(String[] soumissionaire) {
		this.soumissionaire = soumissionaire;
	}

	public String[] getMaitreDoeuvrage() {
		return maitreDoeuvrage;
	}

	public void setMaitreDoeuvrage(String[] maitreDoeuvrage) {
		this.maitreDoeuvrage = maitreDoeuvrage;
	}

	/**
	 * @return the caracteristiqueTechniques
	 */
	public JSONObject[] getCaracteristiqueTechniques() {
		return caracteristiqueTechniques;
	}

	/**
	 * @param caracteristiqueTechniques the caracteristiqueTechniques to set
	 */
	public void setCaracteristiqueTechniques(JSONObject[] caracteristiqueTechniques) {
		this.caracteristiqueTechniques = caracteristiqueTechniques;
	}
	
	
	
	
	

	

}
