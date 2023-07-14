package entities;

import java.time.LocalDate;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;


@Getter
@Setter

@NoArgsConstructor
@Entity
public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Users user;
	@ManyToOne
	private ElementoCatalogo elemento;
	private LocalDate dataInizioPrestito;
	private LocalDate dataRestituzionePrevista;
	private LocalDate dataRestituzioneEffettiva;

	public Prestito(Users user, ElementoCatalogo elemento, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista,
			LocalDate dataRestituzioneEffettiva) {
		super();
		this.user = user;
		this.elemento = elemento;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + user + ", elemento=" + elemento + ", dataInizioPrestito=" + dataInizioPrestito
				+ ", dataRestituzionePrevista=" + dataRestituzionePrevista + ", dataRestituzioneEffettiva="
				+ dataRestituzioneEffettiva + "]";
	}

}