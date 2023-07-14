package entities;




import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;

import javax.persistence.Table;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ElementoCatalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class ElementoCatalogo {
	@Id
	private Long isbn;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;

	public ElementoCatalogo(Long isbn, String titolo, int annoPubblicazione, int numeroPagine) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "Elemento [isbn=" + isbn + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}

}