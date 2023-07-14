package entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;

import lombok.Setter;

import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users {
	@Id
	@GeneratedValue
	private Long id;
	private String numeroTessera;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;

	public Users(String numeroTessera, String nome, String cognome, LocalDate dataNascita) {
		super();
		this.numeroTessera = numeroTessera;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Utente [numeroTessera=" + numeroTessera + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + "]";
	}

}