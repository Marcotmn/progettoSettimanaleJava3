package entities;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("Magazine")
public class Rivista extends ElementoCatalogo {
	@Enumerated(EnumType.STRING)
	private Periodicità periodicità;

	public Rivista(Long isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.periodicità = periodicità;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicità + ", getIsbn()=" + getIsbn() + ", getTitolo()=" + getTitolo()
				+ ", getAnnoPubblicazione()=" + getAnnoPubblicazione() + ", getNumeroPagine()=" + getNumeroPagine()
				+ "]";
	}

}