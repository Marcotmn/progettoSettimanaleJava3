package entities;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;

import lombok.Getter;

import lombok.Setter;

import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor

@Getter
@Setter
@DiscriminatorValue("Book")
public class Books extends ElementoCatalogo {
	private String autore;
	private String genere;

	public Books(Long isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", getIsbn()=" + getIsbn() + ", getTitolo()="
				+ getTitolo() + ", getAnnoPubblicazione()=" + getAnnoPubblicazione() + ", getNumeroPagine()="
				+ getNumeroPagine() + "]";
	}

}