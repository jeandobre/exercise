package br.com.site.domain;

import br.com.site.common.Assertion;

import java.util.Objects;

public final class Language extends Assertion {

	private String ietfTag;

	public Language(String ietfTag) {
		this.setIetfTag(ietfTag);
	}

	public String ietfTag() {
		return ietfTag;
	}

	private void setIetfTag(String ietfTag) {
		this.assertArgumentNotNull(ietfTag, "The IETF Tag must be provided.");

		this.ietfTag = ietfTag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Language language = (Language) o;
		return ietfTag.equals(language.ietfTag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ietfTag);
	}

	@Override
	public String toString() {
		return ietfTag;
	}
}
