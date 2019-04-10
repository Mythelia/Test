package fr.formation.inti.entities;
// Generated 10 avr. 2019 09:24:27 by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Alerte generated by hbm2java
 */
@Entity
@Table(name = "alerte", catalog = "projet")
public class Alerte implements java.io.Serializable {

	private int idAlerte;
	private Utilisateurs utilisateurs;
	private Set<MotsClefs> motsClefses = new HashSet<MotsClefs>(0);

	public Alerte() {
	}

	public Alerte(int idAlerte, Utilisateurs utilisateurs) {
		this.idAlerte = idAlerte;
		this.utilisateurs = utilisateurs;
	}

	public Alerte(int idAlerte, Utilisateurs utilisateurs, Set<MotsClefs> motsClefses) {
		this.idAlerte = idAlerte;
		this.utilisateurs = utilisateurs;
		this.motsClefses = motsClefses;
	}

	@Id

	@Column(name = "idAlerte", unique = true, nullable = false)
	public int getIdAlerte() {
		return this.idAlerte;
	}

	public void setIdAlerte(int idAlerte) {
		this.idAlerte = idAlerte;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Utilisateurs_idUtilisateurs", nullable = false)
	public Utilisateurs getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(Utilisateurs utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "mots-clefs_has_alerte", catalog = "projet", joinColumns = {
			@JoinColumn(name = "Alerte_idAlerte", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Mots-clefs_idMotClef", updatable = false) })
	public Set<MotsClefs> getMotsClefses() {
		return this.motsClefses;
	}

	public void setMotsClefses(Set<MotsClefs> motsClefses) {
		this.motsClefses = motsClefses;
	}

}
