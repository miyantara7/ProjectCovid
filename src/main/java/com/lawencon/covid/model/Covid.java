package com.lawencon.covid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_covid")
public class Covid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int covidId;
	private String namaKota;
	private int kasusNegatif;
	private int kasusPositif;
	private int kasusMati;
	private int kasusSembuh;
	
	public int getCovidId() {
		return covidId;
	}
	public void setCovidId(int covidId) {
		this.covidId = covidId;
	}
	public String getNamaKota() {
		return namaKota;
	}
	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}
	public int getKasusNegatif() {
		return kasusNegatif;
	}
	public void setKasusNegatif(int kasusNegatif) {
		this.kasusNegatif = kasusNegatif;
	}
	public int getKasusPositif() {
		return kasusPositif;
	}
	public void setKasusPositif(int kasusPositif) {
		this.kasusPositif = kasusPositif;
	}
	public int getKasusMati() {
		return kasusMati;
	}
	public void setKasusMati(int kasusMati) {
		this.kasusMati = kasusMati;
	}
	public int getKasusSembuh() {
		return kasusSembuh;
	}
	public void setKasusSembuh(int kasusSembuh) {
		this.kasusSembuh = kasusSembuh;
	}
	
	
}
